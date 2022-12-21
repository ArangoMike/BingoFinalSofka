const { Router } = require('express');
const { temporizadorGet, listaUsuariosOnline} = require('../controllers/lobby')

const router = Router();


router.get('/lobby', temporizadorGet )  

//Método que envia todos los usuarios online en BD mongo
router.get('/lobby/users', listaUsuariosOnline)


module.exports = router;