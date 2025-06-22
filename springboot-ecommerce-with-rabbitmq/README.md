# Plataforma Minimalista de E-commerce em Microsserviços

Este projeto visa construir uma plataforma de e-commerce simplificada utilizando uma arquitetura de microsserviços. A comunicação entre alguns microsserviços será síncrona (via REST APIs), enquanto outras interações, como o processamento de pedidos, serão tratadas de forma assíncrona utilizando uma fila de mensagens (RabbitMQ). A abordagem de microsserviços permite que diferentes funcionalidades da plataforma (como catálogo de produtos, carrinho de compras e gestão de pedidos) sejam desenvolvidas, implantadas e escaladas independentemente. O objetivo é demonstrar a aplicação de princípios de arquitetura moderna, incluindo a arquitetura hexagonal para separação de responsabilidades, testes automatizados e um pipeline de CI/CD para entrega contínua. A utilização do RabbitMQ ilustrará como lidar com comunicação assíncrona e aumentar a resiliência do sistema.

## Requisitos Funcionais

Estes são os recursos que o sistema deve oferecer ao usuário.

1. Gerenciamento de Produtos:
   - Cadastrar novos produtos (nome, descrição, preço, estoque).
   - Listar produtos disponíveis.
   - Visualizar detalhes de um produto específico.
2. Carrinho de Compras:
   - Adicionar produtos ao carrinho.
   - Visualizar os itens no carrinho.
   - Remover itens do carrinho.
   - Atualizar a quantidade de itens no carrinho.
3. Processamento de Pedidos (Assíncrono):
   - Quando um pedido é finalizado, uma mensagem deve ser enviada para uma fila do RabbitMQ para processamento posterior (ex: faturamento, envio).

## Requisitos Não Funcionais

**Escalabilidade**: A arquitetura de microsserviços deve permitir escalar componentes individualmente conforme a demanda. \
**Disponibilidade**: O sistema deve ser resiliente e estar disponível para os usuários. \
**Manutenibilidade**: A arquitetura hexagonal deve facilitar a manutenção e a evolução do código. \
**Testabilidade**: O código deve ser facilmente testável em diferentes níveis (unitário, integração). \
**Entrega Contínua**: As alterações no código devem poder ser integradas, testadas e (potencialmente) implantadas de forma automatizada. \

## Tecnologias Inicialmente Utilizadas

**Linguagem de Programação**: Java \
**Framework Principal**: Spring Boot \
**Construção**: Maven \
**Containerização**: Docker \
**Mensageria**: RabbitMQ \
**Testes Unitários**: JUnit, Mockito \
**Testes de Integração**: Spring Test, Testcontainers (para RabbitMQ) \
**CI/CD**: GitHub Actions

## Lista de Tarefas

1. Configuração Inicial do Projeto (Produto e Pedido Services)
   - [ ] Criar a estrutura básica de projetos Spring Boot para os microsserviços de produto e pedido.
   - [ ] Definir as dependências iniciais (Spring Web, JPA, Spring AMQP, etc.).
2. Implementação do Domínio de Produtos (Produto Service):
   - [ ] Definir a entidade Produto.
   - [ ] Definir as portas de entrada (CriarProdutoPort, BuscarProdutoPort, etc.).
   - [ ] Definir as portas de saída (ProdutoRepositoryPort).
   - [ ] Implementar a lógica de negócios no ProdutoService.
3. Implementação dos Adaptadores (Produto Service):
   - [ ] Criar um RestController para expor as funcionalidades via API REST (ProdutoController).
   - [ ] Criar um adaptador de persistência usando JPA (ProdutoRepositoryAdapter, ProdutoJpaRepository, ProdutoJpaEntity).
4. Implementação do Domínio de Pedidos (Pedido Service):
   - [ ] Definir a entidade Pedido.
   - [ ] Definir as portas de entrada (ex: CriarPedidoPort).
   - [ ] Definir as portas de saída (ex: PedidoRepositoryPort, PedidoQueuePort para enviar mensagens ao RabbitMQ).
   - [ ] Implementar a lógica de negócios no PedidoService.
