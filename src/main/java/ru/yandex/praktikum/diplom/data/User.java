package ru.yandex.praktikum.diplom.data;

import org.apache.commons.lang3.RandomStringUtils;

public class User {

    public static String name;
    public static String email;
    public static String password;

    public static void setUserData() {
        name = RandomStringUtils.randomAlphabetic(5);
        email = RandomStringUtils.randomAlphabetic(5) + "@yandex.ru";
        password = RandomStringUtils.randomAlphanumeric(6);
    }

    public static void setUserDataWrongPassword() {
        name = RandomStringUtils.randomAlphabetic(5);
        email = RandomStringUtils.randomAlphabetic(5) + "@yandex.ru";
        password = RandomStringUtils.randomAlphanumeric(5);
    }
}
