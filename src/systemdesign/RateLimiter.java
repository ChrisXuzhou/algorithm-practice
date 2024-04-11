package systemdesign;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {

    private final Map<String, Long> requestCountMap;
    private final long windowSizeInMillis;
    private final int maxRequests;

    public RateLimiter(long windowSizeInMillis, int maxRequests) {
        this.requestCountMap = new HashMap<>();
        this.windowSizeInMillis = windowSizeInMillis;
        this.maxRequests = maxRequests;
    }

    public synchronized boolean isAllow(String clientId) {

        long currentTimestamp = System.currentTimeMillis();
        long startTimestamp = System.currentTimeMillis();

        // remove outdated records
        requestCountMap.entrySet().removeIf(entry -> entry.getValue() < startTimestamp);

        long count = requestCountMap.getOrDefault(clientId, 0L);
        if (count < maxRequests) {
            requestCountMap.put(clientId, count + 1);
            return true;
        } else {
            return false;
        }
    }

}
