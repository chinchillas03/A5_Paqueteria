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

    public double calcularCosto() {
        double costoAdicional = 0;

        if (this.distancia > 10) {
            costoAdicional += (distancia - 10) * 5.0;
        }

        costoTotal = servicio.calcularCostoServicio() + transporte.getCosto() + paquete.calcularCosto() + costoAdicional;

        return costoTotal;
    }
    
    public double calcularTiempo(){
        double tiempoHoras =  distancia / transporte.getVelocidad();
        
        double tiempoMinutos = tiempoHoras * 60;
        
        return tiempoMinutos;
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
