# Book Management System

This is a simple Book Management System built using Spring Boot.

## Features

- Add new books
- View existing books
- Edit book details
- Delete books

## Technologies Used

- Spring Boot
- Thymeleaf
- MySQL

## Prerequisites

- Java 11 or later
- MySQL installed and running locally
- Gradle

## Getting Started

1. Clone the repository:

git clone https://github.com/Kasweka1/BookAppInterviewQuestionSpringBoot.git

2. Navigate to the project directory:

cd BookApp

3. Open `src/main/resources/application.properties` and configure your MySQL username and password:

spring.datasource.url=jdbc:mysql://localhost:3306/book_db?useSSL=false
spring.datasource.username=your-username
spring.datasource.password=your-password

4. Run the application:

./gradlew bootRun


5. Open your browser and go to [http://localhost:8080](http://localhost:8080) to view the application.

## Usage

- To add a new book, click on the "Add Book" button and fill out the form.
- To view all books, go to [http://localhost:8080/books](http://localhost:8080/books).
- To edit a book, click on the "Edit" button next to the book you want to edit.
- To delete a book, click on the "Delete" button next to the book you want to delete.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
