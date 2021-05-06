package com.mycompany.controller;

import com.google.gson.Gson;
import com.mycompany.controller.command.Commands;
import com.mycompany.domain.Car;
import com.mycompany.domain.User;
import com.mycompany.repository.CarRepository;
import com.mycompany.repository.UserRepository;
import com.mycompany.repository.impl.CarRepositoryImpl;
import com.mycompany.repository.impl.UserRepositoryImpl;
import org.apache.commons.io.IOUtils;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;

public class FrontController extends HttpServlet {

    public UserRepository userRepository = new UserRepositoryImpl();
    public CarRepository carRepository = new CarRepositoryImpl() ;

    public FrontController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processGetRequests(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processPostRequests(req, resp);
    }

    private void processGetRequests(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Commands commandName = Commands.findByCommandName(req.getParameter("command"));
        try {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/bye");
            if (dispatcher != null) {
                resolveGetRequestCommands(req, commandName);
                dispatcher.forward(req, resp);
            }
        } catch (Exception e) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error");
            if (dispatcher != null) {
                req.setAttribute("trace", e.getMessage());
                dispatcher.forward(req, resp);
            }
        }
    }


    private void resolveGetRequestCommands(HttpServletRequest req, Commands commandName) {

        //http://localhost:8080/PROJECT/FrontController?command=findAll&page=0&limit=10 (add offset to query)

        switch (commandName) {
            //     http://localhost:8080/PROJECT/FrontController?command=findUsersAll
            case FIND_USERS_ALL:
                req.setAttribute("users", userRepository.findAll());
                break;
            //     http://localhost:8080/PROJECT/FrontController?command=findCarsAll
            case FIND_CARS_ALL:
                req.setAttribute("cars", carRepository.findAll());
                break;
            //     http://localhost:8080/PROJECT/FrontController?command=findUserById&id=14
            case FIND_USER_BY_ID:
                String id = req.getParameter("id");
                long userId = Long.parseLong(id);
                req.setAttribute("users", Collections.singletonList(userRepository.findOne(userId)));
                break;
            //     http://localhost:8080/PROJECT/FrontController?command=findCarById&id=4
            case FIND_CAR_BY_ID:
                String idCar = req.getParameter("id");
                long Id = Long.parseLong(idCar);
                req.setAttribute("cars", Collections.singletonList(carRepository.findOne(Id)));
                break;
            //     http://localhost:8080/PROJECT/FrontController?command=findUsersByQuery&query=ac
            case FIND_USERS_BY_QUERY:
                String query = req.getParameter("query");
                req.setAttribute("users", userRepository.findUsersByQuery(query));
                break;
            //     http://localhost:8080/PROJECT/FrontController?command=findCarsByQuery&query=a
            case FIND_CARS_BY_QUERY:
                String queryCar = req.getParameter("query");
                req.setAttribute("cars", carRepository.findCarsByName(queryCar));
                break;
            //     http://localhost:8080/PROJECT/FrontController?command=findUsersWeight&from=80&to=100
            case FIND_USERS_WEIGHT:
                String from = req.getParameter("from");
                long userFrom = Long.parseLong(from);
                String to = req.getParameter("to");
                long userTo = Long.parseLong(to);
                req.setAttribute("users", userRepository.findWeightFromTo(userFrom,userTo));
                break;
            case FIND_USER_EXPENSIVE_CAR:
                String number = req.getParameter("number");
                Integer IdUser = Integer.parseInt(number);
                req.setAttribute("singleUser", userRepository.getUserExpensiveCarPrice(IdUser));
                break;
            //     http://localhost:8080/PROJECT/FrontController?command=findCarsFromToPrice&from=10000&to=40000&carName=a
            case FIND_CARS_FROM_TO_PRICE:
                String fromPrice = req.getParameter("from");
                long carFrom = Long.parseLong(fromPrice);
                String toPrice = req.getParameter("to");
                long carTo = Long.parseLong(toPrice);
                String carName = req.getParameter("carName");
                req.setAttribute("cars", carRepository.findCarFromToPrice(carFrom,carTo,carName));
                break;
            default:
                break;
        }
    }
    private void processPostRequests(HttpServletRequest req, HttpServletResponse resp) {
        Commands commandName = Commands.findByCommandName(req.getParameter("command"));
        try {
            switch (commandName) {
                case CREATE_USER:
                    //Deserializing post request body to User class object
                    String body = IOUtils.toString(req.getInputStream(), Charset.defaultCharset());
                    User user = new Gson().fromJson(body, User.class);
                    //Saving user object
                    req.setAttribute("users", Collections.singletonList(userRepository.save(user)));
                    break;
                case CREATE_CAR:
                    String bodyCar = IOUtils.toString(req.getInputStream(), Charset.defaultCharset());
                    Car car = new Gson().fromJson(bodyCar, Car.class);
                    //Saving user object
                    req.setAttribute("cars", Collections.singletonList(carRepository.save(car)));
                    break;
                case UPDATE_USER:
                    String updateBody = IOUtils.toString(req.getInputStream(), Charset.defaultCharset());
                    User updateUser = new Gson().fromJson(updateBody, User.class);
                    req.setAttribute("users", Collections.singletonList(userRepository.update(updateUser)));
                    break;
                case UPDATE_CAR:
                    String updateBodyCar = IOUtils.toString(req.getInputStream(), Charset.defaultCharset());
                    Car updateCar = new Gson().fromJson(updateBodyCar, Car.class);
                    req.setAttribute("cars", Collections.singletonList(carRepository.update(updateCar)));
                    break;
                case DELETE_USER:
                    String id = req.getParameter("id");
                    long userId = Long.parseLong(id);
                    userRepository.delete(userId);
                    req.setAttribute("users", userRepository.findAll());
                    break;
                case DELETE_CAR:
                    String idCar = req.getParameter("id");
                    long Id = Long.parseLong(idCar);
                    carRepository.delete(Id);
                    req.setAttribute("cars", carRepository.findAll());
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
