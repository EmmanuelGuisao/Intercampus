package co.edu.tdea.intercampus.servicio.emprendimientos;

import co.edu.tdea.intercampus.modelo.Administrador;
import co.edu.tdea.intercampus.modelo.Emprendimiento;
import co.edu.tdea.intercampus.modelo.Estudiante;
import co.edu.tdea.intercampus.modelo.Publicacion;
import co.edu.tdea.intercampus.modelo.Usuario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ServicioEmprendimiento {

    /** Emprendimientos registrados, cada uno con sus publicaciones. */
    private final List<Emprendimiento> repositorioEmprendimientos = new ArrayList<>();

    /** Consecutivo para asignar idEmprendimiento e idPublicacion. */
    private int generadorId;

    /** Crea el servicio de emprendimientos y publicaciones. */
    public ServicioEmprendimiento() {
    }

    /**
     * CU22 — Registrar emprendimiento.
     * <p>
     * Actor: Estudiante.
     * </p>
     * <p>
     * Tabla 2.2: {@code Estudiante.registrarEmprendimiento(datos): Emprendimiento}.
     * </p>
     *
     * @param propietario     estudiante dueño del emprendimiento
     * @param nombre          nombre comercial
     * @param descripcion     descripción del emprendimiento
     * @param ubicacion       ubicación (sede, bloque o punto de encuentro)
     * @param contacto        medio de contacto (teléfono, red social, correo)
     * @param horarioAtencion horario de atención, p. ej. "L-V 10:00-14:00"
     * @return el emprendimiento registrado
     */
    public Emprendimiento registrarEmprendimiento(Estudiante propietario, String nombre, String descripcion,
            String ubicacion, String contacto, String horarioAtencion) {
        throw new UnsupportedOperationException("CU22 pendiente de implementar");
    }

    /**
     * CU23 — Actualizar datos del emprendimiento.
     * <p>
     * Actor: Estudiante (solo el propietario).
     * </p>
     * <p>
     * Tabla 2.2:
     * {@code Emprendimiento.actualizarDatos(nombre, descripcion, ubicacion, contacto, horario)}.
     * </p>
     *
     * @param propietario      dueño del emprendimiento
     * @param idEmprendimiento emprendimiento a actualizar
     * @param nombre           nuevo nombre
     * @param descripcion      nueva descripción
     * @param ubicacion        nueva ubicación
     * @param contacto         nuevo contacto
     * @param horarioAtencion  nuevo horario de atención
     * @throws IllegalStateException si quien actualiza no es el propietario
     */
    public void actualizarDatosEmprendimiento(Estudiante propietario, int idEmprendimiento, String nombre,
            String descripcion, String ubicacion, String contacto,
            String horarioAtencion) {
        throw new UnsupportedOperationException("CU23 pendiente de implementar");
    }

    /**
     * CU24 — Publicar producto o servicio.
     * <p>
     * Actor: Estudiante (solo el propietario del emprendimiento).
     * </p>
     * <p>
     * Tabla 2.2: {@code Emprendimiento.agregarPublicacion(publicacion)} +
     * {@code Publicacion.publicar()}.
     * </p>
     *
     * @param propietario      dueño del emprendimiento
     * @param idEmprendimiento emprendimiento al que pertenece la publicación
     * @param titulo           título de la publicación
     * @param descripcion      descripción del producto o servicio
     * @param tipoPublicacion  "PRODUCTO" o "SERVICIO"
     * @param precio           precio de referencia en pesos (COP)
     * @return la publicación creada y activa, con fecha de publicación
     */
    public Publicacion publicarProductoServicio(Estudiante propietario, int idEmprendimiento, String titulo,
            String descripcion, String tipoPublicacion,
            BigDecimal precio) {
        throw new UnsupportedOperationException("CU24 pendiente de implementar");
    }

    /**
     * CU25 — Editar publicación.
     * <p>
     * Actor: Estudiante (solo el propietario). Puede ser extendido por CU26.
     * </p>
     * <p>
     * Tabla 2.2: {@code Publicacion.editar(titulo, descripcion, tipo, precio)}.
     * </p>
     *
     * @param propietario     dueño del emprendimiento
     * @param idPublicacion   publicación a editar
     * @param titulo          nuevo título
     * @param descripcion     nueva descripción
     * @param tipoPublicacion nuevo tipo: "PRODUCTO" o "SERVICIO"
     * @param precio          nuevo precio
     * @throws IllegalStateException si quien edita no es el propietario
     */
    public void editarPublicacion(Estudiante propietario, int idPublicacion, String titulo,
            String descripcion, String tipoPublicacion, BigDecimal precio) {
        throw new UnsupportedOperationException("CU25 pendiente de implementar");
    }

    /**
     * CU26 — Desactivar publicación.
     * <p>
     * «extend» de CU25 (el propietario decide ocultarla) y de CU28 (el
     * administrador no la aprueba).
     * Por eso recibe {@link Usuario}: puede ejecutarlo un Estudiante o un
     * Administrador.
     * </p>
     * <p>
     * Tabla 2.2: {@code Publicacion.desactivar()}.
     * </p>
     *
     * @param usuario       propietario (Estudiante) o moderador (Administrador)
     * @param idPublicacion publicación a desactivar
     */
    public void desactivarPublicacion(Usuario usuario, int idPublicacion) {
        throw new UnsupportedOperationException("CU26 pendiente de implementar");
    }

    /**
     * CU27 — Eliminar publicación.
     * <p>
     * Actor: Estudiante (solo el propietario).
     * </p>
     * <p>
     * Tabla 2.2: {@code Emprendimiento.eliminarPublicacion(idPublicacion)}.
     * </p>
     *
     * @param propietario   dueño del emprendimiento
     * @param idPublicacion publicación a eliminar
     * @throws IllegalStateException si quien elimina no es el propietario
     */
    public void eliminarPublicacion(Estudiante propietario, int idPublicacion) {
        throw new UnsupportedOperationException("CU27 pendiente de implementar");
    }

    /**
     * CU28 — Moderar publicación.
     * <p>
     * Actor: Administrador. Puede ser extendido por CU26 (si no se aprueba).
     * </p>
     * <p>
     * Tabla 2.2: {@code Administrador.moderarPublicacion(publicacion, aprobada)}.
     * </p>
     *
     * @param administrador administrador que modera
     * @param idPublicacion publicación revisada
     * @param aprobada      {@code true} si cumple las normas; {@code false} la
     *                      desactiva (CU26)
     */
    public void moderarPublicacion(Administrador administrador, int idPublicacion, boolean aprobada) {
        // Flujo: si !aprobada -> CU26 desactivarPublicacion(administrador,
        // idPublicacion)
        throw new UnsupportedOperationException("CU28 pendiente de implementar");
    }
}
