package lib.biblioteca.jwt;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JwtUtils {
    public static final String JWT_BEARER = "Bearer ";
    public static final String JWT_AUTHORIZATION = "Authorization";
    public static final String SECRET_KEY = "0123456789-0123456789-0123456789";
    public static final long EXPIRE_DAYS = 0;
    public static final long EXPIRE_HOURS = 0;
    public static final long EXPIRE_MINUTES = 2;

    public JwtUtils(){

    }

    private static Key generatedKeys() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }
    private static Date toExpireData(Date start) {
        // Converte o Date inicial para LocalDateTime para facilitar a manipulação
        LocalDateTime dateTime = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        // Adiciona dias, horas e minutos para definir a data de expiração
        LocalDateTime end = dateTime.plusDays(EXPIRE_DAYS)
                .plusHours(EXPIRE_HOURS)
                .plusMinutes(EXPIRE_MINUTES);

        // Converte a LocalDateTime final de volta para um objeto Date
        // para manter a compatibilidade com sistemas mais antigos que usam Date
        return Date.from(end.atZone(ZoneId.systemDefault()).toInstant());
    }

    @Deprecated
    public static JwtToken createToken (String username, String role) {
        Date issueAt = new Date();
        Date limit  = toExpireData(issueAt);

        String token = Jwts.builder().setHeaderParam("typ", "JWT")
                .setSubject(username).
                setIssuedAt(issueAt).
                setExpiration(limit).
                signWith(generatedKeys(), SignatureAlgorithm.ES256)
                .claim("role", role).compact();
           return new JwtToken(token);
    }

}
