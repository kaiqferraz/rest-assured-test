# 🚀 Automação de Testes REST Assured

Este projeto é um framework de automação de testes de API desenvolvido com **REST Assured** e **JUnit 5**, focado em testes de qualidade e automação de validações de endpoints REST.

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Instalação e Configuração](#instalação-e-configuração)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Como Executar os Testes](#como-executar-os-testes)
- [Exemplos de Testes](#exemplos-de-testes)
- [Relatórios de Teste](#relatórios-de-teste)
- [Contribuição](#contribuição)
- [Licença](#licença)

## 🎯 Sobre o Projeto

Este framework foi desenvolvido para automatizar testes de APIs REST, utilizando o REST Assured como biblioteca principal. O projeto implementa testes para operações CRUD (Create, Read, Update, Delete) em uma API de usuários, demonstrando as melhores práticas de automação de testes de API.

### Funcionalidades

- ✅ Testes automatizados de API REST
- ✅ Validação de status codes e responses
- ✅ Testes de operações CRUD completas
- ✅ Estrutura organizada e escalável
- ✅ Configuração centralizada de base URI
- ✅ Execução ordenada de testes

## 🛠 Tecnologias Utilizadas

- **Java 11** - Linguagem de programação
- **Maven** - Gerenciador de dependências e build
- **REST Assured 5.4.0** - Biblioteca para testes de API REST
- **JUnit 5** - Framework de testes
- **Hamcrest** - Biblioteca de matchers para assertions

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- ☑️ **Java 11** ou superior
- ☑️ **Maven 3.6** ou superior
- ☑️ **Git** (para clonar o repositório)
- ☑️ **IDE** (IntelliJ IDEA, Eclipse ou VS Code)

### Verificação das Instalações

```bash
# Verificar Java
java -version

# Verificar Maven
mvn -version

# Verificar Git
git --version
```

## 🚀 Instalação e Configuração

### 1. Clone o Repositório

```bash
git clone <url-do-repositorio>
cd rest-assured-test
```

### 2. Configuração do Projeto

O projeto utiliza Maven e todas as dependências são gerenciadas automaticamente através do `pom.xml`.

### 3. Compilação

```bash
mvn clean compile
```

## 📁 Estrutura do Projeto

```
rest-assured-test/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           └── example/
│   │               └── App.java
│   └── test/
│       └── java/
│           └── org/
│               └── example/
│                   ├── BaseTest.java          # Classe base para configurações
│                   └── Usuarios.java          # Testes de API de usuários
├── target/                                    # Arquivos compilados (gerado automaticamente)
├── pom.xml                                    # Configuração do Maven
├── .gitignore                                 # Arquivos ignorados pelo Git
└── README.md                                  # Este arquivo
```

### Descrição dos Arquivos

- **`BaseTest.java`**: Classe abstrata que contém configurações comuns para todos os testes, como base URI
- **`Usuarios.java`**: Classe de teste que implementa o fluxo completo de operações CRUD para usuários
- **`pom.xml`**: Arquivo de configuração do Maven com dependências e plugins

## 🧪 Como Executar os Testes

### Executar Todos os Testes

```bash
mvn test
```

### Executar Testes Específicos

```bash
# Executar apenas a classe Usuarios
mvn test -Dtest=Usuarios

# Executar um teste específico
mvn test -Dtest=Usuarios#cadastrarUsuario
```

### Executar com Relatório

```bash
mvn clean test
```

## 📝 Exemplos de Testes

### Teste de Cadastro de Usuário

```java
@Test
@Order(1)
public void cadastrarUsuario() {
    String userJson = "{"
            + "\"nome\": \"QA Teste\","
            + "\"email\": \"teste@exemplo.com\","
            + "\"password\": \"123456\","
            + "\"administrador\": \"true\""
            + "}";

    Response response = given()
            .header("Content-Type", "application/json")
            .body(userJson)
            .when()
            .post("/usuarios");

    response.then()
            .statusCode(201)
            .body("message", equalTo("Cadastro realizado com sucesso"));
}
```

### Fluxo de Testes

O projeto implementa um fluxo completo de testes:

1. **Cadastro** - Cria um novo usuário
2. **Busca por ID** - Recupera o usuário criado
3. **Listagem** - Lista todos os usuários
4. **Edição** - Atualiza dados do usuário
5. **Exclusão** - Remove o usuário

## 📊 Relatórios de Teste

Os resultados dos testes são exibidos no console durante a execução. Para relatórios mais detalhados, você pode integrar ferramentas como:

- **Allure Reports**
- **Extent Reports**
- **Maven Surefire Reports**

### Gerar Relatório Surefire

```bash
mvn surefire-report:report
```

## 🔧 Configurações

### Base URI

A URL base da API está configurada na classe `BaseTest`:

```java
@BeforeAll
public static void setup() {
    RestAssured.baseURI = "https://serverest.dev";
}
```

### Headers Padrão

Os testes utilizam headers padrão para requisições JSON:

```java
.header("Content-Type", "application/json")
```

## 🚨 Troubleshooting

### Problemas Comuns

1. **Erro de Compilação Java**

   - Verifique se o Java 11+ está instalado
   - Confirme a variável JAVA_HOME

2. **Falha na Conexão**

   - Verifique sua conexão com a internet
   - Confirme se a API está online

3. **Dependências Maven**
   - Execute `mvn clean install` para baixar dependências
   - Verifique sua conexão com o Maven Central

## 🤝 Contribuição

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

### Padrões de Código

- Use nomes descritivos para métodos e variáveis
- Adicione comentários quando necessário
- Mantenha a estrutura de pacotes organizada
- Siga as convenções do Java

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 📞 Contato

**Desenvolvedor**: Kaique
**Email**: [seu-email@exemplo.com]

---

⭐ Se este projeto foi útil para você, considere dar uma estrela no repositório!
