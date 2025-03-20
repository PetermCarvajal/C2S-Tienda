package org.peters3.tiendas.Jwt;

import io.jsonwebtoken.security.Keys;
import java.util.Base64;
import javax.crypto.SecretKey;

public class JwtKeyGenerator {
    public static void main(String[] args) {
        SecretKey key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);

        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());

        System.out.println("Clave JWT segura: " + encodedKey);
    }
}

