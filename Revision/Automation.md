# Questions on Automation

## Selenium Basics

1. What is Selenium and its components?

> - Selenium is an open-source automation testing tool for web applications across different browsers and platforms.
>- Components:
>> - Selenium IDE – A browser extension for record-and-playback.
>>- Selenium WebDriver – Automates browser actions using programming languages.
>>- Selenium Grid – Executes tests on multiple machines/browsers in parallel.
>>- Selenium RC (Remote Control) – Deprecated, used to support multiple languages before WebDriver.

2. What is webdriver and how does it work?

> - WebDriver is an interface in Selenium that directly communicates with the browser to automate actions like clicking,
    typing, and navigating.
>- How it works:
>> - Sends HTTP requests to the browser driver (e.g., ChromeDriver).
>>- The driver interacts with the browser using its native API.
>>- Browser performs actions and sends the response back.

3. What are locators in Selenium?

> - Locators are strategies to identify web elements on a page.
>- Common types:
>> - id
>>- name
>>- className
>>- tagName
>>- linkText / partialLinkText
>>- cssSelector
>>- xpath

4. Difference between findElement() and findElements()?

| Feature   | `findElement()`                              | `findElements()`                             |
|-----------|----------------------------------------------|----------------------------------------------|
| Returns   | Single `WebElement`                          | List of `WebElement`                         |
| Exception | Throws `NoSuchElementException` if not found | Returns empty list                           |
| Usage     | Use when expecting one element               | Use when expecting multiple or zero elements |

5. How do you handle dropdowns in Selenium?

> Use the `Select` class for `<select>` HTML tags:  
> If the dropdown is done using the usual \<Select> element, you can use select class with the identified element, then
> select the options using visible text, value, or index.

```java
//Sample Code  

Select dropdown = new Select(driver.findElement(By.id("dropdownId")));  
dropdown.selectByVisibleText("Option"); 
dropdown.selectByIndex(1); 
dropdown.selectByValue("value");
```

6. How do you handle alerts/popups?

> Use `Alert` Interface

```java
//Sample Code

Alert alert = driver.switchTo().alert();  
alert.accept(); // OK
alert.dismiss(); // Cancel
alert.getText(); // Get message
alert.sendKeys("text"); // Enter text if prompt
```

7. How do you perform mouse hover or drag and drop?

> Use `Actions` class:

```java
//Sample Code

Actions actions = new Actions(driver);

// Hover
actions.moveToElement(driver.findElement(By.id("element"))).

perform();

// Drag and drop
WebElement source = driver.findElement(By.id("source"));
WebElement target = driver.findElement(By.id("target"));
actions.dragAndDrop(source, target).perform();
```

8. How do you manage dynamic elements?

> Approaches:
>- Use dynamic XPath or CSS Selectors (e.g., `contains()`, `starts-with()`).
>- Introduce waits (explicit waits).
>- Look for stable parent/child structure.

```java
//Sample Code
        
driver.findElement(By.xpath("//div[contains(@class, 'item') and text()='Text']"));
```

9. What is implicit wait and explicit wait?

> - Implicit Wait: Waits globally for elements to appear

```java
//Sample for Implicit Wait

driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
```

> - Explicit Wait: Waits for a specific condition

```java
//Sample for Explicit Wait

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element")));
```

10. How to take a screenshot in Selenium?

```java
//Sample Code

File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(src, new File("path/to/save/screenshot.png"));
```

> *Note: (Requires `org.apache.commons.io.FileUtils`)

## Selenium Advanced

1. What is Page Model Object(POM)?

> Page Object Model (POM) is a design pattern in Selenium that enhances test maintenance and reduces code duplication by
> separating page structure and test logic.
> - Each web page is represented by a class.
> - Page elements are defined as variables.
> - Actions are written as methods.

```java
//Sample Code

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "username")
    WebElement userField;

    @FindBy(id = "password")
    WebElement passField;

    @FindBy(id = "login")
    WebElement loginButton;

    public void login(String user, String pass) {
        userField.sendKeys(user);
        passField.sendKeys(pass);
        loginButton.click();
    }
}

```

2. What is a headless browser?

> A headless browser is a browser that runs without a GUI. It's useful for faster, automated testing where visual UI
> interaction isn't necessary.
>
>Examples:
>- Headless Chrome
>- Headless Firefox
>- HtmlUnitDriver (deprecated)

```java
//Sample Code:

ChromeOptions options = new ChromeOptions();
options.addArguments("--headless");

WebDriver driver = new ChromeDriver(options);
```

3. How do you run tests in parallel?

> You can run tests in parallel using TestNG or Selenium Grid.  
> Using TestNG:

```xml

<suite name="ParallelTests" parallel="tests" thread-count="2">
    <test name="Test1">...</test>
    <test name="Test2">...</test>
</suite>
```

> Using Selenium Grid:
>- Start Hub and Nodes
>- Distribute test execution across nodes

4. How to handle file upload/download?

> File Upload:

```java
driver.findElement(By.id("upload")).sendKeys("C:\\path\\file.txt");
```

