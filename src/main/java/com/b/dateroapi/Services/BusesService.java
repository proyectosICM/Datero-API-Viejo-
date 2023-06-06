package com.b.dateroapi.Services;

import com.b.dateroapi.Models.BusesModel;
import com.b.dateroapi.Models.EmpresasModel;
import com.b.dateroapi.Models.RutasModel;
import com.b.dateroapi.Models.TrabajadoresModel;
import com.b.dateroapi.Repositories.BusesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

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

    public List<BusesModel>ListarBusesxE(Long emp){
        List<Object[]> resultados = busesRepository.ListBusesxEmp(emp);
        List<BusesModel> busesList = new ArrayList<>();

        for (Object[] resultado : resultados){
            BusesModel busesxe = new BusesModel();
            busesxe.setId_bus((Long) resultado[0]);
            RutasModel rutaxe = new RutasModel();
            rutaxe.setNom_ruta((String) resultado[1]);
            busesxe.setRutasModel(rutaxe);
            busesxe.setPlaca_bus((String) resultado[2]);
            busesxe.setMod_bus((String) resultado[3]);
            TrabajadoresModel trabajadorxe = new TrabajadoresModel();
            trabajadorxe.setNom_tra((String) resultado[4]);
            trabajadorxe.setApe_tra((String) resultado[5]);
            busesxe.setTrabajadoresModel(trabajadorxe);
            busesxe.setEst_bus((Boolean) resultado[6]);
            EmpresasModel empresaxe = new EmpresasModel();
            empresaxe.setNom_emp((String) resultado[7]);
            busesxe.setEmpresasModel(empresaxe);
            busesList.add(busesxe);
        }
        return busesList;
    }

    public List<BusesModel>ListarBusesxE2(Long emp){
        List<Object[]> resultados = busesRepository.ListBusesxEmp2(emp);
        List<BusesModel> busesList = new ArrayList<>();

        for (Object[] resultado : resultados){
            BusesModel busesxe = new BusesModel();
            busesxe.setId_bus((Long) resultado[0]);
            busesxe.setPlaca_bus((String) resultado[1]);
            busesxe.setMod_bus((String) resultado[2]);
            busesxe.setEst_bus((Boolean) resultado[3]);

            busesList.add(busesxe);
        }
        return busesList;
    }
}
