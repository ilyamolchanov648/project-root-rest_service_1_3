import java.util.List;

import model.User;
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
