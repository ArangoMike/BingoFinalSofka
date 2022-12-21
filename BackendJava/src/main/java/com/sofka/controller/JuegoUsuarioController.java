
package com.sofka.controller;


import com.sofka.domain.JuegoUsuario;
import com.sofka.service.JuegoUsuarioService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author maicol
 */
@Slf4j
@RestController
public class JuegoUsuarioController {
    
    @Autowired
    private JuegoUsuarioService juegoUsuarioService;
    
    @GetMapping(path = "/juegousuario")
    public List<JuegoUsuario> listado() {

        var juegousuario = juegoUsuarioService.list();
        return juegousuario;

    }
    
    /**
     * Método crear el enlace entre Usuario y Juego
     *
     * @return
     */
    @PostMapping(path = "/juegoUsuario/crear")
    public ResponseEntity crear(@RequestBody JuegoUsuario juegoUsuario) {
        log.info("juegoUsuario a crear: {}", juegoUsuario);
        
        juegoUsuarioService.save(juegoUsuario);
        return new ResponseEntity<>(juegoUsuario, HttpStatus.CREATED);
    }
}
