
package com.sofka.service;

import com.sofka.domain.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author maicol
 */
public interface IUsuarioService {
    
     public List<Usuario> list();
    
    public Usuario save(Usuario usuario);
    
    public Usuario update(Long id, Usuario usuario);
    
    public void delete(Usuario usuario);
    
    public Optional<Usuario> findContact(Usuario usuario);
}
