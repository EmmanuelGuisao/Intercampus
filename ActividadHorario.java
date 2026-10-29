public class ActividadHorario
{
    int idActividad;
    String nombre;
    String tipoActividad;   // CLASE, DESCANSO o TRABAJO
    int diaSemana;          // 1 = lunes ... 7 = domingo
    int horaInicio;         // hora en formato 24 horas (ej: 8)
    int horaFin;            // hora en formato 24 horas (ej: 10)

    public ActividadHorario(int idActividad, String nombre, String tipoActividad,
                            int diaSemana, int horaInicio, int horaFin)
    {
        this.idActividad = idActividad;
        this.nombre = nombre;
        this.tipoActividad = tipoActividad;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public void actualizarActividad(String nombre, String tipoActividad,
                                    int diaSemana, int horaInicio, int horaFin)
    {
        this.nombre = nombre;
        this.tipoActividad = tipoActividad;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public boolean validarFranjaHoraria()
    {
        return diaSemana >= 1 && diaSemana <= 7
                && horaInicio >= 0 && horaFin <= 24
                && horaInicio < horaFin;
    }

    // Duración en minutos
    public int calcularDuracion()
    {
        return (horaFin - horaInicio) * 60;
    }
}