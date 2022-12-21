
package com.sofka.service;

import com.sofka.dao.TablaBingoDao;
import com.sofka.domain.TablaBingo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *  La clase TablaBingoService es la encargada de resolver la logica de 
 * la aplicación implementando la interfaz ItablaBingoService
 * @author maicol
 */
@Service
public class TablaBingoService implements ITablaBingoService{
    
    @Autowired
    private TablaBingoDao tablaBingoDao;
    
   @Override
    public List<TablaBingo> list() {
        return (List<TablaBingo>) tablaBingoDao.findAll();
    }

    @Override
    public TablaBingo save(TablaBingo tablaBingo) {
        
       return tablaBingoDao.save(tablaBingo);
    }

    @Override
    public TablaBingo update(Long id, TablaBingo tablaBingo) {
       tablaBingo.setId(id);
        return tablaBingoDao.save(tablaBingo);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TablaBingo> findContact(TablaBingo tablaBingo) {
      return tablaBingoDao.findById(tablaBingo.getId());
    }

    

    
}
