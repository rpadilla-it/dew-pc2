/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat.service.impl;

import edu.upc.sunat.dao.PagoContribuyenteDao;
import edu.upc.sunat.dao.impl.PagoContribuyenteDaoImpl;
import edu.upc.sunat.entity.PagoContribuyente;
import edu.upc.sunat.service.PagoContribuyenteService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rpadilla
 */
@Service
public class PagoContribuyenteServiceImpl implements PagoContribuyenteService{

    private static Logger log = LoggerFactory.getLogger(PagoContribuyenteDaoImpl.class);    
    
    @Autowired
    private PagoContribuyenteDao pagoContribuyenteDao;
    
    @Override
    public List<PagoContribuyente> buscarTodos() {
        log.info("Serice:Buscando todos los pagos");
        return pagoContribuyenteDao.buscarTodos();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PagoContribuyente> buscarPorRuc(String ruc) {
        log.info("Serice:Buscando todos los pagos por ruc de contribuyente");
        return pagoContribuyenteDao.buscarPorRuc(ruc);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