> File download
>- Set download preferences in browser profile.
>- Use tools like AutoIT or Robot class if native dialog is used.
>- Depends on situation

5. How do you handle iFrames?

> Switch to iframe using:

```java
driver.switchTo().frame("frameName"); // by name or ID
driver.switchTo().frame(0);           // by index
driver.switchTo().frame(element);     // by WebElement
```

> Return to main content

```java
driver.switchTo().defaultContent();
```

6. How do you generate reports in Selenium?

> Use frameworks like:
> - TestNG Reports (default HTML reports)
> - ExtentReports for advanced and visually rich reports
> - Allure Reports

```java
// Extent report example

ExtentReports report = new ExtentReports("report.html", true);
ExtentTest test = report.startTest("Login Test");
test.log(LogStatus.PASS, "Login successful");
report.endTest(test);
report.flush();
```

7. How do you connect selenium with Excel or database?

> Excel:  
> Use Apache POI:

```java
FileInputStream fis = new FileInputStream("data.xlsx");
Workbook wb = new XSSFWorkbook(fis);
String data = wb.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
```

> Database:
> Use JDBC (Depends on the DB the team is using might be Azure etc...)

```java
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "pass");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM table");
```

8. Can selenium test desktop apps? Why/why not?

> ❌ No, Selenium cannot test desktop apps.
> Reason:
> Selenium is designed only for automating web applications. It interacts with browsers using WebDriver.
>
> ✅ Alternatives for desktop testing:
> - WinAppDriver
> - AutoIT
> - Sikuli

9. What is the difference between Junit and TestNG?

   | Feature        | JUnit                      | TestNG                                       |
      | -------------- | -------------------------- | -------------------------------------------- |
   | Annotations    | Fewer (`@Before`, `@Test`) | Rich (`@BeforeClass`, `@DataProvider`, etc.) |
   | Parallel Tests | Not supported well         | Supported                                    |
   | Dependencies   | No                         | Yes (`dependsOnMethods`)                     |
   | Reporting      | Basic                      | Detailed XML/HTML                            |

10. How do you run tests from command line? 
> Using Maven:
> ```mvn test```  
> Using TestNG XML:  
> ```java -cp "path/to/jars/*" org.testng.TestNG testng.xml```  
> Using JUnit:  
> ```java -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore YourTestClass```
## API Testing

1. What is API testing?

> API Testing involves testing the logic, reliability, security, and performance of Application Programming Interfaces (
> APIs). It checks if APIs return the correct responses for various requests under different conditions.
>
> Focus areas:
>- Response status codes
>- Response body and headers
>- Data accuracy
>- Authentication
>- Error messages and performance

2. Difference between SOAP and REST?

   |Feature|	SOAP|	REST| 
   |----|---|---|
   |Protocol|	Uses only XML via HTTP, SMTP, etc.	|Uses HTTP with multiple formats (JSON, XML)|
   |Format	|XML only	|JSON (commonly), XML, text, etc.|
   |Interface Style|	Strict contract via WSDL|	Loose and flexible|
   |Performance|	Slower due to XML overhead|	Faster and lighter|
   |Standards|	Strict WS-* standards	|Simpler and uses HTTP verbs|
3. Does RESTAPI only return JSON?
> No, REST APIs can return multiple formats depending on the Content-Type or Accept header, such as:  
>- application/json 
>- application/xml 
>- text/plain 
>- text/html 
>- JSON is just the most commonly used.
4. What tools do you use for API testing?
> **Used before:**  
> Postman – Manual testing and automation with collections.  
> JMeter – Load testing APIs.  
> 
> **Not Used:**  
> REST Assured – Java-based automation framework.  
> SoapUI – For SOAP and REST testing.  
> Karate DSL – BDD-style API testing.  
> cURL – Command-line based quick testing. 
> Newman – CLI to run Postman collections.
5. How do you validate API response codes and data?
> Response Code:
```java
assertEquals(response.getStatusCode(), 200);
```
> Response Body:
```java
assertEquals(response.jsonPath().get("name"), "John");
```
> Headers:
```java
assertEquals(response.getHeader("Content-Type"), "application/json");
```
6. What is JSON schema validation?
> JSON Schema Validation checks if a JSON response adheres to a defined structure (schema), including:
> - Data types 
> - Required fields 
> - Value constraints
```java
// Example using REST Assured
given()
.when()
.get("/user")
.then()
.body(matchesJsonSchemaInClasspath("user_schema.json"));

```
7. How do you test secured APIs with tokens?
> 1. Obtain token via login or OAuth request.
> 2. Attach token in headers:
```
given()
.header("Authorization", "Bearer " + token)
.get("/secure-api");
```
8. How do you test negative scenarios in API?
> Test invalid inputs and edge cases, such as:
> - Wrong HTTP method (e.g., GET instead of POST)
> - Missing or invalid parameters 
> - Unauthorized access 
> - Malformed JSON  
```java
// Example
assertEquals(response.getStatusCode(), 400); // Bad Request
assertTrue(response.getBody().asString().contains("Invalid email"));
```
9. What is throttling and rate limiting?
> Throttling: Controls the rate of API requests to avoid overloading the server. 
> Rate Limiting: Restricts the number of requests per user/IP in a given time.
> Common Headers:
> - X-RateLimit-Limit 
> - X-RateLimit-Remaining 
> - Retry-After
10. How do you automate API Testing using Java?
> Using REST Assured:
```java
import io.restassured.RestAssured;
import io.restassured.response.Response;

Response response = RestAssured.get("https://api.example.com/users");
assertEquals(response.getStatusCode(), 200);
```
> You can integrate REST Assured with:
> - TestNG or JUnit for test structure 
> - Maven for dependency management 
> - Jenkins for CI automation


