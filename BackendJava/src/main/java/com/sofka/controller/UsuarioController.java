
package com.sofka.controller;

import com.sofka.domain.Usuario;
import com.sofka.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Clase UsuarioController que servira como controlador realizado con Springboot la cual nos dara los puntos de acceso para el consumo de APIS
 * @author Michael Arango
 */
@Slf4j
@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    
    /**
     *  Método para devolver una lista de todos los registros que hay en la BD
     * @return 
     */
    @GetMapping(path = "/usuarios")
    public List<Usuario> listado() {

        var usuarios = usuarioService.list();
        return usuarios;

    }
   
    /**
     *  Método para devolver una lista de todos los registros que hay en la BD
     * @return 
     */
    @GetMapping(path = "/usuario/{id}")
    public Optional<Usuario> buscarUsuario(Usuario usuario,@PathVariable("id") Long id) {

        
        return usuarioService.findContact(usuario);

    }

   
    /**
     *  Método para crear un registro en la BD contacto
     * @param usuario recibe todos los parametros para crearlo
     * @return respuesta con el registro creado
     */
    @PostMapping(path = "/usuario")
    public ResponseEntity crear(@RequestBody Usuario usuario) {
        log.info("Usuario a crear: {}", usuario);
        usuarioService.save(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    
    /**
     * Método para borrar fisicamente un registro en la BD contacto
     * @param usuario recibe el parametro Id del contacto a eliminar 
     * @return respuesta con el registro eliminado.
     */
    @DeleteMapping(path = "/usuario/{id}")
    public ResponseEntity borrar(Usuario usuario) {
        log.info("Usuario a borrar: {}", usuario);
        usuarioService.delete(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

   /**
    *  Método para actualizar todo un registro del a BD contacto
    * @param usuario recibe por body todos los campos del contacto
    * @param id recibe por url el id a actualizar.
    * @return respuesta con el campo del registro ya actualizado.
    */
    @PutMapping(path = "/usuario/{id}")
    public ResponseEntity actualizar(@RequestBody Usuario usuario, @PathVariable("id") Long id) {
        log.info("Usuario a modificar: {}", usuario);
        usuarioService.update(id, usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    /**
     *  Método para actualizar solo el campo nombre en la BD contacto
     * @param usuario recibe por body el nombre a actualizar.
     * @param id recibe por url el Id del registro a actualizar.
     * @return respuesta con el campo del registro ya actualizado.
     */
    @PatchMapping(path = "/usuario/idmongou/{id}")
    public ResponseEntity actualizarIdMongoU(@RequestBody Usuario usuario, @PathVariable("id") Long id) {
        usuarioService.updateIdMongoU(id, usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);

    }
    
    /*
    @PatchMapping(path = "/usuario/juegoid/{id}")
    public ResponseEntity actualizarJuegoId(@RequestBody Usuario usuario, @PathVariable("id") Long id) {
        usuarioService.updateJuegoId(id, usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);

    }
    
   */

}