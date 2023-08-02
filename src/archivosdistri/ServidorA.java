/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosdistri;

/**
 *
 * @author alebe
 */
import java.rmi.registry.*;

public class ServidorA {
    public static void main(String[] args){
        try{
            //System.setProperty("java.rmi.server.hostname", "localhost");
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
            r.rebind("interfazArchivos", new rmiArchivos());
            System.out.println("\t\tServidor conectado!!");
        }catch(Exception e){System.out.println("Servidor no conectado " + e.getMessage());}
    }
}