package Dao;

import ClaseTablas.Inscripcion;


import java.util.List;

public interface InscripcionDao {
    List<Inscripcion> getAllInscripcion();
    void insertInscripcion(Inscripcion inscripcion);
    void buscarMateriaEstudiante(Inscripcion inscripcion);
}