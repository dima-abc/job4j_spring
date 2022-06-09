package ru.job4j.spring.di;

import java.util.Scanner;

/**
 * 3. Мидл
 * 3.4. Spring
 * 3.4.1. DI. Внедрение зависимостей
 * ConsoleInput класс ввода информации.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.06.2022
 */
public class ConsoleInput {
    private final Scanner scanner = new Scanner(System.in);

    public String askStr(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
