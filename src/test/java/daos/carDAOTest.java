package daos;

import junit.framework.TestCase;
import models.Car;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class carDAOTest  {

    @Test
    public void findByIdtest() throws SQLException {
        Car car = new Car();
        carDAO carD = new carDAO();
        car = carD.findById(1);
        System.out.println(car.toString());

    }

    @Test
    public void testFindAll() throws SQLException {
        List<Car> cars = new ArrayList<>();
        carDAO carD = new carDAO();
        cars = carD.findAll();
        for(Car c : cars) {
            System.out.println(c.toString());
        }
    }

    @Test
    public void testUpdate() throws SQLException {
        carDAO carD = new carDAO();
        Car car = new Car(1, "Nissan", "Sentra",2002, "OutOfTheBlue", "123");
        carD.update(car);
        List<Car> cars = new ArrayList<>();
        cars = carD.findAll();
        for(Car c : cars) {
            System.out.println(c.toString());
        }
    }

    @Test
    public void testCreate() throws SQLException {
        carDAO carD = new carDAO();
        Car car = new Car( 0, "Nissan", "Maxima",2022, "Blue", "141516");
        carD.create(car);
        List<Car> cars = new ArrayList<>();
        cars = carD.findAll();
        for(Car c : cars) {
            System.out.println(c.toString());
        }
    }

    @Test
    public void testDelete() throws SQLException {
        carDAO carD = new carDAO();
        carD.delete(6);
        List<Car> cars = new ArrayList<>();
        cars = carD.findAll();
        for(Car c : cars) {
            System.out.println(c.toString());
        }
    }
}