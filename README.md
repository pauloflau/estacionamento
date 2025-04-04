# Sistema de Estacionamento - Backend

Este é o backend de um sistema de estacionamento, desenvolvido com **Java**, utilizando o framework **Spring Boot** para gestão de usuários e autenticação juntamente com o banco de dados **H2** para persistência. O sistema gerencia o login e o perfil de clientes e administradores, com segurança baseada em **Spring Security** e **JWT**. O projeto inclui funcionalidades de auditoria, documentação via **Swagger**, testes e relatórios.

## Funcionalidades

- **Login e Autenticação**:
  - O sistema utiliza **JWT (JSON Web Tokens)** para autenticação de usuários.
  - Existem dois tipos de usuários: **Administrador** e **Cliente**.
  - O **Administrador** tem permissões para gerenciar o cadastro de clientes, vagas e relatórios.
  - O **Cliente** pode acessar e gerenciar a sua vaga, mas não tem permissões administrativas.

- **Gestão de Vagas**:
  - Cada cliente precisa ser cadastrado previamente para poder acessar e ocupar uma vaga de estacionamento.

- **Auditoria**:
  - O sistema mantém colunas de auditoria em todas as entidades, registrando informações como criação e atualização de registros.
  
- **Relatórios**:
  - O sistema gera relatórios sobre o uso das vagas, com dados de ocupação e tempo de permanência.

- **Documentação com Swagger**:
  - A API está documentada com **Swagger**, permitindo fácil acesso e entendimento das rotas e dados do sistema.

- **Banco de Dados H2**:
  - O banco de dados utilizado é o **H2**, uma solução leve e em memória para desenvolvimento. Já existem usuários cadastrados para teste.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 2.x**
- **Spring Security** para autenticação e autorização
- **JWT (JSON Web Token)** para gerenciamento de sessões
- **H2 Database** para armazenamento de dados
- **Swagger** para documentação da API
- **JUnit 5** e **Mockito** para testes unitários
- **Lombok** para simplificar o código

## Estrutura do Projeto

- **/src/main/java/com/estacionamento**:
  - **config**: Configurações de segurança, JWT, etc.
  - **controller**: Controladores da API.
  - **model**: Entidades do banco de dados, incluindo a auditoria.
  - **repository**: Repositórios do Spring Data JPA.
  - **security**: Configuração de autenticação e autorização com Spring Security.
  - **service**: Lógica de negócios, incluindo o gerenciamento de vagas e usuários.

- **/src/main/resources**:
  - **application.properties**: Configurações do banco de dados, JWT, e outras propriedades do sistema.

### Pré-requisitos

- JDK 17 ou superior
- Maven 3.x ou superior
- Postman
- Banco de Dados configurado (MySQL, PostgreSQL ou H2)

## Configuração do Banco de Dados (H2)

1. Configure as credenciais no `application.properties`:
   ```properties
   # Configuração do banco de dados H2 (em memória)
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.h2.console.enabled=true  # Habilita o console H2 para visualização do banco

   ````

**Nota:** o banco de dados H2 será criado e destruído a cada execução da aplicação.

Caso queira visualizar os dados no banco, você pode acessar o console do H2 diretamente através do seguinte link (quando a aplicação estiver em execução):

[http://localhost:8080/h2-console](http://localhost:8080/h2-console)

**JDBC URL**: jdbc:h2:mem:testdb

**Username**: sa

**Password**: password

## Como Rodar o Projeto
### Passos

1. **Clone o repositório**:

   ```sh
   git clone https://github.com/pauloflau/estacionamento.git
   cd estacionamento
    ```

2. **Acessando o Swagger:**:

A documentação da API é gerada automaticamente pelo Swagger. Após a API estar em execução, você pode acessar a documentação via:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## TESTES

Os testes do sistema serão implementados utilizando JUnit 5.  Os testes incluem:
- Testes de autenticação e autorização com JWT.
- Testes de CRUD para clientes e vagas.
- Testes de segurança para garantir que apenas usuários autorizados possam acessar recursos restritos.

## Auditoria

As entidades do sistema, como Cliente, Vaga e Relatorio, incluem colunas de auditoria para rastrear:

- **Data de criação** e **data de atualização**.

- **Usuário que criou e usuário que atualizou**.

## Planejamento Futuro

- **Frontend**: A interface do usuário será desenvolvida em uma aplicação web separada (em React, Angular, ou outra tecnologia).

- **Recursos adicionais**: Implementação de funcionalidades adicionais, como gerenciamento de relatórios em tempo real, notificações de vagas, etc.

## Contribuindo

Se você quiser contribuir para este projeto, siga os passos abaixo:

1. Faça um fork deste repositório.
2. Crie uma nova branch (`git checkout -b feature/nova-feature`).
3. Faça as alterações e commit (`git commit -am 'Adiciona nova feature'`).
4. Faça o push para a branch (`git push origin feature/nova-feature`).
5. Envie um pull request.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

Se você encontrar algum problema ou tiver sugestões, sinta-se à vontade para abrir uma **issue** ou enviar um **pull request**.



