package validators;

import annotations.DisplayName;

import java.lang.annotation.Annotation;

public class DisplayNameProcessor implements BaseValidator {
    private String value;
    private Annotation annotation;

    public DisplayNameProcessor(Annotation annotation, String value) {
        this.value = value;
        this.annotation = annotation;
    }

    @Override
    public boolean validate() {
        System.out.println(((DisplayName)annotation).name());
        return true;
    }
}
