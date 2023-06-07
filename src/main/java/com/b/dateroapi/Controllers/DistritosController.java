package com.b.dateroapi.Controllers;

import com.b.dateroapi.Models.BusesModel;
import com.b.dateroapi.Models.DistritosModel;
import com.b.dateroapi.Services.DistritosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/disH/{est}")
    public List<DistritosModel> DisH(@PathVariable("est") Boolean est){
        return distritosService.ListarDisH(est);
    }
}
