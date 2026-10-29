package co.edu.tdea.intercampus.servicio.conexiones;

import co.edu.tdea.intercampus.modelo.Coincidencia;
import co.edu.tdea.intercampus.modelo.Estudiante;
import co.edu.tdea.intercampus.modelo.Grupo;
import co.edu.tdea.intercampus.modelo.Usuario;
import co.edu.tdea.intercampus.servicio.horarios.ServicioHorario;

import java.util.ArrayList;
import java.util.List;

/**
 * SERVICIO 3 — Conexiones y grupos.
 *
 * <p>
 * Casos de uso: CU14 Buscar estudiantes compatibles, CU15 Calcular
 * compatibilidad,
 * CU16 Ver criterios de coincidencia, CU17 Crear grupo, CU18 Unirse a un grupo,
 * CU19 Salir de un grupo, CU20 Editar grupo, CU21 Desactivar grupo.
 * </p>
 */
public class ServicioConexiones {

    /**
     * Usuarios registrados: de aquí salen los estudiantes candidatos (lista
     * compartida).
     */
    private final List<Usuario> repositorioUsuarios;

    /**
     * Necesario en CU15 para comparar la disponibilidad horaria de ambos
     * estudiantes.
     */
    private final ServicioHorario servicioHorario;

    /** Coincidencias calculadas entre estudiantes. */
    private final List<Coincidencia> repositorioCoincidencias = new ArrayList<>();

    /** Grupos académicos y sociales creados. */
    private final List<Grupo> repositorioGrupos = new ArrayList<>();

    /** Consecutivo para asignar idCoincidencia e idGrupo. */
    private int generadorId;

    /**
     * Crea el servicio de conexiones y grupos.
     *
     * @param repositorioUsuarios lista compartida de usuarios registrados
     * @param servicioHorario     servicio usado para comparar disponibilidad
     *                            horaria
     */
    public ServicioConexiones(List<Usuario> repositorioUsuarios, ServicioHorario servicioHorario) {
        this.repositorioUsuarios = repositorioUsuarios;
        this.servicioHorario = servicioHorario;
    }

    /**
     * CU14 — Buscar estudiantes compatibles.
     * <p>
     * Actor: Estudiante. «include» CU15. Puede ser extendido por CU16.
     * </p>
     * <p>
     * Tabla 2.2: {@code Estudiante.buscarCoincidencias(): List<Coincidencia>}.
     * </p>
     *
     * @param estudiante estudiante que realiza la búsqueda
     * @return coincidencias ordenadas de mayor a menor compatibilidad (lista vacía
     *         si no hay)
     */
    public List<Coincidencia> buscarEstudiantesCompatibles(Estudiante estudiante) {
        // Flujo: por cada candidato -> CU15 calcularCompatibilidad(estudiante,
        // candidato) -> ordenar
        throw new UnsupportedOperationException("CU14 pendiente de implementar");
    }

    /**
     * CU15 — Calcular compatibilidad.
     * <p>
     * Caso de uso incluido («include») por CU14.
     * </p>
     * <p>
     * Tabla 2.2: {@code Coincidencia.calcularCompatibilidad(origen, sugerido)}.
     * </p>
     *
     * @param origen   estudiante que busca
     * @param sugerido estudiante candidato
     * @return la coincidencia con porcentaje (0 a 100) y criterios coincidentes
     */
    public Coincidencia calcularCompatibilidad(Estudiante origen, Estudiante sugerido) {
        throw new UnsupportedOperationException("CU15 pendiente de implementar");
    }

    /**
     * CU16 — Ver criterios de coincidencia.
     * <p>
     * «extend» de CU14 (opcional: el estudiante quiere saber por qué coinciden).
     * </p>
     * <p>
     * Tabla 2.2: {@code Coincidencia.obtenerCriterios(): List<String>}.
     * </p>
     *
     * @param estudiante     estudiante que consulta (debe ser el origen de la
     *                       coincidencia)
     * @param idCoincidencia coincidencia a consultar
     * @return criterios coincidentes (intereses, programa, franjas libres, etc.)
     */
    public List<String> verCriteriosCoincidencia(Estudiante estudiante, int idCoincidencia) {
        throw new UnsupportedOperationException("CU16 pendiente de implementar");
    }

    /**
     * CU17 — Crear grupo.
     * <p>
     * Actor: Estudiante (queda como creador y primer miembro).
     * </p>
     * <p>
     * Tabla 2.2: {@code Estudiante.crearGrupo(nombre, tipo, tema): Grupo}.
     * </p>
     *
     * @param creador   estudiante que crea el grupo
     * @param nombre    nombre del grupo
     * @param tipoGrupo "ACADEMICO" o "SOCIAL"
     * @param tema      tema principal
     * @return el grupo creado y activo
     */
    public Grupo crearGrupo(Estudiante creador, String nombre, String tipoGrupo, String tema) {
        throw new UnsupportedOperationException("CU17 pendiente de implementar");
    }

    /**
     * CU18 — Unirse a un grupo.
     * <p>
     * Actor: Estudiante.
     * </p>
     * <p>
     * Tabla 2.2: {@code Grupo.agregarMiembro(estudiante)}.
     * </p>
     *
     * @param estudiante estudiante que se une
     * @param idGrupo    grupo destino
     * @throws IllegalStateException si el grupo está inactivo o el estudiante ya es
     *                               miembro
     */
    public void unirseAGrupo(Estudiante estudiante, int idGrupo) {
        throw new UnsupportedOperationException("CU18 pendiente de implementar");
    }

    /**
     * CU19 — Salir de un grupo.
     * <p>
     * Actor: Estudiante.
     * </p>
     * <p>
     * Tabla 2.2: {@code Grupo.retirarMiembro(estudiante)}.
     * </p>
     *
     * @param estudiante estudiante que sale
     * @param idGrupo    grupo del que sale
     * @throws IllegalStateException si el estudiante no es miembro del grupo
     */
    public void salirDeGrupo(Estudiante estudiante, int idGrupo) {
        throw new UnsupportedOperationException("CU19 pendiente de implementar");
    }

    /**
     * CU20 — Editar grupo.
     * <p>
     * Actor: Estudiante (solo el creador). Puede ser extendido por CU21.
     * </p>
     * <p>
     * Tabla 2.2: {@code Grupo.actualizarGrupo(nombre, tema, descripcion)}.
     * </p>
     *
     * @param creador     creador del grupo
     * @param idGrupo     grupo a editar
     * @param nombre      nuevo nombre
     * @param tema        nuevo tema
     * @param descripcion nueva descripción
     * @throws IllegalStateException si quien edita no es el creador
     */
    public void editarGrupo(Estudiante creador, int idGrupo, String nombre, String tema, String descripcion) {
        throw new UnsupportedOperationException("CU20 pendiente de implementar");
    }

    /**
     * CU21 — Desactivar grupo.
     * <p>
     * «extend» de CU20 (opcional, mientras el creador administra el grupo).
     * </p>
     * <p>
     * Tabla 2.2: {@code Grupo.desactivarGrupo()}.
     * </p>
     *
     * @param creador creador del grupo
     * @param idGrupo grupo a desactivar
     * @throws IllegalStateException si quien desactiva no es el creador
     */
    public void desactivarGrupo(Estudiante creador, int idGrupo) {
        throw new UnsupportedOperationException("CU21 pendiente de implementar");
    }
}
