const { Router } = require('express');
const { usuariosPost} = require('../controllers/usuarios')


const router = Router();

// Ruta para crear usuarios en mongo
router.post('/createUser', usuariosPost)       


module.exports = router;