package task05.src.Service;

import task05.src.exceptions.BancoDeDadosException;
import task05.src.repository.RankingRepository;

public class RankingService {

  private RankingRepository rankingRepository;

  public RankingService() {
    this.rankingRepository =  new RankingRepository();
  }

  public void insertOrUpdateRanking(Progresso progresso) {

    try {
      if(rankingRepository.listarById(progresso.getIdJogador())){
        rankingRepository.updateRanking(progresso);
      } else {
        rankingRepository.adicionar(progresso);
      }
    } catch (BancoDeDadosException e) {
      throw new RuntimeException(e);
    }
  }
}
