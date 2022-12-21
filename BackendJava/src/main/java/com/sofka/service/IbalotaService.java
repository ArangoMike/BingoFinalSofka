
package com.sofka.service;

import com.sofka.domain.Balota;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author maicol
 */
public interface IbalotaService {
    
    public List<Balota> list();
    
    public Balota save(Balota balota);
    

    public Optional<Balota> findBallot(Balota balota);
    
}
