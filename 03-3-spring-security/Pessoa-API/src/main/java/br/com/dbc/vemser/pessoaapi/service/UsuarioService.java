package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.UserCreateDto;
import br.com.dbc.vemser.pessoaapi.dto.UserDto;
import br.com.dbc.vemser.pessoaapi.entity.CargoEntity;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.excepction.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.CargoRepository;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final CargoRepository cargoRepository;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public UsuarioEntity save(UsuarioEntity usuarioEntity) {
        return usuarioRepository.save(usuarioEntity);
    }

    public Optional<UsuarioEntity> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Integer getIdLoggedUser() {
        Integer findUserId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return findUserId;
    }

    public Optional<UsuarioEntity> getLoggedUser() throws RegraDeNegocioException {
        return findById(getIdLoggedUser());
    }

    public UserDto create(UserCreateDto userCreateDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UsuarioEntity usuarioEntity = objectMapper.convertValue(userCreateDto, UsuarioEntity.class);

        usuarioEntity.setSenha(encoder.encode(usuarioEntity.getSenha()));

        usuarioEntity.setCargos(userCreateDto.getCargos().stream().map(cargos ->
             cargoRepository.findByNome(cargos)
        ).collect(Collectors.toSet()));

        usuarioRepository.save(usuarioEntity);

        return objectMapper.convertValue(usuarioEntity, UserDto.class);
    }

}
