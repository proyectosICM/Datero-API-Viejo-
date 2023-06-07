package com.b.dateroapi.Services;

import com.b.dateroapi.Models.EmpresasModel;
import com.b.dateroapi.Models.RutasModel;
import com.b.dateroapi.Repositories.RutasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RutasService {
    @Autowired
    RutasRepository rutasRepository;

    public List<RutasModel> ListarRutas(){
        return rutasRepository.findAll();
    }

    public Optional<RutasModel> ListarRutaId(Long id){
        return rutasRepository.findById(id);
    }

    public RutasModel CrearRuta(RutasModel rutasModel){
        return rutasRepository.save(rutasModel);
    }

    public RutasModel EditarRuta(RutasModel rutasModel, Long id){
        Optional<RutasModel> existing = rutasRepository.findById(id);
        if(existing.isPresent()){
            RutasModel rutas = existing.get();
            rutas.setNom_ruta(rutasModel.getNom_ruta());
            rutas.setEst_ruta(rutasModel.getEst_ruta());
            return rutasRepository.save(rutas);
        }
        return null;
    }

    public void EliminarRuta(Long id){
        rutasRepository.deleteById(id);
    }

    public List<RutasModel> ListRutasXEmpT(Long emp){
        List<Object[]> resultados = rutasRepository.ListRutasXEmpT(emp);
        List<RutasModel> rutasList = new ArrayList<>();

        for (Object[] resultado : resultados){
            RutasModel rutasxe = new RutasModel();
            rutasxe.setId_ruta((Long) resultado[0]);
            rutasxe.setNom_ruta((String) resultado[1]);
            EmpresasModel empresasxe = new EmpresasModel();
            empresasxe.setNom_emp((String) resultado[2]);
            rutasxe.setEmpresasModel(empresasxe);
            rutasxe.setEst_ruta((Boolean) resultado[3]);
            rutasList.add(rutasxe);
        }
        return rutasList;
    }

    public List<RutasModel> ListRutasXEmpH(Long emp){
        List<Object[]> resultados = rutasRepository.ListRutasXEmpH(emp);
        List<RutasModel> rutasList = new ArrayList<>();

        for (Object[] resultado : resultados){
            RutasModel rutasxe = new RutasModel();
            rutasxe.setId_ruta((Long) resultado[0]);
            rutasxe.setNom_ruta((String) resultado[1]);
            EmpresasModel empresasxe = new EmpresasModel();
            empresasxe.setNom_emp((String) resultado[2]);
            rutasxe.setEmpresasModel(empresasxe);
            rutasxe.setEst_ruta((Boolean) resultado[3]);
            rutasList.add(rutasxe);
        }
        return rutasList;
    }

    public List<RutasModel> ListRutasXEmpD(Long emp){
        List<Object[]> resultados = rutasRepository.ListRutasXEmpD(emp);
        List<RutasModel> rutasList = new ArrayList<>();

        for (Object[] resultado : resultados){
            RutasModel rutasxe = new RutasModel();
            rutasxe.setId_ruta((Long) resultado[0]);
            rutasxe.setNom_ruta((String) resultado[1]);
            EmpresasModel empresasxe = new EmpresasModel();
            empresasxe.setNom_emp((String) resultado[2]);
            rutasxe.setEmpresasModel(empresasxe);
            rutasxe.setEst_ruta((Boolean) resultado[3]);
            rutasList.add(rutasxe);
        }
        return rutasList;
    }
}
