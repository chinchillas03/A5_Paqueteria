/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.a5_233233;

import FactoryTransporte.AutoFactory;
import FactoryTransporte.BicicletaFactory;
import FactoryTransporte.DronFactory;
import FactoryTransporte.MotoFactory;

/**
 *
 * @author Usuario
 */
public class Pedido {
    
    private Servicio servicio;
    private Transporte transporte;
    private Paquete paquete;
    private double distancia;
    private double costoTotal;

    public Pedido() {
    }

    public Pedido(Servicio servicio, Paquete paquete, double distancia) {
        this.servicio = servicio;
        this.paquete = paquete;
        this.distancia = distancia;
    }

    public double calcular(){
        double costoAdicional = 0;
        if (this.distancia > 10) {
            costoAdicional += (distancia - 10) * 5.0;
        }
        if (servicio.equals(TipoServicio.EXPRESS) && (paquete.equals(CajaPequena.class)) || paquete.equals(Sobre.class) && distancia <= 1) {
            transporte = new DronFactory().crearTransporte();
        } else if (servicio.equals(TipoServicio.ESTANDAR)) {
            transporte = new BicicletaFactory().crearTransporte();
        }
        
        if ((paquete.equals(CajaPequena.class)) || paquete.equals(Sobre.class) && distancia > 1 && servicio.equals(TipoServicio.ESTANDAR)) {
            transporte = new BicicletaFactory().crearTransporte();
        } else if (servicio.equals(TipoServicio.EXPRESS)) {
            transporte = new MotoFactory().crearTransporte();
        }
        
        if (servicio.equals(TipoServicio.ESTANDAR) && distancia <= 5 && (paquete.equals(CajaMediana.class) || paquete.equals(CajaPequena.class))) {
            transporte = new BicicletaFactory().crearTransporte();
        } else if (servicio.equals(TipoServicio.EXPRESS) || distancia > 5) {
            transporte = new MotoFactory().crearTransporte();
        }
        
        if (paquete.equals(CajaGrande.class)) {
            transporte = new AutoFactory().crearTransporte();
        }
        
        costoTotal = servicio.calcularCostoServicio()+ transporte.getCosto() + paquete.calcularCosto() + costoAdicional;
        
        return costoTotal;
    }

    public double getCostoTotal() {
        return costoTotal;
    }
    
    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
}
