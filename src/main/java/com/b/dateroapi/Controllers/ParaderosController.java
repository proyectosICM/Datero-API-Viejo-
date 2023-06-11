package com.b.dateroapi.Controllers;

import com.b.dateroapi.Models.EmpresasModel;
import com.b.dateroapi.Models.ParaderosModel;
import com.b.dateroapi.Services.ParaderosService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/paraderos")
public class ParaderosController {
    @Autowired
    ParaderosService paraderosService;

    @GetMapping
    public List<ParaderosModel> ListarP(){
        return paraderosService.ListarParaderos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParaderosModel> ListarPId(@PathVariable Long id){
        Optional<ParaderosModel> paraderos = paraderosService.ListarParaderoId(id);
        if (paraderos.isPresent()){
            return new ResponseEntity<>(paraderos.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ParaderosModel> CrearE(@RequestBody ParaderosModel paraderosModel){
        ParaderosModel cparaderos = paraderosService.CrearParadero(paraderosModel);
        return new ResponseEntity<>(cparaderos, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParaderosModel> EditarE(@RequestBody ParaderosModel paraderosModel, @PathVariable Long id){
        ParaderosModel eparaderos = paraderosService.EditarParadero(paraderosModel, id);
        if (eparaderos!=null){
            return new ResponseEntity<>(eparaderos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmpresasModel> EliminarE(@PathVariable Long id){
        paraderosService.EliminarParadero(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
