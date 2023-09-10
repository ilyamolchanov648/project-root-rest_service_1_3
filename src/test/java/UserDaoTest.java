import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
public class UserDaoTest {

    @Test
    public void printAllUsers() {
        UserDao userDao = new UserDao();
        List<User> users = userDao.getAllUsers();

        for (User user : users) {
            System.out.println("ID: " + user.getId());
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println();
        }
    }

}
