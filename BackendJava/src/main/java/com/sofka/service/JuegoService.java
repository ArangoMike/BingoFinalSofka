
package com.sofka.service;

import com.sofka.dao.JuegoDao;
import com.sofka.domain.Juego;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *  La clase ContactoService es la encargada de resolver la logica de 
 * la aplicación implementando la interfaz IContactoService
 * @author maicol
 */
@Service
public class JuegoService implements IJuegoService {

    @Autowired // es para inyectar el ContactoDao
    private JuegoDao juegoDao;
    
    // Estos son Los métodos implementados en el controlador
    @Override
    @Transactional (readOnly = true)
    public List<Juego> list() {
        return (List<Juego>) juegoDao.findAll();
    }

    @Override
    @Transactional
    public Juego save(Juego juego) {
        return juegoDao.save(juego);
    }

    @Override
    @Transactional
    public Juego update(Long id, Juego juego) {
       juego.setId(id);
        return juegoDao.save(juego);
               
    }
    
    @Transactional
    public void updateEstadoJuego(Long id, Juego juego){
        juegoDao.updateEstadoJuego(id, juego.getEstadoJuego());
    }
    
    @Transactional
    public void updateGanadorJuego(Long id, Juego juego){
        juegoDao.updateGanadorJuego(id, juego.getGanadorJuego());
    }
    
    /*
    @Transactional
    public void updateUsuarioId(Long id, Juego juego){
        juegoDao.updateUsuarioId(id, juego.getUsuarioId());
    }
    */
    @Transactional
    public void updateFechaInicio(Long id, Juego juego){
        juegoDao.updateFechaInicio(id, juego.getFechaInicio());
    }
    
    
    @Transactional(readOnly = true)
    public Optional<Juego> findbyEnum(Juego juego){
       return (Optional<Juego>) juegoDao.findbyEnum(juego.getEstadoJuego());
    }
    

     @Override
    @Transactional
    public void delete(Juego juego) {
        juegoDao.delete(juego);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Juego> findContact(Juego juego) {
        return juegoDao.findById(juego.getId());
       
    }
    
}
