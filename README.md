# Osaka

A **Osaka Mining Corporation** é uma mineradora fictícia de origem japonesa, especializada na extração e exportação de minério de ferro para o mercado internacional. Embora sua matriz esteja localizada no Japão, a empresa mantém sua **sede administrativa em São Paulo, Brasil**, em razão da importância estratégica do país no setor de mineração e comércio exterior.

A Osaka negocia grandes volumes de minério de ferro com empresas de diversos países, realizando suas operações comerciais majoritariamente em **dólares americanos (USD)**, enquanto mantém controles financeiros e administrativos também em **reais brasileiros (BRL)**.

Para apoiar suas operações comerciais, a empresa necessita de uma **API REST** que permita registrar propostas de compra feitas por clientes internacionais, acompanhar oportunidades de venda, controlar acessos conforme o perfil do usuário, realizar conversões monetárias e exportar dados para integração com outros sistemas corporativos.

---

## 1. Requisitos Funcionais

### 1.1 Gestão de Usuários

**RF01 – Tipos de usuários**

O sistema deve suportar os seguintes tipos de usuários:

* Cliente
* Operador de Negócio – Comum
* Operador de Negócio – Gerente

**RF02 – Permissões por tipo de usuário**

* Clientes podem criar e consultar suas próprias propostas de compra.
* Operadores comuns podem visualizar oportunidades de venda.
* Gerentes podem visualizar e excluir oportunidades de venda.

---

### 1.2 Propostas de Compra

**RF03 – Criação de proposta de compra**

A API deve permitir que apenas usuários do tipo **Cliente** criem propostas de compra.

**RF04 – Dados obrigatórios da proposta**

Cada proposta de compra deve conter:

* Nome da empresa compradora
* Quantidade de minério de ferro (em toneladas)
* Preço por tonelada (em dólares – USD)
* País de origem da empresa
* Data de validade da proposta
* Data de criação da proposta (gerada automaticamente pelo sistema)

**RF05 – Validação da proposta**

O sistema deve validar que:

* A quantidade de toneladas seja maior que zero
* O preço por tonelada seja maior que zero
* A data de validade seja posterior à data de criação

**RF06 – Consulta de propostas**

* Clientes podem consultar apenas suas próprias propostas.
* Operadores de negócio podem consultar todas as propostas válidas.

---

### 1.3 Oportunidades de Venda

**RF07 – Geração de oportunidades de venda**

O sistema deve considerar propostas de compra válidas como oportunidades de venda para a mineradora.

**RF08 – Visualização de oportunidades**

* Operadores comuns e gerentes podem visualizar oportunidades de venda.
* A visualização deve incluir os dados da proposta e os valores convertidos para Real (BRL).

**RF09 – Exclusão de oportunidades**

* Apenas usuários do tipo **Gerente** podem excluir oportunidades de venda.

---

### 1.4 Cotações de Moedas

**RF10 – Acompanhamento de cotações**

O sistema deve acompanhar a cotação das seguintes moedas:

* Dólar americano (USD)
* Real brasileiro (BRL)

**RF11 – Conversão de valores**

O sistema deve permitir a conversão automática do valor total da proposta de USD para BRL, utilizando a cotação mais recente disponível.

---

### 1.5 Exportação de Dados

**RF12 – Formatos de exportação**

O sistema deve permitir a exportação de oportunidades de venda nos formatos:

* JSON
* CSV

**RF13 – Conteúdo da exportação**

A exportação deve conter, no mínimo:

* Dados da proposta
* Valor total em USD
* Valor total convertido em BRL
* Data da cotação utilizada

---

### 1.6 API REST

**RF14 – Interface REST**

O sistema deve disponibilizar uma API REST para:

* Criação de propostas de compra
* Consulta de propostas
* Consulta de oportunidades de venda
* Exclusão de oportunidades (gerente)
* Exportação de oportunidades

**RF15 – Controle de acesso**

A API deve validar autenticação e autorização com base no tipo de usuário.

---

## 2. Requisitos Não Funcionais

### 2.1 Tecnologia e Plataforma

**RNF01 – Linguagem**

A aplicação deve ser desenvolvida em **Java**.

