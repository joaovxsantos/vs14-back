# Sistema de um Mercado

## Descrição
Projeto que simula um sistema de um mercado, desenvolvido em Java. É possível gerenciar clientes, gerenciar produtos, adicionar produtos ao carrinho e finalizar a compra.  

## Estrutura do Projeto
- `CarrinhoDeCompra`: Classe que cria o carrinho de compras.
- `Cliente`: Classe que cria o cliente.
- `Produto`: Classe que cria o produto.
- `ItemCarrinho`: Classe que cria o produto no carrinho de compras.
- `CarrinhoDeCompraServico`: Classe que gerencia o carrinho de compras.
- `ClienteServico`: Classe que gerencia o cliente.
- `ProdutoServico`: Classe que gerencia o produto.
- `Main`: Classe principal para testes e demonstração.

## Compilação e Execução

1. Compile todas as classes Java:
    ```sh
    javac -d bin src/mercado/*.java
    ```

2. Execute a classe `Main`:
    ```sh
    java -cp bin mercado.Main
    ```