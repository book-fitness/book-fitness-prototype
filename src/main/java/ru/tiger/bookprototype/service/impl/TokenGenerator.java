package ru.tiger.bookprototype.service.impl;

import java.util.Random;
import org.springframework.stereotype.Service;

/**
 *
 * @author Igor
 */
@Service
public class TokenGenerator {
    private static final String source = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public TokenGenerator() {
    }

    private String generateToken(int amount) {
        char[] token = new char[amount];
        Random r = new Random(System.currentTimeMillis());

        for (int i = 0; i < amount; i++) {
            int random = r.nextInt(source.length());
            token[i] = source.charAt(random);
        }
        return String.valueOf(token);
    }
    
    public String generateToken40() {
        return generateToken(40);
    } 
}
