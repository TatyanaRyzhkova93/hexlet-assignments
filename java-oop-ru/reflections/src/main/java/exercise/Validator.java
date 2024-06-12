package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class Validator {
    public static List<String> validate(Object obj) {
        ArrayList<String> list = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class) && field.get(obj) == null) {
                    list.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }
}
