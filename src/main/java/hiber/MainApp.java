package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("Audi", 100);
        Car car2 = new Car("BMW", 200);
        Car car3 = new Car("Reno", 300);
        Car car4 = new Car("Honda", 400);

        userService.addUser(new User("User1", "Lastname1", "user1@mail.ru", car1));
        userService.addUser(new User("User2", "Lastname2", "user2@mail.ru", car2));
        userService.addUser(new User("User3", "Lastname3", "user3@mail.ru", car3));
        userService.addUser(new User("User4", "Lastname4", "user4@mail.ru", car4));

        System.out.println(userService.getUserCar("Audi", 100));
        System.out.println(userService.getUserCar("BMW", 200));
        System.out.println(userService.getUserCar("Reno", 300));
        System.out.println(userService.getUserCar("Honda", 400));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        List<Car> cars = userService.listCars();
        for (Car car : cars) {
            System.out.println("Id = " + car.getId());
            System.out.println("Model = " + car.getModel());
            System.out.println("Series = " + car.getSeries());
            System.out.println();
        }
        context.close();
    }
}
