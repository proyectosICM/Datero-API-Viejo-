package com.b.dateroapi.Services;

import com.b.dateroapi.Models.*;
import com.b.dateroapi.Repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    @Autowired
    RolesRepository rolesRepository;

    public List<RolesModel> ListarRoles(){
        return rolesRepository.findAll();
    }

    public Optional<RolesModel> ListarRolId(Long id){
        return rolesRepository.findById(id);
    }

    public RolesModel CrearRoles(RolesModel rolesModel){
        return rolesRepository.save(rolesModel);
    }

    public RolesModel EditarRoles(RolesModel rolesModel, Long id){
        Optional<RolesModel> existing = rolesRepository.findById(id);
        if (existing.isPresent()){
            RolesModel roles = existing.get();
            roles.setNom_rol(rolesModel.getNom_rol());
            roles.setEst_rol(rolesModel.getEst_rol());
            return rolesRepository.save(roles);
        }
        return null;
    }

    public void EliminarRoles(Long id){
        rolesRepository.deleteById(id);
    }

    public List<RolesModel>ListarRolesH(Boolean est){
        List<Object[]> resultados = rolesRepository.ListRolesH(est);
        List<RolesModel> rolesList = new ArrayList<>();

        for (Object[] resultado : resultados){
            RolesModel rolesxh = new RolesModel();
            rolesxh.setId_rol((Long) resultado[0]);
            rolesxh.setNom_rol((String) resultado[1]);
            rolesxh.setEst_rol((Boolean) resultado[2]);
            rolesList.add(rolesxh);
        }
        return rolesList;
    }
}
