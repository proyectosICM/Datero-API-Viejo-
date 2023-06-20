package com.b.dateroapi.Controllers;

import com.b.dateroapi.Models.BusesModel;
import com.b.dateroapi.Models.ERole;
import com.b.dateroapi.Models.RolesModel;
import com.b.dateroapi.Models.TrabajadoresModel;
import com.b.dateroapi.Repositories.TrabajadoresRepository;
import com.b.dateroapi.Request.CreateUserDTO;
import com.b.dateroapi.Services.TrabajadoresService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/trabajadores")
public class TrabajadoresController {
    @Autowired
    TrabajadoresService trabajadoresService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    TrabajadoresRepository trabajadoresRepository;

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

    @GetMapping("/trabajadoresxEmpH/{est}/{emp}")
    public List<TrabajadoresModel> BusesxEmpH(@PathVariable("est") Boolean est, @PathVariable("emp") Long emp){
        return trabajadoresService.ListarTrabjadorxEmpH(est, emp);
    }

    @GetMapping("/trabajadoresxEmpR/{emp}/{est}/{rol}")
    public List<TrabajadoresModel> BusesxEmpD(@PathVariable("emp") Long emp, @PathVariable("est") Boolean est, @PathVariable("rol") Integer rol ){
        return trabajadoresService.ListarTrabjadorxEmpR(emp, est, rol);
    }

    @PostMapping
    public ResponseEntity<TrabajadoresModel> CrearT(@RequestBody TrabajadoresModel trabajadoresModel){
        TrabajadoresModel ctrabajador = trabajadoresService.CrearTrabajador(trabajadoresModel);
        return new ResponseEntity<>(ctrabajador, HttpStatus.CREATED);
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody  CreateUserDTO createUserDTO){

        Set<RolesModel> roles = createUserDTO.getRoles().stream()
                .map( rol -> RolesModel.builder()
                        .name(ERole.valueOf(rol))
                        .build())
                .collect(Collectors.toSet());

        TrabajadoresModel trabajadoresModel = TrabajadoresModel.builder()
                .username(createUserDTO.getUsername())
                .pass_tra(passwordEncoder.encode(createUserDTO.getPass_tra()))
                .nom_tra(createUserDTO.getNom_tra())
                .ape_tra(createUserDTO.getApe_tra())
                .dni_tra(createUserDTO.getDni_tra())
                .est_tra(createUserDTO.getEst_tra())
                .roles(roles)
                .build();
        trabajadoresRepository.save(trabajadoresModel);
        return ResponseEntity.ok(trabajadoresModel);
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
