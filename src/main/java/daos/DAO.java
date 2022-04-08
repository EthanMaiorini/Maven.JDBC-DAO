package daos;

import models.Car;

import java.sql.SQLException;
import java.util.List;

public interface DAO {

    public Car findById(int id) throws SQLException;
    public List<Car> findAll() throws SQLException;
    public Car update(Car dto);
    public Car create(Car dto);
    public void delete(int id);

}
