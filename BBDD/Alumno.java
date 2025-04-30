/**
 * @author Miguel Angel
 */
import java.sql.*;
import java.time.LocalDate;

public class Alumno {
    private String dni;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String email;

    // Constructor
    public Alumno(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String direccion, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.email = email;
    }
    
    //Constructor que crea un objeto Alumno únicamente con su identificador.
    //Se utiliza para leer los datos desde la BD a partir del DNI (clave primaria)
    public Alumno(String dni){
        this.dni = dni;
    }

    // Métodos CRUD -------------------------------------------------------------------------
    
    
    public void create(Connection conexion) throws SQLException {
        String sql = "INSERT INTO alumnos (dni, nombre, apellidos, fechaNacimiento, direccion, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, dni);
            statement.setString(2, nombre);
            statement.setString(3, apellidos);
            statement.setDate(4, Date.valueOf(fechaNacimiento));
            statement.setString(5, direccion);
            statement.setString(6, email);
            statement.executeUpdate();
            System.out.println("Alumno insertado en la base de datos.");
        }
    }

    /**
     * Método para leer los datos de un alumno según su dni
     * @param conexion
     * @param dni
     * @return Objeto de tipo Alumno. Si no existe, devuelve null
     * @throws SQLException 
     */
    public static Alumno read(Connection conexion, String dni) throws SQLException {
        String sql = "SELECT * FROM alumnos WHERE dni = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                LocalDate fechaNacimiento = resultSet.getDate("fechaNacimiento").toLocalDate();
                String direccion = resultSet.getString("direccion");
                String email = resultSet.getString("email");
                return new Alumno(dni, nombre, apellidos, fechaNacimiento, direccion, email);
            } else {
                return null;
            }
        }
    }

    /**
     * Método para leer los datos de un objeto alumno
     * @param conexion
     * @param dni
     * @return Objeto de tipo Alumno. Si no existe, devuelve null
     * @throws SQLException 
     */
    public void read(Connection conexion) throws SQLException {
        String sql = "SELECT * FROM alumnos WHERE dni = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, this.dni);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                this.nombre = resultSet.getString("nombre");
                this.apellidos = resultSet.getString("apellidos");
                this.fechaNacimiento = resultSet.getDate("fechaNacimiento").toLocalDate();
                this.direccion = resultSet.getString("direccion");
                this.email = resultSet.getString("email");
                System.out.println("Datos del alumno actualizados desde la base de datos.");
            } else {
                System.out.println("No se encontró ningún alumno con el DNI especificado.");
            }
        }
    }

    public void update(Connection conexion) throws SQLException {
        String sql = "UPDATE alumnos SET nombre = ?, apellidos = ?, fechaNacimiento = ?, direccion = ?, email = ? WHERE dni = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setDate(3, Date.valueOf(fechaNacimiento));
            statement.setString(4, direccion);
            statement.setString(5, email);
            statement.setString(6, dni);
            statement.executeUpdate();
            System.out.println("Datos del alumno actualizados en la base de datos.");
        }
    }

    public void delete(Connection conexion) throws SQLException {
        String sql = "DELETE FROM alumnos WHERE dni = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, dni);
            statement.executeUpdate();
            System.out.println("Alumno eliminado exitosamente de la base de datos.");
        }
    }

    // Demás métodos como los getters y setters
    
}
