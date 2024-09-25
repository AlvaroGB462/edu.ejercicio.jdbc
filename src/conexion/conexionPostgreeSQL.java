package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexionPostgreeSQL {

    
    private final String url = "jdbc:postgresql://localhost:2004/postgres"; 
    private final String user = "postgres"; 
    private final String password = "ldts123$%";

    public Connection conectar() {
        Connection conexion = null;
        try {
            
            Class.forName("org.postgresql.Driver");
            
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a PostgreSQL!");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado: " + e.getMessage());
        }
        return conexion;
    }

    public void mostrarAlumnos() {
    	String consultaSQL = "SELECT * FROM \"Alumnos\"";
        try (Connection conexion = conectar(); 
             Statement statement = conexion.createStatement();  
             ResultSet resultado = statement.executeQuery(consultaSQL)) {

            
            System.out.println("| idAlumno | nombre | apellidos | email |");
            System.out.println("-------------------------------------");
            while (resultado.next()) {
                int idAlumno = resultado.getInt("idAlumno");
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                String email = resultado.getString("email");

                System.out.println(" | " +idAlumno + " | " + nombre + " | " + apellidos + " | " + email + " | ");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
    	conexionPostgreeSQL mostrarAlumnos = new conexionPostgreeSQL();
        mostrarAlumnos.mostrarAlumnos();
    }
}
