package ru.job4j.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 3. Мидл
 * 3.4. Spring
 * 3.4.1. DI. Внедрение зависимостей
 * StartUI класс зависит от Store
 * 2. Сканирование проекта [#1070]
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.06.2022
 */
@Component
@Scope("prototype")
public class StartUI {
    @Autowired
    private Store store;
    @Autowired
    private ConsoleInput input;

    public static final String ASK = "Введите данные: ";

    public void init() {
        System.out.println("Для выхода нажмите 'q'");
        String run = "";
        while (!"q".equals(run)) {
            run = input.askStr(ASK);
            if (!"q".equals(run)) {
                add(run);
                print();
            }
        }
    }

    public void add(String value) {
        this.store.add(value);
    }

    public void print() {
        for (String value : this.store.getAll()) {
            System.out.println(value);
        }
    }
}
