package co.edu.tdea.intercampus.servicio.cuentas;

import co.edu.tdea.intercampus.modelo.Administrador;
import co.edu.tdea.intercampus.modelo.Estudiante;
import co.edu.tdea.intercampus.modelo.Usuario;

import java.util.List;

/**
 * SERVICIO 1 — Gestión de cuentas y acceso (parte de cuentas de usuario).
 *
 * <p>
 * Casos de uso: CU01 Registrar cuenta, CU04 Actualizar perfil,
 * CU05 Actualizar intereses, CU07 Activar o desactivar usuario.
 * </p>
 */
public class ServicioUsuario {

    /**
     * Usuarios registrados (lista compartida con {@link ServicioAutenticacion}).
     */
    private final List<Usuario> repositorioUsuarios;

    /** Necesario para el «include» CU01 -> CU03. */
    private final ServicioAutenticacion servicioAutenticacion;

    /**
     * Consecutivo para asignar idUsuario (equivale a generadorID del diagrama de
     * clases).
     */
    private int generadorId;

    /**
     * Crea el servicio de cuentas de usuario.
     *
     * @param repositorioUsuarios   lista compartida de usuarios registrados
     * @param servicioAutenticacion servicio usado para validar credenciales (CU03)
     */
    public ServicioUsuario(List<Usuario> repositorioUsuarios,
            ServicioAutenticacion servicioAutenticacion) {
        this.repositorioUsuarios = repositorioUsuarios;
        this.servicioAutenticacion = servicioAutenticacion;
    }

    /**
     * CU01 — Registrar cuenta.
     * <p>
     * Actor: Estudiante. «include» CU03 Validar credenciales institucionales.
     * </p>
     * <p>
     * Tabla 2.2: {@code Usuario.registrarCuenta(nombre, correo, contrasena)}
     * + datos propios de {@code Estudiante}.
     * </p>
     *
     * @param nombre              nombre completo
     * @param correoInstitucional correo institucional (será el usuario de acceso)
     * @param contrasena          contraseña; se almacena como hash
     * @param codigoEstudiantil   código asignado por la institución
     * @param programaAcademico   programa en el que está matriculado
     * @param semestre            semestre actual
     * @return el estudiante registrado, con su idUsuario asignado
     * @throws IllegalArgumentException si las credenciales no son válidas o el
     *                                  correo ya existe
     */
    public Estudiante registrarCuenta(String nombre, String correoInstitucional, String contrasena,
            String codigoEstudiantil, String programaAcademico, int semestre) {
        // Flujo: CU03 servicioAutenticacion.validarCredenciales(...) -> crear
        // Estudiante -> guardar
        throw new UnsupportedOperationException("CU01 pendiente de implementar");
    }

    /**
     * CU04 — Actualizar perfil.
     * <p>
     * Actores: Estudiante, Administrador. Puede ser extendido por CU05.
     * </p>
     * <p>
     * Tabla 2.2: {@code Usuario.actualizarPerfil(nombre)}.
     * </p>
     *
     * @param usuario usuario que actualiza su perfil
     * @param nombre  nuevo nombre
     */
    public void actualizarPerfil(Usuario usuario, String nombre) {
        throw new UnsupportedOperationException("CU04 pendiente de implementar");
    }

    /**
     * CU05 — Actualizar intereses.
     * <p>
     * «extend» de CU04 Actualizar perfil (solo aplica si el usuario es estudiante).
     * </p>
     * <p>
     * Tabla 2.2: {@code Estudiante.actualizarIntereses(nuevosIntereses)}.
     * </p>
     *
     * @param estudiante      estudiante que actualiza sus intereses
     * @param nuevosIntereses lista de intereses que reemplaza a la actual
     */
    public void actualizarIntereses(Estudiante estudiante, List<String> nuevosIntereses) {
        throw new UnsupportedOperationException("CU05 pendiente de implementar");
    }

    /**
     * CU07 — Activar o desactivar usuario.
     * <p>
     * Actor: Administrador.
     * </p>
     * <p>
     * Tabla 2.2: {@code Administrador.cambiarEstadoUsuario(usuario, activo)}.
     * </p>
     *
     * @param administrador administrador que realiza la acción
     * @param idUsuario     usuario a activar o desactivar
     * @param activo        {@code true} para activar, {@code false} para desactivar
     * @throws IllegalArgumentException si el usuario no existe
     */
    public void cambiarEstadoUsuario(Administrador administrador, int idUsuario, boolean activo) {
        throw new UnsupportedOperationException("CU07 pendiente de implementar");
    }
}
