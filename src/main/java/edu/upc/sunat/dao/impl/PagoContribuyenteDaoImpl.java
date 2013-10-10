/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat.dao.impl;

import edu.upc.sunat.dao.PagoContribuyenteDao;
import edu.upc.sunat.entity.PagoContribuyente;
import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rpadilla
 */
@Repository
public class PagoContribuyenteDaoImpl extends SimpleJdbcDaoSupport implements PagoContribuyenteDao{
    private static Logger log = LoggerFactory.getLogger(PagoContribuyenteDaoImpl.class);

    @Autowired
    public PagoContribuyenteDaoImpl(DataSource dataSource) {
        log.info("Asignando el dataSource");
        setDataSource(dataSource);
    }
    
    @Override
    public List<PagoContribuyente> buscarTodos() {
        return getSimpleJdbcTemplate().query(
                "SELECT `pagoContribuyente`.`idTributo`,\n" +
                " `tributo`.`nombre_tributo`, " +
                " `pagoContribuyente`.`ejercicio`, " +
                " `pagoContribuyente`.`periodo`, " +
                " `contribuyente`.`idcontribuyente_ruc`, " +
                " `contribuyente`.`razon_social`, " +
                " `tipoContribuyente`.`nombre_tipo`, " +
                " `pagoContribuyente`.`fechaRegistro` " +
                "FROM `sunat`.`pagoContribuyente` " +
                "INNER JOIN `sunat`.`tributo` ON `pagoContribuyente`.`idTributo` =  `tributo`.`idtributo` " +
                "INNER JOIN `sunat`.`contribuyente` ON `pagoContribuyente`.`idcontribuyente` = `contribuyente`.`idcontribuyente_ruc` " +
                "INNER JOIN `sunat`.`tipoContribuyente` ON `contribuyente`.`tipo_contribuyente` = `tipoContribuyente`.`idtipo_contribuyente` ",
                new BeanPropertyRowMapper<PagoContribuyente>(PagoContribuyente.class));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PagoContribuyente> buscarPorRuc(String ruc) {
        try {
            return getSimpleJdbcTemplate().query(
                "SELECT `pagoContribuyente`.`idTributo`, " +
                " `tributo`.`nombre_tributo`, " +
                " `pagoContribuyente`.`ejercicio`, " +
                " `pagoContribuyente`.`periodo`, " +
                " `contribuyente`.`idcontribuyente_ruc`, " +
                " `contribuyente`.`razon_social`, " +
                " `tipoContribuyente`.`nombre_tipo`, " +
                " `pagoContribuyente`.`fechaRegistro` " +
                "FROM `sunat`.`pagoContribuyente` " +
                "INNER JOIN `sunat`.`tributo` ON `pagoContribuyente`.`idTributo` =  `tributo`.`idtributo` " +
                "INNER JOIN `sunat`.`contribuyente` ON `pagoContribuyente`.`idcontribuyente` = `contribuyente`.`idcontribuyente_ruc` " +
                "INNER JOIN `sunat`.`tipoContribuyente` ON `contribuyente`.`tipo_contribuyente` = `tipoContribuyente`.`idtipo_contribuyente` " +
                "WHERE `contribuyente`.`idcontribuyente_ruc`=?",
                    new BeanPropertyRowMapper<PagoContribuyente>(PagoContribuyente.class), ruc);

            
        } catch (EmptyResultDataAccessException e) {
            log.info("************** Resultado Vacio de la consulta SQL.");
            return null;
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PagoContribuyente buscarPorIdTransaccion(Integer id) {
         try {
            return getSimpleJdbcTemplate().queryForObject(
                "SELECT `pagoContribuyente`.`idTributo`, " +
                " `tributo`.`nombre_tributo`, " +
                " `pagoContribuyente`.`ejercicio`, " +
                " `pagoContribuyente`.`periodo`, " +
                " `contribuyente`.`idcontribuyente_ruc`, " +
                " `contribuyente`.`razon_social`, " +
                " `tipoContribuyente`.`nombre_tipo`, " +
                " `pagoContribuyente`.`fechaRegistro` " +
                "FROM `sunat`.`pagoContribuyente` " +
                "INNER JOIN `sunat`.`tributo` ON `pagoContribuyente`.`idTributo` =  `tributo`.`idtributo` " +
                "INNER JOIN `sunat`.`contribuyente` ON `pagoContribuyente`.`idcontribuyente` = `contribuyente`.`idcontribuyente_ruc` " +
                "INNER JOIN `sunat`.`tipoContribuyente` ON `contribuyente`.`tipo_contribuyente` = `tipoContribuyente`.`idtipo_contribuyente` " +
                "WHERE `pagoContribuyente`.`idpago_contribuyente`=?",
                    new BeanPropertyRowMapper<PagoContribuyente>(PagoContribuyente.class), id);

            
        } catch (EmptyResultDataAccessException e) {
            log.info("************** Resultado Vacio de la consulta SQL.");
            return null;
        }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
