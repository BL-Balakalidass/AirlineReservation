package service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RateLimiterService {

    // =====================================================
    // MAX REQUESTS
    // =====================================================

    private static final int MAX_REQUESTS = 10;

    // =====================================================
    // REQUEST STORE
    // =====================================================

    private Map<String, Integer> requestCounter =
            new HashMap<>();

    // =====================================================
    // ALLOW REQUEST
    // =====================================================

    public boolean allowRequest(
            String clientId) {

        int count =
                requestCounter.getOrDefault(
                        clientId,
                        0);

        if (count >= MAX_REQUESTS) {

            System.out.println(
                    "Rate Limit Exceeded for "
                            + clientId);

            return false;

        }

        requestCounter.put(
                clientId,
                count + 1);

        System.out.println(
                "Request Accepted : "
                        + clientId);

        System.out.println(
                "Usage : "
                        + (count + 1)
                        + "/"
                        + MAX_REQUESTS);

        return true;

    }

    // =====================================================
    // RESET CLIENT COUNTER
    // =====================================================

    public void resetCounter(
            String clientId) {

        requestCounter.remove(clientId);

        System.out.println(
                "Rate Limit Reset : "
                        + clientId);

    }

    // =====================================================
    // RESET ALL
    // =====================================================

    public void resetAll() {

        requestCounter.clear();

        System.out.println(
                "All Counters Reset.");

    }

    // =====================================================
    // GET REQUEST COUNT
    // =====================================================

    public int getRequestCount(
            String clientId) {

        return requestCounter.getOrDefault(
                clientId,
                0);

    }

    // =====================================================
    // DISPLAY USAGE
    // =====================================================

    public void displayUsage() {

        System.out.println(
                "\n========== API USAGE ==========");

        if (requestCounter.isEmpty()) {

            System.out.println(
                    "No Requests Recorded.");

            return;

        }

        for (Map.Entry<String, Integer> entry
                : requestCounter.entrySet()) {

            System.out.println(
                    "Client : "
                            + entry.getKey());

            System.out.println(
                    "Requests : "
                            + entry.getValue());

            System.out.println(
                    "Remaining : "
                            + (MAX_REQUESTS
                            - entry.getValue()));

            System.out.println();

        }

    }

    // =====================================================
    // DISPLAY STATUS
    // =====================================================

    public void displayStatus() {

        System.out.println(
                "\nRate Limiter Status");

        System.out.println(
                "Maximum Requests : "
                        + MAX_REQUESTS);

        System.out.println(
                "Generated : "
                        + LocalDateTime.now());

    }

}