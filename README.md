I have used java 17 version and maven 4.0.0 version and postgre sql.

In case you want to change the database just change the dependency over the POM.XML and add the maven dependency like mysql connector in place of postgresql.
And also make relative changes in application.properties file inside resources.

for mysql just replace postgresql dependency with this dependency and provide the relative version.
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>{version}</version>
</dependency>

replace application.properties with these if using mysql making suitable changes 
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect



The Api's endpoint are :-

POST
{BaseURL}/api/customer/save         --> to add a new customer in DB  you need to pass these details in header.
{
    "firstName": "String",
    "lastName": "String",
    "email": "String",
    "password": "String"
}

GET
{BaseURL}/api/customer/id         --> to find the customer using id just replace the id with and integer value


 GET
 {BaseURL}/api/customer/findAll    --> to get all the customer that are in db.

 PUT
 {BaseURL}/api/customer/update/id    --> to update the customer here as well you need to pass the details over header.
 {
    "firstName": "String",
    "lastName": "String",
    "email": "String",
    "password": "String"
}

DELETE
{BaseURL}/api/customer/delete/id    --> to delete a value from db on the basis of id just replcae id by integer.


# API Endpoints

## Add a New Customer
- **Method:** POST  
- **Endpoint:** `{BaseURL}/api/customer/save`  
- **Description:** Add a new customer to the database.  
- **Request Payload:** JSON  
    ```json
    {
        "firstName": "String",
        "lastName": "String",
        "email": "String",
        "password": "String"
    }
    ```
- **Response Status Codes:**  
    - HttpStatus : CREATED in case of success.
    - HttpStatus : BAD_REQUEST in case of error.

## Get Customer by ID
- **Method:** GET  
- **Endpoint:** `{BaseURL}/api/customer/{id}`  
- **Description:** Retrieve a customer by their ID. Replace `{id}` with the customer's ID.  
- **Response Status Codes:**  
    - 200 OK: Customer found
    - HttpStatus : NOT_FOUND in case of error.

## Get All Customers
- **Method:** GET  
- **Endpoint:** `{BaseURL}/api/customer/findAll`  
- **Description:** Retrieve all customers in the database.  
- **Response Status Codes:**  
    - 200 OK: Customer found
    - HttpStatus : NOT_FOUND in case of error.
## Update Customer
- **Method:** PUT  
- **Endpoint:** `{BaseURL}/api/customer/update/{id}`  
- **Description:** Update an existing customer's details. Replace `{id}` with the customer's ID.  
- **Request Payload:** Same as the "Add a New Customer" endpoint  
- **Response Status Codes:**  
    - HttpStatus : CREATED in case of success.
    - 404 Not Found: Customer not found or BAD_REQUEST in case of error.

## Delete Customer
- **Method:** DELETE  
- **Endpoint:** `{BaseURL}/api/customer/delete/{id}`  
- **Description:** Delete a customer from the database. Replace `{id}` with the customer's ID.  
- **Response Status Codes:**  
    - 200 OK: Customer found
    - HttpStatus : NOT_FOUND in case of error.

 
