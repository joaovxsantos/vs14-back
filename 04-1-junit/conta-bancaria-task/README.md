## Cenario 01 : Deposito mal sucedido

* Dado: Um valor do tipo numerico negativo
* Quando: Eu deposito R$ -500 para uma conta corrente</p>
* Então: Ação não é completada e retorna um false</p>

## Cenario 02 : Transferir com erro de invalido por valor ser menor que 0

* Dado: Um valor do tipo numerico e um saldo inicial de 5000</p>
* Quando: Eu transfiro R$ -500 da conta de origem para a conta de destino</p>
* Então: Ação não é completada e retorna um false</p>


## Cenario 03 : Transferir com erro saldo insuficiente

* Dado: Uma conta com um saldo 0</p>
* Quando: Eu transfiro R$ 500 para outra conta </p>
* Então: Ação não é completada e retorna um false</p>

## Cenario 04 : Sacar de conta com valor 0

* Dado: Uma conta com saldo 5000 e um valor de saque R$ 0</p>
* Quando: Eu tento relaizar o saque na conta</p>
* Então: Ação não é completada e retorna um false</p>
