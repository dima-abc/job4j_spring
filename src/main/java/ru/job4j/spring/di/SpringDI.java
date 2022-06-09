package ru.job4j.spring.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 3. Мидл
 * 3.4. Spring
 * 3.4.1. DI. Внедрение зависимостей
 * 1. Spring DI. Запуск [#2091]
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.06.2022
 */
public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Store.class);
        context.register(ConsoleInput.class);
        context.register(StartUI.class);
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        ui.init();
    }
}
