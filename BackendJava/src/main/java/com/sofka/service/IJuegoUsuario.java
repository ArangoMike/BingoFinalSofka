
package com.sofka.service;


import com.sofka.domain.JuegoUsuario;

import java.util.List;

/**
 *
 * @author maicol
 */
public interface IJuegoUsuario {
    
    public JuegoUsuario save(JuegoUsuario juegoUsuario);
    
    public List<JuegoUsuario> list();
    
}
