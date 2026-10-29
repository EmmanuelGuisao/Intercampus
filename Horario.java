import java.time.LocalDate;
import java.util.ArrayList;

public class Horario
{
    int idHorario;
    String periodoAcademico;
    LocalDate fechaCreacion;
    String estado;
    ArrayList<ActividadHorario> actividades;

    public Horario(int idHorario, String periodoAcademico)
    {
        this.idHorario = idHorario;
        this.periodoAcademico = periodoAcademico;
        this.fechaCreacion = LocalDate.now();
        this.estado = "BORRADOR";
        this.actividades = new ArrayList<>();
    }

    public boolean agregarActividad(ActividadHorario actividad)
    {
        if (validarConflicto(actividad)) {
            return false;
        }
        actividades.add(actividad);
        return true;
    }

    // Retorna true si la actividad se cruza con otra del horario
    public boolean validarConflicto(ActividadHorario actividad)
    {
        for (ActividadHorario a : actividades) {
            if (a.diaSemana == actividad.diaSemana
                    && a.horaInicio < actividad.horaFin
                    && actividad.horaInicio < a.horaFin) {
                return true;
            }
        }
        return false;
    }

    // Ordena las actividades por día y hora
    public void generarPropuesta()
    {
        actividades.sort((a, b) -> a.diaSemana != b.diaSemana
                ? a.diaSemana - b.diaSemana : a.horaInicio - b.horaInicio);
        estado = "PROPUESTA";
    }

    public void reorganizar()
    {
        actividades.sort((a, b) -> a.diaSemana != b.diaSemana
                ? a.diaSemana - b.diaSemana : a.horaInicio - b.horaInicio);
    }
}