package com.cnleng.utils;

import java.util.UUID;

public class UuidGenerator {
    public static String generateCorrelationID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
