## Simulação de Testes da API de Tarefas

Este documento apresenta a simulação dos testes da API de Tarefas, demonstrando as requisições e respostas esperadas para cada endpoint, conforme os requisitos da atividade. As evidências são apresentadas em formato de texto, simulando a saída de ferramentas como o Postman.

**Base URL da API:** `http://localhost:8080/tarefas`

--- 

### Teste 1 - Inserir novas tarefas e verificar se aparecem na lista.

**Requisito:** Inserir 3 tarefas, sendo que uma delas deverá obedecer o critério: "Inserir como tarefa Desenvolvimento da API, como responsável coloque seu primeiro nome seguido do RU, para data de entrega coloque 12/12/2025."

#### Requisição 1: Criar Tarefa (Desenvolvimento da API - Nome do Aluno e RU)

*   **Endpoint:** `POST /tarefas`
*   **Headers:** `Content-Type: application/json`
*   **Body:**
    ```json
    {
        "nome": "Desenvolvimento da API",
        "dataEntrega": "2025-12-12",
        "responsavel": "SeuNome 1234567"
    }
    ```
*   **Resposta Esperada (Status 200 OK):**
    ```json
    {
        "id": 1,
        "nome": "Desenvolvimento da API",
        "dataEntrega": "2025-12-12",
        "responsavel": "SeuNome 1234567"
    }
    ```

#### Requisição 2: Criar Tarefa (Estudar Spring Boot)

*   **Endpoint:** `POST /tarefas`
*   **Headers:** `Content-Type: application/json`
*   **Body:**
    ```json
    {
        "nome": "Estudar Spring Boot",
        "dataEntrega": "2025-10-20",
        "responsavel": "Aluno"
    }
    ```
*   **Resposta Esperada (Status 200 OK):**
    ```json
    {
        "id": 2,
        "nome": "Estudar Spring Boot",
        "dataEntrega": "2025-10-20",
        "responsavel": "Aluno"
    }
    ```

#### Requisição 3: Criar Tarefa (Preparar Apresentação)

*   **Endpoint:** `POST /tarefas`
*   **Headers:** `Content-Type: application/json`
*   **Body:**
    ```json
    {
        "nome": "Preparar Apresentação",
        "dataEntrega": "2025-11-01",
        "responsavel": "Professor"
    }
    ```
*   **Resposta Esperada (Status 200 OK):**
    ```json
    {
        "id": 3,
        "nome": "Preparar Apresentação",
        "dataEntrega": "2025-11-01",
        "responsavel": "Professor"
    }
    ```

--- 

### Teste 2 - Listar todas as tarefas cadastradas

**Requisito:** Listagem correta, mostrando inclusive o registro com nome do aluno e RU.

#### Requisição: Listar Todas as Tarefas

*   **Endpoint:** `GET /tarefas`
*   **Headers:** (Nenhum)
*   **Resposta Esperada (Status 200 OK):**
    ```json
    [
        {
            "id": 1,
            "nome": "Desenvolvimento da API",
            "dataEntrega": "2025-12-12",
            "responsavel": "SeuNome 1234567"
        },
        {
            "id": 2,
            "nome": "Estudar Spring Boot",
            "dataEntrega": "2025-10-20",
            "responsavel": "Aluno"
        },
        {
            "id": 3,
            "nome": "Preparar Apresentação",
            "dataEntrega": "2025-11-01",
            "responsavel": "Professor"
        }
    ]
    ```

--- 

### Teste 3 - Atualizar o cadastro (com seu nome) e verificar se os dados estão refletidos corretamente.

**Requisito:** Atualização do registro contendo nome do aluno e RU.

#### Requisição: Atualizar Tarefa (ID 1 - Desenvolvimento da API)

*   **Endpoint:** `PUT /tarefas/1`
*   **Headers:** `Content-Type: application/json`
*   **Body:**
    ```json
    {
        "nome": "Desenvolvimento da API - Concluído",
        "dataEntrega": "2025-12-12",
        "responsavel": "SeuNome 1234567"
    }
    ```
*   **Resposta Esperada (Status 200 OK):**
    ```json
    {
        "id": 1,
        "nome": "Desenvolvimento da API - Concluído",
        "dataEntrega": "2025-12-12",
        "responsavel": "SeuNome 1234567"
    }
    ```

#### Requisição: Verificar Atualização (Listar Todas as Tarefas)

*   **Endpoint:** `GET /tarefas`
*   **Headers:** (Nenhum)
*   **Resposta Esperada (Status 200 OK):**
    ```json
    [
        {
            "id": 1,
            "nome": "Desenvolvimento da API - Concluído",
            "dataEntrega": "2025-12-12",
            "responsavel": "SeuNome 1234567"
        },
        {
            "id": 2,
            "nome": "Estudar Spring Boot",
            "dataEntrega": "2025-10-20",
            "responsavel": "Aluno"
        },
        {
            "id": 3,
            "nome": "Preparar Apresentação",
            "dataEntrega": "2025-11-01",
            "responsavel": "Professor"
        }
    ]
    ```

--- 

### Teste 4 - Excluir um cadastro (com seu nome) e mostrar que ele desaparece da lista.

**Requisito:** Remoção do registro contendo nome e RU do aluno.

#### Requisição: Excluir Tarefa (ID 1)

*   **Endpoint:** `DELETE /tarefas/1`
*   **Headers:** (Nenhum)
*   **Resposta Esperada (Status 200 OK):** (Corpo vazio ou mensagem de sucesso)

#### Requisição: Verificar Exclusão (Listar Todas as Tarefas)

*   **Endpoint:** `GET /tarefas`
*   **Headers:** (Nenhum)
*   **Resposta Esperada (Status 200 OK):**
    ```json
    [
        {
            "id": 2,
            "nome": "Estudar Spring Boot",
            "dataEntrega": "2025-10-20",
            "responsavel": "Aluno"
        },
        {
            "id": 3,
            "nome": "Preparar Apresentação",
            "dataEntrega": "2025-11-01",
            "responsavel": "Professor"
        }
    ]
    ```

--- 

**Observação:** Lembre-se de substituir "SeuNome 1234567" pelo seu nome e RU reais ao realizar os testes. Estes exemplos servem como guia para a execução e documentação dos testes no Postman.
