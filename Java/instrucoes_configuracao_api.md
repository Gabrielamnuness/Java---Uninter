## Instruções para Configuração do Ambiente e Execução da API de Tarefas

Este documento detalha os passos necessários para configurar o ambiente de desenvolvimento, incluindo o banco de dados MySQL, e para executar a aplicação Spring Boot da API de Tarefas.

### 1. Configuração do Banco de Dados MySQL

A API de Tarefas utiliza um banco de dados MySQL para persistir os dados. Siga os passos abaixo para configurar o banco de dados:

1.  **Instalar MySQL Server:** Se você ainda não possui o MySQL Server instalado, faça o download e a instalação a partir do site oficial do MySQL (https://dev.mysql.com/downloads/mysql/). Siga as instruções de instalação para o seu sistema operacional.

2.  **Iniciar o MySQL Server:** Certifique-se de que o serviço do MySQL Server esteja em execução.

3.  **Acessar o MySQL:** Abra um terminal ou prompt de comando e acesse o cliente MySQL. Geralmente, você pode fazer isso com o comando:
    ```bash
    mysql -u root -p
    ```
    Será solicitada a senha do usuário `root` do MySQL (a senha que você definiu durante a instalação).

4.  **Criar o Banco de Dados:** Dentro do cliente MySQL, execute o seguinte comando para criar o banco de dados `tarefasdb`:
    ```sql
    CREATE DATABASE tarefasdb;
    ```
    **Nota:** O nome do banco de dados `tarefasdb` está configurado no arquivo `application.properties` do projeto. Se desejar usar outro nome, você precisará alterá-lo nesse arquivo.

5.  **Criar Usuário e Conceder Permissões (Opcional, mas recomendado):** Para maior segurança, é recomendável criar um usuário específico para a aplicação e conceder a ele apenas as permissões necessárias no banco de dados `tarefasdb`. Substitua `seu_usuario` e `sua_senha` pelos valores desejados:
    ```sql
    CREATE USER 'seu_usuario'@'localhost' IDENTIFIED BY 'sua_senha';
    GRANT ALL PRIVILEGES ON tarefasdb.* TO 'seu_usuario'@'localhost';
    FLUSH PRIVILEGES;
    ```
    Se você optar por criar um novo usuário, lembre-se de atualizar as credenciais (`spring.datasource.username` e `spring.datasource.password`) no arquivo `application.properties` do projeto.

6.  **Sair do Cliente MySQL:**
    ```sql
    EXIT;
    ```

### 2. Configuração e Execução da API Spring Boot

Após configurar o banco de dados, siga os passos para configurar e executar a API:

1.  **Pré-requisitos:**
    *   **Java Development Kit (JDK) 11:** Certifique-se de ter o JDK 11 instalado e configurado corretamente em seu sistema. Você pode verificar a versão do Java com `java -version` e `javac -version`.
    *   **Apache Maven:** Certifique-se de ter o Maven instalado. Você pode verificar a versão com `mvn -version`.

2.  **Navegar até o Diretório do Projeto:** Abra um terminal ou prompt de comando e navegue até o diretório raiz do projeto `tarefas-api` (onde o arquivo `pom.xml` está localizado).

3.  **Verificar Dependências (Opcional):** Para garantir que todas as dependências do Maven estejam corretas, você pode executar:
    ```bash
    mvn clean install
    ```
    Isso irá baixar as dependências e compilar o projeto.

4.  **Executar a Aplicação:** Para iniciar a API, execute o seguinte comando no diretório raiz do projeto:
    ```bash
    mvn spring-boot:run
    ```
    A aplicação será iniciada e estará acessível em `http://localhost:8080` (a porta padrão do Spring Boot). Você verá logs no console indicando que a aplicação foi iniciada com sucesso.

### 3. Acessando a API

Com a API em execução e o banco de dados configurado, você pode usar ferramentas como o Postman, Insomnia ou `curl` para interagir com os endpoints:

*   **Base URL:** `http://localhost:8080/tarefas`

Os endpoints disponíveis são:

*   `POST /tarefas`: Criar uma nova tarefa.
*   `GET /tarefas`: Listar todas as tarefas.
*   `GET /tarefas/{id}`: Obter uma tarefa por ID.
*   `PUT /tarefas/{id}`: Atualizar uma tarefa existente.
*   `DELETE /tarefas/{id}`: Remover uma tarefa.

Com essas instruções, você poderá configurar e executar a API de Tarefas em seu ambiente local.
