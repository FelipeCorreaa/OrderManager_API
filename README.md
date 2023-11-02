# Projeto de Gerenciamento de Pedidos

Este projeto é uma aplicação que realiza operações de CRUD (Create, Read, Update, Delete) em um banco de dados PostgreSQL. Ele permite a adição e remoção de produtos, assim como a realização de pedidos.

## Funcionalidades Principais

- **Produtos:** A aplicação gerencia produtos com base em categorias. Possui uma classe que herda informações de outra classe.

- **Pedidos:** A aplicação permite a criação de pedidos, representados pela classe, que contêm itens específicos referenciados por outra classe.

- **Usuários:** Os usuários são representados por uma classe.

- **Status do Pedido:** Os pedidos têm estados definidos por uma enumeração.

## Estrutura do Projeto

O projeto está organizado nas seguintes classes principais:

- `Classe 1`: Gerencia informações sobre os itens.

- `Classe 2`: Representa os itens incluídos em um pedido.

- `Classe 3`: Responsável pelo gerenciamento de pedidos e seus estados.

- `Classe 4`: Lida com informações de pagamento associadas a um pedido.

- `Classe 5`: Mantém dados sobre os usuários da aplicação.

## Executando o Projeto

Para executar o projeto localmente, siga os passos abaixo:

1. Clone este repositório para o seu ambiente local.

2. Certifique-se de ter o PostgreSQL instalado e configurado.

3. Configure as credenciais do banco de dados no arquivo de configuração.

4. Execute a aplicação.

```bash
$ mvn spring-boot:run
