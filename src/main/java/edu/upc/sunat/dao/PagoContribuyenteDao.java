/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat.dao;

import edu.upc.sunat.entity.PagoContribuyente;
import java.util.List;

/**
 *
 * @author rpadilla
 */
public interface PagoContribuyenteDao {
    public List<PagoContribuyente> buscarTodos();
    public List<PagoContribuyente> buscarPorRuc(String ruc);
    public PagoContribuyente buscarPorIdTransaccion(Integer id);
    
}
