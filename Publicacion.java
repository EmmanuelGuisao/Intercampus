import java.time.LocalDate;

public class Publicacion
{
    int idPublicacion;
    String titulo;
    String descripcion;
    String tipoPublicacion;   // PRODUCTO o SERVICIO
    double precio;
    LocalDate fechaPublicacion;
    boolean activa;

    public Publicacion(int idPublicacion, String titulo, String descripcion,
                       String tipoPublicacion, double precio)
    {
        this.idPublicacion = idPublicacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipoPublicacion = tipoPublicacion;
        this.precio = precio;
        this.activa = false;
    }

    public void publicar()
    {
        if (titulo != null && descripcion != null && tipoPublicacion != null) {
            fechaPublicacion = LocalDate.now();
            activa = true;
        }
    }

    public void editar(String titulo, String descripcion, String tipoPublicacion, double precio)
    {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipoPublicacion = tipoPublicacion;
        this.precio = precio;
    }

    public void desactivar()
    {
        activa = false;
    }
}