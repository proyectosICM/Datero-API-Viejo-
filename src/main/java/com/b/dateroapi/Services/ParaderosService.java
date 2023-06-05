package com.b.dateroapi.Services;

import com.b.dateroapi.Models.ParaderosModel;
import com.b.dateroapi.Repositories.ParaderosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParaderosService {
    @Autowired
    ParaderosRepository paraderosRepository;

    public List<ParaderosModel> ListarParaderos(){
        return paraderosRepository.findAll();
    }

    public Optional<ParaderosModel> ListarParaderoId(Long id){
        return paraderosRepository.findById(id);
    }

    public ParaderosModel CrearParadero(ParaderosModel paraderosModel){
        return paraderosRepository.save(paraderosModel);
    }

    public ParaderosModel EditarParadero(ParaderosModel paraderosModel, Long id){
        Optional<ParaderosModel> existing = paraderosRepository.findById(id);
        if (existing.isPresent()){
            ParaderosModel paraderos = existing.get();
            paraderos.setNom_par(paraderosModel.getNom_par());
            paraderos.setEst_par(paraderosModel.getEst_par());
            paraderos.setDistritosModel(paraderosModel.getDistritosModel());
            return paraderosRepository.save(paraderos);
        } else {
            return null;
        }
    }

    public void EliminarParadero(Long id){
        paraderosRepository.deleteById(id);
    }
}
