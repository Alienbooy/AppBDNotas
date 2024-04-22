package ClaseTablas;

public class Notas {
    private int idNota;
    private int id_Inscripcion;
    private int ResgistroEstudiante;
    private int CodigoMaterias;
    private String tipoExamen;
    private int valor;

    private float PromedioNotas;

    public Notas( int resgistroEstudiante, String tipoExamen, int valor) {
        ResgistroEstudiante = resgistroEstudiante;
        this.tipoExamen = tipoExamen;
        this.valor = valor;

    }

    public Notas(int resgistroEstudiante, int codigoMaterias) {
        ResgistroEstudiante = resgistroEstudiante;
        this.CodigoMaterias = codigoMaterias;

    }

    public Notas(int resgistroEstudiante) {
        ResgistroEstudiante = resgistroEstudiante;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public int getId_Inscripcion() {
        return id_Inscripcion;
    }

    public void setId_Inscripcion(int id_Inscripcion) {
        this.id_Inscripcion = id_Inscripcion;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getResgistroEstudiante() {
        return ResgistroEstudiante;
    }

    public void setResgistroEstudiante(int resgistroEstudiante) {
        ResgistroEstudiante = resgistroEstudiante;
    }

    public float getPromedioNotas() {
        return PromedioNotas;
    }

    public void setPromedioNotas(float promedioNotas) {
        PromedioNotas = promedioNotas;
    }

    public int getCodigoMaterias() {
        return CodigoMaterias;
    }

    public void setCodigoMaterias(int codigoMaterias) {
        CodigoMaterias = codigoMaterias;
    }
}
