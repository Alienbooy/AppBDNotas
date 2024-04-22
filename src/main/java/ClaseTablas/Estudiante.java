package ClaseTablas;

public class Estudiante {
    private int ResgistroEstudiante;
    private String nombreCompleto;
    private String fechaNacimiento;
    private String Carrera;


    public Estudiante(int RegistoEstudiante, String nombreCompleto, String fechaNacimiento, String Carrera){
        this.ResgistroEstudiante = RegistoEstudiante;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.Carrera = Carrera;
    }

    public int getResgistroEstudiante() {
        return ResgistroEstudiante;
    }

    public void setResgistroEstudiante(int resgistroEstudiante) {
        ResgistroEstudiante = resgistroEstudiante;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String carrera) {
        Carrera = carrera;
    }
}
