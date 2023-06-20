package com.b.dateroapi.Services;

import com.b.dateroapi.Models.EmpresasModel;
import com.b.dateroapi.Models.RolesModel2;
import com.b.dateroapi.Models.TrabajadoresModel;
import com.b.dateroapi.Repositories.TrabajadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrabajadoresService {
    @Autowired
    TrabajadoresRepository trabajadoresRepository;

    public List<TrabajadoresModel> ListarTrabajadores(){
        return trabajadoresRepository.findAll();
    }

    public Optional<TrabajadoresModel> ListarTrabajadorId(Long id){
        return trabajadoresRepository.findById(id);
    }

    public TrabajadoresModel CrearTrabajador(TrabajadoresModel trabajadoresModel){
        return trabajadoresRepository.save(trabajadoresModel);
    }

    public TrabajadoresModel EditarTrabajador(TrabajadoresModel trabajadoresModel, Long id){
        Optional<TrabajadoresModel> existing = trabajadoresRepository.findById(id);
        if (existing.isPresent()){
            TrabajadoresModel trabajador = existing.get();
            trabajador.setNom_tra(trabajadoresModel.getNom_tra());
            trabajador.setApe_tra(trabajadoresModel.getApe_tra());
            trabajador.setDni_tra(trabajadoresModel.getDni_tra());
            trabajador.setEst_tra(trabajadoresModel.getEst_tra());
            //trabajador.setUser_tra(trabajadoresModel.getUser_tra());
            trabajador.setPass_tra(trabajadoresModel.getPass_tra());
            //trabajador.setRolesModel(trabajadoresModel.getRolesModel());
            return trabajadoresRepository.save(trabajador);
        }
        return null;
    }

    public void EliminarTrabajador(Long id){
        trabajadoresRepository.deleteById(id);
    }

    public List<TrabajadoresModel> ListarTrabjadorxEmpT(Long emp){
        List<Object[]> resultados = trabajadoresRepository.ListTrabjadorxEmpT(emp);
        List<TrabajadoresModel> trabajadorList = new ArrayList<>();

        for (Object[] resultado : resultados){
            TrabajadoresModel trabajadoresxe =  new TrabajadoresModel();
            trabajadoresxe.setId_tra((Long) resultado[0] );
            trabajadoresxe.setNom_tra((String) resultado[1]);
            trabajadoresxe.setApe_tra((String) resultado[2]);
            trabajadoresxe.setDni_tra((String) resultado[3]);
            EmpresasModel empresasxe = new EmpresasModel();
            empresasxe.setId_emp((Long) resultado[4]);
            empresasxe.setNom_emp((String) resultado[5]);
            trabajadoresxe.setEmpresasModel(empresasxe);
            //trabajadoresxe.setUser_tra((String) resultado[6]);
            trabajadoresxe.setPass_tra((String) resultado[7]);
            RolesModel2 rolesxe  = new RolesModel2();
            rolesxe.setId_rol((Long) resultado[8]);
            rolesxe.setNom_rol((String) resultado[9]);
            //trabajadoresxe.setRolesModel(rolesxe);
            trabajadoresxe.setEst_tra((Boolean) resultado[10]);
            trabajadorList.add(trabajadoresxe);
        }
        return trabajadorList;
    }

    public List<TrabajadoresModel> ListarTrabjadorxEmpH( Boolean est, Long emp){
        List<Object[]> resultados = trabajadoresRepository.ListTrabjadorxEmpH(est, emp);
        List<TrabajadoresModel> trabajadorList = new ArrayList<>();

        for (Object[] resultado : resultados){
            TrabajadoresModel trabajadoresxe =  new TrabajadoresModel();
            trabajadoresxe.setId_tra((Long) resultado[0] );
            trabajadoresxe.setNom_tra((String) resultado[1]);
            trabajadoresxe.setApe_tra((String) resultado[2]);
            trabajadoresxe.setDni_tra((String) resultado[3]);
            EmpresasModel empresasxe = new EmpresasModel();
            empresasxe.setId_emp((Long) resultado[4]);
            empresasxe.setNom_emp((String) resultado[5]);
            trabajadoresxe.setEmpresasModel(empresasxe);
            //trabajadoresxe.setUser_tra((String) resultado[6]);
            trabajadoresxe.setPass_tra((String) resultado[7]);
            RolesModel2 rolesxe  = new RolesModel2();
            rolesxe.setId_rol((Long) resultado[8]);
            rolesxe.setNom_rol((String) resultado[9]);
            //trabajadoresxe.setRolesModel(rolesxe);
            trabajadoresxe.setEst_tra((Boolean) resultado[10]);
            trabajadorList.add(trabajadoresxe);
        }
        return trabajadorList;
    }

    public List<TrabajadoresModel> ListarTrabjadorxEmpR(Long emp, Boolean est, Integer rol){
        List<Object[]> resultados = trabajadoresRepository.ListTrabjadorxEmpR(emp, est, rol);
        List<TrabajadoresModel> trabajadorList = new ArrayList<>();

        for (Object[] resultado : resultados){
            TrabajadoresModel trabajadoresxe =  new TrabajadoresModel();
            trabajadoresxe.setId_tra((Long) resultado[0] );
            trabajadoresxe.setNom_tra((String) resultado[1]);
            trabajadoresxe.setApe_tra((String) resultado[2]);
            trabajadoresxe.setDni_tra((String) resultado[3]);
            EmpresasModel empresasxe = new EmpresasModel();
            empresasxe.setId_emp((Long) resultado[4]);
            empresasxe.setNom_emp((String) resultado[5]);
            trabajadoresxe.setEmpresasModel(empresasxe);
            //trabajadoresxe.setUser_tra((String) resultado[6]);
            trabajadoresxe.setPass_tra((String) resultado[7]);
            RolesModel2 rolesxe  = new RolesModel2();
            rolesxe.setId_rol((Long) resultado[8]);
            rolesxe.setNom_rol((String) resultado[9]);
            //trabajadoresxe.setRolesModel(rolesxe);
            trabajadoresxe.setEst_tra((Boolean) resultado[10]);
            trabajadorList.add(trabajadoresxe);
        }
        return trabajadorList;
    }
}
