package com.mycompany.repository.impl;

import com.mycompany.domain.Car;
import com.mycompany.exception.NoSuchEntityException;
import com.mycompany.repository.CarRepository;
import com.mycompany.util.DatabasePropertiesReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.mycompany.util.DatabasePropertiesReader.*;
import static com.mycompany.util.DatabasePropertiesReader.DATABASE_PASSWORD;

public class CarRepositoryImpl  {

//    private DatabasePropertiesReader reader = DatabasePropertiesReader.getInstance();
//
//    public static final String ID = "id";
//    public static final String NAME = "name";
//    public static final String MODEL = "model";
//    public static final String PRODUCTION_DATE = "production_date";
//    public static final String PRICE = "price";
//
//    @Override
//    public List<Car> findAll() {
//        final String findAllQuery = "select * from cars order by id desc";
//
//        List<Car> result = new ArrayList<>();
//
//        Connection connection;
//        Statement statement;
//        ResultSet rs;
//
//        try {
//            Class.forName(reader.getProperty(DATABASE_DRIVER_NAME));
//        } catch (ClassNotFoundException e) {
//            System.err.println("JDBC Driver Cannot be loaded!");
//            throw new RuntimeException("JDBC Driver Cannot be loaded!");
//        }
//
//        String jdbcURL = reader.getProperty(DATABASE_URL);
//        String login = reader.getProperty(DATABASE_LOGIN);
//        String password = reader.getProperty(DATABASE_PASSWORD);
//
//        try {
//            connection = DriverManager.getConnection(jdbcURL, login, password);
//            statement = connection.createStatement();
//            rs = statement.executeQuery(findAllQuery);
//
//            //Row mapping
//            while (rs.next()) {
//                Car car = new Car();
//                car.setId(rs.getLong(ID));
//                car.setName(rs.getString(NAME));
//                car.setModel(rs.getString(MODEL));
//                car.setProduction_date(rs.getDate(PRODUCTION_DATE));
//                car.setPrice(rs.getFloat(PRICE));
//
//                result.add(car);
//            }
//
//            return result;
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//            throw new RuntimeException("SQL Issues!");
//        }
//    }
//
//    @Override
//    public Car findOne(Long id) {
//        final String findById = "select * from cars where id = ?";
//
//        Connection connection;
//        PreparedStatement statement;
//        ResultSet rs;
//
//        try {
//            Class.forName(reader.getProperty(DATABASE_DRIVER_NAME));
//        } catch (ClassNotFoundException e) {
//            System.err.println("JDBC Driver Cannot be loaded!");
//            throw new RuntimeException("JDBC Driver Cannot be loaded!");
//        }
//
//        String jdbcURL = reader.getProperty(DATABASE_URL);
//        String login = reader.getProperty(DATABASE_LOGIN);
//        String password = reader.getProperty(DATABASE_PASSWORD);
//
//        try {
//            connection = DriverManager.getConnection(jdbcURL, login, password);
//            statement = connection.prepareStatement(findById);
//            statement.setLong(1, id);
//            rs = statement.executeQuery();
//            //Row mapping
//            if (rs.next()) {
//                Car car = new Car();
//                car.setId(rs.getLong(ID));
//                car.setName(rs.getString(NAME));
//                car.setModel(rs.getString(MODEL));
//                car.setProduction_date(rs.getDate(PRODUCTION_DATE));
//                car.setPrice(rs.getFloat(PRICE));
//
//                return car;
//            }
//
//            throw new NoSuchEntityException("No such car with id:" + id);
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//            throw new RuntimeException("SQL Issues!");
//        }
//    }
//
//    @Override
//    public Car save(Car car) {
//        final String insertQuery = "insert into cars (name, model, production_date, price) " +
//                "values (?,?,?,?)";
//
//        Connection connection;
//        PreparedStatement statement;
//
//        try {
//            Class.forName(reader.getProperty(DATABASE_DRIVER_NAME));
//        } catch (ClassNotFoundException e) {
//            System.err.println("JDBC Driver Cannot be loaded!");
//            throw new RuntimeException("JDBC Driver Cannot be loaded!");
//        }
//
//        String jdbcURL = reader.getProperty(DATABASE_URL);
//        String login = reader.getProperty(DATABASE_LOGIN);
//        String password = reader.getProperty(DATABASE_PASSWORD);
//
//        try {
//            connection = DriverManager.getConnection(jdbcURL, login, password);
//            statement = connection.prepareStatement(insertQuery);
//
//            PreparedStatement lastInsertId = connection.prepareStatement("SELECT currval('cars_id_seq') as last_insert_id;");
//
//            statement.setString(1, car.getName());
//            statement.setString(2, car.getModel());
//            statement.setDate(3, new Date(car.getProduction_date().getTime()));
//            statement.setFloat(4, car.getPrice());
//
//
//            statement.executeUpdate();
//
//            Long insertedId;
//            ResultSet lastIdResultSet = lastInsertId.executeQuery();
//            if (lastIdResultSet.next()) {
//                insertedId = lastIdResultSet.getLong("last_insert_id");
//            } else {
//                throw new RuntimeException("We cannot read sequence last value during User creation!");
//            }
//
//            return findOne(insertedId);
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//            throw new RuntimeException("SQL Issues!");
//        }
//    }
//
//    @Override
//    public Car update(Car car) {
//        final String findByIdQuery = "update cars " +
//                "set " +
//                "name = ?,  " +
//                "model = ?,  " +
//                "production_date = ?,  " +
//                "price = ?  " +
//                "where id = ?";
//
//        Connection connection;
//        PreparedStatement statement;
//
//        try {
//            Class.forName(reader.getProperty(DATABASE_DRIVER_NAME));
//        } catch (ClassNotFoundException e) {
//            System.err.println("JDBC Driver Cannot be loaded!");
//            throw new RuntimeException("JDBC Driver Cannot be loaded!");
//        }
//
//        try {
//            connection = DriverManager.getConnection(reader.getProperty(DATABASE_URL), reader.getProperty(DATABASE_LOGIN), reader.getProperty(DATABASE_PASSWORD));
//            statement = connection.prepareStatement(findByIdQuery);
//            statement.setString(1, car.getName());
//            statement.setString(2, car.getModel());
//            statement.setDate(3, new Date(car.getProduction_date().getTime()));
//            statement.setFloat(4, car.getPrice());
//            statement.setLong(5, car.getId());
//
//            statement.executeUpdate();
//            return findOne(car.getId());
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//            throw new RuntimeException("SQL Issues!");
//        }
//    }
//
//    @Override
//    public void delete(Long id) {
//        final String findByIdQuery = "delete from cars where id = ?";
//
//        Connection connection;
//        PreparedStatement statement;
//
//        try {
//            Class.forName(reader.getProperty(DATABASE_DRIVER_NAME));
//        } catch (ClassNotFoundException e) {
//            System.err.println("JDBC Driver Cannot be loaded!");
//            throw new RuntimeException("JDBC Driver Cannot be loaded!");
//        }
//
//        try {
//            connection = DriverManager.getConnection(reader.getProperty(DATABASE_URL), reader.getProperty(DATABASE_LOGIN), reader.getProperty(DATABASE_PASSWORD));
//            statement = connection.prepareStatement(findByIdQuery);
//            statement.setLong(1, id);
//
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//            throw new RuntimeException("SQL Issues!");
//        }
//    }
//
//    @Override
//    public List<Car> findCarsByName(String name) {
//
//        final String findQuery = "select * from cars WHERE name like ? ";
//
//        List<Car> result = new ArrayList<>();
//
//        Connection connection;
//        PreparedStatement statement;
//        ResultSet rs;
//
//        try {
//            Class.forName(reader.getProperty(DATABASE_DRIVER_NAME));
//        } catch (ClassNotFoundException e) {
//            System.err.println("JDBC Driver Cannot be loaded!");
//            throw new RuntimeException("JDBC Driver Cannot be loaded!");
//        }
//
//        String jdbcURL = reader.getProperty(DATABASE_URL);
//        String login = reader.getProperty(DATABASE_LOGIN);
//        String password = reader.getProperty(DATABASE_PASSWORD);
//
//        try {
//            connection = DriverManager.getConnection(jdbcURL, login, password);
//            statement = connection.prepareStatement(findQuery);
//            statement.setString(1,"%"+ name + "%" );
//            rs = statement.executeQuery();
//
//            //Row mapping
//            while (rs.next()) {
//                Car car = new Car();
//                car.setId(rs.getLong(ID));
//                car.setName(rs.getString(NAME));
//                car.setModel(rs.getString(MODEL));
//                car.setProduction_date(rs.getDate(PRODUCTION_DATE));
//                car.setPrice(rs.getFloat(PRICE));
//                result.add(car);
//            }
//
//            return result;
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//            throw new RuntimeException("SQL Issues!");
//        }
//    }
//
//    @Override
//    public List<Car> findCarFromToPrice(Long from,Long to,String carName) {
//
//        final String findQuery = "select * FROM cars WHERE price > ? AND price< ? AND name LIKE ? order by price desc ";
//
//        List<Car> result = new ArrayList<>();
//
//        Connection connection;
//        PreparedStatement statement;
//        ResultSet rs;
//
//        try {
//            Class.forName(reader.getProperty(DATABASE_DRIVER_NAME));
//        } catch (ClassNotFoundException e) {
//            System.err.println("JDBC Driver Cannot be loaded!");
//            throw new RuntimeException("JDBC Driver Cannot be loaded!");
//        }
//
//        String jdbcURL = reader.getProperty(DATABASE_URL);
//        String login = reader.getProperty(DATABASE_LOGIN);
//        String password = reader.getProperty(DATABASE_PASSWORD);
//
//        try {
//            connection = DriverManager.getConnection(jdbcURL, login, password);
//            statement = connection.prepareStatement(findQuery);
//            statement.setLong(1, from );
//            statement.setLong(2, to );
//            statement.setString(3,"%"+ carName + "%" );
//
//            rs = statement.executeQuery();
//
//            //Row mapping
//            while (rs.next()) {
//                Car car = new Car();
//                car.setId(rs.getLong(ID));
//                car.setName(rs.getString(NAME));
//                car.setModel(rs.getString(MODEL));
//                car.setProduction_date(rs.getDate(PRODUCTION_DATE));
//                car.setPrice(rs.getFloat(PRICE));
//
//                result.add(car);
//            }
//
//            return result;
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//            throw new RuntimeException("SQL Issues!");
//        }
//    }
//
//}
//
//
//
}