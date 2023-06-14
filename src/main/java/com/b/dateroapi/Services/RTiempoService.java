package com.b.dateroapi.Services;

import com.b.dateroapi.Models.RTiempoModel;
import com.b.dateroapi.Repositories.RTiempoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RTiempoService {
    @Autowired
    RTiempoRepository rTiempoRepository;

    public List<RTiempoModel> ListarRTiempos(){
        return rTiempoRepository.findAll();
    }

    public Optional<RTiempoModel> ListarRTiemposId(Long id){
        return rTiempoRepository.findById(id);
    }

    public RTiempoModel CrearRTiempo(RTiempoModel rTiempoModel){
        return rTiempoRepository.save(rTiempoModel);
    }

    public RTiempoModel EditarRTiempo(RTiempoModel rTiempoModel, Long id){
        Optional<RTiempoModel> existing = rTiempoRepository.findById(id);
        if(existing.isPresent()){
            RTiempoModel rtiempo = existing.get();
            rtiempo.setTiempo(rTiempoModel.getTiempo());
            rtiempo.setBusesModel(rtiempo.getBusesModel());
            rTiempoRepository.save(rtiempo);
        }
        return null;
    }

    public void EliminarRTiempo(Long id){
        rTiempoRepository.deleteById(id);
    }

}
