package email_validator;

import org.apache.commons.validator.routines.EmailValidator;

public class EmailValidation {
    public EmailValidation() {

    }

    public static boolean isValid(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }
}
