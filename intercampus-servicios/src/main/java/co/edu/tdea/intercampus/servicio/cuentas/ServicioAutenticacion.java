package co.edu.tdea.intercampus.servicio.cuentas;

import co.edu.tdea.intercampus.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * SERVICIO 1 — Gestión de cuentas y acceso (parte de autenticación).
 *
 * <p>
 * Casos de uso: CU02 Iniciar sesión, CU03 Validar credenciales institucionales,
 * CU06 Cerrar sesión.
 * </p>
 */
public class ServicioAutenticacion {

    /** Usuarios registrados (lista compartida con {@link ServicioUsuario}). */
    private final List<Usuario> repositorioUsuarios;

    /**
     * Usuarios con sesión activa (equivale a gestorSesiones del diagrama de
     * clases).
     */
    private final List<Usuario> sesionesActivas = new ArrayList<>();

    /**
     * Crea el servicio de autenticación.
     *
     * @param repositorioUsuarios lista compartida de usuarios registrados
     */
    public ServicioAutenticacion(List<Usuario> repositorioUsuarios) {
        this.repositorioUsuarios = repositorioUsuarios;
    }

    /**
     * CU02 — Iniciar sesión.
     * <p>
     * Actores: Estudiante, Administrador. «include» CU03.
     * </p>
     * <p>
     * Tabla 2.2: {@code Usuario.iniciarSesion(correo, contrasena)}.
     * </p>
     *
     * @param correoInstitucional correo con dominio institucional
     * @param contrasena          contraseña digitada (se compara contra
     *                            {@code hashContrasena})
     * @return el usuario autenticado; puede ser {@code Estudiante} o
     *         {@code Administrador}
     * @throws IllegalArgumentException si las credenciales no son válidas o la
     *                                  cuenta está inactiva
     */
    public Usuario iniciarSesion(String correoInstitucional, String contrasena) {
        // Flujo: CU03 validarCredenciales(...) -> marcar sesionActiva -> agregar a
        // sesionesActivas
        throw new UnsupportedOperationException("CU02 pendiente de implementar");
    }

    /**
     * CU03 — Validar credenciales institucionales.
     * <p>
     * Caso de uso incluido («include») por CU01 Registrar cuenta y CU02 Iniciar
     * sesión.
     * </p>
     * <p>
     * Tabla 2.2: lo que consulta {@code iniciarSesion}: correoInstitucional,
     * hashContrasena y activo.
     * </p>
     *
     * @param correoInstitucional correo a validar (debe pertenecer al dominio de la
     *                            institución)
     * @param contrasena          contraseña a validar
     * @return {@code true} si las credenciales son válidas
     */
    public boolean validarCredenciales(String correoInstitucional, String contrasena) {
        throw new UnsupportedOperationException("CU03 pendiente de implementar");
    }

    /**
     * CU06 — Cerrar sesión.
     * <p>
     * Actores: Estudiante, Administrador.
     * </p>
     * <p>
     * Tabla 2.2: {@code Usuario.cerrarSesion()}.
     * </p>
     *
     * @param usuario usuario que cierra su sesión
     */
    public void cerrarSesion(Usuario usuario) {
        throw new UnsupportedOperationException("CU06 pendiente de implementar");
    }
}
