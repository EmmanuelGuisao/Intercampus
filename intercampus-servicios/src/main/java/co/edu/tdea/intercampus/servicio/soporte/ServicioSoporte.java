package co.edu.tdea.intercampus.servicio.soporte;

import co.edu.tdea.intercampus.modelo.Administrador;
import co.edu.tdea.intercampus.modelo.Estudiante;
import co.edu.tdea.intercampus.modelo.TicketSoporte;

import java.util.ArrayList;
import java.util.List;

/**
 * SERVICIO 5 — Soporte.
 *
 */
public class ServicioSoporte {

    /** Tickets de soporte creados por los estudiantes. */
    private final List<TicketSoporte> repositorioTickets = new ArrayList<>();

    /** Consecutivo para asignar idTicket. */
    private int generadorId;

    /** Crea el servicio de soporte. */
    public ServicioSoporte() {
    }

    /**
     * CU29 — Solicitar soporte.
     * <p>
     * Actor: Estudiante.
     * </p>
     * <p>
     * Tabla 2.2:
     * {@code Estudiante.solicitarSoporte(tipo, descripcion): TicketSoporte}.
     * </p>
     *
     * @param solicitante   estudiante que pide ayuda
     * @param tipoSolicitud "DUDA", "REPORTE" o "SUGERENCIA"
     * @param descripcion   detalle de la solicitud
     * @return el ticket creado con estado "ABIERTO"
     */
    public TicketSoporte solicitarSoporte(Estudiante solicitante, String tipoSolicitud, String descripcion) {
        throw new UnsupportedOperationException("CU29 pendiente de implementar");
    }

    /**
     * CU30 — Calificar atención.
     * <p>
     * Actor: Estudiante (solo el solicitante del ticket).
     * </p>
     * <p>
     * Tabla 2.2: {@code TicketSoporte.calificarAtencion(valor)}.
     * </p>
     *
     * @param solicitante  estudiante que creó el ticket
     * @param idTicket     ticket a calificar
     * @param calificacion valor de 1 a 5
     * @throws IllegalArgumentException si la calificación está fuera del rango 1-5
     * @throws IllegalStateException    si el ticket no está "RESUELTO" o "CERRADO"
     */
    public void calificarAtencion(Estudiante solicitante, int idTicket, int calificacion) {
        throw new UnsupportedOperationException("CU30 pendiente de implementar");
    }

    /**
     * CU31 — Atender ticket.
     * <p>
     * Actor: Administrador. «include» CU32. Puede ser extendido por CU33.
     * </p>
     * <p>
     * Tabla 2.2: {@code Administrador.atenderTicket(ticket, respuesta)} +
     * {@code TicketSoporte.asignarResponsable(administrador)}.
     * </p>
     *
     * @param administrador administrador que toma el ticket (queda como
     *                      responsable)
     * @param idTicket      ticket a atender
     * @param respuesta     respuesta para el estudiante
     */
    public void atenderTicket(Administrador administrador, int idTicket, String respuesta) {
        // Flujo: asignar responsable (estado "EN_PROCESO") -> CU32
        // responderTicket(ticket, respuesta)
        throw new UnsupportedOperationException("CU31 pendiente de implementar");
    }

    /**
     * CU32 — Responder ticket.
     * <p>
     * Caso de uso incluido («include») por CU31.
     * </p>
     * <p>
     * Tabla 2.2: {@code TicketSoporte.responder(texto)}.
     * </p>
     *
     * @param ticket    ticket que se está atendiendo
     * @param respuesta texto de la respuesta (el ticket pasa a estado "RESUELTO")
     */
    public void responderTicket(TicketSoporte ticket, String respuesta) {
        throw new UnsupportedOperationException("CU32 pendiente de implementar");
    }

    /**
     * CU33 — Cerrar ticket.
     * <p>
     * «extend» de CU31 (solo si la respuesta resuelve la solicitud).
     * </p>
     * <p>
     * Tabla 2.2: {@code TicketSoporte.cerrarTicket()}.
     * </p>
     *
     * @param administrador administrador responsable del ticket
     * @param idTicket      ticket a cerrar
     * @throws IllegalStateException si el ticket aún no tiene respuesta
     */
    public void cerrarTicket(Administrador administrador, int idTicket) {
        throw new UnsupportedOperationException("CU33 pendiente de implementar");
    }
}
