# ScreenMatch API

This project is the result of Alura's “Java: creating your first API and connecting it to the front-end” course. The aim was to create a REST API to supply data to a front-end application, exercising essential concepts of web development with Java and Spring Boot.

## Table of Contents

- Installation
- Usage
- API EndPoints
- Technologies 

## Installation

1. Clone the repository

        git clone https://github.com/your-username/project-name.git

2. Install dependencies with Maven

3. Install PostgresSQL

## Usage

1. Start aplication with maven 

        mvn spring-boot:run

2. The API will be accessible at http://localhost:8080

## API EndPoints

GET /series - returns all series registered in the database

GET /series/{id} - returns information about a specific serie

GET /series/top5 - returns top 5 series by assessment

GET /series/lancamentos - returns series with releases of the latest episodes 

GET /series/{id}/temporadas/todas - returns all the episodes of a serie

GET /series/{id}/temporadas/{numero} - returns all the episodes of a specific season of a serie

GET /series/categoria/{nome_categoria} - returns all the series in a specific category

## Technologies

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
