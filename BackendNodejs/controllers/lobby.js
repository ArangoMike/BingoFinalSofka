const { response, request } = require('express');


const User = require('../models/user');

/* Metodo que crea el juego, si  hay uno en curso 
lo envia como respuesta
*/
const temporizadorGet = async (req = request, res = response) => {

    // creación de fecha en que hubo el login
    const inicioJuego = new Date();

    const horalogin = new Date();

    horalogin.setMinutes(inicioJuego.getMinutes() + 1)
    horalogin.setHours(inicioJuego.getHours() - 5)


    const fechaFinal = horalogin.toISOString().replace('Z', '');

    const online = true;


    const existeOnline = await User.findOne({ online });
    const newuser = await User.findByIdAndUpdate(req.idMongoU, { online })

    if (existeOnline) {

        const fechaNow = new Date().toISOString().replace('Z', '');

        fetch('http://localhost:9090/games', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(result => result.json())
            .then(juegos => {
                JSON.stringify(juegos)

                for (const juego of juegos) {
                    if (juego.estadoJuego == 'iniciando') {

                        agregarusuarioJuego(juego, req, datos => {
                            console.log(datos);

                            res({
                                juegoId: juego.id,
                                fecha: fechaNow,
                                usuarioId: req.id,
                                idMongoU: req.idMongoU
                            })

                        })

                    }

                }

            }).catch((err) => {
                console.log(err);
                console.log('voy mal jaja');

            });

    } else {

        const body = {
            'estadoJuego': 'iniciando',
            'fechaInicio': fechaFinal,
        }

        fetch('http://localhost:9090/juego', {
            method: 'POST',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }

        }).then(result => result.json())
            .then(dat => {
                JSON.stringify(dat)
                console.log('datos añadidos correctamente ', dat);
                agregarusuarioJuego(dat, req, datos => {
                    console.log(datos);
                })
                res({
                    juegoId: dat.id,
                    fecha: dat.fechaInicio,
                    usuarioId: req.id,
                    idMongoU: req.idMongoU
                })
            }).catch((err) => {
                console.log(err);
                console.log('me cai');

            });

    }

}

/* Método para consumir api en la BD SQL
y conectar el usuario al juego creado o en curso
*/
const agregarusuarioJuego = (juego, usuario, res = response) => {

    const body = {
        'juegoId': { id: juego.id },
        'usuarioId': { id: usuario.id },
    }
    console.log(body);

    fetch('http://localhost:9090/juegoUsuario/crear', {
        method: 'POST',
        body: JSON.stringify(body),
        headers: {
            'Content-Type': 'application/json'
        }

    }).then(response => response.json())
        .then(data => {
            JSON.stringify(data)
            res(data)
        })

}

// Método para enviar los usuarios online en la BD mongo.
const listaUsuariosOnline = async(req,res = response) => {

    const online = true;
    usuarios = await User.find({online})
   
    res.send(usuarios);


}
module.exports = {
    temporizadorGet,
    listaUsuariosOnline
}