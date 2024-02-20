/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.a5_233233;

/**
 *
 * @author Usuario
 */
public class Servicio {
    
    private TipoServicio servicio;

    public Servicio() {
    }

    public double calcularCostoServicio(){
        if (servicio == TipoServicio.ESTANDAR) {
            return 30;
        }
        if (servicio == TipoServicio.ESTANDAR) {
            return 50;
        }
        return 0;
    }
    
    public TipoServicio getServicio() {
        return servicio;
    }

    public void setServicio(TipoServicio servicio) {
        this.servicio = servicio;
    }
    
}
