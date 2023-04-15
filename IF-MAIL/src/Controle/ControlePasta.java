/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.Email;
import Modelo.Pasta;

/**
 *
 * @author Herbert
 */
public class ControlePasta {
    
        public boolean adicionaEmail(Pasta pasta, Email email) {
        return pasta.getEmails().add(email);
    }

}
