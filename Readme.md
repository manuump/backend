# 🛠️ Backend - OcioJaen - Plataforma de Ocio y Turismo en Jaén

Este es el **backend** del proyecto **OcioJaen**, una plataforma web destinada a centralizar y dar visibilidad a eventos culturales, de ocio y turismo de la provincia de Jaén. Provee una API REST desarrollada con **Spring Boot**, incluyendo funcionalidades de autenticación, gestión de eventos y usuarios, y participación en actividades.

---

## 📌 Índice

- [🛠️ Backend - OcioJaen - Plataforma de Ocio y Turismo en Jaén](#️-backend---ociojaen---plataforma-de-ocio-y-turismo-en-jaén)
  - [📌 Índice](#-índice)
  - [🎯 Descripción General](#-descripción-general)
  - [🧑‍🤝‍🧑 Roles y Permisos](#-roles-y-permisos)
  - [🧠 Tecnologías Usadas](#-tecnologías-usadas)
  - [🚀 Cómo Ejecutar el Proyecto](#-cómo-ejecutar-el-proyecto)
    - [🔧 Requisitos](#-requisitos)
    - [▶️ Pasos para ejecutar con Docker + Spring Boot](#️-pasos-para-ejecutar-con-docker--spring-boot)
    - [📝 Anotacion : Crear el archivo `.env`](#-anotacion--crear-el-archivo-env)
  - [🔐 Autenticación JWT](#-autenticación-jwt)
  - [📂 Endpoints REST](#-endpoints-rest)
    - [🔐 Autenticación (`/auth`)](#-autenticación-auth)
    - [📅 Eventos (`/eventos`)](#-eventos-eventos)
    - [🧾 Participaciones (`/participaciones`)](#-participaciones-participaciones)
    - [👮 Gestión de Usuarios (`/admin/usuarios`)](#-gestión-de-usuarios-adminusuarios)
  - [🗂️ Estructura de Carpetas](#️-estructura-de-carpetas)
  - [🤝 Agradecimientos](#-agradecimientos)

---

## 🎯 Descripción General

Este backend provee todas las funcionalidades necesarias para el proyecto OcioJaen:

- Registro e inicio de sesión con roles (`USUARIO`, `EMPRESA`, `ADMIN`)
- Gestión de eventos por empresas
- Participación de usuarios en eventos
- Gestión de usuarios por parte del administrador
- Generación de PDFs con lista de participantes

---

## 🧑‍🤝‍🧑 Roles y Permisos

| Rol     | Descripción                                                                 |
|---------|------------------------------------------------------------------------------|
| USUARIO | Puede ver eventos, inscribirse en ellos, cancelar participaciones y ver sus inscripciones. |
| EMPRESA | Puede crear y eliminar sus propios eventos, ver participantes y generar PDF de esos participantes por evento. |
| ADMIN   | Puede listar todos los usuarios, cambiar roles, y eliminar usuarios.        |

---

## 🧠 Tecnologías Usadas

| Tecnología         | Descripción                               |
|--------------------|-------------------------------------------|
| ☕ Spring Boot      | Framework backend basado en Java          |
| 🔐 Spring Security | Sistema de autenticación y autorización   |
| 💾 JPA + Hibernate | Persistencia y mapeo ORM con base de datos|
| 📄 iText / PDFBox  | Generación de documentos PDF              |
| 🐬 MySQL / Adminer | Gestión de base de datos relacional       |
| 🐳 Docker          | Contenedores para desarrollo y despliegue |

---

## 🚀 Cómo Ejecutar el Proyecto

### 🔧 Requisitos

- Java 17+
- Maven
- Docker + Docker Compose

### ▶️ Pasos para ejecutar con Docker + Spring Boot

```bash
# 1. Clona el repositorio
git clone https://github.com/tu-usuario/ociojaen-backend.git
cd ociojaen-backend

# 2. Levanta los contenedores de base de datos y Adminer
docker compose up -d

# 3. Verifica que MySQL y Adminer están funcionando
    - Adminer disponible en http://localhost:${ADMINER_PORT}
    - MySQL escucha en localhost:${MYSQL_PORT}

# 4. Configura el archivo application.yml con las variables de entorno o credenciales de tu base de datos

# 5. Arranca el backend de Spring Boot
./mvnw spring-boot:run
```

### 📝 Anotacion : Crear el archivo `.env`

Para que Docker cargue correctamente las variables de entorno, crea un archivo llamado `.env` en la raíz del proyecto con el siguiente contenido (puedes personalizar los valores según tu entorno):

```env
MYSQL_ROOT_PASSWORD=tu_contraseña_segura
MYSQL_PORT=3307
ADMINER_PORT=8081
``` 

## 🔐 Autenticación JWT

Los usuarios se autentican con credenciales y reciben un **JWT**.

El token debe incluirse en las peticiones posteriores con el header:

```http
Authorization: Bearer {token}
```

## 📂 Endpoints REST

### 🔐 Autenticación (`/auth`)

| Método | Endpoint     | Descripción         |
|--------|--------------|---------------------|
| POST   | `/register`  | Registro de usuario |
| POST   | `/login`     | Inicio de sesión    |

---

### 📅 Eventos (`/eventos`)

| Método | Endpoint           | Acceso   | Descripción                               |
|--------|--------------------|----------|-------------------------------------------|
| GET    | `/`                | Público  | Lista todos los eventos                   |
| GET    | `/{id}`            | Público  | Obtiene un evento por ID                  |
| POST   | `/`                | EMPRESA  | Crea un nuevo evento                      |
| PUT    | `/{id}`            | EMPRESA  | Actualiza un evento existente             |
| DELETE | `/{id}`            | EMPRESA  | Elimina un evento                         |
| GET    | `/mis-eventos`     | EMPRESA  | Lista eventos creados por la empresa      |

---

### 🧾 Participaciones (`/participaciones`)

| Método | Endpoint                             | Acceso   | Descripción                              |
|--------|--------------------------------------|----------|------------------------------------------|
| POST   | `/evento/{eventoId}`                | USUARIO  | Participar en un evento                  |
| GET    | `/`                                  | USUARIO  | Ver mis participaciones                  |
| DELETE | `/{participacionId}`                 | USUARIO  | Cancelar participación                   |
| GET    | `/evento/{eventoId}`                 | EMPRESA  | Lista de participantes de un evento      |
| GET    | `/evento/{eventoId}/pdf`             | EMPRESA  | Descargar PDF con lista de participantes |

---

### 👮 Gestión de Usuarios (`/admin/usuarios`)

| Método | Endpoint         | Acceso | Descripción                |
|--------|------------------|--------|----------------------------|
| GET    | `/`              | ADMIN  | Lista todos los usuarios   |
| PUT    | `/{id}/rol`      | ADMIN  | Cambia el rol de un usuario|
| DELETE | `/{id}`          | ADMIN  | Elimina un usuario         |

---

## 🗂️ Estructura de Carpetas

```text
src/
├── controllers/     → Controladores REST
├── models/          → Entidades JPA (Usuario, Evento, Participacion, Rol)
├── repos/           → Interfaces JPARepository
├── security/        → Configuración JWT y Spring Security
├── services/        → Lógica de negocio
```

## 🤝 Agradecimientos

Gracias por apoyar esta plataforma de promoción cultural y turística en Jaén.
Este backend es la base que permite que OcioJaen funcione de forma segura, escalable y orientada a los distintos perfiles de usuario.