**RNF02 – Framework**

A API REST deve ser implementada utilizando **Quarkus**.

**RNF03 – Execução**

A aplicação deve suportar execução em **JVM** e como **native image** (GraalVM).

**RNF04 – Banco de dados**

O sistema deve utilizar **PostgreSQL** como banco de dados relacional principal.

---

### 2.2 Persistência de Dados

**RNF05 – Acesso a dados**

O acesso ao banco de dados deve ser realizado por meio de ORM compatível com Quarkus (ex.: **Hibernate ORM / Panache**).

**RNF06 – Integridade referencial**

O banco de dados deve garantir integridade referencial, chaves primárias e estrangeiras e restrições de domínio.

**RNF07 – Transações**

As operações de criação, exclusão e atualização devem ser transacionais, garantindo consistência dos dados.

**RNF08 – Versionamento de esquema**

O esquema do banco de dados deve ser versionado e controlado por ferramenta de migração (ex.: **Flyway** ou **Liquibase**).

---

### 2.3 Segurança e Dados

**RNF09 – Credenciais do banco**

As credenciais de acesso ao PostgreSQL devem ser armazenadas de forma segura e externalizadas via variáveis de ambiente.

**RNF10 – Privilégios de acesso**

O usuário do banco de dados utilizado pela aplicação deve possuir apenas os privilégios mínimos necessários.

---

### 2.4 Desempenho

**RNF11 – Conexões**

O gerenciamento de conexões com o PostgreSQL deve utilizar pool de conexões configurado no Quarkus.

**RNF12 – Índices**

O banco de dados deve possuir índices adequados para consultas frequentes (ex.: propostas válidas, oportunidades ativas).

---

### 2.5 Escalabilidade e Disponibilidade

**RNF13 – Escalabilidade da aplicação**

A aplicação deve permitir escalabilidade horizontal independentemente do banco de dados.

**RNF14 – Backup e recuperação**

Devem existir mecanismos de backup periódico e recuperação do PostgreSQL.

---

### 2.6 Manutenibilidade

**RNF15 – Portabilidade do banco**

O uso de PostgreSQL deve seguir padrões SQL sempre que possível, evitando dependência excessiva de recursos proprietários.

**RNF16 – Testes com banco**

O sistema deve permitir execução de testes automatizados com banco de dados PostgreSQL (ex.: containers de teste).

---

### 2.7 Observabilidade e Auditoria

**RNF17 – Auditoria de dados**

As operações críticas (criação e exclusão de propostas e oportunidades) devem ser registradas de forma auditável no banco.

**RNF18 – Monitoramento**

Devem existir métricas e logs relacionados a desempenho e falhas de acesso ao PostgreSQL.

---

## 3. Modelagem das Entidades do Microsserviço de Cotação

### 3.1 Entidades

As entidades manipuladas pelo microsserviço de cotação são:

- `enum Currency` (`BRL`, `USD`)

- `class CurrencyQuote`

### 3.2 Entidade `CurrencyQuote`

**CurrencyQuote** representa a **cotação de conversão entre duas moedas** em um determinado instante, definindo quanto vale **1 unidade da moeda de origem (`from`)** na **moeda de destino (`to`)**, por meio de uma **taxa (`rate`)** registrada com data e hora para fins de histórico, auditoria e conversões financeiras consistentes.

Atributos da entidade `CurrencyQuote`:

- `UUID id`
- `Currency from`
- `Currency to`
- `BigDecimal rate`
- `Timestamp quotedAt`

## 4. Modelagem das Entidades do Microsserviço de Propostas (Em Implementação)

### 4.1 Entidades

As entidades manipuladas pelo microsserviço de proposta são:

- `enum Country`

- `class Proposal`

### 4.2 Entidade `Proposal`

**Proposal** representa a proposta de compra de uma empresa cliente. Ela contém informações sobre a empresa proponente, a quantidade (em toneladas) que se pretende adquirir, o preço por tonelada e o país onde a proposta foi realizada.

Atributos da entidade `Proposal`:

- `UUID id`
- `String customerName`
- `BigDecimal tons`
- `BigDecimal pricePerTon`
- `Country country`
- `Timestamp createAt`
