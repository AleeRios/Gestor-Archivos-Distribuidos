/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosdistri;

/**
 *
 * @author alebe
 */

import java.util.Scanner;
import java.rmi.registry.*;

public class ClienteA {
    
    public static void main(String[] args){
        Scanner x = new Scanner(System.in);
        try{
            Registry registro = LocateRegistry.getRegistry("localhost",1099);
            interfazArchivos ia = (interfazArchivos) registro.lookup("interfazArchivos");
            System.out.println("Conectado con el Servidor");
            
            do{
                System.out.println("\n\t\tMenu de opciones");
                System.out.println("1.- Crear un archivo");
                System.out.println("2.- Mover un archivo");
                System.out.println("3.- Copiar un archivo");
                System.out.println("4.- Borrar un archivo");
                System.out.println("5.- Cambiar nombre de un archivo");
                System.out.println("6.- Salir");
                System.out.print("Ingresa una opcion: ");
                int op = x.nextInt();
                System.out.println();

                switch(op){
                    case 1:
                        Scanner x1 = new Scanner(System.in);
                        System.out.print("Ingresa la ruta: ");
                        String ru = x1.nextLine();
                        System.out.print("\nIngresa el nombre: ");
                        String nom = x1.nextLine();
                        ia.crearArchivo(ru, nom);
                        break;
                    case 2:
                        Scanner x5 = new Scanner(System.in);
                        System.out.print("Ingresa la ruta o el nombre: ");
                        String ru5 = x5.nextLine();
                        System.out.print("\nIngresa la nueva ruta para mover: ");
                        String nue5 = x5.nextLine();
                        ia.moverArchivo(ru5, nue5);
                        break;
                    case 3:
                        Scanner x4 = new Scanner(System.in);
                        System.out.print("Ingresa la ruta o el nombre: ");
                        String ru4 = x4.nextLine();
                        System.out.print("\nIngresa la nueva ruta para copiar: ");
                        String nue4 = x4.nextLine();
                        ia.copiarArchivo(ru4, nue4);
                        break;
                    case 4:
                        Scanner x2 = new Scanner(System.in);
                        System.out.print("Ingresa la ruta o el nombre: ");
                        String ru1 = x2.nextLine();
                        ia.borrarArchivo(ru1);
                        break;
                    case 5:
                        Scanner x3 = new Scanner(System.in);
                        System.out.print("Ingresa la ruta o el nombre: ");
                        String ru3 = x3.nextLine();
                        System.out.print("\nIngresa el nuevo nombre: ");
                        String nom3 = x3.nextLine();
                        ia.cambiarNombreArchivo(ru3, nom3);
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }while(true);
        }catch(Exception e){System.out.println("Servidor desconectado " + e.getMessage());}
    }
    
    public static void conectar() throws Exception{
        
    }
}
