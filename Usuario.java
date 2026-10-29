public class Usuario
{
    int idUsuario;
    String nombre;
    String correoInstitucional;
    String hashContrasena;
    boolean activo;
    boolean sesionActiva;

    public Usuario(int idUsuario, String nombre, String correoInstitucional, String contrasena)
    {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correoInstitucional = correoInstitucional;
        this.hashContrasena = String.valueOf(contrasena.hashCode());
        this.activo = true;
        this.sesionActiva = false;
    }

    public boolean iniciarSesion(String correo, String contrasena)
    {
        if (activo && correoInstitucional.equals(correo)
                && hashContrasena.equals(String.valueOf(contrasena.hashCode()))) {
            sesionActiva = true;
            return true;
        }
        return false;
    }

    public String actualizarPerfil(String nombre)
    {
        this.nombre = nombre;
        return this.nombre;
    }

    public void cerrarSesion()
    {
        sesionActiva = false;
    }
}