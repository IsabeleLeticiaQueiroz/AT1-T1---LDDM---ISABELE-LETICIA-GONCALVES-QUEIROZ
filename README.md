# Sylvanian API
<p align="center">
  <img src="./giphy.gif" width="200"/>
</p>## Autora
Isabele Leticia Gonçalves Queiroz

## 📖 Sobre
A Sylvanian API é uma aplicação que simula o gerenciamento de dados do universo Sylvanian Families, uma linha de brinquedos que representa famílias de animais vivendo em uma vila fictícia.

A API permite realizar operações de CRUD (Create, Read, Update, Delete) para:
- 🏠 Casas (Houses)
- 🐰 Personagens (Characters)

Cada personagem pertence a uma casa, representando as famílias e suas relações dentro da vila.

## 📦 Como rodar o projeto

### 1. Subir o banco
docker-compose up -d

### 2. Rodar a aplicação
./gradlew run

### 3. Acessar API
http://127.0.0.1:8080

### 4. Swagger
http://127.0.0.1:8080/swagger
