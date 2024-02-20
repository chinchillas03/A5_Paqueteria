/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FactoryCaja;

import com.itson.a5_233233.Caja;
import com.itson.a5_233233.CajaMediana;

/**
 *
 * @author Usuario
 */
public class CajaMedianaFactory implements CajaFactory{

    @Override
    public Caja crearCaja() {
        return new CajaMediana();
    }
    
}
