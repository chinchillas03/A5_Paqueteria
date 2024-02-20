/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FactoryTransporte;

import com.itson.a5_233233.Moto;
import com.itson.a5_233233.Transporte;

/**
 *
 * @author Usuario
 */
public class MotoFactory implements TransporteFactory{

    @Override
    public Transporte crearTransporte() {
        return new Moto();
    }
    
}
