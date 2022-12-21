
package com.sofka.service;


import com.sofka.domain.TablaBingo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author maicol
 */
public interface ITablaBingoService {
    
    public List<TablaBingo> list();
    
    public TablaBingo save(TablaBingo tablaBingo);
    
    public TablaBingo update(Long id, TablaBingo tablabingo);
    
    public Optional<TablaBingo> findContact(TablaBingo tablabingo);
    
    
    
}
