package org.example;

import conexion.Conexion;
import dao.*;
import modelo.*;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static final AutorDAO autorDAO = new AutorDAO();
    private static final LibroDAO libroDAO = new LibroDAO();
    private static final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static final PrestamoDAO prestamoDAO = new PrestamoDAO();
    private static final MultaDAO multaDAO = new MultaDAO();

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Connection conn = Conexion.getConnection();
        if (conn == null) {
            System.out.println("❌ No se pudo establecer conexión con la base de datos.");
            return;
        }

        int opcionPrincipal;
        do {
            mostrarMenuPrincipal();
            System.out.print("👉 Elige una opción: ");
            opcionPrincipal = sc.nextInt();
            sc.nextLine();

            switch (opcionPrincipal) {
                case 1 -> menuAutores();
                case 2 -> menuLibros();
                case 3 -> menuUsuarios();
                case 4 -> menuPrestamos();
                case 5 -> menuMultas();
                case 0 -> System.out.println("👋 Saliendo del sistema...");
                default -> System.out.println("⚠️ Opción no válida. Intenta de nuevo.");
            }
        } while (opcionPrincipal != 0);

        Conexion.cerrarConexion();
    }

    // ================== MENÚS ==================

    private static void mostrarMenuPrincipal() {
        System.out.println("""
                
                ==============================
                📚 SISTEMA DE BIBLIOTECA
                ==============================
                1. Gestión de Autores
                2. Gestión de Libros
                3. Gestión de Usuarios
                4. Gestión de Préstamos
                5. Gestión de Multas
                0. Salir
                ==============================
                """);
    }

    private static void menuAutores() {
        int opcion;
        do {
            System.out.println("""
                    
                    === GESTIÓN DE AUTORES ===
                    1. Insertar autor
                    2. Listar autores
                    0. Volver al menú principal
                    """);
            System.out.print("👉 Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> insertarAutor();
                case 2 -> listarAutores();
                case 0 -> System.out.println("↩️ Volviendo al menú principal...");
                default -> System.out.println("⚠️ Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void menuLibros() {
        int opcion;
        do {
            System.out.println("""
                    
                    === GESTIÓN DE LIBROS ===
                    1. Insertar libro
                    2. Listar libros
                    0. Volver al menú principal
                    """);
            System.out.print("👉 Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> insertarLibro();
                case 2 -> listarLibros();
                case 0 -> System.out.println("↩️ Volviendo al menú principal...");
                default -> System.out.println("⚠️ Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void menuUsuarios() {
        int opcion;
        do {
            System.out.println("""
                    
                    === GESTIÓN DE USUARIOS ===
                    1. Insertar usuario
                    2. Listar usuarios
                    0. Volver al menú principal
                    """);
            System.out.print("👉 Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> insertarUsuario();
                case 2 -> listarUsuarios();
                case 0 -> System.out.println("↩️ Volviendo al menú principal...");
                default -> System.out.println("⚠️ Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void menuPrestamos() {
        int opcion;
        do {
            System.out.println("""
                    
                    === GESTIÓN DE PRÉSTAMOS ===
                    1. Registrar préstamo
                    2. Listar préstamos
                    0. Volver al menú principal
                    """);
            System.out.print("👉 Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> registrarPrestamo();
                case 2 -> listarPrestamos();
                case 0 -> System.out.println("↩️ Volviendo al menú principal...");
                default -> System.out.println("⚠️ Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void menuMultas() {
        int opcion;
        do {
            System.out.println("""
                    
                    === GESTIÓN DE MULTAS ===
                    1. Registrar multa
                    2. Listar multas
                    0. Volver al menú principal
                    """);
            System.out.print("👉 Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> registrarMulta();
                case 2 -> listarMultas();
                case 0 -> System.out.println("↩️ Volviendo al menú principal...");
                default -> System.out.println("⚠️ Opción no válida.");
            }
        } while (opcion != 0);
    }

    // ================== FUNCIONES CRUD ==================

    private static void insertarAutor() {
        System.out.print("Nombre del autor: ");
        String nombre = sc.nextLine();
        System.out.print("Nacionalidad: ");
        String nacionalidad = sc.nextLine();

        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setNacionalidad(nacionalidad);

        autorDAO.insertar(autor);
    }

    private static void listarAutores() {
        List<Autor> autores = autorDAO.listar();
        if (autores.isEmpty()) System.out.println("No hay autores registrados.");
        else autores.forEach(System.out::println);
    }

    private static void insertarLibro() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("ID del autor: ");
        int autorid = sc.nextInt(); sc.nextLine();
        System.out.print("Género: ");
        String genero = sc.nextLine();
        System.out.print("Año de publicación: ");
        int anio = sc.nextInt();

        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setAutorid(autorid);
        libro.setGenero(genero);
        libro.setAnioPublicacion(anio);

        libroDAO.insertar(libro);
    }

    private static void listarLibros() {
        List<Libro> libros = libroDAO.listar();
        if (libros.isEmpty()) System.out.println("No hay libros registrados.");
        else libros.forEach(System.out::println);
    }

    private static void insertarUsuario() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setTelefono(telefono);

        usuarioDAO.insertar(usuario);
    }

    private static void listarUsuarios() {
        List<Usuario> usuarios = usuarioDAO.listar();
        if (usuarios.isEmpty()) System.out.println("No hay usuarios registrados.");
        else usuarios.forEach(System.out::println);
    }

    private static void registrarPrestamo() {
        System.out.print("ID del usuario: ");
        int usuarioid = sc.nextInt();
        System.out.print("ID del libro: ");
        int libroid = sc.nextInt();
        sc.nextLine();

        Prestamo prestamo = new Prestamo();
        prestamo.setUsuarioid(usuarioid);
        prestamo.setLibroid(libroid);
        prestamo.setFechaPrestamo(Date.valueOf(LocalDate.now()));
        prestamo.setFechaDevolucion(Date.valueOf(LocalDate.now().plusDays(15)));
        prestamo.setDevuelto(false);

        prestamoDAO.insertar(prestamo);
    }

    private static void listarPrestamos() {
        List<Prestamo> prestamos = prestamoDAO.listar();
        if (prestamos.isEmpty()) System.out.println("No hay préstamos registrados.");
        else prestamos.forEach(System.out::println);
    }

    private static void registrarMulta() {
        System.out.print("ID del préstamo: ");
        int prestamoid = sc.nextInt();
        System.out.print("Monto: ");
        double monto = sc.nextDouble();
        sc.nextLine();

        Multa multa = new Multa();
        multa.setPrestamoid(prestamoid);
        multa.setMonto(monto);
        multa.setPagada(false);

        multaDAO.insertar(multa);
    }

    private static void listarMultas() {
        List<Multa> multas = multaDAO.listar();
        if (multas.isEmpty()) System.out.println("No hay multas registradas.");
        else multas.forEach(System.out::println);
    }
}
