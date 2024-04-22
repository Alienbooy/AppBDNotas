package EjecutarDao;

import ClaseTablas.Estudiante;
import Conexion.Conexion;
import Dao.EstudianteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EjecEstudianteDao implements EstudianteDao {
    Logger logger = Logger.getLogger(EjecEstudianteDao.class.getName());
    @Override
    public List<Estudiante> getAllEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Estudiante");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int ResgistoEstudiante = rs.getInt("ResgistroEstudiante");
                String nombreCompleto = rs.getString("nombreCompleto");
                String fechaNacimiento = rs.getString("fechaNacimiento");
                String Carrera = rs.getString("Carrera");
                Estudiante estudiante = new Estudiante(ResgistoEstudiante, nombreCompleto, fechaNacimiento,Carrera);
                estudiantes.add(estudiante);
                logger.info("Extraer estudiante");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            logger.info("Error en Obtener Estudiantes");
        }
        logger.info("Conexion a Estudiantes exitosa");
        return estudiantes;

    }

    @Override
    public Estudiante getEstudiante(int id) {

        return null;


    }

    @Override
    public void updateEstudiante(Estudiante estudiante) {
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE Estudiante SET nombreCompleto = ?, carrera = ? WHERE ResgistroEstudiante = ?"
            );
            stmt.setString(1, estudiante.getNombreCompleto());
            stmt.setString(2,estudiante.getCarrera());
            stmt.setInt(3, estudiante.getResgistroEstudiante());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteEstudiante(Estudiante estudiante) {
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                        "DELETE FROM Estudiante WHERE ResgistroEstudiante = ?"
            );
            stmt.setInt(1, estudiante.getResgistroEstudiante());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void createEstudiante(Estudiante estudiante) {
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Estudiante (ResgistroEstudiante, nombreCompleto, fechaNacimiento, Carrera) VALUES (?, ?, ?, ?)"
            );
            stmt.setInt(1, estudiante.getResgistroEstudiante());
            stmt.setString(2, estudiante.getNombreCompleto());
            stmt.setString(3, estudiante.getFechaNacimiento());
            stmt.setString(4,estudiante.getCarrera());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //un metodo para buscar por nombre del estudiante
    public void searchEstudiante(Estudiante estudiante){
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT E.nombre AS nombreCompleto, M.nombre AS NombreMateria\n" +
                            "FROM Estudiante E\n" +
                            "JOIN Inscripcion I ON E.ResgistroEstudiante = I.ResgistroEstudiante\n" +
                            "JOIN Materias M ON I.CodigoMaterias = M.CodigoMaterias\n" +
                            "WHERE E.nombre = '?';"
            );
            stmt.setInt(1, estudiante.getResgistroEstudiante());
            stmt.setString(2, estudiante.getNombreCompleto());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

