package validators;

import java.lang.annotation.Annotation;

public class NotBlankProcessor implements BaseValidator {

    private String value;
    private Annotation annotation;

    public NotBlankProcessor(Annotation annotation, String value) {
        this.value = value;
        this.annotation = annotation;
    }

    @Override
    public boolean validate() {
        if(value != null && !value.trim().isEmpty()){
            return true;
        }
        System.out.println("NotBlank validation failed");
        return false;
    }
}
