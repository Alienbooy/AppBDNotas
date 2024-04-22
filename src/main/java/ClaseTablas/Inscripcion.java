package ClaseTablas;

public class Inscripcion {
    private int id_Inscripcion;
    private int ResgistroEstudiante;
    private int CodigoMaterias;

    private String nombreEstudiante;
    private String nombreMaterias;

    public Inscripcion( int resgistroEstudiante, int codigoMaterias) {
        ResgistroEstudiante = resgistroEstudiante;
        CodigoMaterias = codigoMaterias;
    }

    public Inscripcion(String nombreEstudiante, String nombreMaterias) {
        this.nombreEstudiante = nombreEstudiante;
        this.nombreMaterias = nombreMaterias;
    }

    public Inscripcion(int resgistroEstudiante) {
        ResgistroEstudiante = resgistroEstudiante;
    }

    public int getId_Inscripcion() {
        return id_Inscripcion;
    }

    public void setId_Inscripcion(int id_Inscripcion) {
        this.id_Inscripcion = id_Inscripcion;
    }

    public int getResgistroEstudiante() {
        return ResgistroEstudiante;
    }

    public void setResgistroEstudiante(int resgistroEstudiante) {
        ResgistroEstudiante = resgistroEstudiante;
    }

    public int getCodigoMaterias() {
        return CodigoMaterias;
    }

    public void setCodigoMaterias(int codigoMaterias) {
        CodigoMaterias = codigoMaterias;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getNombreMaterias() {
        return nombreMaterias;
    }

    public void setNombreMaterias(String nombreMaterias) {
        this.nombreMaterias = nombreMaterias;
    }
}
