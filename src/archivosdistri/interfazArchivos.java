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

import java.rmi.*;

public interface interfazArchivos extends Remote{
    
    public void borrarArchivo(String ru) throws RemoteException;
    
    public void crearArchivo(String ru, String nom) throws RemoteException;
    
    public void cambiarNombreArchivo(String ru, String nom) throws RemoteException;
    
    public void copiarArchivo(String ru, String nue) throws RemoteException;
    
    public void moverArchivo(String ru, String nue) throws RemoteException;
}
