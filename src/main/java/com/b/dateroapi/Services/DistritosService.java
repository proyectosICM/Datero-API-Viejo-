package com.b.dateroapi.Services;

import com.b.dateroapi.Models.DistritosModel;
import com.b.dateroapi.Repositories.DistritosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DistritosService {
    @Autowired
    DistritosRepository distritosRepository;

    public List<DistritosModel> ListarDistrito(){
        return distritosRepository.findAll();
    }

    public Optional<DistritosModel> ListarDistritoId(Long id){
        return distritosRepository.findById(id);
    }

    public DistritosModel CrearDistrito(DistritosModel distritosModel){
        return distritosRepository.save(distritosModel);
    }

    public DistritosModel EditarDistrito(DistritosModel distritosModel, Long id){
        Optional<DistritosModel> existing = distritosRepository.findById(id);
        if (existing.isPresent()){
            DistritosModel distrito = existing.get();
            distrito.setNom_dis(distritosModel.getNom_dis());
            distrito.setEst_dis(distritosModel.getEst_dis());
            return distritosRepository.save(distrito);
        } else {
            return null;
        }
    }

    public void EliminarDistrito(Long id){
        distritosRepository.deleteById(id);
    }

    public List<DistritosModel> ListarDisH(Boolean est){
        List<Object[]> resultados = distritosRepository.ListDish(est);
        List<DistritosModel> distritoList = new ArrayList<>();

        for (Object[] resultado:resultados){
            DistritosModel distritoh = new DistritosModel();
            distritoh.setId_dis((Long) resultado[0]);
            distritoh.setEst_dis((Boolean) resultado[1]);
            distritoh.setNom_dis((String) resultado[2]);
            distritoList.add(distritoh);
        }
        return distritoList;
    }
}
