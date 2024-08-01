package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.CargoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private String login;
}
