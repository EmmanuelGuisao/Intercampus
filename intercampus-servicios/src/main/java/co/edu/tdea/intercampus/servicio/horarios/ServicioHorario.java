package co.edu.tdea.intercampus.servicio.horarios;

import co.edu.tdea.intercampus.modelo.ActividadHorario;
import co.edu.tdea.intercampus.modelo.Estudiante;
import co.edu.tdea.intercampus.modelo.Horario;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * SERVICIO 2 — Organización de horarios.
 *
 * <p>
 * Casos de uso: CU08 Crear horario, CU09 Registrar actividad, CU10 Modificar
 * actividad,
 * CU11 Validar conflicto de horario, CU12 Generar propuesta de horario, CU13
 * Reorganizar horario.
 * </p>
 */
public class ServicioHorario {

    /** Horarios creados por los estudiantes. */
    private final List<Horario> repositorioHorarios = new ArrayList<>();

    /** Consecutivo para asignar idHorario e idActividad. */
    private int generadorId;

    /** Crea el servicio de organización de horarios. */
    public ServicioHorario() {
    }

    /**
     * CU08 — Crear horario.
     * <p>
     * Actor: Estudiante.
     * </p>
     * <p>
     * Tabla 2.2: {@code Estudiante.crearHorario(periodo): Horario}.
     * </p>
     *
     * @param estudiante       dueño del horario
     * @param periodoAcademico periodo, por ejemplo "2026-2"
     * @return el horario creado con estado "BORRADOR"
     * @throws IllegalStateException si el estudiante ya tiene un horario para ese
     *                               periodo
     */
    public Horario crearHorario(Estudiante estudiante, String periodoAcademico) {
        throw new UnsupportedOperationException("CU08 pendiente de implementar");
    }

    /**
     * CU09 — Registrar actividad (clase, trabajo o descanso).
     * <p>
     * Actor: Estudiante. «include» CU11 Validar conflicto de horario.
     * </p>
     * <p>
     * Tabla 2.2: {@code Horario.agregarActividad(actividad)}.
     * </p>
     *
     * @param estudiante    dueño del horario
     * @param idHorario     horario al que se agrega la actividad
     * @param nombre        nombre de la actividad (p. ej. "Cálculo integral")
     * @param tipoActividad "CLASE", "TRABAJO" o "DESCANSO"
     * @param diaSemana     día de la semana, p. ej. "LUNES"
     * @param horaInicio    hora de inicio
     * @param horaFin       hora de finalización
     * @return la actividad registrada, con su idActividad asignado
     * @throws IllegalStateException si la actividad se cruza con otra (resultado de
     *                               CU11)
     */
    public ActividadHorario registrarActividad(Estudiante estudiante, int idHorario, String nombre,
            String tipoActividad, String diaSemana,
            LocalTime horaInicio, LocalTime horaFin) {
        // Flujo: buscar horario -> crear ActividadHorario -> CU11
        // validarConflictoHorario(...) -> agregar
        throw new UnsupportedOperationException("CU09 pendiente de implementar");
    }

    /**
     * CU10 — Modificar actividad.
     * <p>
     * Actor: Estudiante. «include» CU11 Validar conflicto de horario.
     * </p>
     * <p>
     * Tabla 2.2:
     * {@code ActividadHorario.actualizarActividad(nombre, tipo, dia, inicio, fin)}.
     * </p>
     *
     * @param estudiante    dueño del horario
     * @param idActividad   actividad a modificar
     * @param nombre        nuevo nombre
     * @param tipoActividad nuevo tipo
     * @param diaSemana     nuevo día
     * @param horaInicio    nueva hora de inicio
     * @param horaFin       nueva hora de finalización
     * @throws IllegalStateException si los nuevos datos generan conflicto
     *                               (resultado de CU11)
     */
    public void modificarActividad(Estudiante estudiante, int idActividad, String nombre,
            String tipoActividad, String diaSemana,
            LocalTime horaInicio, LocalTime horaFin) {
        // Flujo: buscar actividad -> CU11 validarConflictoHorario(...) -> actualizar
        // datos
        throw new UnsupportedOperationException("CU10 pendiente de implementar");
    }

    /**
     * CU11 — Validar conflicto de horario.
     * <p>
     * Caso de uso incluido («include») por CU09 y CU10.
     * </p>
     * <p>
     * Tabla 2.2: {@code Horario.validarConflicto(actividad)} +
     * {@code ActividadHorario.validarFranjaHoraria()}.
     * </p>
     *
     * @param horario   horario donde se ubicará la actividad
     * @param actividad actividad nueva o modificada
     * @return {@code true} si la franja es válida y NO se cruza con otra actividad
     */
    public boolean validarConflictoHorario(Horario horario, ActividadHorario actividad) {
        throw new UnsupportedOperationException("CU11 pendiente de implementar");
    }

    /**
     * CU12 — Generar propuesta de horario.
     * <p>
     * Actor: Estudiante. Puede ser extendido por CU13.
     * </p>
     * <p>
     * Tabla 2.2: {@code Horario.generarPropuesta(): Horario}.
     * </p>
     *
     * @param estudiante dueño del horario
     * @param idHorario  horario a organizar
     * @return el horario con la propuesta generada (estado "PROPUESTA")
     */
    public Horario generarPropuestaHorario(Estudiante estudiante, int idHorario) {
        throw new UnsupportedOperationException("CU12 pendiente de implementar");
    }

    /**
     * CU13 — Reorganizar horario.
     * <p>
     * «extend» de CU12 (solo si la propuesta no le sirve al estudiante).
     * </p>
     * <p>
     * Tabla 2.2: {@code Horario.reorganizar(): Horario}.
     * </p>
     *
     * @param estudiante dueño del horario
     * @param idHorario  horario cuya propuesta se reorganiza
     * @return el horario con la nueva organización de actividades
     */
    public Horario reorganizarHorario(Estudiante estudiante, int idHorario) {
        throw new UnsupportedOperationException("CU13 pendiente de implementar");
    }
}
