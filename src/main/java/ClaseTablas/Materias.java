package ClaseTablas;

public class Materias {

    private int CodigoMaterias;
    private String nombre;
    private String NumeroCredito;

    public Materias(int codigoMaterias, String nombre, String numeroCredito) {
        CodigoMaterias = codigoMaterias;
        this.nombre = nombre;
        NumeroCredito = numeroCredito;
    }


    public int getCodigoMaterias() {
        return CodigoMaterias;
    }

    public void setCodigoMaterias(int codigoMaterias) {
        CodigoMaterias = codigoMaterias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroCredito() {
        return NumeroCredito;
    }

    public void setNumeroCredito(String numeroCredito) {
        NumeroCredito = numeroCredito;
    }
}
