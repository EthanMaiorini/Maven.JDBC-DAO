package daos;

import models.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class carDAO implements DAO{

    public Car findById(int id) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("Select * from car where car.id ="+id);
        if(rs.next())
        {
            Car car = new Car();

            car.setId( rs.getInt("id") );
            car.setMake( rs.getString("make") );
            car.setModel( rs.getString("model") );
            car.setYear( rs.getInt("year") );
            car.setColor( rs.getString("color"));
            car.setVin( rs.getString("vin"));

            return car;
        }

        return null;
    }

    public List<Car> findAll() throws SQLException {
        List<Car> cars = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("Select * from car");
        while(rs.next())
        {
            Car car = new Car();

            car.setId( rs.getInt("id") );
            car.setMake( rs.getString("make") );
            car.setModel( rs.getString("model") );
            car.setYear( rs.getInt("year") );
            car.setColor( rs.getString("color"));
            car.setVin( rs.getString("vin"));

            cars.add(car);
        }



        return cars;
    }

    public Car update(Car dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement
                    ("UPDATE car SET make=?, model=?, year=?, color=?, vin=? WHERE id=?");
            ps.setString(1, dto.getMake());
            ps.setString(2, dto.getModel());
            ps.setInt(3, dto.getYear());
            ps.setString(4, dto.getColor());
            ps.setString(5, dto.getVin());
            ps.setInt(6, dto.getId());
            int i = ps.executeUpdate();

            if(i == 1) {
                return dto;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dto;
    }

    public Car create(Car dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO car VALUES (NULL, ?, ?, ?, ?, ?)");
            ps.setString(1, dto.getMake());
            ps.setString(2, dto.getModel());
            ps.setInt(3, dto.getYear());
            ps.setString(4, dto.getColor());
            ps.setString(5, dto.getVin());
            int i = ps.executeUpdate();

            if(i == 1) {
                return dto;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dto;
    }

    public boolean delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM car WHERE id=" + id);

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;

    }
}
