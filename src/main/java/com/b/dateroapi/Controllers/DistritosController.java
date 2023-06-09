package com.b.dateroapi.Controllers;

import com.b.dateroapi.Models.BusesModel;
import com.b.dateroapi.Models.DistritosModel;
import com.b.dateroapi.Services.DistritosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/distritos")
public class DistritosController {
    @Autowired
    DistritosService distritosService;

    @GetMapping
    public List<DistritosModel> GetAllD(){
        return distritosService.ListarDistrito();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistritosModel> GetDId(@PathVariable Long id){
        Optional<DistritosModel> distrito = distritosService.ListarDistritoId(id);
        if(distrito.isPresent()){
            return new ResponseEntity<>(distrito.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<DistritosModel> CrearD(@RequestBody DistritosModel distritosModel){
        DistritosModel cdistrito = distritosService.CrearDistrito(distritosModel);
        return new ResponseEntity<>(cdistrito, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DistritosModel> EditarD(@RequestBody DistritosModel distritosModel, @PathVariable Long id){
        DistritosModel edistrito = distritosService.EditarDistrito(distritosModel, id);
        if (edistrito!=null){
            return new ResponseEntity<>(edistrito, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DistritosModel> EliminarD(@PathVariable Long id){
        distritosService.EliminarDistrito(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/disH/{est}")
    public List<DistritosModel> DisH(@PathVariable("est") Boolean est){
        return distritosService.ListarDisH(est);
    }
}
