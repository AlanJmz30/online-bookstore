
# Online Bookstore API

An API to manage a book inventory, calculate prices based on book types, and track customer loyalty points.

## Technologies

- Java 11
- Spring Boot
- H2 (in-memory database)
- Maven

## Features

- Manage book inventory
- Book purchase and price calculation
- Track customer loyalty points

## Installation

1. Clone the repository:

```bash
git clone https://github.com/AlanJmz30/online-bookstore.git
```

2. Navigate to the project folder:

```bash
cd online-bookstore
```

3. Install dependencies:

```bash
mvn install
```

4. Run the application:

```bash
mvn spring-boot:run
```

## API Usage

- **GET /books**: Returns the books available in the inventory
- **POST /purchase**: Makes a purchase
- **GET /loyalty-points/{customerId}**: Checks loyalty points for a customer

## License

This project is licensed under the MIT License.
