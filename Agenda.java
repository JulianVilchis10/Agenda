package agenda;
import persona.Persona;
import java.util.*;

public class Agenda {
    public ArrayList<Contacto> contactos = new ArrayList<Contacto>();
    Contacto c = null;
    Scanner read = new Scanner(System.in);

    public void agregar() {
        c = new Contacto();
        
        System.out.println("Ingrese nombre: ");
        c.setNombre(read.nextLine());
        String cad = c.getNombre();
        System.out.println("Ingrese paterno: ");
        c.setPaterno(read.nextLine());
        System.out.println("Ingrese materno: ");
        c.setMaterno(read.nextLine());
        System.out.println("Ingrese telefono: ");
        c.setTelefono(read.nextLine());
        System.out.println("Ingrese email: ");
        c.setEmail(read.nextLine());

        contactos.add(c);
    }

    public boolean vacia() {
        if(contactos.isEmpty())
            return true;
        else         
            return false;
    }

    public void eliminar() {
        if(!vacia()) { 
            mostrar();
            int i = 100;
            boolean flag = false;
            System.out.println("\nIngrese el nombre o numero de contacto a eliminar: ");
            String indice = read.nextLine();;
            try {
                i = Integer.valueOf(indice);
                if(i <= contactos.size()) {
                    contactos.remove(i-1);
                    System.out.println("Contacto eliminado ...");
                }
                else 
                    System.out.println("Ingrese un numero existente...");
            } catch(NumberFormatException e) {
                System.out.println("Ingreso nombre... "); 
                int ip=0;   
                for (Contacto persona : contactos) {
                    if(persona.getNombre().equalsIgnoreCase(indice)) {
                        ip = contactos.indexOf(persona);
                        flag = true;
                        System.out.println("Eliminado...");
                    }
                }
                if(flag)
                    contactos.remove(ip);
                else 
                    System.out.println("Ingrese un nombre existente...");    
            }
        }
        else {
            mostrar();
        }
    }   

    public void mostrar() {
        if(vacia()) {
            System.out.println("Agenda vacia.");
        }
        else {
            int i = 0;    
            for (Contacto persona : contactos) {
                i++;
                System.out.println( i + ") " + persona);
            }
        }    
    }

    public void agendaVacia() {
        if(vacia()) {
            System.out.println("No hay ningun contacto...");
        } else {
            int op = contactos.size();
            contactos.clear();
            System.out.println("Contactos eliminados: " + op);
        }
    }

    public void buscar() {
        System.out.println("**********La busqueda se hace por nombre.***************");
        System.out.println("Ingrese nombre del contacto ");
        String tmp = read.nextLine();
        boolean f = true;

        for (Contacto persona : contactos) {
            if(persona.getNombre().equalsIgnoreCase(tmp)) {
                System.out.println("Encontrado...");
                System.out.println(persona);
                f = false;
            }
        }
        if(f) System.out.println("No encontrado...");
    }

    public void modificar() {
        int i = 0;
        if(!vacia()) {
            mostrar();
            boolean flag = false;
            System.out.println("Seleccione el numero de contacto a modificar... ");
            i = read.nextInt();
            if(i <= contactos.size()) {
                System.out.println(contactos.get(i-1));
                System.out.println("\t\t\tContacto seleccionado...");
                System.out.println("\t\t\t¿Que dato desea modificar?");
                System.out.println("\t\t\t1) Nombre 2) Paterno 3) Materno 4) Telefono 5) E-mail");
                int ip = read.nextInt();
                read.nextLine();
                String tmp = "";
                switch(ip) { 
                    case 1:
                        System.out.println("Ingrese nuevo nombre: ");
                        tmp = read.nextLine();
                        contactos.get(i-1).setNombre(tmp);
                        break;
                    case 2: 
                        System.out.println("Ingrese nuevo apellido: ");
                        tmp = read.nextLine();
                        contactos.get(i-1).setPaterno(tmp);
                        break;
                    case 3: 
                        System.out.println("Ingrese nuevo apellido: ");
                        tmp = read.nextLine();
                        contactos.get(i-1).setMaterno(tmp);
                        break;
                    case 4: 
                        System.out.println("Ingrese nuevo telefono: ");
                        tmp = read.nextLine();
                        contactos.get(i-1).setTelefono(tmp);
                        break;
                    case 5: 
                        System.out.println("Ingrese nuevo email: ");
                        tmp = read.nextLine();
                        contactos.get(i-1).setEmail(tmp);
                        break;
                    default: 
                        System.out.println("Ingrese op valida..");
                        flag = true;
                        break;            
                }
                if(flag == false) {
                    System.out.println("Contacto modificado \n" + contactos.get(i-1));
                }
            }     
            else 
                System.out.println("Contacto inexistente");
        }
        else 
            mostrar();
    }
}