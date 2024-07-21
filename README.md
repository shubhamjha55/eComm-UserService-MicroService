# eComm-UserService-MicroService

## Overview

The `eComm-UserService-MicroService` is a microservice designed to handle user registration and authentication for an e-commerce platform. This service is built using Java (Springboot 3.3.2) / PostgreSQL and adheres to the principles of microservice architecture, ensuring scalability, maintainability, and ease of deployment.

## Features

- **User Registration**: Allows new users to register by providing necessary information.
- **User Authentication**: Validates user credentials for secure access.
- **Password Management**: Supports password hashing and verification.
- **Token Generation**: Provides JWT tokens for session management and secure communication.

## Architecture

The architecture of the `eComm-UserService-MicroService` is designed to be modular and scalable. Here is an overview of the key components:

### 1. Controller Layer

- **UserController**: Handles HTTP requests related to user operations such as registration, login, and password management.
  
### 2. Service Layer

- **UserService**: Contains business logic for user operations. It interacts with the repository layer to perform CRUD operations on user data.

### 3. Repository Layer

- **UserRepository**: Interfaces with the database to perform CRUD operations on user entities.

### 4. Security Layer

- **JwtTokenProvider**: Manages JWT token creation and validation.
- **PasswordEncoder**: Handles password hashing and verification.

### 5. Configuration

- **Application Configuration**: Contains configuration files for database connections, security settings, and other environment-specific variables.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven 3.6+
- A running instance of a database (e.g., MySQL, PostgreSQL)

### Installation and Setup

1. **Clone the repository:**
   ```sh
   git clone https://github.com/shubhamjha55/eComm-UserService-MicroService.git
   cd eComm-UserService-MicroService
   ```

2. **Configure the Application**

   Update the `application.properties` file with your database configurations and other environment-specific settings.

3. **Install dependencies / Build the Project**

   ```sh
   mvn clean install
   ```
4. **Run the application**

  ```sh
   mvn spring-boot:run
   ```


# API Endpoints

- **POST /api/users/register**: Register a new user.
- **POST /api/auth/login**: Authenticate a user and generate a JWT token.
- **POST /api/users/profile/{username}**: Returns the user profile after client assertion check (using JWT token).
- **GET /api/user/{id}**: Retrieve user details by ID.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## Contact

For any inquiries or support, please contact Shubham J.
