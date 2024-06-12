package exercise;

import java.lang.reflect.Field;
import java.text.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> map = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            List<String> list = new ArrayList<>();
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(MinLength.class) && (field.get(obj) == null
                        || field.get(obj).toString().length() < field.getAnnotation(MinLength.class).minLength())) {
                    list.add("length less than " + field.getAnnotation(MinLength.class).minLength());
                }
                if (field.isAnnotationPresent(NotNull.class) && field.get(obj) == null) {
                    list.add("can not be null");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (!list.isEmpty()) {
                map.put(field.getName(), list);
            }
        }
        return map;
    }
}
