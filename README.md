# Retail store application
This application is a retail website offering different discounts to different types of user.

## Project Overview
This project is a retail store discount calculator implemented using Spring Boot. The application calculates the net payable amount for a bill by applying various discounts based on user type and the nature of items in the bill. The design leverages the Chain of Responsibility and Factory design patterns to achieve flexibility and scalability.

## Working
This application uses the Chain of Responsibility design pattern and the Factory design pattern.

- In the `DiscountHandlerConfig`, the discount handler chain is created with the first handler being the `PercentageDiscountHandler`, followed by the `FlatDiscountHandler`.
- The `Bill` class provides the method `getAmountPayable()` and autowires this discountHandler to calculate the percentage discount and then the flat discount.
- In the `PercentageDiscountHandler` class, the percentage discount is calculated on non-grocery items using the Factory design pattern, where different discounts are given based on the `UserType` (Employee, Affiliate, or Customer).

### Example of Discount Calculation
**UserType:** EMPLOYEE  
**Item1:** non-grocery Laptop 500  
**Item2:** Grocery Apple 200  
**Total amount:** 700

**Calculations:**
- **Percentage discount on non-grocery:** 30% of 500 = 150
- **Flat discount:** Total amount/100 * 5 = 700/100 * 5 = 35
- **Payable amount:** 700 - 150 - 35 = 515

UML:
![UML.jpeg](UML.jpeg)


## Requirements
- Java 17 or higher
- Maven

## Running the Application
1. Clone the repository:
    ```bash
    git clone https://github.com/atulgupta04n/retail.git
    ```
2. Navigate to the project directory:
    ```bash
    cd retail
    ```
3. Build the project:
    ```bash
    mvn clean install
    ```
4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## Running Tests
1. Navigate to the project directory:
    ```bash
    cd retail
    ```
2. Run the tests:
    ```bash
    mvn test
    ```


## Conclusion
This project demonstrates the use of Chain of Responsibility and Factory design patterns to create a flexible and maintainable discount calculation system for a retail store. It includes comprehensive unit tests to ensure the correctness of the discount calculations.
