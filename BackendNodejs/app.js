require('dotenv').config();
const Server = require('./models/server');

/**
 * creación de la clase server
 */
const server = new Server;

// escuchando conexión del host 
server.listen();