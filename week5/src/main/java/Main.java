import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/learning_sd";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "28q64@ba128p";

    public static void main(String[] args) {
        Connection connection;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установлено");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Соединение с БД не установлено");
        }
    }
}