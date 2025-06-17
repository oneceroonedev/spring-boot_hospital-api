# 🏥 Hospital API - Spring Boot + H2

Este proyecto es una API REST creada con **Spring Boot** y **Java**, que simula una base de datos de un hospital con información de doctores y pacientes.

## 📚 Requisitos

- Java 17
- Maven
- IDE recomendado: IntelliJ
- Navegador (para probar los endpoints y consultar la BBDD)
- Postman o similar (herramienta opcional para probar los endpoints)

## ⚙️ Tecnologías usadas

- Spring Boot (3.5.0)
- Spring Web
- Spring Data JPA
- H2 Database (en memoria)
- Maven

## 📁 Estructura del proyecto

    src/main/java/com.example.hospital
    ├── config           # Carga de datos iniciales
    ├── controller       # Controladores REST
    ├── model            # Entidades JPA (Employee, Patient)
    ├── repository       # Repositorios Spring Data
    └── HospitalApplication.java


## 🛠️ Cómo ejecutar el proyecto

1. Clona el repositorio:

   ```bash
   git clone https://github.com/oneceroonedev/spring-boot_hospital-api.git
   cd hospital-api
   ```
   
2. Ejecuta el proyecto desde tu IDE o con Maven:
    ```bash
    mvn spring-boot:run
    ```
   
3. Una vez ejecutado, la aplicación estará disponible en:

    ```bash
    http://localhost:8080
    ```

## 🌐 Endpoints

### 💻 Desde el navegador
Abre cualquiera de estas URLs en tu navegador:

### 👨‍⚕️ Doctores
- Todos los doctores

    👉 http://localhost:8080/doctors


- Doctor por ID (por ejemplo, 356712)

    👉 http://localhost:8080/doctors/356712


- Doctores por estado (por ejemplo, ON_CALL)

    👉 http://localhost:8080/doctors/status/ON_CALL


- Doctores por departamento (por ejemplo, cardiology)

    👉 http://localhost:8080/doctors/department/cardiology

### 🧑‍🤝‍🧑 Pacientes
- Todos los pacientes

    👉 http://localhost:8080/patients


- Paciente por ID (por ejemplo, 1)

    👉 http://localhost:8080/patients/1


- Pacientes por rango de fecha de nacimiento

    👉 http://localhost:8080/patients/dob?start=1950-01-01&end=1980-12-31


- Pacientes por departamento del médico que los admitió
    
    👉 http://localhost:8080/patients/by-doctor-department/cardiology


- Pacientes cuyo doctor está OFF

    👉 http://localhost:8080/patients/by-doctor-status/OFF

### 🟠 Postman

### 👨‍⚕️ Doctores

| Método | Ruta                               | Descripción                                          |
| ------ | ---------------------------------- | ---------------------------------------------------- |
| GET    | `/doctors`                         | Obtener todos los doctores                           |
| GET    | `/doctors/{id}`                    | Obtener doctor por ID                                |
| GET    | `/doctors/status/{status}`         | Filtrar doctores por estado (`ON`, `OFF`, `ON_CALL`) |
| GET    | `/doctors/department/{department}` | Filtrar doctores por departamento                    |

### 🧑‍🤝‍🧑 Pacientes
| Método | Ruta                                            | Descripción                                           |
| ------ | ----------------------------------------------- | ----------------------------------------------------- |
| GET    | `/patients`                                     | Obtener todos los pacientes                           |
| GET    | `/patients/{id}`                                | Obtener paciente por ID                               |
| GET    | `/patients/dob?start=YYYY-MM-DD&end=YYYY-MM-DD` | Pacientes entre fechas de nacimiento                  |
| GET    | `/patients/by-department/{department}`          | Pacientes por departamento del médico que los admitió |
| GET    | `/patients/by-doctor-status/OFF`                | Pacientes admitidos por doctores con estado OFF       |


## 💾 Base de datos
Puedes acceder a la base de datos H2 a través del siguiente enlace:
    
👉 http://localhost:8080/hospital-api

Usa esta configuración para entrar:

- JDBC URL: jdbc:h2:mem:testdb

- User: ironhack

- Password: (dejar en blanco)

## 📌 Notas
- Los datos se almacenan en memoria (H2) y se borran al cerrar la aplicación.

- Puedes adaptar fácilmente el proyecto para usar MySQL cambiando la configuración en ```application.properties```