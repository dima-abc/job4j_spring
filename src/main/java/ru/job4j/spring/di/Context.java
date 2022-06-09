package ru.job4j.spring.di;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3. Мидл
 * 3.4. Spring
 * 3.4.1. DI. Внедрение зависимостей
 * Context Мы будем регистрировать классы в нем,
 * а он будет отдавать нам проинициализированные объекты.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.06.2022
 */
public class Context {
    private final Map<String, Object> els = new HashMap<>();

    public void reg(Class cl) throws IllegalAccessException {
        Constructor[] constructors = cl.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new IllegalAccessException("Class has multiple constructors : " + cl.getCanonicalName());
        }
        Constructor constructor = constructors[0];
        List<Object> args = new ArrayList<>();
        for (Class arg : constructor.getParameterTypes()) {
            if (!els.containsKey(arg.getCanonicalName())) {
                throw new IllegalAccessException("Object doesn't found in context : " + arg.getCanonicalName());
            }
            args.add(els.get(arg.getCanonicalName()));
        }
        try {
            els.put(cl.getCanonicalName(), constructor.newInstance(args.toArray()));
        } catch (Exception e) {
            throw new IllegalAccessException("Count create an instance of : " + cl.getCanonicalName());
        }
    }

    public <T> T get(Class<T> inst) {
        return (T) els.get(inst.getCanonicalName());
    }
}
