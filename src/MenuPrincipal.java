import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();
        boolean salir = false;

        while (!salir) {
            System.out.println("=== AGENDA DE CONTACTOS ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Listar contactos (orden alfabetico)");
            System.out.println("5. Listar historial (orden de insercion)");
            System.out.println("6. Agregar grupo");
            System.out.println("7. Agregar contacto a grupo");
            System.out.println("8. Listar grupos");
            System.out.println("9. Mostrar contactos por grupo");
            System.out.println("10. Salir");
            System.out.println("==========================");
            System.out.println("Elige una opcion:");

            if (!sc.hasNextInt()) {
                System.out.println("Opcion invalida, intente de nuevo");
                sc.nextLine();
                continue;
            }

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nAGREGAR CONTACTO");
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    agenda.agregarContacto(new Contacto(nombre, telefono, email));
                    break;

                case 2:
                    System.out.print("Nombre a buscar: ");
                    String nombreBuscar = sc.nextLine();
                    Contacto contacto = agenda.buscarContacto(nombreBuscar);
                    if (contacto != null) {
                        System.out.println(contacto);
                    } else {
                        System.out.println("Contacto no encontrado: " + nombreBuscar);
                    }
                    break;

                case 3:
                    System.out.print("Nombre a eliminar: ");
                    String nombreEliminar = sc.nextLine();
                    agenda.eliminarContacto(nombreEliminar);
                    break;

                case 4:
                    agenda.listarContactos();
                    break;

                case 5:
                    agenda.listarHistorial();
                    break;

                case 6:
                    System.out.print("Nombre del grupo: ");
                    String nuevoGrupo = sc.nextLine();
                    agenda.agregarGrupo(nuevoGrupo);
                    break;

                case 7:
                    System.out.print("Nombre del contacto: ");
                    String contactoGrupo = sc.nextLine();
                    System.out.print("Nombre del grupo: ");
                    String grupoDestino = sc.nextLine();
                    agenda.agregarContactoAGrupo(contactoGrupo, grupoDestino);
                    break;

                case 8:
                    System.out.println("LISTA DE GRUPOS");
                    agenda.listargrupos();
                    break;

                case 9:
                    System.out.print("Nombre del grupo: ");
                    String grupoConsulta = sc.nextLine();
                    agenda.mostrarContactosPorGrupo(grupoConsulta);
                    break;

                case 10:
                    System.out.println("Saliendo de la agenda...");
                    salir = true;
                    break;

                default:
                    System.out.println("Opcion invalida, intenta de nuevo");
                    break;
            }

        }

        sc.close();

    }
}
