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
- MariaDB

## Prerequisites

- Java 11 or later
- MariaDB installed and running locally
- Gradle

## Getting Started

1. Clone the repository:

git clone https://github.com/Kasweka1/BookRestFulApi-Spring.git

2. Navigate to the project directory:

cd BookApp

3. Open `src/main/resources/application.properties` and configure your MariaDB username and password:

- spring.datasource.url=jdbc:mariaDB://localhost:3306/book_db?useSSL=false
- spring.datasource.username=your-username
- spring.datasource.password=your-password

4. Checkout to the Scheduler branch:
    `git checkout scheduler`

5. From the project root directory, run:
    ` ./install_node_dependencies`

6. Run the application:

./gradlew bootRun

7. Run the cors server:
    ` ./start_cors_server`

8. Start the scedule:
    ` ./start_scedule`


9. Open your browser and go to [http://localhost:8080](http://localhost:8080) to view the application.

## Usage

- To add a new book, click on the "Add Book" button and fill out the form.
- To view all books, go to [http://localhost:8080/books](http://localhost:8080/books).
- To edit a book, click on the "Edit" button next to the book you want to edit.
- To delete a book, click on the "Delete" button next to the book you want to delete.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
