package com.b.dateroapi.Services;

import com.b.dateroapi.Models.BusesModel;
import com.b.dateroapi.Models.EmpresasModel;
import com.b.dateroapi.Models.TrabajadoresModel;
import com.b.dateroapi.Models.UsuariosModel;
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
            empresasxe.setNom_emp((String) resultado[4]);
            trabajadoresxe.setEmpresasModel(empresasxe);
            UsuariosModel usuariosxe = new UsuariosModel();
            usuariosxe.setUser_usu((String) resultado[5]);
            usuariosxe.setPass_usu((String) resultado[6]);
            usuariosxe.setEst_usu((Boolean) resultado[7]);
            trabajadoresxe.setUsuariosModel(usuariosxe);
            trabajadorList.add(trabajadoresxe);
        }
        return trabajadorList;
    }

    public List<TrabajadoresModel> ListarTrabjadorxEmpH(Long emp){
        List<Object[]> resultados = trabajadoresRepository.ListTrabjadorxEmpH(emp);
        List<TrabajadoresModel> trabajadorList = new ArrayList<>();

        for (Object[] resultado : resultados){
            TrabajadoresModel trabajadoresxe =  new TrabajadoresModel();
            trabajadoresxe.setId_tra((Long) resultado[0] );
            trabajadoresxe.setNom_tra((String) resultado[1]);
            trabajadoresxe.setApe_tra((String) resultado[2]);
            trabajadoresxe.setDni_tra((String) resultado[3]);
            EmpresasModel empresasxe = new EmpresasModel();
            empresasxe.setNom_emp((String) resultado[4]);
            trabajadoresxe.setEmpresasModel(empresasxe);
            UsuariosModel usuariosxe = new UsuariosModel();
            usuariosxe.setUser_usu((String) resultado[5]);
            usuariosxe.setPass_usu((String) resultado[6]);
            usuariosxe.setEst_usu((Boolean) resultado[7]);
            trabajadoresxe.setUsuariosModel(usuariosxe);
            trabajadorList.add(trabajadoresxe);
        }
        return trabajadorList;
    }

    public List<TrabajadoresModel> ListarTrabjadorxEmpD(Long emp){
        List<Object[]> resultados = trabajadoresRepository.ListTrabjadorxEmpD(emp);
        List<TrabajadoresModel> trabajadorList = new ArrayList<>();

        for (Object[] resultado : resultados){
            TrabajadoresModel trabajadoresxe =  new TrabajadoresModel();
            trabajadoresxe.setId_tra((Long) resultado[0] );
            trabajadoresxe.setNom_tra((String) resultado[1]);
            trabajadoresxe.setApe_tra((String) resultado[2]);
            trabajadoresxe.setDni_tra((String) resultado[3]);
            EmpresasModel empresasxe = new EmpresasModel();
            empresasxe.setNom_emp((String) resultado[4]);
            trabajadoresxe.setEmpresasModel(empresasxe);
            UsuariosModel usuariosxe = new UsuariosModel();
            usuariosxe.setUser_usu((String) resultado[5]);
            usuariosxe.setPass_usu((String) resultado[6]);
            usuariosxe.setEst_usu((Boolean) resultado[7]);
            trabajadoresxe.setUsuariosModel(usuariosxe);
            trabajadorList.add(trabajadoresxe);
        }
        return trabajadorList;
    }
}
