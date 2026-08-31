# Full Stack Backend

Backend API for a full-stack web application built with **Spring Boot**. It provides authentication, user management, database connectivity, and REST APIs consumed by the frontend application.

## 🚀 Tech Stack

* **Java**
* **Spring Boot**
* **Spring Web**
* **Spring Security**
* **REST API**
* **Database**
* **Maven**
* **JWT / Authentication**
* **Render** — Backend Deployment

## 📁 Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── ...
│   └── resources/
│       └── application.properties
│
├── test/
│   └── ...
│
├── pom.xml
└── README.md
```

> The exact package structure may vary depending on the current implementation.

## 🔐 Authentication

The backend provides authentication APIs for user registration and login.

### Login

```http
POST /api/auth/login
```

### Register

```http
POST /api/auth/register
```

Authentication requests are validated on the backend before returning the appropriate response to the frontend.

Example responses include:

```text
Invalid email or password
```

and:

```text
Email already registered
```

## 🌐 API Base URL

Production backend:

```text
https://full-stack-0yf4.onrender.com
```

Example:

```text
POST https://full-stack-0yf4.onrender.com/api/auth/login
```

## ⚙️ Environment Configuration

Sensitive configuration should be stored using environment variables and should **not** be committed to GitHub.

Example:

```properties
DATABASE_URL=your_database_url
DATABASE_USERNAME=your_database_username
DATABASE_PASSWORD=your_database_password
JWT_SECRET=your_jwt_secret
```

Use the actual variable names defined in the project configuration.

## 🗄️ Database

The backend uses a production database for persistent application data.

Database configuration is handled through environment variables so that credentials and connection details remain outside the source code.

## 🔒 Security

The project follows standard backend security practices, including:

* Authentication and authorization
* Password protection
* Secure environment variables
* Token-based authentication where configured
* CORS configuration
* Server-side validation

Never commit:

```text
.env
database passwords
JWT secrets
API keys
private credentials
```

## 🛠️ Running Locally

### 1. Clone the repository

```bash
git clone https://github.com/rameshworchaudhary/FULL-STACK-.git
```

### 2. Navigate to the project

```bash
cd FULL-STACK-
```

### 3. Configure environment variables

Create the required environment variables according to the application's configuration.

### 4. Run the application

Using Maven:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The backend will normally start on:

```text
http://localhost:8080
```

## 🔗 Frontend

This backend is designed to work with the deployed frontend application:

```text
https://full-stack-frontend-pink.vercel.app/
```

The frontend communicates with this backend through REST APIs.

## 📡 API

Main authentication endpoints:

| Method | Endpoint             | Description                   |
| ------ | -------------------- | ----------------------------- |
| POST   | `/api/auth/login`    | Authenticate an existing user |
| POST   | `/api/auth/register` | Register a new user           |

Additional API endpoints may be available depending on the current application implementation.

## 🚀 Deployment

The backend is deployed using **Render**.

Production API:

```text
https://full-stack-0yf4.onrender.com
```

Deployment configuration should use production environment variables rather than local development credentials.

## 🧪 Testing

Run the test suite using:

```bash
./mvnw test
```

On Windows:

```bash
mvnw.cmd test
```

## 📌 Current Status

* ✅ Spring Boot backend
* ✅ REST API
* ✅ User registration
* ✅ User login
* ✅ Production database
* ✅ Authentication
* ✅ Frontend API integration
* ✅ Production deployment

## 👨‍💻 Author

**Rameshwor Chaudhary**

Computer Science Engineering | AI & ML

---

⭐ If you find this project useful, consider giving the repository a star.
