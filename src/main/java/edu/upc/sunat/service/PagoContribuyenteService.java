/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat.service;

import edu.upc.sunat.entity.PagoContribuyente;
import java.util.List;

/**
 *
 * @author rpadilla
 */
public interface PagoContribuyenteService {
    public List<PagoContribuyente> buscarTodos();
    public List<PagoContribuyente> buscarPorRuc(String ruc);
}
