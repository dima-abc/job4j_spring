package ru.job4j.spring.di;

/**
 * 3. Мидл
 * 3.4. Spring
 * 3.4.1. DI. Внедрение зависимостей
 * StartUI класс зависит от Store
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.06.2022
 */
public class StartUI {
    private final Store store;
    private final ConsoleInput input;
    public static final String ASK = "Введите данные: ";

    public StartUI(Store store, ConsoleInput input) {
        this.store = store;
        this.input = input;
    }

    public void init() {
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
