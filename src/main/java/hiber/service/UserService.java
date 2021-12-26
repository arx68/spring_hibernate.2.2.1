package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void addCar(Car car);

    User getUserCar(String model, int series);

    List<User> listUsers();

    List<Car> listCars();
}
