# Authentication Using JWT

This repository demonstrates how to implement authentication using JSON Web Tokens (JWT) in a Java-based application.

## Features
- Secure user authentication using JWT.
- Token generation and validation.
- Role-based access control for different routes.

## Technologies Used
- Java
- Spring Boot
- Maven for dependency management.

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/vxrun/authentication-using-jwt.git
    cd authentication-using-jwt
    ```

2. Build the project:

    ```bash
    mvn clean install
    ```

3. Run the application:

    ```bash
    mvn spring-boot:run
    ```

## API Endpoints

- **POST** `/auth/login`: Authenticate a user and generate a JWT.
- **GET** `/protected`: Access protected resources using a valid JWT.

## Usage

1. Register a user via the provided API.
2. Authenticate the user to obtain a JWT token.
3. Use the token to access protected endpoints.
