package service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ApiAuthenticationService {

    // =====================================================
    // TOKEN STORE
    // =====================================================

    private Map<String, String> tokenStore =
            new HashMap<>();

    // =====================================================
    // AUTHENTICATE USER
    // =====================================================

    public boolean authenticate(
            String username,
            String password) {

        if (username == null ||
                password == null) {

            return false;

        }

        if (username.equals("admin") &&
                password.equals("admin123")) {

            System.out.println(
                    "Authentication Successful.");

            return true;

        }

        System.out.println(
                "Authentication Failed.");

        return false;

    }

    // =====================================================
    // GENERATE TOKEN
    // =====================================================

    public String generateToken(
            String username) {

        String token =
                UUID.randomUUID()
                        .toString()
                        .replace("-", "");

        tokenStore.put(
                token,
                username);

        System.out.println(
                "\nAPI Token Generated.");

        System.out.println(
                "User : " + username);

        System.out.println(
                "Generated : " +
                        LocalDateTime.now());

        System.out.println(
                "Token : " + token);

        return token;

    }

    // =====================================================
    // VALIDATE TOKEN
    // =====================================================

    public boolean validateToken(
            String token) {

        boolean valid =
                tokenStore.containsKey(token);

        System.out.println(
                "\nToken Validation : "
                        + (valid ? "VALID" : "INVALID"));

        return valid;

    }

    // =====================================================
    // REMOVE TOKEN
    // =====================================================

    public void logout(
            String token) {

        tokenStore.remove(token);

        System.out.println(
                "User Logged Out.");

    }

    // =====================================================
    // DISPLAY ACTIVE TOKENS
    // =====================================================

    public void displayActiveTokens() {

        System.out.println(
                "\n========== ACTIVE TOKENS ==========");

        if (tokenStore.isEmpty()) {

            System.out.println(
                    "No Active Tokens.");

            return;

        }

        for (Map.Entry<String, String> entry
                : tokenStore.entrySet()) {

            System.out.println(
                    "User : "
                            + entry.getValue());

            System.out.println(
                    "Token : "
                            + entry.getKey());

            System.out.println();

        }

    }

}