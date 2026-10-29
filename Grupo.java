import java.util.ArrayList;

public class Grupo
{
    int idGrupo;
    String nombreGrupo;
    String tipoGrupo;     // ACADEMICO o SOCIAL
    String temaGrupo;
    String descripcion;
    boolean activo;
    ArrayList<Estudiante> miembros;

    public Grupo(int idGrupo, String nombreGrupo, String tipoGrupo, String temaGrupo)
    {
        this.idGrupo = idGrupo;
        this.nombreGrupo = nombreGrupo;
        this.tipoGrupo = tipoGrupo;
        this.temaGrupo = temaGrupo;
        this.descripcion = "";
        this.activo = true;
        this.miembros = new ArrayList<>();
    }

    public boolean agregarMiembro(Estudiante estudiante)
    {
        if (activo && !miembros.contains(estudiante)) {
            miembros.add(estudiante);
            estudiante.grupos.add(this);
            return true;
        }
        return false;
    }

    public boolean retirarMiembro(Estudiante estudiante)
    {
        if (miembros.remove(estudiante)) {
            estudiante.grupos.remove(this);
            return true;
        }
        return false;
    }

    public void actualizarGrupo(String nombreGrupo, String temaGrupo, String descripcion)
    {
        this.nombreGrupo = nombreGrupo;
        this.temaGrupo = temaGrupo;
        this.descripcion = descripcion;
    }

    public void desactivarGrupo()
    {
        activo = false;
    }
}