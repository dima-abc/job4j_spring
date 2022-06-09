package ru.job4j.spring.di;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 3. Мидл
 * 3.4. Spring
 * 3.4.1. DI. Внедрение зависимостей
 * Store класс эмуляции хранилища.
 * 2. Сканирование проекта [#1070]
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.06.2022
 */
@Component
public class Store {
    private final List<String> data = new ArrayList<>();

    public void add(String value) {
        this.data.add(value);
    }

    public List<String> getAll() {
        return this.data;
    }
}
