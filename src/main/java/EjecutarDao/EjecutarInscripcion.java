package EjecutarDao;

import ClaseTablas.Inscripcion;
import ClaseTablas.Materias;
import Conexion.Conexion;
import Dao.InscripcionDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EjecutarInscripcion implements InscripcionDao {
    @Override
    public List<Inscripcion> getAllInscripcion() {
        List<Inscripcion> Inscripciones = new ArrayList<>();
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "select e.ResgistroEstudiante, e.nombreCompleto as nombre_estudiante, m.nombre as nombre_materias" +
                            " from Inscripcion I" +
                            " join Estudiante e on I.ResgistroEstudiante = e.ResgistroEstudiante" +
                            " Join Materias m on I.CodigoMaterias = m.CodigoMaterias" //+
                           // " WHERE e.ResgistroEstudiante = ?"

            );
            //stmt.setInt();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nombreEstudiante = rs.getString("nombre_estudiante");
                String nombreMaterias = rs.getString("nombre_materias");
                Inscripcion inscripcion = new Inscripcion
                        (nombreEstudiante, nombreMaterias);
                Inscripciones.add(inscripcion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Inscripciones;
    }
    @Override
    public void insertInscripcion (Inscripcion inscripcion) {
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Inscripcion (ResgistroEstudiante, CodigoMaterias) VALUES (?, ?)"
            );
            stmt.setInt(1, inscripcion.getResgistroEstudiante());
            stmt.setInt(2, inscripcion.getCodigoMaterias());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void buscarMateriaEstudiante(Inscripcion inscripcion) {
            try (Connection conn = Conexion.getConnection()){
                PreparedStatement stmt = conn.prepareStatement("" +
                        "SELECT e.ResgistroEstudiante, e.nombreCompleto AS nombre_estudiante, m.nombre AS nombre_materia \n" +
                        "FROM Inscripcion I \n" +
                        "JOIN Estudiante e ON I.ResgistroEstudiante = e.ResgistroEstudiante \n" +
                        "JOIN Materias m ON I.CodigoMaterias = m.CodigoMaterias  \n" +
                        "WHERE e.ResgistroEstudiante = ? \n"
                );
                stmt.setInt(1,inscripcion.getResgistroEstudiante());
                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    String nombreEstudiante = rs.getString("nombre_estudiante");
                    String nombreMateria = rs.getString("nombre_materia");
                    System.out.println("Nombre del Estudiante: " + nombreEstudiante);
                    System.out.println("Nombre de la Materia: " + nombreMateria);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }
}

