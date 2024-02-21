/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.itson.a5_233233;

import FactoryCaja.CajaGrandeFactory;
import FactoryCaja.CajaMedianaFactory;
import FactoryCaja.CajaPequenaFactory;
import FactoryTransporte.AutoFactory;
import FactoryTransporte.BicicletaFactory;
import FactoryTransporte.DronFactory;
import FactoryTransporte.MotoFactory;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class A5_233233 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Servicio s = new Servicio();
        Pedido pedido = new Pedido();
        
        System.out.println("Ingrese el tipo de servicio (estandar(es) o express(ex)):");
        String tipoServicio = scanner.nextLine();

        System.out.println("Ingrese el tamaño del paquete (sobre (s), caja pequeña(p), mediana(m) o grande(g)):");
        String tamañoPaquete = scanner.nextLine();

        System.out.println("Ingrese la distancia en kilómetros:");
        double distanciaKm = scanner.nextDouble();      
        
        if (tipoServicio.equalsIgnoreCase("es")) {
            s.setServicio(TipoServicio.ESTANDAR);
        }else if (tipoServicio.equalsIgnoreCase("ex")) {
            s.setServicio(TipoServicio.EXPRESS);
        }else{
            System.out.println("Tipo de servicio erroneo...");            
        }
        
            pedido.setServicio(s);
            
        if (tamañoPaquete.equalsIgnoreCase("s")) {
            pedido.setPaquete(new Sobre());
        } else if (tamañoPaquete.equalsIgnoreCase("p")) {
            CajaPequena cp = (CajaPequena) new CajaPequenaFactory().crearCaja();
            pedido.setPaquete(cp);
        } else if (tamañoPaquete.equalsIgnoreCase("m")) {
            CajaMediana cp = (CajaMediana) new CajaMedianaFactory().crearCaja();
            pedido.setPaquete(cp);
        } else if (tamañoPaquete.equalsIgnoreCase("g")) {
            CajaGrande cp = (CajaGrande) new CajaGrandeFactory().crearCaja();
            pedido.setPaquete(cp);
        } else {
            System.out.println("Tamaño de paquete no válido.");
        }
        
        pedido.setDistancia(distanciaKm);
        
        calcularTransporte(pedido, s);
        
    }
    
    public static void calcularTransporte(Pedido pedido, Servicio servicio) {
        double distancia = pedido.getDistancia();
        Paquete paquete = pedido.getPaquete();
        Transporte transporte = null;
        
        if ((paquete instanceof Sobre || paquete instanceof CajaPequena) && distancia <= 1 && servicio.getServicio() == TipoServicio.EXPRESS){
            transporte = new DronFactory().crearTransporte();
        } else if (servicio.getServicio() == TipoServicio.ESTANDAR) {
            transporte = new BicicletaFactory().crearTransporte();
        }
        if ((paquete instanceof Sobre || paquete instanceof CajaPequena) && distancia > 1 && servicio.getServicio() == TipoServicio.ESTANDAR) { 
            transporte = new BicicletaFactory().crearTransporte();
        } else if (servicio.getServicio() == TipoServicio.EXPRESS) {
            transporte = new MotoFactory().crearTransporte();
        }
        if (paquete instanceof CajaMediana && distancia <= 5 && servicio.getServicio() == TipoServicio.ESTANDAR) {
            transporte = new BicicletaFactory().crearTransporte();
        } else if (servicio.getServicio() == TipoServicio.EXPRESS || distancia > 5) {
            transporte = new MotoFactory().crearTransporte();
        }
        
        if (paquete instanceof CajaGrande) {
            transporte = new AutoFactory().crearTransporte();
        }
        
        pedido.setTransporte(transporte);
        
        System.out.println("El total del pedido es: " + pedido.calcularCosto());
        System.out.println("El tiempo total en minutos del pedidos es de: " + pedido.calcularTiempo());
        
        
    }
}
