package validators;

import annotations.Length;

import java.lang.annotation.Annotation;

public class LengthProcessor implements BaseValidator {

    private String value;
    Annotation annotation;

    public LengthProcessor(Annotation annotation, String value) {
        this.value = value;
        this.annotation = annotation;
    }

    @Override
    public boolean validate() {
        int min = ((Length)annotation).min();
        int max = ((Length)annotation).max();
        if (value == null && min == 0) {
            return true;
        }
        if (value == null) {
            System.out.println("Length is not valid. Value is null");
            return false;
        }
        if (value.length() <= max && value.length() >= min) {
            return true;
        }
        System.out.println("Length is not valid. Must be >= " + min + " and <= " + max);
        return false;
    }
}
