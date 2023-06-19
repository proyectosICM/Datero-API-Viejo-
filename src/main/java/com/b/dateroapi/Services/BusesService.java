package com.b.dateroapi.Services;

import com.b.dateroapi.Models.BusesModel;
import com.b.dateroapi.Models.EmpresasModel;
import com.b.dateroapi.Models.RutasModel;
import com.b.dateroapi.Models.TrabajadoresModel;
import com.b.dateroapi.Repositories.BusesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.math.BigDecimal;
import java.util.*;


@Service
public class BusesService {
    @Autowired
    BusesRepository busesRepository;
    public List<BusesModel> ListarBuses(){
        return busesRepository.findAll();
    }

    public Optional<BusesModel> ListarBusId(Long id){
        return busesRepository.findById(id);
    }

    public BusesModel CrearBus(BusesModel busesModel){
        return busesRepository.save(busesModel);
    }

    public BusesModel EditarBus(BusesModel busesModel, Long id){
        Optional<BusesModel> existing = busesRepository.findById(id);
        if (existing.isPresent()){
            BusesModel bus = existing.get();
            bus.setMod_bus(busesModel.getMod_bus());
            bus.setPlaca_bus(busesModel.getPlaca_bus());
            bus.setLongitud(busesModel.getLongitud());
            bus.setLatitud(busesModel.getLatitud());
            bus.setEst_bus(busesModel.getEst_bus());
            bus.setTrabajadoresModel(busesModel.getTrabajadoresModel());
            bus.setEmpresasModel(busesModel.getEmpresasModel());
            bus.setRutasModel(busesModel.getRutasModel());
            return busesRepository.save(bus);
        }
        return null;
    }

    public void EliminarBus(Long id){
        busesRepository.deleteById(id);
    }

    public List<BusesModel> ListarBD(){
        List<Object[]> resultados = busesRepository.ListBusesD();
        List<BusesModel> busesList= new ArrayList<>();

        for (Object[] resultado : resultados){
            BusesModel busesm = new BusesModel();
            busesm.setId_bus((Long) resultado [0]);
            busesm.setRutasModel((new RutasModel()));
            busesm.getRutasModel().setId_ruta((Long) resultado[1]);
            busesm.getRutasModel().setNom_ruta((String) resultado[2]);
            busesm.setPlaca_bus((String) resultado[3]);
            busesm.setMod_bus((String) resultado[4]);
            busesm.setTrabajadoresModel((new TrabajadoresModel()));
            busesm.getTrabajadoresModel().setNom_tra((String) resultado[5]);
            busesm.getTrabajadoresModel().setApe_tra((String) resultado[6]);
            busesm.setEmpresasModel((new EmpresasModel()));
            busesm.getEmpresasModel().setNom_emp((String) resultado[7]);
            busesm.setLatitud((BigDecimal) resultado[8]);
            busesm.setLongitud((BigDecimal) resultado[9]);

            busesList.add(busesm);
        }
        return busesList;
    }

    public List<BusesModel>ListarBusesxET(Long emp){
        List<Object[]> resultados = busesRepository.ListBusesxEmp(emp);
        List<BusesModel> busesList = new ArrayList<>();

        for (Object[] resultado : resultados){
            BusesModel busesxe = new BusesModel();
            busesxe.setId_bus((Long) resultado[0]);
            RutasModel rutaxe = new RutasModel();
            rutaxe.setId_ruta((Long) resultado[1]);
            rutaxe.setNom_ruta((String) resultado[2]);
            busesxe.setRutasModel(rutaxe);
            busesxe.setPlaca_bus((String) resultado[3]);
            busesxe.setMod_bus((String) resultado[4]);
            TrabajadoresModel trabajadorxe = new TrabajadoresModel();
            trabajadorxe.setId_tra((Long) resultado[5]);
            trabajadorxe.setNom_tra((String) resultado[6]);
            trabajadorxe.setApe_tra((String) resultado[7]);
            busesxe.setTrabajadoresModel(trabajadorxe);
            busesxe.setEst_bus((Boolean) resultado[8]);
            EmpresasModel empresaxe = new EmpresasModel();
            empresaxe.setId_emp((Long) resultado[9]);
            empresaxe.setNom_emp((String) resultado[10]);
            busesxe.setEmpresasModel(empresaxe);
            busesList.add(busesxe);
        }
        return busesList;
    }

    public List<BusesModel>ListarBusesxEH(Long emp){
        List<Object[]> resultados = busesRepository.ListBusesxEmpH(emp);
        List<BusesModel> busesList = new ArrayList<>();

        for (Object[] resultado : resultados){
            BusesModel busesxe = new BusesModel();
            busesxe.setId_bus((Long) resultado[0]);
            RutasModel rutaxe = new RutasModel();
            rutaxe.setId_ruta((Long) resultado[1]);
            rutaxe.setNom_ruta((String) resultado[2]);
            busesxe.setRutasModel(rutaxe);
            busesxe.setPlaca_bus((String) resultado[3]);
            busesxe.setMod_bus((String) resultado[4]);
            TrabajadoresModel trabajadorxe = new TrabajadoresModel();
            trabajadorxe.setId_tra((Long) resultado[5]);
            trabajadorxe.setNom_tra((String) resultado[6]);
            trabajadorxe.setApe_tra((String) resultado[7]);
            busesxe.setTrabajadoresModel(trabajadorxe);
            busesxe.setEst_bus((Boolean) resultado[8]);
            EmpresasModel empresaxe = new EmpresasModel();
            empresaxe.setId_emp((Long) resultado[9]);
            empresaxe.setNom_emp((String) resultado[10]);
            busesxe.setEmpresasModel(empresaxe);
            busesList.add(busesxe);
        }
        return busesList;
    }

    public List<BusesModel>ListarBusesxED(Long emp){
        List<Object[]> resultados = busesRepository.ListBusesxEmpD(emp);
        List<BusesModel> busesList = new ArrayList<>();

        for (Object[] resultado : resultados){
            BusesModel busesxe = new BusesModel();
            busesxe.setId_bus((Long) resultado[0]);
            RutasModel rutaxe = new RutasModel();
            rutaxe.setId_ruta((Long) resultado[1]);
            rutaxe.setNom_ruta((String) resultado[2]);
            busesxe.setRutasModel(rutaxe);
            busesxe.setPlaca_bus((String) resultado[3]);
            busesxe.setMod_bus((String) resultado[4]);
            TrabajadoresModel trabajadorxe = new TrabajadoresModel();
            trabajadorxe.setId_tra((Long) resultado[5]);
            trabajadorxe.setNom_tra((String) resultado[6]);
            trabajadorxe.setApe_tra((String) resultado[7]);
            busesxe.setTrabajadoresModel(trabajadorxe);
            busesxe.setEst_bus((Boolean) resultado[8]);
            EmpresasModel empresaxe = new EmpresasModel();
            empresaxe.setId_emp((Long) resultado[9]);
            empresaxe.setNom_emp((String) resultado[10]);
            busesxe.setEmpresasModel(empresaxe);
            busesList.add(busesxe);
        }
        return busesList;
    }
}
