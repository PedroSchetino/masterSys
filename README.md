# MasterSys - Sistema de Gestão para Academias

O **MasterSys** é uma API REST desenvolvida para a modernização e gestão de academias de artes marciais. O projeto
consiste na migração de um sistema legado desktop para uma arquitetura moderna, escalável e pronta para ambientes
dockerizados ou deploy em nuvem.

---

## 🚀 Propósito e Aprendizado

O núcleo deste projeto é a aplicação prática de conceitos avançados de desenvolvimento back-end, incluindo:

* **Versionamento de Banco de Dados:** Evolução controlada do esquema usando migrações automatizadas.
* **Boas Práticas de Arquitetura:** Separação clara de responsabilidades (Camadas: Controller, Service, Repository).
* **Escalabilidade:** Código limpo, tipagem forte com Java 21 e preparação para transição de ambiente local para nuvem.

---

## 🛠️ Stack Tecnológica

* **Linguagem:** Java 21
* **Framework:** Spring Boot (Web, Data JPA, Validation)
* **Gerenciador de Dependências:** Maven
* **Banco de Dados:** PostgreSQL
* **Versionamento de Banco:** Flyway Migration
* **Produtividade:** Lombok

---

## 📦 Principais Funcionalidades

* **Gestão de Academias:** Cadastro e controle de usuários, alunos, modalidades e graduações (faixas).
* **Controle de Planos:** Vinculação de modalidades a planos com gestão financeira integrada.
* **Processos de Matrícula:** Fluxo completo de matrícula de alunos, geração de faturas e acompanhamento de status.
* **Assiduidade:** Módulo nativo para controle de presença e frequência dos alunos.

---

## 🔧 Como Executar o Projeto (Local)

### Pré-requisitos

* Java 21 instalado.
* PostgreSQL ativo localmente.

### Passo a Passo

1. Clone o repositório:
   ```bash
   git clone [git remote add origin https://github.com/PedroSchetino/MasterSys.git]
