/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;


/**
 *
 * @author nicke
 */
public class ControleListEmails implements ListModel<String> {
    private List<String> elementos;

    public ControleListEmails(List<String> elementos) {
        this.elementos = elementos;
    }

    @Override
    public int getSize() {
        return elementos.size();
    }

    @Override
    public String getElementAt(int index) {
        return elementos.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        // Implementação não necessária neste exemplo
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        // Implementação não necessária neste exemplo
    }
}
