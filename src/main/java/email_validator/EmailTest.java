package email_validator;

import java.util.Random;

public class EmailTest {
    private static final String[] VALID_DOMAINS = {"gmail.com", "yahoo.com", "hotmail.com"};
    private static final String[] INVALID_DOMAINS = {"example.com", "test.org", "fake.net"};
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("Valid email addresses:");
        for (int i = 0; i < 10; i++) {
            String username = generateRandomString(random, 5);
            String domain = VALID_DOMAINS[random.nextInt(VALID_DOMAINS.length)];
            String email = username + "@" + domain;
            System.out.println("Email: " + email + "\t Validez: " + EmailValidation.isValid(email));
        }
        System.out.println("\nInvalid email addresses:");
        for (int i = 0; i < 10; i++) {
            String username = generateRandomString(random, 5);
            String domain = INVALID_DOMAINS[random.nextInt(INVALID_DOMAINS.length)];
            String email = username + "@" + "etc.e";
            System.out.println("Email: " + email + "\t Validez: " + EmailValidation.isValid(email));
        }
    }
    private static String generateRandomString(Random random, int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }
        return sb.toString();
    }
}
