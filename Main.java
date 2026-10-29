import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static int idPublicacion = 1;

    public static void main(String[] args)
    {
        // Limpia los datos para poder ejecutar main varias veces en BlueJ
        Estudiante.todos.clear();
        usuarios.clear();
        idPublicacion = 1;

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n===== INTERCAMPUS =====");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Registrar administrador");
            System.out.println("3. Iniciar sesion");
            System.out.println("0. Salir");
            opcion = leerEntero("Opcion: ");

            if (opcion == 1 || opcion == 2) {
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Correo institucional: ");
                String correo = sc.nextLine();
                System.out.print("Contrasena: ");
                String contrasena = sc.nextLine();
                if (buscarUsuario(correo) != null) {
                    System.out.println("Ya existe un usuario con ese correo.");
                } else if (opcion == 1) {
                    System.out.print("Codigo estudiantil: ");
                    String codigo = sc.nextLine();
                    System.out.print("Programa academico: ");
                    String programa = sc.nextLine();
                    int semestre = leerEntero("Semestre: ");
                    usuarios.add(new Estudiante(usuarios.size() + 1, nombre, correo, contrasena,
                            codigo, programa, semestre));
                    System.out.println("Estudiante registrado.");
                } else {
                    usuarios.add(new Administrador(usuarios.size() + 1, nombre, correo, contrasena));
                    System.out.println("Administrador registrado.");
                }
            } else if (opcion == 3) {
                System.out.print("Correo institucional: ");
                String correo = sc.nextLine();
                System.out.print("Contrasena: ");
                String contrasena = sc.nextLine();
                Usuario u = buscarUsuario(correo);
                if (u == null || !u.iniciarSesion(correo, contrasena)) {
                    System.out.println("Correo o contrasena incorrectos, o usuario inactivo.");
                } else {
                    System.out.println("Bienvenido, " + u.nombre);
                    if (u instanceof Estudiante) {
                        menuEstudiante((Estudiante) u);
                    } else {
                        menuAdministrador((Administrador) u);
                    }
                    u.cerrarSesion();
                }
            }
        }
        System.out.println("Hasta pronto.");
    }

    static void menuEstudiante(Estudiante e)
    {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n--- MENU ESTUDIANTE ---");
            System.out.println(" 1. Actualizar perfil            12. Retirar miembro de un grupo");
            System.out.println(" 2. Actualizar intereses         13. Modificar un grupo");
            System.out.println(" 3. Crear horario                14. Desactivar un grupo");
            System.out.println(" 4. Agregar actividad            15. Registrar emprendimiento");
            System.out.println(" 5. Modificar actividad          16. Agregar publicacion");
            System.out.println(" 6. Generar propuesta de horario 17. Editar publicacion");
            System.out.println(" 7. Reorganizar horario          18. Desactivar publicacion");
            System.out.println(" 8. Ver mi informacion           19. Eliminar publicacion");
            System.out.println(" 9. Buscar coincidencias         20. Solicitar soporte");
            System.out.println("10. Crear grupo                  21. Calificar atencion");
            System.out.println("11. Agregar miembro a un grupo   22. Cerrar un ticket");
            System.out.println(" 0. Cerrar sesion");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1: {
                    System.out.print("Nuevo nombre: ");
                    System.out.println("Nombre actualizado: " + e.actualizarPerfil(sc.nextLine()));
                    break;
                }
                case 2: {
                    System.out.print("Intereses separados por coma: ");
                    String[] partes = sc.nextLine().split(",");
                    ArrayList<String> intereses = new ArrayList<>();
                    for (String p : partes) {
                        intereses.add(p.trim().toLowerCase());
                    }
                    e.actualizarIntereses(intereses);
                    System.out.println("Intereses actualizados: " + e.intereses);
                    break;
                }
                case 3: {
                    System.out.print("Periodo academico (ej: 2026-2): ");
                    Horario h = e.crearHorario(sc.nextLine());
                    System.out.println("Horario " + h.idHorario + " creado.");
                    break;
                }
                case 4: {
                    int i = elegir("un horario", e.horarios.size());
                    if (i >= 0) {
                        Horario h = e.horarios.get(i);
                        System.out.print("Nombre de la actividad: ");
                        String nombre = sc.nextLine();
                        System.out.print("Tipo (CLASE, DESCANSO o TRABAJO): ");
                        String tipo = sc.nextLine().toUpperCase();
                        int dia = leerEntero("Dia (1=lunes ... 7=domingo): ");
                        int inicio = leerEntero("Hora de inicio (0-24): ");
                        int fin = leerEntero("Hora de fin (0-24): ");
                        ActividadHorario a = new ActividadHorario(h.actividades.size() + 1,
                                nombre, tipo, dia, inicio, fin);
                        if (h.agregarActividad(a)) {
                            System.out.println("Actividad agregada.");
                        } else {
                            System.out.println("No se pudo agregar: franja invalida o se cruza con otra actividad.");
                        }
                    }
                    break;
                }
                case 5: {
                    int i = elegir("un horario", e.horarios.size());
                    if (i >= 0) {
                        Horario h = e.horarios.get(i);
                        int j = elegir("una actividad", h.actividades.size());
                        if (j >= 0) {
                            ActividadHorario a = h.actividades.get(j);
                            System.out.print("Nuevo nombre: ");
                            String nombre = sc.nextLine();
                            System.out.print("Nuevo tipo (CLASE, DESCANSO o TRABAJO): ");
                            String tipo = sc.nextLine().toUpperCase();
                            int dia = leerEntero("Nuevo dia (1-7): ");
                            int inicio = leerEntero("Nueva hora de inicio: ");
                            int fin = leerEntero("Nueva hora de fin: ");
                            a.actualizarActividad(nombre, tipo, dia, inicio, fin);
                            System.out.println("Actividad actualizada. Franja valida: " + a.validarFranjaHoraria());
                        }
                    }
                    break;
                }
                case 6: {
                    int i = elegir("un horario", e.horarios.size());
                    if (i >= 0) {
                        e.horarios.get(i).generarPropuesta();
                        System.out.println("Propuesta generada.");
                    }
                    break;
                }
                case 7: {
                    int i = elegir("un horario", e.horarios.size());
                    if (i >= 0) {
                        e.horarios.get(i).reorganizar();
                        System.out.println("Horario reorganizado.");
                    }
                    break;
                }
                case 8: {
                    System.out.println("Nombre: " + e.nombre + " | Programa: " + e.programaAcademico
                            + " | Semestre: " + e.semestre);
                    System.out.println("Intereses: " + e.intereses);
                    for (Horario h : e.horarios) {
                        System.out.println("Horario " + h.idHorario + " (" + h.periodoAcademico
                                + ", " + h.estado + ")");
                        for (ActividadHorario a : h.actividades) {
                            System.out.println("   " + a.idActividad + ". " + a.nombre + " ["
                                    + a.tipoActividad + "] dia " + a.diaSemana + ", "
                                    + a.horaInicio + " a " + a.horaFin + " h ("
                                    + a.calcularDuracion() + " min)");
                        }
                    }
                    for (Grupo g : e.grupos) {
                        System.out.println("Grupo " + g.idGrupo + ": " + g.nombreGrupo + " | "
                                + g.tipoGrupo + " | " + g.temaGrupo + " | activo: " + g.activo);
                        for (Estudiante m : g.miembros) {
                            System.out.println("   - " + m.nombre);
                        }
                    }
                    for (Emprendimiento em : e.emprendimientos) {
                        System.out.println("Emprendimiento " + em.idEmprendimiento + ": "
                                + em.nombreEmprendimiento + " | " + em.ubicacionEmprendimiento
                                + " | " + em.contacto + " | " + em.horario);
                        for (Publicacion p : em.publicaciones) {
                            System.out.println("   " + p.idPublicacion + ". " + p.titulo + " ["
                                    + p.tipoPublicacion + "] $" + p.precio + " | activa: " + p.activa);
                        }
                    }
                    for (TicketSoporte t : e.tickets) {
                        System.out.println("Ticket " + t.idTicket + ": " + t.tipoSolicitud + " | "
                                + t.estado + " | respuesta: " + t.respuesta
                                + " | calificacion: " + t.calificacion);
                    }
                    break;
                }
                case 9: {
                    ArrayList<Coincidencia> coincidencias = e.buscarCoincidencias();
                    if (coincidencias.isEmpty()) {
                        System.out.println("No hay coincidencias.");
                    }
                    for (Coincidencia c : coincidencias) {
                        System.out.println(c.estudianteSugerido.nombre + ": "
                                + c.porcentajeCompatibilidad + "% " + c.obtenerCriterios());
                    }
                    break;
                }
                case 10: {
                    System.out.print("Nombre del grupo: ");
                    String nombre = sc.nextLine();
                    System.out.print("Tipo (ACADEMICO o SOCIAL): ");
                    String tipo = sc.nextLine().toUpperCase();
                    System.out.print("Tema: ");
                    String tema = sc.nextLine();
                    Grupo g = e.crearGrupo(nombre, tipo, tema);
                    System.out.println("Grupo " + g.idGrupo + " creado.");
                    break;
                }
                case 11: {
                    int i = elegir("un grupo", e.grupos.size());
                    if (i >= 0) {
                        System.out.print("Correo del estudiante a agregar: ");
                        Usuario u = buscarUsuario(sc.nextLine());
                        if (u instanceof Estudiante) {
                            System.out.println("Agregado: " + e.grupos.get(i).agregarMiembro((Estudiante) u));
                        } else {
                            System.out.println("No existe un estudiante con ese correo.");
                        }
                    }
                    break;
                }
                case 12: {
                    int i = elegir("un grupo", e.grupos.size());
                    if (i >= 0) {
                        System.out.print("Correo del estudiante a retirar: ");
                        Usuario u = buscarUsuario(sc.nextLine());
                        if (u instanceof Estudiante) {
                            System.out.println("Retirado: " + e.grupos.get(i).retirarMiembro((Estudiante) u));
                        } else {
                            System.out.println("No existe un estudiante con ese correo.");
                        }
                    }
                    break;
                }
                case 13: {
                    int i = elegir("un grupo", e.grupos.size());
                    if (i >= 0) {
                        System.out.print("Nuevo nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Nuevo tema: ");
                        String tema = sc.nextLine();
                        System.out.print("Descripcion: ");
                        String descripcion = sc.nextLine();
                        e.grupos.get(i).actualizarGrupo(nombre, tema, descripcion);
                        System.out.println("Grupo actualizado.");
                    }
                    break;
                }
                case 14: {
                    int i = elegir("un grupo", e.grupos.size());
                    if (i >= 0) {
                        e.grupos.get(i).desactivarGrupo();
                        System.out.println("Grupo desactivado.");
                    }
                    break;
                }
                case 15: {
                    Emprendimiento em = e.registrarEmprendimiento();
                    System.out.print("Nombre del emprendimiento: ");
                    String nombre = sc.nextLine();
                    System.out.print("Descripcion: ");
                    String descripcion = sc.nextLine();
                    System.out.print("Ubicacion: ");
                    String ubicacion = sc.nextLine();
                    System.out.print("Contacto: ");
                    String contacto = sc.nextLine();
                    System.out.print("Horario de atencion: ");
                    String horario = sc.nextLine();
                    em.actualizarDatosDelEmprendimiento(nombre, descripcion, ubicacion, contacto, horario);
                    System.out.println("Emprendimiento " + em.idEmprendimiento + " registrado.");
                    break;
                }
                case 16: {
                    int i = elegir("un emprendimiento", e.emprendimientos.size());
                    if (i >= 0) {
                        System.out.print("Titulo: ");
                        String titulo = sc.nextLine();
                        System.out.print("Descripcion: ");
                        String descripcion = sc.nextLine();
                        System.out.print("Tipo (PRODUCTO o SERVICIO): ");
                        String tipo = sc.nextLine().toUpperCase();
                        int precio = leerEntero("Precio: ");
                        Publicacion p = new Publicacion(idPublicacion, titulo, descripcion, tipo, precio);
                        if (e.emprendimientos.get(i).agregarPublicacion(p)) {
                            idPublicacion++;
                            p.publicar();
                            System.out.println("Publicacion " + p.idPublicacion + " publicada.");
                        }
                    }
                    break;
                }
                case 17: {
                    int i = elegir("un emprendimiento", e.emprendimientos.size());
                    if (i >= 0) {
                        Emprendimiento em = e.emprendimientos.get(i);
                        int j = elegir("una publicacion", em.publicaciones.size());
                        if (j >= 0) {
                            System.out.print("Nuevo titulo: ");
                            String titulo = sc.nextLine();
                            System.out.print("Nueva descripcion: ");
                            String descripcion = sc.nextLine();
                            System.out.print("Nuevo tipo (PRODUCTO o SERVICIO): ");
                            String tipo = sc.nextLine().toUpperCase();
                            int precio = leerEntero("Nuevo precio: ");
                            em.publicaciones.get(j).editar(titulo, descripcion, tipo, precio);
                            System.out.println("Publicacion actualizada.");
                        }
                    }
                    break;
                }
                case 18: {
                    int i = elegir("un emprendimiento", e.emprendimientos.size());
                    if (i >= 0) {
                        Emprendimiento em = e.emprendimientos.get(i);
                        int j = elegir("una publicacion", em.publicaciones.size());
                        if (j >= 0) {
                            em.publicaciones.get(j).desactivar();
                            System.out.println("Publicacion desactivada.");
                        }
                    }
                    break;
                }
                case 19: {
                    int i = elegir("un emprendimiento", e.emprendimientos.size());
                    if (i >= 0) {
                        Emprendimiento em = e.emprendimientos.get(i);
                        int j = elegir("una publicacion", em.publicaciones.size());
                        if (j >= 0) {
                            em.eliminarPublicacion(em.publicaciones.get(j).idPublicacion);
                            System.out.println("Publicacion eliminada.");
                        }
                    }
                    break;
                }
                case 20: {
                    System.out.print("Tipo (DUDA, REPORTE o SUGERENCIA): ");
                    String tipo = sc.nextLine().toUpperCase();
                    System.out.print("Descripcion: ");
                    String descripcion = sc.nextLine();
                    TicketSoporte t = e.solicitarSoporte(tipo, descripcion);
                    System.out.println("Ticket " + t.idTicket + " creado.");
                    break;
                }
                case 21: {
                    int i = elegir("un ticket", e.tickets.size());
                    if (i >= 0) {
                        int valor = leerEntero("Calificacion (1 a 5): ");
                        if (e.tickets.get(i).calificarAtencion(valor)) {
                            System.out.println("Gracias por calificar.");
                        } else {
                            System.out.println("No se pudo calificar (el ticket debe estar resuelto o cerrado, y la nota entre 1 y 5).");
                        }
                    }
                    break;
                }
                case 22: {
                    int i = elegir("un ticket", e.tickets.size());
                    if (i >= 0) {
                        TicketSoporte t = e.tickets.get(i);
                        t.cerrarTicket();
                        System.out.println("Estado del ticket: " + t.estado);
                    }
                    break;
                }
            }
        }
    }

    static void menuAdministrador(Administrador admin)
    {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n--- MENU ADMINISTRADOR ---");
            System.out.println("1. Activar o desactivar un usuario");
            System.out.println("2. Moderar una publicacion");
            System.out.println("3. Atender un ticket");
            System.out.println("0. Cerrar sesion");
            opcion = leerEntero("Opcion: ");

            if (opcion == 1) {
                System.out.print("Correo del usuario: ");
                Usuario u = buscarUsuario(sc.nextLine());
                if (u == null) {
                    System.out.println("No existe ese usuario.");
                } else {
                    System.out.print("Activar? (s/n): ");
                    boolean activo = sc.nextLine().equalsIgnoreCase("s");
                    admin.cambiarEstadoUsuario(u, activo);
                    System.out.println("Usuario " + u.nombre + " activo: " + u.activo);
                }
            } else if (opcion == 2) {
                ArrayList<Publicacion> todas = new ArrayList<>();
                for (Estudiante e : Estudiante.todos) {
                    for (Emprendimiento em : e.emprendimientos) {
                        todas.addAll(em.publicaciones);
                    }
                }
                for (int k = 0; k < todas.size(); k++) {
                    System.out.println((k + 1) + ". " + todas.get(k).titulo + " | activa: " + todas.get(k).activa);
                }
                int i = elegir("una publicacion", todas.size());
                if (i >= 0) {
                    System.out.print("Aprobar? (s/n): ");
                    boolean aprobada = sc.nextLine().equalsIgnoreCase("s");
                    admin.moderarPublicacion(todas.get(i), aprobada);
                    System.out.println("Publicacion activa: " + todas.get(i).activa);
                }
            } else if (opcion == 3) {
                ArrayList<TicketSoporte> todos = new ArrayList<>();
                for (Estudiante e : Estudiante.todos) {
                    todos.addAll(e.tickets);
                }
                for (int k = 0; k < todos.size(); k++) {
                    TicketSoporte t = todos.get(k);
                    System.out.println((k + 1) + ". " + t.solicitante.nombre + " | " + t.tipoSolicitud
                            + " | " + t.descripcion + " | " + t.estado);
                }
                int i = elegir("un ticket", todos.size());
                if (i >= 0) {
                    System.out.print("Respuesta: ");
                    admin.atenderTicket(todos.get(i), sc.nextLine());
                    System.out.println("Estado del ticket: " + todos.get(i).estado);
                }
            }
        }
    }

    // Lee un numero entero; si escriben otra cosa, vuelve a preguntar
    static int leerEntero(String mensaje)
    {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Debe escribir un numero entero.");
            }
        }
    }

    static Usuario buscarUsuario(String correo)
    {
        for (Usuario u : usuarios) {
            if (u.correoInstitucional.equals(correo)) {
                return u;
            }
        }
        return null;
    }

    // Pide un numero entre 1 y total; retorna la posicion (0, 1, ...) o -1 si no es valido
    static int elegir(String que, int total)
    {
        if (total == 0) {
            System.out.println("No hay elementos para elegir.");
            return -1;
        }
        int n = leerEntero("Elija " + que + " (1-" + total + "): ");
        if (n < 1 || n > total) {
            System.out.println("Numero invalido.");
            return -1;
        }
        return n - 1;
    }
}