package com.b.dateroapi.Services;

import com.b.dateroapi.Models.DistritosModel;
import com.b.dateroapi.Models.ParaderosModel;
import com.b.dateroapi.Models.RPModel;
import com.b.dateroapi.Models.RutasModel;
import com.b.dateroapi.Repositories.RPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RPService {
    @Autowired
    RPRepository rpRepository;

    public List<RPModel> ListarRP(){
        return rpRepository.findAll();
    }

    public Optional<RPModel> ListarRPXID(Long id){
        return rpRepository.findById(id);
    }

    public RPModel CrearRP(RPModel rpModel){
        return rpRepository.save(rpModel);
    }

    public RPModel EditarRP(RPModel rpModel, Long id){
        Optional<RPModel> existing = rpRepository.findById(id);
        if (existing.isPresent()){
            RPModel rp = existing.get();
            rp.setRutasModel(rp.getRutasModel());
            rp.setParaderosModel(rpModel.getParaderosModel());
            rp.setOrden_rp(rpModel.getOrden_rp());
            rp.setEst_rp(rpModel.getEst_rp());
            return rpRepository.save(rp);
        }
        return null;
    }

    public void EliminarRP(Long id){
        rpRepository.deleteById(id);
    }

    public List<RPModel> ListarParaderosXRuta(Long ruta){
        List<Object[]> resultados = rpRepository.ListParaderoXRuta(ruta);
        List<RPModel> rpList = new ArrayList<>();

        for (Object[] resultado: resultados){
            RPModel rpx = new RPModel();
            rpx.setId_rp((Long) resultado[0]);
            rpx.setOrden_rp((Integer) resultado[1]);
            RutasModel rutax = new RutasModel();
            rutax.setId_ruta((Long) resultado[2]);
            rutax.setNom_ruta((String) resultado[3]);
            rpx.setRutasModel(rutax);
            ParaderosModel paraderox = new ParaderosModel();
            paraderox.setId_par((Long) resultado[4]);
            paraderox.setNom_par((String) resultado[5]);
            DistritosModel distritox = new DistritosModel();
            distritox.setId_dis((Long) resultado[6]);
            distritox.setNom_dis((String) resultado[7]);
            paraderox.setDistritosModel(distritox);
            paraderox.setLatitud((BigDecimal) resultado[8]);
            paraderox.setLongitud((BigDecimal) resultado[9]);
            rpx.setParaderosModel(paraderox);
            rpx.setEst_rp((Boolean) resultado[10]);
            rpList.add(rpx);
        }
        return rpList;
    }

}
