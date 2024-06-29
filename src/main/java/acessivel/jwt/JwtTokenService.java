package acessivel.jwt;

import acessivel.entity.Usuario;
import acessivel.security.QueixanteDetailsImpl;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class JwtTokenService {

    private static final String CHAVE_SECRETA = "ClaudioChristianzinhoNatalinha123456!!";
    private static final String ISSUER = "acessivel-api";

    public String gerarToken(QueixanteDetailsImpl queixante) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(CHAVE_SECRETA);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withIssuedAt(dataCriacao())
                    .withExpiresAt(dataExpiracao())
                    .withSubject(queixante.getUsername())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new JWTCreationException("Erro ao gerar token.", exception);
        }
    }

    public String pegarSujeitoPeloToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(CHAVE_SECRETA);
            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException("Token inválido ou expirado.");
        }
    }

    private Instant dataCriacao() {
        return ZonedDateTime.now(ZoneId.of("America/Sao Paulo")).toInstant();
    }

    private Instant dataExpiracao(){
        return ZonedDateTime.now(ZoneId.of("America/Sao Paulo")).plusDays(7).toInstant();
    }
}
