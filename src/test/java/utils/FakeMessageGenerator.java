package utils;

import com.github.javafaker.Faker;

public class FakeMessageGenerator {

    public static String generateEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String generatePassword() {
        return new Faker().internet().password(8, 10);
    }

    public static String generatePasswordHint() {
        return new Faker().internet().password();
    }

    public static String generateTextEntry() {
        return new Faker().lorem().fixedString(10);
    }

    public static String generateTag() {
        return new Faker().animal().name();
    }
}
