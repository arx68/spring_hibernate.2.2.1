package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public User getUserCar(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("select users from User users where" +
                        " users.car.model = :model and users.car.series = :series", User.class);
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory
                .getCurrentSession()
                .createQuery("from User");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecke")
    public List<Car> listCars() {
        TypedQuery<Car> query = sessionFactory
                .getCurrentSession()
                .createQuery("from Car");
        return query.getResultList();
    }
}
