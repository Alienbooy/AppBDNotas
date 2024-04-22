package EjecutarDao;

import ClaseTablas.Materias;
import Conexion.Conexion;
import Dao.MateriaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EjecMateriaDao implements MateriaDao {
    @Override
    public List<Materias> getAllMaterias() {
        List<Materias> materias = new ArrayList<>();
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Materias");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int CodigoMaterias = rs.getInt("CodigoMaterias");
                String nombre = rs.getString("nombre");
                String numeroCredito = rs.getString("NumeroCredito");
                Materias materia = new Materias(CodigoMaterias, nombre, numeroCredito);
                materias.add(materia);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return materias;
    }

    @Override
    public Materias getMateria(int id) {
        return null;
    }

    /*@Override
    public void buscarMateriaEstudiante(Materias materias){
        try (Connection conn = Conexion.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("" +
                    "SELECT e.ResgistroEstudiante, e.nombreCompleto AS nombre_estudiante, m.nombre AS nombre_materia \n" +
                    "FROM Inscripcion I \n" +
                    "JOIN Estudiante e ON I.ResgistroEstudiante = e.ResgistroEstudiante \n" +
                    "JOIN Materias m ON I.CodigoMaterias = m.CodigoMaterias  \n" +
                    "WHERE e.ResgistroEstudiante = ? \n"
            );
            stmt.setInt(1,materias);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


     */
    @Override
    public void updateMateria(Materias materias) {

    }

    @Override
    public void deleteMateria(Materias materias) {
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "DELETE FROM Materias WHERE CodigoMaterias = ?");
            stmt.setInt(1,materias.getCodigoMaterias());
            stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
        @Override
    public void createMateria(Materias materias) {

    }

}
