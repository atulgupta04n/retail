# Retail store application
This application is a retail website offering different discounts to different types of user.

## Working
This application uses chain of responsibility design pattern and factory design pattern.
In the Discount Handler Config, discount handler chain is created with first the percentage discount calculator and then
nextHandler is marked as flatDiscountCalculator. 
The Bill class provides the method getAmountPayable(), and autowires this discountHandler to calculate the percentageDiscount
and then the flatDiscount.
In PercentageDiscountHandler class, percentage discount is calculated on non grocery items using factory design pattern,
where different discount is given based on the userType(Employee, Affiliate or Customer).

Eg of discount:
UserType: EMPLOYEE
Item1: non-grocery Laptop 500
Item2: Grocery Apple 200
Total amount: 700
Percentage discount on non grocery: 30% of 500 = 150
Flat discount =  Total amount/100*5 = 700/100*5 = 35
Payable amount = 700 - 150 - 35 = 515

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

