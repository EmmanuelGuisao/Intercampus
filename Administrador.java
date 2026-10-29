public class Administrador extends Usuario
{
    public Administrador(int idUsuario, String nombre, String correoInstitucional, String contrasena)
    {
        super(idUsuario, nombre, correoInstitucional, contrasena);
    }

    public void cambiarEstadoUsuario(Usuario usuario, boolean activo)
    {
        usuario.activo = activo;
    }

    public void moderarPublicacion(Publicacion publicacion, boolean aprobada)
    {
        publicacion.activa = aprobada;
    }

    public void atenderTicket(TicketSoporte ticket, String respuesta)
    {
        if (!ticket.estado.equals("CERRADO")) {
            ticket.asignarResponsable(this);
            ticket.responder(respuesta);
        }
    }
}