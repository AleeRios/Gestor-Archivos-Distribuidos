/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivosdistri;

/**
 *
 * @author alebe
 */

import java.rmi.server.*;
import java.rmi.*;
import java.nio.file.*;
import java.io.*;
import java.util.Scanner;
        
public class rmiArchivos extends UnicastRemoteObject implements interfazArchivos{
    
    
    public rmiArchivos() throws RemoteException{
        System.out.println("RMI Conectado");
    }
    
    public void borrarArchivo(String ru) throws RemoteException{
        Path ruta=Paths.get(ru);
        if(Files.exists(ruta)){
            try {
                Files.delete(ruta);
                System.out.println("\t\tArchivo eliminado correctamente!!");
            }catch(IOException ex){System.out.println("Error al eliminar archivo: " + ex.getMessage());}
        }else System.out.println("El archivo no existe");
    }
    
    public void crearArchivo(String ru, String nom) throws RemoteException{
        if(ru.equals("")){
            System.out.print("Seleccione una ruta valida");
        }else{
            Path ruta = Path.of(ru + "/" + nom);
            if(!Files.exists(ruta)){
                try {
                    Files.createFile(ruta);
                    System.out.println("\t\tArchivo creado correctamente!!");
                }catch(IOException ex){System.out.println("Error al crear archivo: " + ex.getMessage());}
            }else System.out.println("\t\tEl archivo ya existe!!");
        }
    }
    
    public void cambiarNombreArchivo(String ru, String nom) throws RemoteException{
        File f1 = new File(ru);
        String s = f1.getParent()+ "/" + nom;
        if(f1.exists()){
            f1.renameTo(new File(s));
            System.out.println("\t\tArchivo renombrado correctamente!!");
        }else System.out.println("El archivo que desea renombrar no existe");
    }
    
    public void copiarArchivo(String ru, String nue) throws RemoteException{
        if(ru.equals("")){
            System.out.println("Seleccione Archivo");
        }else if(nue.equals("")){
            System.out.println("Ingresa la nueva ruta"); 
        }else{
            Path ruta = Path.of(ru);
            Path copia = Path.of(nue);
            try {
                Path copiar = Files.copy(ruta,copia.resolve(ruta.getFileName()),StandardCopyOption.REPLACE_EXISTING);
                System.out.println("\t\tArchivo copiado correctamente!!");
            }catch(IOException ex){System.out.println("Error al copiar archivo: " + ex.getMessage());}
        }
    }
    
    public void moverArchivo(String ru, String nue) throws RemoteException{
        if(ru.equals("")){
            System.out.println("Seleccione Archivo");
        }else if(nue.equals("")){
            System.out.println("Ingresa la nueva ruta"); 
        }else{
            Path ruta = Path.of(ru);
            Path copia = Path.of(nue);
            try {
                Path mover = Files.move(ruta,copia.resolve(ruta.getFileName()),StandardCopyOption.REPLACE_EXISTING);
                System.out.println("\t\tArchivo movido correctamente!!");
            }catch(IOException ex){System.out.println("Error al mover archivo: " + ex.getMessage());}
        }
    }
}
