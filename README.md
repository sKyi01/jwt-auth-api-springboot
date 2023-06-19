# jwt-auth-api-springboot

# Project Name
REST API with Spring Boot, JPA, and Spring Security

## Description
This project is a RESTful API built using Spring Boot, JPA (Java Persistence API), and Spring Security. It provides authentication and authorization using JWT (JSON Web Tokens) for securing the API endpoints. Additionally, it includes functionalities for user verification, password verification, password reset, and password change using tokens or user email and old password.

## Features
- User registration
- User login
- User verification via email
- Password reset using token or user email
- Password change using token or user email and old password
- Secure API endpoints with authentication and authorization using JWT

## Technologies Used
- Java 8+
- Spring Boot
- Spring Security
- JPA (Java Persistence API)
- JWT (JSON Web Tokens)

## Installation
1. Clone the repository:
   git clone https://github.com/your_username/your_project.git

2. Change directory:
   cd your_project
  
3. Build the project using Maven:
   mvn clean install
   
4. Run the application:
   mvn spring-boot:run

The application will be accessible at http://localhost:8080.

## Configuration
The following configuration files can be found in the project:
- `application.properties`: Contains general application configuration properties.
- `security.properties`: Contains security-related configuration properties.
- `database.properties`: Contains database-related configuration properties.

Ensure that you modify these files as per your requirements, such as database connection settings, token expiration times, etc.

## API Documentation
The API documentation can be found at http://localhost:8080/swagger-ui.html after starting the application. It provides detailed information about each endpoint, their request/response formats, and required authentication/authorization.

## Usage
1. Register a new user using the `/api/register` endpoint.
2. Log in using the `/api/login` endpoint to obtain an authentication token.
3. Use the obtained token in the `Authorization` header for subsequent API requests.
4. Verify user email using the `/api/verify-email` endpoint.
5. Reset password using the `/api/reset-password` endpoint, providing either the reset token or the user's email.
6. Change password using the `/api/change-password` endpoint, providing either the change token or the user's email and old password.

## Contributing
Contributions are welcome! If you have any ideas, improvements, or bug fixes, please open an issue or submit a pull request.

## License
This project is licensed under the MIT License.

## Acknowledgements
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- JPA (Java Persistence API)


