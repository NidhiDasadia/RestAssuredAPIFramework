# REST API Automation Framework

A comprehensive REST API testing framework built with Rest Assured, Cucumber BDD, and JUnit for validating Google Maps Place APIs.

## Technologies Used

- **Java** - Programming language
- **Rest Assured 6.0.0** - REST API testing library
- **Cucumber 7.16.1** - BDD framework for writing test scenarios
- **JUnit 5.10.2** - Testing framework
- **Maven** - Build and dependency management
- **Jackson Databind** - JSON serialization/deserialization
- **Groovy 3.0.25** - For JSON path assertions

## Project Structure

```
APIFramework/
├── src/test/java/
│   ├── features/          # Cucumber feature files
│   ├── stepDefination/    # Step definition classes
│   ├── pojo/              # Plain Old Java Objects for request/response
│   ├── resources/         # Reusable utility classes
│   └── cucumber/          # Test runner configuration
└── pom.xml
```

## Test Scenarios Covered

### Place API Validations
- **Add Place API** - Verify place creation with dynamic data (name, language, address)
- **Get Place API** - Validate place retrieval and verify created place details
- **Delete Place API** - Verify place deletion functionality

### Features
- Data-driven testing using Cucumber Examples
- Parameterized scenarios for multiple test data sets
- End-to-end API workflow validation
- Response validation (status codes, response body fields)
- Regression test suite with tags (@AddPlace, @DeletePlace, @Regression)

## Prerequisites

- Java 8 or higher
- Maven 3.6+
- IDE (Eclipse/IntelliJ IDEA)

## Setup Instructions

1. Clone the repository
```bash
git clone <repository-url>
cd APIFramework
```

2. Install dependencies
```bash
mvn clean install
```

3. Update API endpoints in resource files if needed

## Running Tests

Execute all tests:
```bash
mvn test
```

Run specific tags:
```bash
mvn test -Dcucumber.filter.tags="@Regression"
```

Run specific feature:
```bash
mvn test -Dcucumber.filter.tags="@AddPlace"
```

## Test Reports

After test execution, Cucumber reports are generated in:
- `target/cucumber-reports/` - HTML reports
- `target/jsonReports/` - JSON reports

View detailed reports:
```bash
mvn verify
```
Reports will be available at `target/cucumber-html-reports/overview-features.html`

## Key Features

- **BDD Approach** - Human-readable test scenarios
- **Reusable Components** - Modular step definitions and utilities
- **Data-Driven Testing** - Scenario outlines with multiple data sets
- **Comprehensive Reporting** - Cucumber HTML reports with test execution details
- **API Chaining** - Tests validate complete workflows (Add → Get → Delete)

## Author

Nidhi Dasadia
