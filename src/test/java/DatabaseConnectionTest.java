import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class DatabaseConnectionTest {

    @Test
    public void testDatabaseConnection() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            assertNotNull(connection);
            connection.close(); // закрываем соединение после успешного теста
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Exception thrown: " + e.getMessage());
        }
    }
}

