package com.b.dateroapi.Services;

import com.b.dateroapi.Models.*;
import com.b.dateroapi.Repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    @Autowired
    RolesRepository rolesRepository;

    public List<RolesModel2> ListarRoles(){
        return rolesRepository.findAll();
    }

    public Optional<RolesModel2> ListarRolId(Long id){
        return rolesRepository.findById(id);
    }

    public RolesModel2 CrearRoles(RolesModel2 rolesModel){
        return rolesRepository.save(rolesModel);
    }

    public RolesModel2 EditarRoles(RolesModel2 rolesModel, Long id){
        Optional<RolesModel2> existing = rolesRepository.findById(id);
        if (existing.isPresent()){
            RolesModel2 roles = existing.get();
            roles.setNom_rol(rolesModel.getNom_rol());
            roles.setEst_rol(rolesModel.getEst_rol());
            return rolesRepository.save(roles);
        }
        return null;
    }

    public void EliminarRoles(Long id){
        rolesRepository.deleteById(id);
    }

    public List<RolesModel2>ListarRolesH(Boolean est){
        List<Object[]> resultados = rolesRepository.ListRolesH(est);
        List<RolesModel2> rolesList = new ArrayList<>();

        for (Object[] resultado : resultados){
            RolesModel2 rolesxh = new RolesModel2();
            rolesxh.setId_rol((Long) resultado[0]);
            rolesxh.setNom_rol((String) resultado[1]);
            rolesxh.setEst_rol((Boolean) resultado[2]);
            rolesList.add(rolesxh);
        }
        return rolesList;
    }
}
