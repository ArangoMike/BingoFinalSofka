
package com.sofka.service;

import com.sofka.dao.BalotaDao;
import com.sofka.domain.Balota;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BalotaService implements IbalotaService{
    
    @Autowired
    private BalotaDao balotaDao;
    

    @Override
    public List<Balota> list() {
        return (List<Balota>) balotaDao.findAll();
    }

    @Override
    public Balota save(Balota balota) {
         return balotaDao.save(balota);
    }

    @Override
    public Optional<Balota> findBallot(Balota balota) {
        return balotaDao.findById(balota.getId());
    }
    
   
    
}
