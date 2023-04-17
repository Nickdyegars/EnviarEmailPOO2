/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Servidor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author nicke
 */
public class Empacotamento 
{
     public static void gravarArquivoBinario(Servidor servidor, String nomeArq) 
     {
      File arq = new File(nomeArq);
      try 
      {
        arq.delete();
        arq.createNewFile();

        ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
        objOutput.writeObject(servidor);
        objOutput.close();

      } 
      catch(IOException erro) 
      {
          System.out.printf("Erro: %s", erro.getMessage());
      }
    }
     
     public static Servidor lerArquivoBinario(String nomeArq) {
      Servidor servidor = new Servidor();
      try 
      {
        File arq = new File(nomeArq);
        if (arq.exists()) 
        {
           ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
           servidor = (Servidor)objInput.readObject();
           objInput.close();
        }
      } 
      catch(IOException | ClassNotFoundException erro1) 
      {
          System.out.printf("Erro: %s", erro1.getMessage());
      }

      return servidor;
    }
}
