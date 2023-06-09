package com.b.dateroapi.Controllers;

import com.b.dateroapi.Models.RutasModel;
import com.b.dateroapi.Services.RutasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/rutas")
public class RutasController {
    @Autowired
    RutasService rutasService;

    @GetMapping
    public List<RutasModel> GetAll(){
        return rutasService.ListarRutas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutasModel> GetRId(@PathVariable Long id){
        Optional<RutasModel> rutas = rutasService.ListarRutaId(id);
        if (rutas.isPresent()){
            return new ResponseEntity<>(rutas.get(), HttpStatus.OK);
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<RutasModel> CrearR(@RequestBody RutasModel rutasModel){
        RutasModel crutas = rutasService.CrearRuta(rutasModel);
        return new ResponseEntity<>(crutas, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RutasModel> EditarR(@RequestBody RutasModel rutasModel, @PathVariable Long id){
        RutasModel eruta = rutasService.EditarRuta(rutasModel, id);
        if (eruta!=null){
            return new ResponseEntity<>(eruta, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RutasModel> EliminarR(@PathVariable Long id){
        rutasService.EliminarRuta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/rutasXEmpT/{emp}")
    public List<RutasModel> RutasXEmpT(@PathVariable("emp") Long emp){
        return rutasService.ListRutasXEmpT(emp);
    }

    @GetMapping("/rutasXEmpH/{emp}")
    public List<RutasModel> RutasXEmpH(@PathVariable("emp") Long emp){
        return rutasService.ListRutasXEmpH(emp);
    }

    @GetMapping("/rutasXEmpD/{emp}")
    public List<RutasModel> RutasXEmpD(@PathVariable("emp") Long emp){
        return rutasService.ListRutasXEmpD(emp);
    }
}
