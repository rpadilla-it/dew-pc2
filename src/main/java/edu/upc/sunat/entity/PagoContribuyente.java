/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rpadilla
 */
@XmlRootElement
public class PagoContribuyente {
    private Integer idTributo;
    private String nombre_tributo;
    private Integer ejercicio;
    private Integer periodo;
    private String idcontribuyente_ruc;
    private String razon_social;
    private String nombre_tipo;
    private String fechaRegistro;

    public PagoContribuyente(){
        
    }
            
    public PagoContribuyente(Integer idTributo, String nombre_tributo, Integer ejercicio, Integer periodo, String idcontribuyente_ruc, String razon_social, String nombre_tipo, String fechaRegistro) {
        this.idTributo = idTributo;
        this.nombre_tributo = nombre_tributo;
        this.ejercicio = ejercicio;
        this.periodo = periodo;
        this.idcontribuyente_ruc = idcontribuyente_ruc;
        this.razon_social = razon_social;
        this.nombre_tipo = nombre_tipo;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdTributo() {
        return idTributo;
    }

    public void setIdTributo(Integer idTributo) {
        this.idTributo = idTributo;
    }

    public String getNombre_tributo() {
        return nombre_tributo;
    }

    public void setNombre_tributo(String nombre_tributo) {
        this.nombre_tributo = nombre_tributo;
    }

    public Integer getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Integer ejercicio) {
        this.ejercicio = ejercicio;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public String getIdcontribuyente_ruc() {
        return idcontribuyente_ruc;
    }

    public void setIdcontribuyente_ruc(String idcontribuyente_ruc) {
        this.idcontribuyente_ruc = idcontribuyente_ruc;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
}
