const { response, request } = require('express');

const { temporizadorGet } = require('./lobby')
const User = require('../models/user');

let envio;
let i = 0;


// Método para login hacia el juego
const loginPatch = async (req, res = response) => {
    const { nickname, password } = req.body;

    const existeNickname = await User.findOne({ nickname });

    try {

        if (existeNickname.nickname == nickname &&
            existeNickname.password == password) {

            validateUserLogin(existeNickname, async resultado => {
                res.json(resultado)
            });

        } else {
            return res.json('usuario o contraseña incorrecta')
        }
    } catch (error) {
        return res.json({ msj: 'usuario o contraseña incorrectaaaaa' })
    }

}

//Método para crear el usuario en la base SQL enviado desde mongo
const createUserJ = (req = request, res = response) => {
    const idMongoU = req;

    const body = { idMongoU };

    fetch('http://localhost:9090/usuario', {
        method: 'POST',
        body: JSON.stringify(body),
        headers: {
            'Content-Type': 'application/json'
        }

    }).then(result => result.json())
        .then(data => {
            JSON.stringify(data)
            console.log(data);
            res(data)
        }).catch((err) => {
            console.log(err);
        });

}

/*Método que valida si ya existe el usuario en la base SQL,
si no existe lo crea.
*/
const validateUserLogin = (req = request, res = response) => {
    const idMongoU = req.id;

    fetch('http://localhost:9090/usuarios', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }

    }).then(result => result.json())
        .then(data => {
            Object.keys(data).map(key => {
                const usuario = data[key]

                console.log(usuario.idMongoU);

                if (usuario.idMongoU == idMongoU) {
                    i++;
                    temporizadorGet(usuario, resultado => {
                        res(resultado)
                    })
                }
            })

            if (i == 0) {
                createUserJ(idMongoU, datos => {

                    temporizadorGet(datos, resultado => {
                        res(resultado)
                    })
                })
            }
        }).catch((err) => {
            console.log(err);
        });
}



// Metodo usado en la ruta Post para registrar un nuevo usuario
const usuariosPost = async (req = request, res = response) => {
    const { nickname, password, email } = req.body;

    // Validación si ya existe el nickname
    const existeNickname = await User.findOne({ nickname });


    if (existeNickname) {
        return res.status(400).json({ msg: `El usuario: ${nickname}, ya está registrado` });
    }

    // Validación si ya existe el correo
    const existeEmail = await User.findOne({ email });
    if (existeEmail) {
        return res.status(400).json({ msg: `El correo: ${email}, ya está registrado` });
    }


    const user = new User({
        "nickname": nickname,
        "password": password,
        "email": email
    });

    user.save()

    res.status(201).json({
        user,
        msg: 'Usuario creado con EXITO'
    })


    

}

const logoutPatch = async(req = request, res = response)=>{

    const {id} = req.body;
    const online = false;

    const existeNickname = await User.findByIdAndUpdate(id, { online });

    res.json(`Sesion cerrada exitosamente de :  ${existeNickname.nickname}`);

}






module.exports = {
    usuariosPost,
    loginPatch,
    logoutPatch
}