
package com.sofka.service;

import com.sofka.domain.Juego;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author maicol
 */
public interface IJuegoService {
    
     public List<Juego> list();
    
    public Juego save(Juego juego);
    
    public Juego update(Long id, Juego juego);
    
    
    public void delete(Juego juego);
    
    public Optional<Juego> findContact(Juego juego);
    
}
