import java.util.ArrayList;

public class Estudiante extends Usuario
{
    // Lista de todos los estudiantes creados, para poder buscar coincidencias
    static ArrayList<Estudiante> todos = new ArrayList<>();

    String codigoEstudiantil;
    String programaAcademico;
    int semestre;
    ArrayList<String> intereses;
    ArrayList<Horario> horarios;
    ArrayList<Grupo> grupos;
    ArrayList<Emprendimiento> emprendimientos;
    ArrayList<TicketSoporte> tickets;

    public Estudiante(int idUsuario, String nombre, String correoInstitucional, String contrasena,
                      String codigoEstudiantil, String programaAcademico, int semestre)
    {
        super(idUsuario, nombre, correoInstitucional, contrasena);
        this.codigoEstudiantil = codigoEstudiantil;
        this.programaAcademico = programaAcademico;
        this.semestre = semestre;
        this.intereses = new ArrayList<>();
        this.horarios = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.emprendimientos = new ArrayList<>();
        this.tickets = new ArrayList<>();
        todos.add(this);
    }

    public void actualizarIntereses(ArrayList<String> nuevosIntereses)
    {
        intereses = nuevosIntereses;
    }

    public Horario crearHorario(String periodo)
    {
        Horario horario = new Horario(horarios.size() + 1, periodo);
        horarios.add(horario);
        return horario;
    }

    public ArrayList<Coincidencia> buscarCoincidencias()
    {
        ArrayList<Coincidencia> coincidencias = new ArrayList<>();
        for (Estudiante otro : todos) {
            if (otro != this) {
                Coincidencia c = new Coincidencia(coincidencias.size() + 1, otro);
                if (c.calcularCompatibilidad(this) > 0) {
                    coincidencias.add(c);
                }
            }
        }
        return coincidencias;
    }

    public Grupo crearGrupo(String nombre, String tipo, String tema)
    {
        Grupo grupo = new Grupo(grupos.size() + 1, nombre, tipo, tema);
        grupo.agregarMiembro(this);
        return grupo;
    }

    public Emprendimiento registrarEmprendimiento()
    {
        Emprendimiento emprendimiento = new Emprendimiento(emprendimientos.size() + 1);
        emprendimientos.add(emprendimiento);
        return emprendimiento;
    }

    public TicketSoporte solicitarSoporte(String tipo, String descripcion)
    {
        TicketSoporte ticket = new TicketSoporte(tickets.size() + 1, this, tipo, descripcion);
        tickets.add(ticket);
        return ticket;
    }
}