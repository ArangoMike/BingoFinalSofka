
const { Router } = require("express");

const {loginPatch} = require('../controllers/usuarios')


const router = Router();

// Ruta para login y sus validaciones.
router.patch('/login', loginPatch);


module.exports = router;