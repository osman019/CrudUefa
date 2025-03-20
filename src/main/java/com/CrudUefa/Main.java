package com.CrudUefa;


import java.util.Scanner;

import com.CrudUefa.application.usecase.equipocase.EquipoUseCase;


import com.CrudUefa.domain.repository.EquipoRespository;
import com.CrudUefa.infrastructure.database.ConnectionFactory;
import com.CrudUefa.infrastructure.persistence.Equipo.EquipoRepositoryImpl;




public class Main {
    public static void main(String[] args) {
        EquipoRespository equipoRepository = new EquipoRepositoryImpl(ConnectionFactory.crearConexion());
       
       

        
        EquipoUseCase equipoUseCase = new EquipoUseCase(equipoRepository);

       
        try (Scanner teclado = new Scanner(System.in)) {
            int option;

            do {
                System.out.println("---------------------------------");
                System.out.println("-     MENU PRINCIPAL            -");
                System.out.println("---------------------------------");
                System.out.println("Seleccione una opción:");
                System.out.println("1. Gestión de Equipos");
                System.out.println("2. Gestión de Jugadores");
                System.out.println("0. Salir");
                System.out.println("----------------------------------");
                System.out.print("Ingrese opción: ");

                while (!teclado.hasNextInt()) {
                    System.out.println("¡Entrada inválida. Ingrese solo números válidos!.");
                    teclado.next();
                }
                option = teclado.nextInt();
                teclado.nextLine(); 

                switch (option) {
                    case 1:
                        menuEquipos(teclado, equipoUseCase);
                        break;
                    case 2:
                        menuJugadores(teclado);
                        break;
                    case 0:
                        System.out.println("Vuelve pronto.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        break;
                }
            } while (option != 0);
        }
    }

    private static void menuEquipos(Scanner teclado, EquipoUseCase equipoUseCase) {
        int option;
        do {
            System.out.println("---------------------------------");
            System.out.println("-     GESTIÓN DE EQUIPOS        -");
            System.out.println("---------------------------------");
            System.out.println("1. Gestionar Equipos");
            System.out.println("2. Listar Equipos");
            System.out.println("3. Actualizar datos de Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("0. Volver al menú principal");
            System.out.println("----------------------------------");
            System.out.print("Ingrese opción: ");

            while (!teclado.hasNextInt()) {
                System.out.println("¡Entrada inválida. Ingrese solo números válidos!.");
                teclado.next();
            }
            option = teclado.nextInt();
            teclado.nextLine(); 

            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre del equipo: ");
                    String name = teclado.nextLine();
     
                    System.out.println("Ingrese el Año de fundacion del equipo: ");
                    int yearfoundation = teclado.nextInt();

                    System.out.println("Ingrese el coach del equipo: ");
                    String coach = teclado.nextLine();

                     equipoUseCase.guardar(yearfoundation, name, coach);
                    System.out.println("EQUIPO REGISTRADO CON ÉXITO");
                    break;

                case 2:
                    System.out.println("Lista de Equipos: ");
                    // List<Equipo> equipos = clientUseCase.listarClientes();
                    // for (Equipo equipo : equipos) {
                    //     System.out.println(equipo);
                    // }
                    break;

                case 3:
                    System.out.println("Ingrese el ID del equipo a actualizar: ");
                    int id = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("Ingrese el nuevo nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.println("Ingrese el nuevo coach: ");
                     coach = teclado.nextLine();

                     EquipoUseCase.actualizarEquipos(id, nombre, coach);
                    System.out.println("EQUIPO ACTUALIZADO CON ÉXITO");
                    break;

                case 4:
                    System.out.println("Ingrese el ID del equipo a eliminar: ");
                    id = teclado.nextInt();
                    teclado.nextLine();

                    // clientUseCase.eliminarCliente(id);
                    System.out.println("EQUIPO ELIMINADO CON ÉXITO");
                    break;

                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (option != 0);
    }

    private static void menuJugadores(Scanner teclado) {
        int option;
        do {
            System.out.println("---------------------------------");
            System.out.println("-     GESTIÓN DE JUGADORES      -");
            System.out.println("---------------------------------");
            System.out.println("1. Gestionar jugadores");
            System.out.println("2. Listar jugadores");
            System.out.println("3. Eliminar jugadores");
            System.out.println("4. Actualizar jugadores");
            System.out.println("0. Volver al menú principal");
            System.out.println("----------------------------------");
            System.out.print("Ingrese opción: ");

            while (!teclado.hasNextInt()) {
                System.out.println("¡Entrada inválida. Ingrese solo números válidos!.");
                teclado.next();
            }
            option = teclado.nextInt();
            teclado.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Ingrese el ID del jugador: ");
                    int id = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("Ingrese el nombre del jugador: ");
                    String nombre = teclado.nextLine();

                    System.out.println("Ingrese la posición del jugador: ");
                    String posicion = teclado.nextLine();

                    // productUseCase.registrarproducto(id, nombre, posicion);
                    System.out.println("JUGADOR REGISTRADO CON ÉXITO");
                    break;

                case 2:
                    System.out.println("Lista de jugadores:");
                    // List<Jugador> jugadores = productUseCase.listarProductos();
                    // for (Jugador jugador : jugadores) {
                    //     System.out.println(jugador);
                    // }
                    break;

                case 3:
                    System.out.println("Ingrese el ID del jugador que desea eliminar: ");
                    id = teclado.nextInt();
                    teclado.nextLine();

                    // productUseCase.eliminarproducto(id);
                    System.out.println("JUGADOR ELIMINADO CON ÉXITO");
                    break;

                case 4:
                    System.out.println("Ingrese el ID del jugador que desea actualizar: ");
                    id = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("Ingrese el nuevo nombre del jugador: ");
                    nombre = teclado.nextLine();

                    System.out.println("Ingrese la nueva posición del jugador: ");
                    posicion = teclado.nextLine();

                    // productUseCase.actualizarproducto(id, nombre, posicion);
                    System.out.println("JUGADOR ACTUALIZADO CON ÉXITO");
                    break;

                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (option != 0);
    }
}