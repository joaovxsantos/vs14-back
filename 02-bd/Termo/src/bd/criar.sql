-- Criar seguencia SEQ_JOGADOR
CREATE SEQUENCE seq_jogador
START WITH 1
INCREMENT BY 1;

-- Criar tabela de JOGADORES
CREATE TABLE jogadores (
    id NUMBER PRIMARY KEY,
    nome VARCHAR2(100) NOT NULL,
    partidas_jogadas NUMBER NOT NULL,
    vitorias NUMBER NOT NULL,
    derrotas NUMBER NOT NULL
);