5. Implementação dos Adaptadores (Pedido Service):
   - [ ] Criar um RestController para receber pedidos (PedidoController).
   - [ ] Criar um adaptador de persistência para pedidos (PedidoRepositoryAdapter).
   - [ ] Criar um adaptador para enviar mensagens ao RabbitMQ (RabbitMQPedidoAdapter).
   - [ ] Criar um listener para consumir mensagens de processamento de pedidos (se necessário, em outro microsserviço ou no mesmo para simulação).
6. Implementação de Testes (Produto e Pedido Services):
   - [ ] Escrever testes unitários para a camada de domínio (ProdutoServiceTest).
   - [ ] Configurar e escrever testes de integração para os adaptadores, incluindo testes da interação com o RabbitMQ (usando Testcontainers).
7. Dockerização (Produto Service):
   - [ ] Criar um Dockerfile para o microsserviço de produtos.
   - [ ] Configuração do CI/CD:
   - [ ] Criar um workflow do GitHub Actions para build, teste e construção da imagem Docker.

## Como Executar o Projeto

Existem algumas maneiras de executar os microsserviços desta plataforma:

### 1. Execução Direta via JAR

Para executar um microsserviço diretamente a partir do JAR (após a compilação com Maven ou Gradle):

1. Navegue até o diretório do microsserviço desejado (ex: `produto-service`).
2. Execute o seguinte comando no terminal:

```bash
java -jar target/*.jar
```

Certifique-se de que você tenha o Java instalado em seu sistema.

### 2. Execução com GraalVM (Opcional - Requer compilação prévia)

Se você compilou o microsserviço utilizando o GraalVM para gerar um executável nativo, pode executá-lo diretamente:

1. Navegue até o diretório do microsserviço desejado.
2. Execute o executável nativo (o nome pode variar, ex: `produto-service-native`):

```bash
./produto-service-native
```

A execução nativa com GraalVM tende a ter um tempo de inicialização e consumo de recursos menores.

### 3. Execução via Docker

Para executar os microsserviços utilizando Docker (requer Docker instalado):

1. Certifique-se de ter construído as imagens Docker para os microsserviços (geralmente feito através do workflow de CI/CD ou manualmente com `docker build`).
2. Você pode usar o `docker run` para cada microsserviço individualmente. Por exemplo, para o serviço de produtos:

   ```bash
   docker run -p <porta_da_aplicacao>:<porta_da_aplicacao> <nome_da_imagem>
   ```

   Substitua `<porta_da_aplicacao>` pela porta que o serviço expõe (ex: 8080) e `<nome_da_imagem>` pelo nome da imagem Docker do serviço.

3. **Usando Docker Compose (Recomendado para desenvolvimento local):**

    Se você tiver um arquivo `docker-compose.yml` configurado (será um passo futuro), poderá executar todos os serviços (incluindo o RabbitMQ) com um único comando:

    ```bash
    docker-compose up -d
    ```

    Para parar os serviços:

    ```bash
    docker-compose down
    ```

4. Execução via Kubernetes (Opcional - Mais avançado)

Para executar em um cluster Kubernetes (requer um cluster Kubernetes configurado e `kubectl` instalado):

1. Você precisará de arquivos de definição do Kubernetes (ex: Deployments, Services) para cada microsserviço.
2. Aplique as definições ao seu cluster usando `kubectl apply`:

    ```bash
    kubectl apply -f <caminho_para_definicao>.yaml
    ```

    Por exemplo:

    ```bash
    kubectl apply -f k8s/produto-service-deployment.yaml
    kubectl apply -f k8s/produto-service-service.yaml
    ```

    Você precisará configurar adequadamente os serviços para expor as aplicações e os deployments para gerenciar os pods.
