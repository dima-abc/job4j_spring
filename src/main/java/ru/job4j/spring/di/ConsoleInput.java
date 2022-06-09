package ru.job4j.spring.di;

import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * 3. Мидл
 * 3.4. Spring
 * 3.4.1. DI. Внедрение зависимостей
 * ConsoleInput класс ввода информации.
 * 2. Сканирование проекта [#1070]
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.06.2022
 */
@Component
public class ConsoleInput {
    private final Scanner scanner = new Scanner(System.in);

    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
