package EjecutarDao;

import ClaseTablas.Estudiante;
import ClaseTablas.Inscripcion;
import ClaseTablas.Notas;
import Conexion.Conexion;
import Dao.NotasDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EjecutarNotas implements NotasDao {
    Logger logger = Logger.getLogger(EjecutarNotas.class.getName());
    @Override
    public List<Notas> getAllNotas(){
        List<Notas> Notas1 = new ArrayList<>();
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM Notas");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int ResgistroEstudiante = rs.getInt("ResgistroEstudiante");
                String tipoExamen = rs.getString("tipoExamen");
                int  nota  = rs.findColumn("nota");
                Notas notas = new Notas
                        (ResgistroEstudiante,tipoExamen,nota);
                Notas1.add(notas);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Notas1;
    }
    @Override
    public void insertNotas (Notas notas){
        try (Connection conn = Conexion.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO notas(id_Inscripcion, tipoExamen, nota) " +
                            "VALUES (?, ?, ?)"
                    );
            stmt.setInt(1,notas.getIdNota());
            stmt.setString(2,notas.getTipoExamen());
            stmt.setFloat(3,notas.getValor());

            stmt.executeUpdate();
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
    @Override
    public void CalcularNotas(Notas notas){
        //List<Notas> Notas1 = new ArrayList<>();
        try (Connection conn = Conexion.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("" +
                    "SELECT E.nombreCompleto, I.CodigoMaterias, AVG(nota) AS promedio \n" +
                    "FROM Notas N\n" +
                    "JOIN Inscripcion I ON N.id_Inscripcion = I.id_Inscripcion \n" +
                    "JOIN Estudiante E ON I.ResgistroEstudiante = E.ResgistroEstudiante\n" +
                    "WHERE E.ResgistroEstudiante = ?\n" +
                    "AND I.CodigoMaterias = ?\n" +
                    "GROUP BY E.nombreCompleto, I.CodigoMaterias;\n"
            );

            stmt.setInt(1,notas.getResgistroEstudiante());
            stmt.setInt(2,notas.getCodigoMaterias());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                String nombreEstudiante = rs.getString("nombreCompleto");
                String CodigoMaterias = rs.getString("CodigoMaterias");
                float promedio = rs.getFloat("promedio");
                System.out.println("Nombre del estudiante: " + nombreEstudiante);
                System.out.println("Nombre de la materia: " + CodigoMaterias);
                System.out.println("Promedio de notas: " + promedio);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void verNotas(Notas notas) {
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT E.nombreCompleto, M.nombre AS nombreMateria, N.tipoExamen, N.nota " +
                            "FROM Notas N " +
                            "JOIN Inscripcion I ON N.id_Inscripcion = I.id_Inscripcion " +
                            "JOIN Estudiante E ON E.ResgistroEstudiante = I.ResgistroEstudiante " +
                            "JOIN Materias M ON I.CodigoMaterias = M.CodigoMaterias " +
                            "WHERE E.ResgistroEstudiante = ?"
            );
            stmt.setInt(1, notas.getResgistroEstudiante());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nombreCompleto = rs.getString("nombreCompleto");
                String nombreMateria = rs.getString("nombreMateria");
                String tipoExamen = rs.getString("tipoExamen");
                float nota = rs.getFloat("nota");

                // Imprimir los resultados
                System.out.println("Estudiante: " + nombreCompleto);
                System.out.println("Materia: " + nombreMateria);
                System.out.println("Tipo de Examen: " + tipoExamen);
                System.out.println("Nota: " + nota);
                System.out.println("-----------------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
