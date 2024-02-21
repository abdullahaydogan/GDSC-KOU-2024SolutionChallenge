# Solution Challenge 2024 Project

## Introduction
The Solution Challenge 2024 project is a comprehensive platform designed to address specific challenges and provide effective solutions. This document serves as a guide for developers to understand the project structure, technologies used, and how to set up the development environment.

## Technologies Used
- **Java 17:** Primary programming language.
- **Spring Boot:** Framework for rapid Java application development.
- **Maven:** Project management and build tool.
- **MySQL:** Database management system.
- **IntelliJ IDEA:** Preferred integrated development environment (IDE).
- **Postman:** Tool for API testing and documentation.

## Project Structure
The project follows a modular structure with packages for different components:
- `com.example.demo.user:` User-related classes and operations.
- `com.example.demo.product:` Product-related classes and operations.
- `com.example.demo.auth:` Authentication and authorization components.
- `com.example.demo.configuration:` Project configuration settings.
- `com.example.demo.error:` Custom exception handling and error responses.
- `com.example.demo.shared:` Shared utilities and constants.

## Development Environment Setup
1. **Java 17:** Install Java 17 on your computer. [Download from Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://openjdk.java.net/).
2. **IntelliJ IDEA:** Download and install IntelliJ IDEA from the [official website](https://www.jetbrains.com/idea/).
3. **MySQL:** Install MySQL or use another preferred database management system. [Download MySQL](https://dev.mysql.com/downloads/).
4. **Postman:** Download Postman from [here](https://www.postman.com/downloads/).
5. **Maven:** Ensure Maven is installed. [Download Maven](https://maven.apache.org/download.cgi).
6. **GitHub:** Create a GitHub account for version control and collaboration.

## Setting Up the Project
1. Clone the GitHub repository.
2. Open the project in IntelliJ IDEA.
3. Update the `application.properties` file with your MySQL connection details.
4. Run the project.

## API Endpoints
### User Management
- `POST /api/v1/user/userCreate:` Create a new user.
- `GET /api/v1/user/userList:` Retrieve users with pagination.
- `GET /api/v1/user/userListById/{id}:` Retrieve user by ID.
- `PATCH /api/v1/user/userActivation/{token}/active:` Activate user account.
- `PUT /api/v1/user/userUpdate/{id}:` Update user information.

### Product Management
- `POST /api/v1/product/productSave:` Create a new product.
- `GET /api/v1/product/productList:` Retrieve products.
- `GET /api/v1/product/getproductById/{id}:` Retrieve product by ID.
- `GET /api/v1/product/getProductByTag/{tag}:` Retrieve products by tag.
- `GET /api/v1/product/getProductByCategory/{category}:` Retrieve products by category.
- `GET /api/v1/product/getProductByCity/{city}:` Retrieve products by city.
- `GET /api/v1/product/getProductByTagAndCity/tag/{tag}/city/{city}:` Retrieve products by tag and city.
- `GET /api/v1/product/getProductByCategoryAndTag/category/{category}/tag/{tag}:` Retrieve products by category and tag.
- `GET /api/v1/product/getProductByCategoryAndCity/category/{category}/city/{city}:` Retrieve products by category and city.
- `PUT /api/v1/product/productUpdate/{id}:` Update product information.

### Authentication
- Basic HTTP authentication is implemented.
- Obtain a token by authenticating with the `/api/v1/auth` endpoint.
- Include the obtained token in the headers of secured endpoints.

## Contribution
If you wish to contribute to the project, fork the repository, make changes, and submit a pull request. Refer to the contribution guide for details.

## License
This project is licensed under the MIT license.
