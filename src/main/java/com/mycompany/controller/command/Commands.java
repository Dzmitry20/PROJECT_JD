package com.mycompany.controller.command;

import org.apache.commons.lang3.StringUtils;

public enum Commands {
    FIND_USER_BY_ID("findUserById"),
    FIND_CAR_BY_ID("findCarById"),
    FIND_USER_EXPENSIVE_CAR("findUserExpensiveCar"),
    FIND_USERS_WEIGHT("findUsersWeight"),
    FIND_USERS_BY_QUERY("findUsersByQuery"),
    FIND_CARS_FROM_TO_PRICE("findCarsFromToPrice"),
    FIND_CARS_BY_QUERY("findCarsByQuery"),
    FIND_USERS_ALL("findUsersAll"),
    FIND_CARS_ALL("findCarsAll"),
    CREATE_USER("createUser"),
    CREATE_CAR("createCar"),
    DELETE_USER("deleteUser"),
    DELETE_CAR("deleteCar"),
    UPDATE_USER("updateUser"),
    UPDATE_CAR("updateCar"),
    DEFAULT("findUsersAll");


    private String commandName;

    Commands(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

    public static Commands findByCommandName(String commandName) {
        if (StringUtils.isNotBlank(commandName)) {
            for (Commands value : Commands.values()) {
                if (value.getCommandName().equalsIgnoreCase(commandName)) {
                    return value;
                }
            }
        }
        return DEFAULT;
    }
}
