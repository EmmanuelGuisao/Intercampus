import java.time.LocalDate;

public class TicketSoporte
{
    int idTicket;
    Estudiante solicitante;
    String tipoSolicitud;     // DUDA, REPORTE o SUGERENCIA
    String descripcion;
    LocalDate fechaCreacion;
    String estado;            // ABIERTO, EN_ATENCION, RESUELTO o CERRADO
    String respuesta;
    int calificacion;         // de 1 a 5 (0 = sin calificar)
    Administrador responsable;

    public TicketSoporte(int idTicket, Estudiante solicitante, String tipoSolicitud, String descripcion)
    {
        this.idTicket = idTicket;
        this.solicitante = solicitante;
        this.tipoSolicitud = tipoSolicitud;
        this.descripcion = descripcion;
        this.fechaCreacion = LocalDate.now();
        this.estado = "ABIERTO";
        this.calificacion = 0;
    }

    public void asignarResponsable(Administrador administrador)
    {
        responsable = administrador;
        estado = "EN_ATENCION";
    }

    public void responder(String texto)
    {
        respuesta = texto;
        estado = "RESUELTO";
    }

    public void cerrarTicket()
    {
        if (respuesta != null) {
            estado = "CERRADO";
        }
    }

    public boolean calificarAtencion(int valor)
    {
        if ((estado.equals("RESUELTO") || estado.equals("CERRADO")) && valor >= 1 && valor <= 5) {
            calificacion = valor;
            return true;
        }
        return false;
    }
}