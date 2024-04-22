package Dao;

import ClaseTablas.Estudiante;

import java.util.List;

public interface EstudianteDao {
    List<Estudiante> getAllEstudiantes();
    Estudiante getEstudiante(int id);
    void updateEstudiante(Estudiante estudiante);
    void deleteEstudiante(Estudiante estudiante);
    void createEstudiante(Estudiante estudiante);
    void searchEstudiante(Estudiante estudiante);

}