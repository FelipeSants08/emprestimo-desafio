# 🏦 Loan Selection API

API desenvolvida em Java com Spring Boot para análise de elegibilidade de empréstimos. O sistema processa o perfil de um cliente e determina quais modalidades de crédito estão disponíveis com base em regras de negócio específicas de renda, idade e localização.

## 🚀 Diferenciais Técnicos

- **Java 21 & Spring Boot 3**: Utilizando as versões mais estáveis e modernas do ecossistema.
- **Docker Multi-Stage Build**: Imagem final ultra-leve (~90MB) utilizando Alpine Linux e JRE.
- **Test-Driven Reliability**: O build da imagem Docker é condicionado ao sucesso de 100% dos testes unitários.
- **Clean Code**: Implementação utilizando `Records` para imutabilidade e `Enums` para padronização de taxas.

## 📋 Regras de Negócio

A API avalia três tipos de empréstimos:

| Tipo | Taxa | Requisitos |
| :--- | :--- | :--- |
| **Pessoal** | 4% | Renda ≤ 3000 OU (Renda entre 3000 e 5000 + idade < 30 + SP) |
| **Com Garantia** | 3% | Renda ≤ 3000 OU (Renda entre 3000 e 5000 + idade < 30 + SP) |
| **Consignado** | 2% | Renda ≥ 5000 |

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 21
- **Framework:** Spring Boot 3
- **Testes:** JUnit 5, AssertJ
- **Containerização:** Docker (Alpine Linux)
- **Gerenciador de Dependências:** Maven

## 📦 Como Executar com Docker

Uma das grandes vantagens deste projeto é que você não precisa ter o Java instalado na sua máquina para buildar, apenas o Docker.

### 1. Construir a imagem (e rodar os testes):
Este comando executa todo o ciclo de vida do Maven dentro de um container temporário. Se os testes falharem, a imagem não será gerada.
```bash
docker build -t loan-api .
```
2. Executar o container:
```bash
docker run -p 8080:8080 loan-api
```
A API estará disponível em: http://localhost:8080/customer-loans

## 🧪 Exemplo de Uso (Payload)
POST /customer-loans
```bash
{
  "age": 25,
  "cpf": "123.456.789-00",
  "name": "Antrolopoulos",
  "income": 5000.0,
  "location": "SP"
}
```
Resposta Esperada:

```bash
{
  "customer": "Antrolopoulos",
  "loans": [
    { "type": "PERSONAL", "interestRate": 4 },
    { "type": "GUARANTEED", "interestRate": 3 },
    { "type": "CONSIGNMENT", "interestRate": 2 }
  ]
}
```
Projeto focado em demonstrar conhecimentos de lógica de programação, tratamento de erros de borda e automação de infraestrutura com Docker.
