# ToDo Web App

A simple ToDo web application built with Spring Boot, Bootstrap, and Spring Security.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This web application allows users to manage their ToDo tasks. Users can add, update, and delete tasks. Authentication is implemented using Spring Security to secure the application.

## Features

- User authentication with Spring Security.
- Add new ToDo tasks.
- Update and delete existing ToDo tasks.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or later
- Maven
- Your preferred IDE (e.g., IntelliJ, Eclipse)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/todo-web-app.git
   
2. Navigate to the project directory:

   ```bash
   cd todo-web-app
   
3. Build the project:

   ```bash
   mvn clean install
   
## Usage

1. Run the application:

   ```bash
   java -jar target/todo-web-app-1.0.0.jar
   
2. Access the application in your web browser:

   ```bash
   http://localhost:8080

## Project Structure

  The project follows the standard Spring Boot project structure:

    ```bash
    src
      |-- main
        |-- java
            |-- com.example.todo
                |-- controller
                |-- model
                |-- repository
                |-- security
                |-- service
        |-- resources
            |-- static
            |-- templates
        |-- Webapp

## Technologies Used

- Spring Boot
- Spring Security
- Thymeleaf
- Bootstrap

## Contributing

Feel free to contribute by opening issues or submitting pull requests. For major changes, please open an issue first to discuss the proposed changes.

## License

This project is licensed under the MIT License - see the [LICENSE]() file for details.















