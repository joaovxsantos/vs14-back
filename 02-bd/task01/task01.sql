CREATE TABLE ESTUDANTE {
    id_estudante NUMBER PRIMARY KEY,
    nome VARCHAR2(200) NOT NULL,
    data_nascimento DATE NOT NULL,
    nr_matricula NUMBER(10) NOT NULL UNIQUE,
    ativo CHAR(1) CHECK (ativo IN ('S', 'N')) NOT NULL
}



CREATE SEQUENCE SEQ_ESTUDANTE
    START WITH 1
    INCREMENT BY 1
    NOCACHE NOCYCLE


INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.nextval, 'João', TO_DATE('27-01-2003', 'DD-MM-YYYY'), '1111111111', 'S')

INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.nextval, 'Pedro', TO_DATE('30-05-2001', 'DD-MM-YYYY'), '2222222222', 'S')

INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.nextval, 'Paula', TO_DATE('01-01-2005', 'DD-MM-YYYY'), '3333333333', 'N')

INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.nextval, 'Livia', TO_DATE('30-03-2002', 'DD-MM-YYYY'), '4444444444', 'N')

INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.nextval, 'Luis', TO_DATE('17-09-1995', 'DD-MM-YYYY'), '5555555555', 'N')

INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.nextval, 'André', TO_DATE('20-02-2006', 'DD-MM-YYYY'), '6666666666', 'S')

INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.nextval, 'Silvia', TO_DATE('09-11-1971', 'DD-MM-YYYY'), '7777777777', 'S')

INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.nextval, 'Marcia', TO_DATE('11-11-1999', 'DD-MM-YYYY'), '8888888888', 'S')

INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.nextval, 'Larissa', TO_DATE('23-05-1998', 'DD-MM-YYYY'), '9999999999', 'S')

INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.nextval, 'Michel', TO_DATE('02-08-2004', 'DD-MM-YYYY'), '1010101010', 'S')



SELECT * FROM ESTUDANTES