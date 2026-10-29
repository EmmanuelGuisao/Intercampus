import java.time.LocalDate;
import java.util.ArrayList;

public class Coincidencia
{
    int idCoincidencia;
    Estudiante estudianteOrigen;
    Estudiante estudianteSugerido;
    double porcentajeCompatibilidad;
    ArrayList<String> criteriosCoincidentes;
    LocalDate fechaCalculo;

    public Coincidencia(int idCoincidencia, Estudiante estudianteSugerido)
    {
        this.idCoincidencia = idCoincidencia;
        this.estudianteSugerido = estudianteSugerido;
        this.criteriosCoincidentes = new ArrayList<>();
    }

    // Intereses en común: hasta 50 puntos, mismo programa: 25, descanso a la misma hora: 25
    public double calcularCompatibilidad(Estudiante estudianteOrigen)
    {
        this.estudianteOrigen = estudianteOrigen;
        criteriosCoincidentes = new ArrayList<>();
        double total = 0;

        int comunes = 0;
        for (String interes : estudianteOrigen.intereses) {
            if (estudianteSugerido.intereses.contains(interes)) {
                comunes++;
            }
        }
        if (comunes > 0) {
            total += 50.0 * comunes / estudianteOrigen.intereses.size();
            criteriosCoincidentes.add("Intereses en comun");
        }

        if (estudianteOrigen.programaAcademico.equals(estudianteSugerido.programaAcademico)) {
            total += 25;
            criteriosCoincidentes.add("Mismo programa academico");
        }

        boolean descansoCompartido = false;
        for (Horario h1 : estudianteOrigen.horarios) {
            for (ActividadHorario a1 : h1.actividades) {
                for (Horario h2 : estudianteSugerido.horarios) {
                    for (ActividadHorario a2 : h2.actividades) {
                        if (a1.tipoActividad.equals("DESCANSO") && a2.tipoActividad.equals("DESCANSO")
                                && a1.diaSemana == a2.diaSemana
                                && a1.horaInicio < a2.horaFin && a2.horaInicio < a1.horaFin) {
                            descansoCompartido = true;
                        }
                    }
                }
            }
        }
        if (descansoCompartido) {
            total += 25;
            criteriosCoincidentes.add("Descanso a la misma hora");
        }

        porcentajeCompatibilidad = total;
        fechaCalculo = LocalDate.now();
        return porcentajeCompatibilidad;
    }

    public ArrayList<String> obtenerCriterios()
    {
        return criteriosCoincidentes;
    }
}