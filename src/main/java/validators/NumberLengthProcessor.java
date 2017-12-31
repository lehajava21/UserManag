package validators;

import annotations.NumberLength;

import java.lang.annotation.Annotation;

public class NumberLengthProcessor implements BaseValidator {

    private String value;
    private Annotation annotation;

    public NumberLengthProcessor(Annotation annotation, String value) {
        this.value = value;
        this.annotation = annotation;
    }

    @Override
    public boolean validate() {
        int min = ((NumberLength)annotation).min();
        int max = ((NumberLength)annotation).max();
        if(Integer.parseInt(value) >= min && Integer.parseInt(value) <= max){
            return true;
        }
        System.out.println("Number is not valid. Must be >= " + min + " and <= " + max);
        return false;
    }
}
