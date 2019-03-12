# Kenzan Employees

### Information
This project utilize a variety of tools like:
- H2 DataBase
- Lombok
- JPA
- SpringBoot
- Spring
- SwaggerUI
- Maven

I use **MVC pattern** to propperly divide each component and have more control over the application flow.
With **Spring** I use *Singleton* and *I can inject* the resources when I require them.

For this example I use the new `LocalDate` and `DateTimeFormatter` to manipulate the dates.
Also I use the `stream` for the list results to can iterate and map from the EntityObj to rhe ResponseObj


### Clon the project
Select a path in your directory and open a Terminal that point to that path, execute the following command:

```
git clone https://github.com/tezka/kenzan-employees.git
cd kenzan-employees
```

### Startup
The app uses in memory H2 database. It creates the required schema and populate the info using the files located at: 

`./src/main/resources/schema.sql` and `./src/main/resources/import.sql`


Please change the `import.sql` file to populate with the desired data in the following format:

```sql
INSERT INTO employee (id,  first_name, middle_name, last_name, date_of_birth, date_of_employment, status) VALUES (1, 'Rene', null, 'Gutierrez Medina', '1981-04-23', '2015-06-18', 'ACTIVE');
```

Considere the dates format in the query must be `YYYY-MM-DD`.




### Build
Follow the next steps to properly run the project:

In the root folder of the project run the commands:

```
mvn clean install
java -jar ./target/kenzan-employees-0.0.1-SNAPSHOT.jar
```

The service should start in `http://localhost:8000/swagger-ui.html`

In the web page you're able to navigate though the operations and use the example provided, click on the `Try it out!` button to run the operation.



### Operations
The list of operations provided by the API:
- create - POST request Provide the EmployeeReq obj
- list - GET request return the complete list of ACTIVE employees
- get - GET request return the employee with the ID provided
- update - PUT request return the Employee data with the new data provided
- delete - DELETE request requires authorization, it change the status of the employee to INACTIVE


### TOKEN
To make the call for authorized users use the following token: `33f8b4dc-93b9-4679-a50d-6c3811c9d015`



