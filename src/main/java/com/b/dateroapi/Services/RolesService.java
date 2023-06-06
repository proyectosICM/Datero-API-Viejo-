package com.b.dateroapi.Services;

import com.b.dateroapi.Models.RolesModel;
import com.b.dateroapi.Repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
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
}