11. What is the difference between postman and automated API scripts?

    |Feature	|Postman	|Automated Scripts (e.g. REST Assured)|
    |---|---|---|
    |Nature	|Manual & Semi-automated	|Fully automated|
    |Execution	|GUI or CLI (via Newman)|	Runs via test runners (JUnit/TestNG)|
    |Best for	|Exploratory & functional tests	|CI/CD, regression, data-driven testing|
    |Maintenance	|Harder to version control	|Easy with Git|
    |Scalability	|Limited	|High (supports loops, logic, frameworks)|

## CICD, Frameworks and Real-time

1. What is a test automation framework

> A Test Automation Framework is a structured set of guidelines and tools to create, manage, and execute automated tests
> efficiently.
> Features:
> - Reusability of code
> - Better maintainability
> - Separation of test logic and test data
> - Reporting and logging mechanisms
>
> Examples:
> - Data-Driven Framework
> - Keyword-Driven Framework
> - Hybrid Framework
> - Behavior-Driven Development (BDD)

2. What is a hybrid framework

> A Hybrid Framework is a combination of two or more testing frameworks to leverage their strengths.
>
> Example:
> Combining:
> - Data-Driven (test data from Excel or CSV)
> - Keyword-Driven (keywords define actions)
> - Page Object Model (reusable page logic)
>
> Benefits: Flexible, scalable, and easier to maintain.

3. What is BDD? Explain with examples

> BDD (Behavior-Driven Development) is a testing approach where tests are written in a human-readable format using a
> common language (usually English), typically with tools like Cucumber or Behave.
> Structure: Given, When, Then
```gherkin
Feature: Login functionality

  Scenario: Successful login
    Given user is on login page
    When user enters valid username and password
    Then user should be redirected to dashboard
```
```java
@Given("user is on login page")
public void userIsOnLoginPage() { ... }

@When("user enters valid username and password")
public void enterCredentials() { ... }

@Then("user should be redirected to dashboard")
public void verifyDashboard() { ... }
```

4. What is Jenkins and how is it used for automation?

> Jenkins is an open-source automation server used for Continuous Integration (CI) and Continuous Delivery (CD).
>
> Uses:
> - Trigger tests automatically on code changes
> - Build, test, and deploy applications
> - Schedule jobs and generate reports
>
> Typical Use in Automation:
> -Set up a Jenkins job to pull code from Git
> Compile and run automation scripts
> Publish test reports (e.g., Allure, Extent)

5. What is Git and how do you manage code versions?

> Git is a distributed version control system used to track changes in source code during software development.
>
> Basic Commands:
> - `git clone` – Copy repository
> - `git status` – View changes
> - `git add` – Stage changes
> - `git commit` – Save changes locally
> - `git push` – Upload changes to remote repo
> - `git pull` – Fetch latest changes
>
> Version Management:
> - Use branches (feature, bugfix, main)
> - Merge via Pull Requests
> - Tag releases (e.g., v1.0.0)

6. How do you trigger automation after every build?

> Using Jenkins:
> - Configure Jenkins to monitor the repository.
> - Use webhooks (e.g., from GitHub/GitLab/Bitbucket).
> - After every commit/push:
>> - Jenkins pulls the code
>> - Builds the project
>> - Runs the automation test suite
```groovy
pipeline {
  stages {
    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
  }
}
```

7. What are some common challenges in automation?

> - Flaky tests (fail randomly)
> - Dynamic elements or changing DOM
> - Environment issues (e.g., different configs)
> - Test data management
> - Slow execution time
> - Poorly designed locators
> - Lack of skilled resources or framework maintenance

8. When should you not automate a test case?

> Avoid automation when:
> - Test case is run only once
> - UI is unstable or under frequent change
> - Requires human judgment (visual, UX)
> - Test is too complex or costly to automate
> - Time constraints demand faster manual test

9. How do you identify flaky tests and fix them?

> Identifying:
> - Fails inconsistently with the same code
> - Check logs and test history
> - Monitor failed builds
>
> Fixing:
> - Add proper waits (explicit, not thread.sleep)
> - Avoid shared/global state between tests
> - Stabilize environment and test data
> - Retry failed tests only when justified

10. What’s your approach to maintaining large automation suites?

> Use Page Object Model (POM) for modularity
> Apply naming conventions and standards
> Split tests into suites (smoke, regression, etc.)
> Automate reports with Allure/Extent
> Use CI tools (Jenkins, GitLab CI) for scheduled runs
> Regularly review and refactor tests
> Archive and clean up unused scripts
