package ru.tiger.bookprototype.security;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author tiger
 */
public class BearerTokenGenerator {
    public String createToken() {
        Random random = new SecureRandom();
        String token = new BigInteger(130, random).toString(32);
        return token;
    }
}
