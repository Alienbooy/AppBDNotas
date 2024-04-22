package Dao;


import ClaseTablas.Materias;

import java.util.List;

public interface MateriaDao {
    List<Materias> getAllMaterias();

    Materias getMateria(int id);
    //void buscarMateriaEstudiante(Materias materias);
    void updateMateria(Materias materias);
    void deleteMateria(Materias materias);
    void createMateria(Materias materias);
}
