import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionUtil {

    // 16 character key (AES requirement)
    // private static final String SECRET_KEY = "MySuperSecret12";
private static final String SECRET_KEY = "MySuperSecret123";
    // 🔐 ENCRYPT
    public static String encrypt(String password) {

        try {

            if (password == null || password.isEmpty()) {
                System.out.println("Encrypt ERROR: empty password");
                return null;
            }

            SecretKeySpec key =
                    new SecretKeySpec(SECRET_KEY.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] encryptedBytes =
                    cipher.doFinal(password.getBytes());

            String result = Base64.getEncoder()
                    .encodeToString(encryptedBytes);

            // 🔥 DEBUG
            System.out.println("Encrypt SUCCESS: " + result);

            return result;

        } catch (Exception e) {

            // 🔥 REAL ERROR PRINT (VERY IMPORTANT)
            System.out.println("Encrypt FAILED:");
            e.printStackTrace();

            return null;
        }
    }

    // 🔓 DECRYPT
    public static String decrypt(String encryptedPassword) {

        try {

            if (encryptedPassword == null || encryptedPassword.isEmpty()) {
                System.out.println("Decrypt ERROR: empty input");
                return null;
            }

            SecretKeySpec key =
                    new SecretKeySpec(SECRET_KEY.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] decodedBytes =
                    Base64.getDecoder().decode(encryptedPassword);

            byte[] decryptedBytes =
                    cipher.doFinal(decodedBytes);

            String result = new String(decryptedBytes);

            // 🔥 DEBUG
            System.out.println("Decrypt SUCCESS: " + result);

            return result;

        } catch (Exception e) {

            // 🔥 REAL ERROR PRINT (THIS WAS HIDDEN BEFORE)
            System.out.println("Decrypt FAILED:");
            e.printStackTrace();

            return null;
        }
    }
}