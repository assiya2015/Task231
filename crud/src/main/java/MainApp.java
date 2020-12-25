import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.PersistenceConfig;
import web.entity.User;
import web.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class MainApp {

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PersistenceConfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.saveUser(new User("name1", "lName1", "email1"));
        List<User> users = userService.getUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());

        }
        context.close();
    }
}
