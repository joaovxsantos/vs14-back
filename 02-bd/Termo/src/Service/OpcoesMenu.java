package task05.src.Service;

public enum OpcoesMenu {

  CADASTRAR_JOGADOR(1, "Cadastrar Jogador"),
  EDITAR_JOGADOR(2, "Editar Jogador"),
  INSTRUCOES_JOGO(3, "Instruções do Jogo"),
  INICIAR_PARTIDA(4, "Iniciar Partida"),
  RANKING(5, "Ranking"),
  SAIR(6, "Sair");

  private final int valor;
  private final String descricao;

  OpcoesMenu(int valorOpcao, String descricaoOpcao) {
    valor = valorOpcao;
    descricao = descricaoOpcao;
  }

  public int getValor() {
    return valor;
  }

  public String getDescricao() {
    return descricao;
  }

  public static OpcoesMenu valueOf(int valor) {
    for (OpcoesMenu opcao : values()) {
      if (opcao.getValor() == valor) {
        return opcao;
      }
    }
    return null;
  }
}
