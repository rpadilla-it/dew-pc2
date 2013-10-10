/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat;

import edu.upc.sunat.dao.PagoContribuyenteDao;
import edu.upc.sunat.entity.PagoContribuyente;
import edu.upc.sunat.service.PagoContribuyenteService;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rpadilla
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-base-test.xml")
@Transactional
public class PagoContribuyenteDaoTest {
    private static Logger log = LoggerFactory.getLogger(PagoContribuyenteDaoTest.class);
    
    @Autowired
    PagoContribuyenteDao pagoContribuyenteDao;

    @Autowired
    PagoContribuyenteService pagoContribuyenteService;
    
    @Test
    public void testBuscarPorRuc() {
        // Salto el paso prepare por que ya tengo registros en la BD
        //PagoContribuyente pagoContribuyente = new PagoContribuyente("Giancarlo Corzo","gian.corzo@antartec.com","admin");
        //Integer id = pagoContribuyenteDao.insertar(pagoContribuyente);
        
        List<PagoContribuyente> listaPagoContribuyente ;
        listaPagoContribuyente = pagoContribuyenteDao.buscarPorRuc("20516755416");
        Assert.assertNotNull(listaPagoContribuyente);

    }
}
