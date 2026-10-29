import java.util.ArrayList;

public class Emprendimiento
{
    int idEmprendimiento;
    String nombreEmprendimiento;
    String descripcionEmprendimiento;
    String ubicacionEmprendimiento;
    String contacto;
    String horario;
    ArrayList<Publicacion> publicaciones;

    public Emprendimiento(int idEmprendimiento)
    {
        this.idEmprendimiento = idEmprendimiento;
        this.publicaciones = new ArrayList<>();
    }

    public void actualizarDatosDelEmprendimiento(String nombreEmprendimiento,
            String descripcionEmprendimiento, String ubicacion, String contacto, String horario)
    {
        this.nombreEmprendimiento = nombreEmprendimiento;
        this.descripcionEmprendimiento = descripcionEmprendimiento;
        this.ubicacionEmprendimiento = ubicacion;
        this.contacto = contacto;
        this.horario = horario;
    }

    public boolean agregarPublicacion(Publicacion publicacion)
    {
        if (publicaciones.contains(publicacion)) {
            return false;
        }
        publicaciones.add(publicacion);
        return true;
    }

    public boolean eliminarPublicacion(int idPublicacion)
    {
        for (Publicacion p : publicaciones) {
            if (p.idPublicacion == idPublicacion) {
                publicaciones.remove(p);
                return true;
            }
        }
        return false;
    }
}