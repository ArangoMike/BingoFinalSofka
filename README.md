# SOFKA TALLER FINAL BINGO

##   springboot 

## Descripción:
En este proyecto encontraras un juego de bingo virtual implementado con cosas vistas en las canteras de sofka technologies
y parte de mi aprendizaje personal, desarrollado en Angular el frontend y el Backend en Springboot-MYSQL y Nodejs-Mongo

## Configuración spring boot:

Aquí tendrás que configurar en la carpeta resourse src/main/resources/application.properties
* El usuario y contraseña para el servidor donde esta la BD.
* el nombre de la BD en el link de conexión.

<pre>

# Configuración para MySQL 8
spring.datasource.url=jdbc:mysql://localhost/databingo?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrival=true --AQUI--
			--Remplaza la palabra databingo por el nombre de tu BD--

# Usuario de base de datos
spring.datasource.username=root. --AQUI--

# Contraseña para usuario de base de datos
spring.datasource.password=123456789 --AQUI--
</pre>

## Configuración politicas CORS:

En este paso tendrás que cambiar la URL desde donde estas consumiendo el servicio REST,
el archivo esta en src/main/java/com/sofka/AgendaTel . (escribela completa con http y localhost...)

<pre>

@Bean
        public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:5500").allowedMethods("*").allowedHeaders("*");  --AQUI--
			}                                -- CAMBIA LA URL POR LA URL DE TU CLIENTE --
		};
	   }
     
</pre>

## Configuración  Angular y nodeJs:

Recuerda descargar los node-modules requeridos en cada proyecto en su apartado de package-json.
Si hay errores con el modulo countdown en angular visitar pagina de creadores y actualizar su modulo si hace
falta. http://countdownjs.org/


## contribuidor:
* Michael Arango Nieto - michaelarango0531@gmail.com

