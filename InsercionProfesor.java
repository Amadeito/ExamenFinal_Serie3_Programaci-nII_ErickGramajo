import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsercionProfesor {

    public static void main(String[] args) {
        // Configuración de la conexión a la base de datos
        String url = "localhost";
        String port = "3306";
        String dbName= "profesor"; //este es el nombre de la tabla creada en heidi sql
        String usuario = "root";
        String contraseña = "12345678";

        // Datos del profesor a insertar
        int codigo = 1;
        String nombre = "Nombre del Profesor";
        String profesion = "Profesión del Profesor";

        // Query de inserción
        String query = "INSERT INTO profesor (codigo, nombre, profesion) VALUES (?, ?, ?)";

        try (
            // Establecer la conexión a la base de datos
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            
            // Preparar la declaración SQL para la inserción
            PreparedStatement preparedStatement = conexion.prepareStatement(query)
        ) {
            // Establecer los valores de los parámetros en la declaración preparada
            preparedStatement.setInt(1, codigo);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, profesion);

            // Ejecutar la inserción
            int filasAfectadas = preparedStatement.executeUpdate();

            // Verificar si la inserción fue exitosa
            if (filasAfectadas > 0) {
                System.out.println("Inserción exitosa");
            } else {
                System.out.println("La inserción no se realizó correctamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
