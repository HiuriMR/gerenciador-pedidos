# 📦 Gerenciador de Pedidos

Sistema simples de gerenciamento de pedidos desenvolvido com **Java, Spring Boot, Spring Data JPA e PostgreSQL**, com o objetivo de praticar conceitos de persistência de dados, mapeamento de entidades e integração com banco de dados relacional.

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Jakarta Persistence API (JPA)

---

## 📋 Funcionalidades

- Cadastro de Produtos
- Cadastro de Categorias
- Cadastro de Pedidos
- Persistência de dados utilizando JPA/Hibernate
- Integração com PostgreSQL
- Configuração através de variáveis de ambiente

---

## 🏗️ Estrutura do Projeto

```text
src
└── main
    ├── java
    │   └── br.com.gerenciador_pedidos
    │       ├── model
    │       │   ├── Produto.java
    │       │   ├── Categoria.java
    │       │   └── Pedido.java
    │       │
    │       ├── repository
    │       │   ├── ProdutoRepository.java
    │       │   ├── CategoriaRepository.java
    │       │   └── PedidoRepository.java
    │       │
    │       ├── principal
    │       │   └── Principal.java
    │       │
    │       └── GerenciadorPedidosApplication.java
    │
    └── resources
        └── application.properties
```

---

## 🗄️ Modelo de Dados

### Produto

| Campo | Tipo |
|---------|---------|
| id | Long |
| nome | String |
| preco | Double |

### Categoria

| Campo | Tipo |
|---------|---------|
| id | Long |
| nome | String |

### Pedido

| Campo | Tipo |
|---------|---------|
| id | Long |
| data | LocalDate |

---

## ⚙️ Configuração do Banco de Dados

O projeto utiliza variáveis de ambiente para conexão com o PostgreSQL.

```properties
spring.datasource.url=jdbc:postgresql://${DB_HOST}:5433/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```

Configure as seguintes variáveis:

```bash
DB_HOST=localhost
DB_NAME=gerenciador_pedidos
DB_USER=postgres
DB_PASSWORD=sua_senha
```

---

## ▶️ Como Executar

### 1. Clonar o repositório

```bash
git clone https://github.com/HiuriMR/gerenciador-pedidos.git
```

### 2. Entrar na pasta do projeto

```bash
cd gerenciador-pedidos
```

### 3. Configurar o PostgreSQL

Crie o banco de dados:

```sql
CREATE DATABASE gerenciador_pedidos;
```

### 4. Executar a aplicação

Pelo Maven:

```bash
./mvnw spring-boot:run
```

Ou:

```bash
mvn spring-boot:run
```

---

## 🎯 Objetivo do Projeto

Este projeto foi desenvolvido para praticar:

- Mapeamento de entidades com JPA
- Persistência de dados utilizando Spring Data JPA
- Criação de repositórios com JpaRepository
- Integração com PostgreSQL
- Organização em camadas (Model, Repository e Application)
- Boas práticas de desenvolvimento Backend com Java

---

## 📚 Próximos Passos

- [ ] Implementar relacionamento entre Pedido e Produto
- [ ] Implementar relacionamento entre Produto e Categoria
- [ ] Criar camada de Service
- [ ] Criar Controllers REST
- [ ] Adicionar DTOs
- [ ] Implementar validações
- [ ] Criar testes unitários
- [ ] Dockerizar a aplicação

---

## 👨‍💻 Autor

**Hiuri Marques Rocha**

- GitHub: https://github.com/HiuriMR
- LinkedIn: https://linkedin.com/in/hiuri-rocha

---

⭐ Se este projeto foi útil para você, considere deixar uma estrela no repositório.