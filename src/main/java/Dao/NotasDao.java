package Dao;

import ClaseTablas.Estudiante;
import ClaseTablas.Inscripcion;
import ClaseTablas.Notas;

import java.util.List;

public interface NotasDao {
    List<Notas> getAllNotas();
    void insertNotas(Notas notas);
    void CalcularNotas(Notas notas);
    void verNotas(Notas notas);
}
