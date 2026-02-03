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
├── src/
│   ├── main/
│   │   ├── java/                          # Main source code (if any)
│   │   └── resources/                     # Main resources
│   └── test/
│       ├── java/
│       │   ├── cucumber/
│       │   │   └── Options/
│       │   │       └── TestRunner.java    # Cucumber test runner with tags and plugins
│       │   ├── features/
│       │   │   └── placeValidations.feature  # BDD scenarios for Place APIs
│       │   ├── pojo/
│       │   │   ├── AddPlace.java          # Request POJO for Add Place API
│       │   │   └── Location.java          # Location object for coordinates
│       │   ├── resources/
│       │   │   ├── APIResources.java      # Enum for API endpoints and HTTP methods
│       │   │   ├── TestDataBuild.java     # Builder class for test data/payloads
│       │   │   ├── Utils.java             # Utility methods (API calls, JSON parsing)
│       │   │   └── global.properties      # Configuration (base URL, endpoints)
│       │   └── stepDefination/
│       │       ├── Hooks.java             # Cucumber hooks (Before/After scenarios)
│       │       └── StepDefination.java    # Step definitions for feature files
│       └── resources/                     # Test resources
├── target/                                # Build output directory
│   ├── cucumber-reports/                  # Generated test reports
│   └── jsonReports/                       # JSON format reports
├── pom.xml                                # Maven configuration and dependencies
├── .gitattributes                         # Git language detection configuration
└── README.md                              # Project documentation
```

### Key Components

**Feature Files** (`features/`)
- Contains Gherkin scenarios for API testing
- Scenario outlines with data tables for parameterized testing

**POJO Classes** (`pojo/`)
- Java objects for request/response serialization
- Used with Jackson for JSON conversion

**Resources** (`resources/`)
- `APIResources.java` - Centralized API endpoint management
- `TestDataBuild.java` - Dynamic test data creation
- `Utils.java` - Reusable methods for API requests and validations
- `global.properties` - Environment configuration

**Step Definitions** (`stepDefination/`)
- Implementation of Gherkin steps
- Hooks for setup and teardown operations

**Test Runner** (`cucumber/Options/`)
- Configures Cucumber execution
- Defines report formats and tag filters

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
