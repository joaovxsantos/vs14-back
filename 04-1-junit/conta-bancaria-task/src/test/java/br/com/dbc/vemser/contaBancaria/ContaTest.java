package br.com.dbc.vemser.contaBancaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {


        private ContaCorrente contaCorrente;
        private ContaPoupanca contaPoupanca;
        private ContaPagamento contaPagamento;


        @BeforeEach
        public void setUp() {
            contaCorrente = new ContaCorrente();
            contaPoupanca = new ContaPoupanca();
            contaPagamento = new ContaPagamento();
        }


        @Test
        void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() {
            contaCorrente.setSaldo(50);
            contaCorrente.sacar(20);

            int resultEsperado = 50 - 20;

            assertEquals(resultEsperado, contaCorrente.getSaldo());
        }



        @Test
        void deveTestarSaqueContaCorrenteSemSaldo() {

            Boolean consegueSacar = contaCorrente.sacar(100);

            assertFalse(consegueSacar, "Não é possível realizar saque de zero reais.");
            assertFalse(consegueSacar, "Saldo e cheque especial insuficientes para realizar o saque.");
        }


        @Test
        void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() {
            contaPoupanca.setSaldo(50);
            contaPoupanca.sacar(20);

            int resultEsperado = 50 - 20;

            assertEquals(resultEsperado, contaPoupanca.getSaldo());
        }


        @Test
        void deveTestarSaqueContaPoupancaSemSaldo() {
            Boolean consegueSacar = contaPoupanca.sacar(100);

            assertFalse(consegueSacar, "Não é possível realizar saque de zero reais.");
            assertFalse(consegueSacar, "Saldo insuficiente para realizar o saque.");
        }

        @Test
        void deveTestarSaqueContaPagamentoComSucesso() {

            double TAXA_SAQUE = 4.25;

            contaPagamento.setSaldo(50 + TAXA_SAQUE);
            contaPagamento.sacar(20);

            int resultEsperado = 50 - 20;
            assertEquals(resultEsperado, contaPagamento.getSaldo());
        }


        @Test
        void deveTestarTransferenciaEVerificarSaldoComSucesso() {
            int valorTransferencia = 50;

            contaCorrente.setSaldo(valorTransferencia);
            contaCorrente.transferir(contaPoupanca, valorTransferencia);

            assertEquals(valorTransferencia, contaPoupanca.getSaldo());
        }


        @Test
        void deveTestarTransferenciaSemSaldo() {
            int valorTransferencia = 100;
            contaPoupanca.transferir(contaCorrente, valorTransferencia);
            assertFalse(contaCorrente.getSaldo() >= valorTransferencia, "Saldo insuficiente.");
        }


        @Test
        void deveTestarSaqueContaCorrenteComValorZero() {
           int valorSaque = 0;
           int valorSaldo = 200;

           contaCorrente.setSaldo(valorSaldo);
           Boolean saqueErro = contaCorrente.sacar(valorSaque);

           assertFalse(saqueErro);
        }


        @Test
        void deveTestarSaqueContaCorrenteComValorNegativo() {
               int valorSaque = -100;
               int valorSaldo = 200;

               contaCorrente.setSaldo(valorSaldo);
               boolean saqueFeito = contaCorrente.sacar(valorSaque);
               assertFalse(saqueFeito);
        }


    @Test
    void deveTestarSaqueContaPagamentoSemSaldoSuficiente() {

        contaPagamento.setSaldo(20);

        Boolean saqueFeito = contaPagamento.sacar(50);

        assertEquals(false, saqueFeito);
    }

}