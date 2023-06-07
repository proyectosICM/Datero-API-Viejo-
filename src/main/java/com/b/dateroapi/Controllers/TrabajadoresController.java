package com.b.dateroapi.Controllers;

import com.b.dateroapi.Models.BusesModel;
import com.b.dateroapi.Models.TrabajadoresModel;
import com.b.dateroapi.Services.TrabajadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/trabajadores")
public class TrabajadoresController {
    @Autowired
    TrabajadoresService trabajadoresService;

    @GetMapping
    public List<TrabajadoresModel> GetAllT(){
        return trabajadoresService.ListarTrabajadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabajadoresModel> GetAllTID(@PathVariable Long id){
        Optional<TrabajadoresModel> trabajador = trabajadoresService.ListarTrabajadorId(id);
        if (trabajador!=null){
            return new ResponseEntity<>(trabajador.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/trabajadoresxEmpT/{emp}")
    public List<TrabajadoresModel> BusesxEmpT(@PathVariable("emp") Long emp){
        return trabajadoresService.ListarTrabjadorxEmpT(emp);
    }

    @GetMapping("/trabajadoresxEmpH/{emp}")
    public List<TrabajadoresModel> BusesxEmpH(@PathVariable("emp") Long emp){
        return trabajadoresService.ListarTrabjadorxEmpH(emp);
    }

    @GetMapping("/trabajadoresxEmpD/{emp}")
    public List<TrabajadoresModel> BusesxEmpD(@PathVariable("emp") Long emp){
        return trabajadoresService.ListarTrabjadorxEmpD(emp);
    }

    @PostMapping
    public ResponseEntity<TrabajadoresModel> CrearT(@RequestBody TrabajadoresModel trabajadoresModel){
        TrabajadoresModel ctrabajador = trabajadoresService.CrearTrabajador(trabajadoresModel);
        return new ResponseEntity<>(ctrabajador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrabajadoresModel> EditarT(@RequestBody TrabajadoresModel trabajadoresModel, @PathVariable Long id){
        TrabajadoresModel etrabajador = trabajadoresService.EditarTrabajador(trabajadoresModel, id);
        if (etrabajador!=null){
            return new ResponseEntity<>(etrabajador, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TrabajadoresModel> EliminarT(@PathVariable Long id){
        trabajadoresService.EliminarTrabajador(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
