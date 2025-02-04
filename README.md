# QA Engineer Test-Insider Task
This task involves three different types of QA testing: UI Automation Testing, Load Testing, and API Testing. Each framework is designed to validate different aspects of the system using appropriate tools and methodologies.


# InsiderUI_Test
- This framework is about UI Automation Testing
- I started my work by analyzing document
- Then I created my scenarios, and I executed them manually tests
- After that I wrote my test scripts with the POM approach using Selenium-Java..
- Framework supports different browser execution with using configuration.properties file
- Tools : Java, Selenium, TestNG

###  Verify Insider Home Page & "Careers" Page from the "Company" Menu:
```bash
Step 1: Launch the browser and navigate to https://useinsider.com/.
Step 2: Check the page title and verify that it contains the word "Insider".
Step 3: Click on the "Company" menu.
Step 4: Click on the "Careers" option.
Step 5: Verify that the Careers page is opened.
Step 6: Check that the "Locations", "Teams", and "Life at Insider" blocks are displayed.
```
### Filter QA Jobs and Verify Job List, Details 
```bash
Step 1: Navigate to https://useinsider.com/careers/quality-assurance/.
Step 2: Click on the "See all QA jobs" button.
Step 3: Filter jobs by "Location: Istanbul, Turkey" and "Department: Quality Assurance".
Step 4: Verify that the job list is displayed.
Step 5: Check each job in the list:
  Position: Must contain "Quality Assurance".
  Department: Must contain "Quality Assurance".
  Location: Must contain "Istanbul, Turkey".
```
### Verify "View Role" Button Redirects to Lever Application Form
```bash
Step 1: Click the "View Role" button for any job.
Step 2: Verify that the user is redirected to the Lever Application form page.
```
# Load_Test
- First, I read and analyzed the requirements.
- I created my test scenarios and executed manual tests.
- After that, I designed my test plan using JMeter.
- Test steps: The test includes homepage load testing and search request testing.
- Validations: HTTP response codes and response times were checked to evaluate test results.
- Used Components: such as User Defined Variables, HTTP Header Manager & Cookie Manager, Assertions
- Tools: JMeter

```bash
Scenario 1 : Verify that the Homepage response status code is 200. 
Scenario 2 : Search for "kulaklık" and measure if the response time is less than 2 seconds. 
Scenario 3 : Search for "kulaklık" and verify that the correct search results are displayed.
```

# Petstore_API_Test
- This framework is about Backend Automation Testing
- I started my work by analyzing API document
- Then I created my scenarios, and I executed them manually on Postman
- After this I wrote my test scripts by using RestAssured-Java.
- Framework supports parallel execution and data-driven testing
- Tools : Postman, Maven, Java, RestAssured, TestNG, Apache POI
## Following scenarios are executed in this framework and failed ones are declared.


### Create User Scenarios:
```bash
Scenario 1 : Create a new pet with valid information successfully (Positive Scenario)
Scenario 2 : Create a new pet with invalid Id type (Negative Scenario)
Scenario 3 : Create a new pet without picture(Negative Scenario)
            FAILED : User should not be created without picture
```
### Update User with PUT Request Scenarios:
```bash
Scenario 1 : Update a pet data by ID successfully(Positive Scenario) 
Scenario 2 : Update a pet's data without existing ID (Negative Scenario)
FAILED : User should not be update pet's data without existing ID
```
### Get User Data Scenarios:
```bash
Scenario 1 : Get a pet data by ID successfully(Positive Scenario) 
Scenario 2 : Get a pet data by invalid ID type (Negative Scenario)
```
### Delete User Data Scenarios:
```bash
Scenario 1 : Delete a pet with valid id number(Positive Scenario) 
Scenario 2 : Delete a pet that is nonexistent(Negative Scenario)
Scenario 3 : Delete a pet with invalid id numbers(Negative Scenario)
```
