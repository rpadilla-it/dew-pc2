/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat.controller;

import edu.upc.sunat.entity.CriterioBusquedaPagos;
import edu.upc.sunat.entity.JsonResponse;
import edu.upc.sunat.entity.PagoContribuyente;
import edu.upc.sunat.service.PagoContribuyenteService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rpadilla
 */
@Controller("pagoContribuyenteController")
public class PagoContribuyenteController {
    @Autowired
    private PagoContribuyenteService pagoContribuyenteService;
    private static Logger log = LoggerFactory.getLogger(PagoContribuyenteController.class);
    
    @RequestMapping("/pagos/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("pagos/index");
        List<PagoContribuyente> pagosContribuyente = pagoContribuyenteService.buscarTodos();
        CriterioBusquedaPagos criterioBusqueda = new CriterioBusquedaPagos();
        mav.addObject("pagosContribuyente", pagosContribuyente);
        mav.addObject("criterioBusqueda",criterioBusqueda);
        return mav;
    }
    
    
    @RequestMapping(value = "/pagos/buscar", method=RequestMethod.POST)
    public ModelAndView buscar(@ModelAttribute("criterioBusqueda") CriterioBusquedaPagos criterio, SessionStatus status) {

        log.info("resultado = " + pagoContribuyenteService.buscarPorRuc(criterio.getRuc()).size());
        
        ModelAndView mav = new ModelAndView("pagos/resultadoBusqueda");
        mav.getModel().put("resultado",pagoContribuyenteService.buscarPorRuc(criterio.getRuc()));
        
        return mav;
    }
    
    @RequestMapping(value = "/listarpagos", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse listMyFiles() {
        List<PagoContribuyente> listaPagos = pagoContribuyenteService.buscarTodos();
        return new JsonResponse(true, listaPagos);
    }
}
