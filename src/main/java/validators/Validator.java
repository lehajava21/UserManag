package validators;

import annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Validator {

    private static Map<Field, Boolean> checkMap = new HashMap<>();
    private static boolean start = true;

    private static void fillCheckMap(Object o){
        for(Field field : o.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(Valid.class)){
                checkMap.put(field, false);
            }
        }
    }

    public static boolean validate(Object o) throws IllegalAccessException, NoSuchMethodException,
            InstantiationException, InvocationTargetException {

        if(start){
            fillCheckMap(o);
            start = false;
        }
        for (Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if(!field.isAnnotationPresent(Valid.class)){
                continue;
            }
            if(field.get(o) == null){
                continue;
            }
            if(checkMap.get(field)){
                continue;
            }
            Annotation[] annotations = field.getAnnotations();
            if(annotations == null){
                continue;
            }
            for (Annotation annotation : annotations) {
                if(annotation.annotationType().equals(Valid.class)){
                    continue;
                }
                if(!validField(annotation, field.get(o).toString())){
                    field.set(o,null);
                    return false;
                }
            }
            checkMap.put(field, true);
        }
        return true;
    }

    private static boolean validField(Annotation annotation, String field) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class c = annotation.annotationType();
        if(c.equals(DisplayName.class)){
            return processing(DisplayNameProcessor.class, annotation, field);
        }else if(c.equals(NotBlank.class)){
            return processing(NotBlankProcessor.class, annotation, field);
        }else if(c.equals(Length.class)){
            return processing(LengthProcessor.class, annotation, field);
        }else if(c.equals(NumberLength.class)){
            return processing(NumberLengthProcessor.class, annotation, field);
        }else if(c.equals(Email.class)){
            return processing(EmailProcessor.class, annotation, field);
        }
        return false;
    }

    private static boolean processing(Class cls, Annotation annotation, String field)
            throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        BaseValidator bv = (BaseValidator) cls.getDeclaredConstructor(Annotation.class, String.class)
                .newInstance(annotation,field);
        return bv.validate();
    }

}
