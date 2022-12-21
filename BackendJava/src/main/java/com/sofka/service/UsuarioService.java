
package com.sofka.service;




import com.sofka.dao.UsuarioDao;
import com.sofka.domain.Usuario;
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
public class UsuarioService implements IUsuarioService {

    @Autowired // es para inyectar el ContactoDao
    private UsuarioDao usuarioDao;
    
    // Estos son Los métodos implementados en el controlador
    @Override
    @Transactional (readOnly = true)
    public List<Usuario> list() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public Usuario update(Long id, Usuario usuario) {
       usuario.setId(id);
        return usuarioDao.save(usuario);
               
    }
    
    @Transactional
    public void updateIdMongoU(Long id, Usuario usuario){
        usuarioDao.updateIdMongoU(id, usuario.getIdMongoU());
    }
    
    /*
    @Transactional
    public void updateJuegoId(Long id, Usuario usuario){
        usuarioDao.updateJuegoId(id, usuario.getJuegoId());
    }
    
   */
     @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findContact(Usuario usuario) {
        return usuarioDao.findById(usuario.getId());
       
    }
    
}

