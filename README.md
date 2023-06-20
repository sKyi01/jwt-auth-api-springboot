# jwt-auth-api-springboot

# Project Name
jwt-auth-api-springboot

## Description
This project is a RESTful API built using Spring Boot, JPA (Java Persistence API), and Spring Security. It provides authentication and authorization using JWT (JSON Web Tokens) for securing the API endpoints. Additionally, it includes functionalities for user verification by tokens, resend verification token by using old token, password verification, password reset, and password change using tokens or user email and old password.

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
   git clone https://github.com/sKyi01/jwt-auth-api-springboot
  
2. Build the project using Maven:
   mvn clean install
   
3. Run the application:
   mvn spring-boot:run

The application will be accessible at http://localhost:1234.

## Configuration
The following configuration files can be found in the project:
- `application.yml`: Contains general application configuration properties.

## Usage
1. Register a new user using the `/api/register` endpoint.
2. Verify user using the token `/api/verifyRegistration` endpoint.
3. Use the obtained token in the `Authorization` header for subsequent API requests.
4. Reset password using the `/api/resetPassword` endpoint, providing either the reset token or the user's email.
6. Change password using the `/api/changePassword` endpoint, providing either the change token or the user's email and old password.

## Contributing
Contributions are welcome! If you have any ideas, improvements, or bug fixes, please open an issue or submit a pull request.

## License
This project is licensed under the MIT License.

## Acknowledgements
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- JPA (Java Persistence API)


