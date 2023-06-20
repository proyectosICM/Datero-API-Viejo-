package com.b.dateroapi.Services;

import com.b.dateroapi.Models.EmpresasModel;
import com.b.dateroapi.Repositories.EmpresasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresasService {
    @Autowired
    EmpresasRepository empresasRepository;

    public List<EmpresasModel> ListarEmpresas() {
        return empresasRepository.findAll();
    }

    public Optional<EmpresasModel> ListarEmpresaId(Long id) {
        return empresasRepository.findById(id);
    }


    public List<EmpresasModel> ListarEmpHab(){
        List<Object[]> resultados = empresasRepository.EmpHabilitadas();
        List<EmpresasModel> empresasHList = new ArrayList<>();

        for (Object[] resultado : resultados ){
            EmpresasModel empresasmh = new EmpresasModel();
            empresasmh.setId_emp((Long) resultado[0]);
            empresasmh.setEst_emp((Boolean) resultado[1]);
            empresasmh.setNom_emp((String) resultado[2]);
            empresasHList.add(empresasmh);
        }
        return empresasHList;
    }

    public List<EmpresasModel> ListarEmpDeshab(){
        List<Object[]> resultados = empresasRepository.EmpDeHabilitadas();
        List<EmpresasModel> empresasDList = new ArrayList<>();

        for (Object[] resultado : resultados){
            EmpresasModel empresasmd = new EmpresasModel();
            empresasmd.setId_emp((Long) resultado[0]);
            empresasmd.setEst_emp((Boolean) resultado[1]);
            empresasmd.setNom_emp((String) resultado[2]);
            empresasDList.add(empresasmd);
        }
        return empresasDList;
    }


    public List<EmpresasModel> ListarEmpresasH(boolean est){
        List<Object[]> resultados = empresasRepository.ListarEmpresasH(est);
        List<EmpresasModel> empresasDList = new ArrayList<>();

        for (Object[] resultado : resultados){
            EmpresasModel empresasmd = new EmpresasModel();
            empresasmd.setId_emp((Long) resultado[0]);
            empresasmd.setEst_emp((Boolean) resultado[1]);
            empresasmd.setNom_emp((String) resultado[2]);
            empresasDList.add(empresasmd);
        }
        return empresasDList;
    }

    public EmpresasModel CrearEmpresa(EmpresasModel empresasModel){
        return empresasRepository.save(empresasModel);
    }

    public EmpresasModel EditarEmpresa(EmpresasModel empresasModel, Long id){
        Optional<EmpresasModel> existing = empresasRepository.findById(id);
        if (existing.isPresent()){
            EmpresasModel empresa = existing.get();
            empresa.setNom_emp(empresasModel.getNom_emp());
            empresa.setEst_emp(empresasModel.getEst_emp());
            return empresasRepository.save(empresa);
        } else {
            return null;
        }
    }

    public void EliminarEmpresa(Long id){
        empresasRepository.deleteById(id);
    }
}
