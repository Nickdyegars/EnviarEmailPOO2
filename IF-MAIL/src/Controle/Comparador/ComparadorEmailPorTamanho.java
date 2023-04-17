/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle.Comparador;

import Modelo.Email;
import java.util.Comparator;

/**
 *
 * @author Okami
 */
public class ComparadorEmailPorTamanho implements Comparator<Email>{

    @Override
    public int compare(Email o1, Email o2) {
        if(o1.getTamanho() < o2.getTamanho()){
            return -1;
        }
        if(o1.getTamanho() > o2.getTamanho()){
            return 1;
        }
        return 0;
    }




    
}
