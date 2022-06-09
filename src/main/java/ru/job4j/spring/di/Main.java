package ru.job4j.spring.di;

/**
 * 3. Мидл
 * 3.4. Spring
 * 3.4.1. DI. Внедрение зависимостей
 * Main клас демонстрирует работу DI(context)
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.06.2022
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(ConsoleInput.class);
        context.reg(StartUI.class);

        StartUI ui = context.get(StartUI.class);
        ui.init();
        ui.print();
    }
}
