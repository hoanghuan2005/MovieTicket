package utils;

import dao.UserDAO;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import model.UserDTO;

/**
 *
 * @author SUPPER LOQ
 */
public class PassUtils {
     public static String encryptSHA256(String password) {
        if (password == null || password.isEmpty()) {
            return null;
        }
        try {
            // Tạo MessageDigest instance cho SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Chuyển đổi password thành byte array và hash
            byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

            // Chuyển đổi byte array thành hex string
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA-256 algorithm not available: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Error during SHA-256 encryption: " + e.getMessage());
            return null;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(encryptSHA256("123"));
        // Cat nhat lai mat khau
        UserDAO userDAO = new UserDAO();
        List<UserDTO> list = userDAO.getAllUser();
        for (UserDTO user : list) {
            userDAO.updatePassword(user.getName(), encryptSHA256(user.getPassword()));
        }
    }
}
