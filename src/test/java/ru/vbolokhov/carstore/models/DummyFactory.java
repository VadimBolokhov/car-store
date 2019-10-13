package ru.vbolokhov.carstore.models;

import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * Dummy entity factory for testing.
 * @author Vadim Bolokhov
 */
public class DummyFactory {

    public Car getCar() {
        Car car = new Car();
        car.setModel(this.createModel());
        car.setOwner(this.createUser());
        car.setColor(Color.BLACK);
        car.setPrice(10000d);
        car.setPostDate(LocalDateTime.now());
        Gearbox box = new Gearbox("box");
        car.setGearbox(box);
        return car;
    }

    private CarModel createModel() {
        CarModel model = new CarModel("Test");
        model.setMake(new Make("Make"));
        model.setBody(new Body("Style"));
        model.setEngine(new Engine("Engine"));
        model.setTransmission(new Transmission("Transmission"));
        return model;
    }

    private User createUser() {
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        user.setRole(Role.AMDIN);
        user.setEmail("some@email.com");
        user.setFirstname("Firstname");
        user.setLastname("Lastname");
        user.setCars(new LinkedList<>());
        return user;
    }

    public User getUser() {
        return this.getUser("login", "password");
    }

    public User getUser(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(Role.USER);
        user.setEmail("some@email.com");
        user.setFirstname("Firstname");
        user.setLastname("Lastname");
        user.setCars(new LinkedList<>());
        return user;
    }
}
