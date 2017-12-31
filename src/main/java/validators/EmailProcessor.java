package validators;

import java.lang.annotation.Annotation;
import java.util.regex.Pattern;

public class EmailProcessor implements BaseValidator {

    private String value;
    private Annotation annotation;

    public EmailProcessor(Annotation annotation, String value) {
        this.value = value;
        this.annotation = annotation;
    }

    @Override
    public boolean validate() {
        if(Pattern.compile("[0-?A-~]+@[0-?A-~]+\\.[0-?A-~]+").matcher(value).matches()){
            return true;
        }
        System.out.println("Email is not valid");
        return false;
    }
}
