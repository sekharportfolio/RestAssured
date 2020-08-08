package Utilities;

public class EmailValidator {
    private static final String REGEX_To_VALIDATE_EMAIL_ID = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";

    public static Boolean checkEmailFormat(String email) {
        return email.matches(REGEX_To_VALIDATE_EMAIL_ID);
    }
}
