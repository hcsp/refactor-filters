package com.github.hcsp.polymorphism;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void compareToMethodIsCorrect() {
        List<User> users =
                Arrays.asList(
                        new User(1, "a"), new User(2, "b"), new User(3, "c"), new User(4, "d"));

        Assertions.assertEquals(
                Arrays.asList("a"),
                User.filter(users, u -> u.getId() == 1).stream()
                        .map(User::getName)
                        .collect(Collectors.toList()));
        Assertions.assertEquals(
                Arrays.asList("b", "d"),
                User.filter(users, u -> u.getId() % 2 == 0).stream()
                        .map(User::getName)
                        .collect(Collectors.toList()));
    }
}
