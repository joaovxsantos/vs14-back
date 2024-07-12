CREATE TABLE JOGADORES (
    id_jogador NUMBER PRIMARY KEY,
    nome VARCHAR2(100) NOT NULL
);

BEGIN
  EXECUTE IMMEDIATE 'DROP SEQUENCE ' || 'jogador_seq';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -2289 THEN
      RAISE;
    END IF;
END;

CREATE SEQUENCE jogador_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

INSERT INTO JOGADORES (id_jogador, nome)
VALUES (jogador_seq.NEXTVAL, 'Mattheus Luiz');

INSERT INTO JOGADORES (id_jogador, nome)
VALUES (jogador_seq.NEXTVAL, 'Ludmila ');

INSERT INTO JOGADORES (id_jogador, nome)
VALUES (jogador_seq.NEXTVAL, 'Bruna Almeida');

INSERT INTO JOGADORES (id_jogador, nome)
VALUES (jogador_seq.NEXTVAL, 'João Vitor');



CREATE TABLE RANKING (
    id_ranking NUMBER PRIMARY KEY,
    id_jogador NUMBER NOT NULL,
    partidas_jogadas NUMBER DEFAULT 0,
    vitorias NUMBER DEFAULT 0,
    derrotas NUMBER DEFAULT 0,
    FOREIGN KEY (id_jogador) REFERENCES Jogadores(id_jogador) ON DELETE CASCADE
);


BEGIN
  EXECUTE IMMEDIATE 'DROP SEQUENCE ' || 'ranking_seq';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -2289 THEN
      RAISE;
    END IF;
END;

CREATE SEQUENCE ranking_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

INSERT INTO RANKING (id_ranking, id_jogador, partidas_jogadas, vitorias, derrotas)
VALUES (ranking_seq.NEXTVAL, 1, 10, 7, 3);

INSERT INTO RANKING (id_ranking, id_jogador, partidas_jogadas, vitorias, derrotas)
VALUES (ranking_seq.NEXTVAL, 2, 15, 10, 5);

INSERT INTO RANKING (id_ranking, id_jogador, partidas_jogadas, vitorias, derrotas)
VALUES (ranking_seq.NEXTVAL, 3, 8, 3, 5);

INSERT INTO RANKING (id_ranking, id_jogador, partidas_jogadas, vitorias, derrotas)
VALUES (ranking_seq.NEXTVAL, 4, 20, 14, 6);


CREATE TABLE palavras (
    id NUMBER,
    palavra VARCHAR2(100) NOT NULL,
    PRIMARY KEY (id)
);


BEGIN
  EXECUTE IMMEDIATE 'DROP SEQUENCE ' || 'seq_palavras_id';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -2289 THEN
      RAISE;
    END IF;
END;

CREATE SEQUENCE seq_palavras_id
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

INSERT INTO palavras (id, palavra) VALUES (seq_palavras_id.NEXTVAL, 'ABALO');
INSERT INTO palavras (id, palavra) VALUES (seq_palavras_id.NEXTVAL, 'ABANO');
INSERT INTO palavras (id, palavra) VALUES (seq_palavras_id.NEXTVAL, 'ABONO');
INSERT INTO palavras (id, palavra) VALUES (seq_palavras_id.NEXTVAL, 'GARRA');
INSERT INTO palavras (id, palavra) VALUES (seq_palavras_id.NEXTVAL, 'MENTE');

SELECT palavra
FROM (
    SELECT palavra
    FROM palavras
    ORDER BY DBMS_RANDOM.VALUE
)
WHERE ROWNUM = 1;