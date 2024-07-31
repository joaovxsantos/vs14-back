package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {
    static final String HEADER_STRING = "Authorization";

    private static final String TOKEN_PREFIX = "Bearer";

    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;

//    public String getToken(UsuarioEntity usuarioEntity) {
//        String tokenTexto = usuarioEntity.getLogin() + ";" + usuarioEntity.getSenha(); // thiago.gomes;1234 > 923y978126391
//        String token = Base64.getEncoder().encodeToString(tokenTexto.getBytes());
//        return token;
//    }

    public String gerarTokenJwt(UsuarioEntity usuarioEntity) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + Long.parseLong(expiration));

        return TOKEN_PREFIX + " " +
                Jwts.builder()
                        .setIssuer("vemser-api")
                        .claim(Claims.ID, usuarioEntity.getIdUsuario().toString())
                        .setIssuedAt(now)
                        .setExpiration(exp)
                        .signWith(SignatureAlgorithm.HS256, secret)
                        .compact();
    }

//    public Optional<UsuarioEntity> isValid(String token) {
//        if(token == null){
//            return Optional.empty();
//        }
//        byte[] decodedBytes = Base64.getUrlDecoder().decode(token);
//        String decoded = new String(decodedBytes);
//        String[] split = decoded.split(";");
//        return usuarioService.findByLoginAndSenha(split[0], split[1]);
//    }

    public UsernamePasswordAuthenticationToken isValid(String token) {
        if (token != null) {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            String user = body.get(Claims.ID, String.class);
            if (user != null) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
                return usernamePasswordAuthenticationToken;
            }
        }
        return null;
    }
}
