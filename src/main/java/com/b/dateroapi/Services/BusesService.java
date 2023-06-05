package com.b.dateroapi.Services;

import com.b.dateroapi.Models.BusesModel;
import com.b.dateroapi.Models.EmpresasModel;
import com.b.dateroapi.Models.RutasModel;
import com.b.dateroapi.Models.TrabajadoresModel;
import com.b.dateroapi.Repositories.BusesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BusesService {
    @Autowired
    BusesRepository busesRepository;
    public List<BusesModel> ListarBuses(){
        return busesRepository.findAll();
    }

    public List<BusesModel> ListarBD(){
        List<Object[]> resultados = busesRepository.ListBusesD();
        List<BusesModel> busesList= new ArrayList<>();

        for (Object[] resultado : resultados){
            BusesModel busesm = new BusesModel();
            busesm.setId_bus((Long) resultado [0]);
            busesm.setRutasModel((new RutasModel()));
            busesm.getRutasModel().setNom_ruta((String) resultado[1]);
            busesm.setPlaca_bus((String) resultado[2]);
            busesm.setMod_bus((String) resultado[3]);
            busesm.setTrabajadoresModel((new TrabajadoresModel()));
            busesm.getTrabajadoresModel().setNom_tra((String) resultado[4]);
            busesm.getTrabajadoresModel().setApe_tra((String) resultado[5]);
            busesm.setEmpresasModel((new EmpresasModel()));
            busesm.getEmpresasModel().setNom_emp((String) resultado[6]);

            busesList.add(busesm);
        }
        return busesList;
    }
}
