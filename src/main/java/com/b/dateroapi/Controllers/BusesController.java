package com.b.dateroapi.Controllers;

import com.b.dateroapi.Models.BusesModel;
import com.b.dateroapi.Services.BusesService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/buses")
public class BusesController {
    @Autowired
    BusesService busesService;

    @GetMapping
    public List<BusesModel> GetAll(){
        return busesService.ListarBuses();
    }

    @GetMapping("/vista")
    public List<BusesModel> getListBusesD(){
        return busesService.ListarBD();
    }

    @GetMapping("/busxempT/{emp}")
    public List<BusesModel> BusesxEmp(@PathVariable("emp") Long emp){
        return busesService.ListarBusesxET(emp);
    }

    @GetMapping("/busxempH/{emp}")
    public List<BusesModel> BusesxEmpH(@PathVariable("emp") Long emp){
        return busesService.ListarBusesxEH(emp);
    }

    @GetMapping("/busxempD/{emp}")
    public List<BusesModel> BusesxEmpD(@PathVariable("emp") Long emp){
        return busesService.ListarBusesxED(emp);
    }
}
