
package com.sofka.service;

import com.sofka.dao.JuegoUsuarioDao;
import com.sofka.domain.JuegoUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author maicol
 */
@Service
public class JuegoUsuarioService implements IJuegoUsuario{
    
    @Autowired
    private JuegoUsuarioDao juegoUsuarioDao;
    
    
     @Override
    @Transactional
    public JuegoUsuario save(JuegoUsuario juegoUsuario) {
      
        return juegoUsuarioDao.save(juegoUsuario);
    }

    @Override
    @Transactional (readOnly = true)
    public List<JuegoUsuario> list() {
      return (List<JuegoUsuario>) juegoUsuarioDao.findAll();
    }
}
