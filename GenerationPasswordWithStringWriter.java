package StringWriter;

/*
Генератор паролей
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class StringWriter {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword(8);
        System.out.println(password);
    }
    public static ByteArrayOutputStream getPassword(int length) throws IOException {
        ByteArrayOutputStream is = new ByteArrayOutputStream();
        String password = "";

        for (int i = 0; i < length - 2; i++) {
            password = password + randomCharacter("AaBbCcDdEeFfGgHhIiKkLlMmNnOoPpQqRrSsTtVvWwXxYyZz");

        }
        String randomDigit = randomCharacter("0123456789");
        password = insertAtRandom(password, randomDigit);
        String randomCharacter = randomCharacter("!@#$%&*()-+");
        password = insertAtRandom(password, randomCharacter);
        byte[] bytes = password.getBytes();

        is.write(bytes);
        is.close();

        return is;
    }

    public static String randomCharacter(String str) {
        int n = str.length();
        int r = (int) (n * Math.random());
        return str.substring(r, r + 1);

    }

    public static String insertAtRandom(String str, String toInsert) {
        int n = str.length();
        int r = (int) (n * Math.random());
        return str.substring(0, r) + toInsert + str.substring(r);

    }
}
