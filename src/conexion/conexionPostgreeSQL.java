package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado: " + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
    	conexionPostgreeSQL conexionPostgreSQL = new conexionPostgreeSQL();
        conexionPostgreSQL.conectar();
    }
}
