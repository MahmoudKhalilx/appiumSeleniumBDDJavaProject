# Appium BDD Java Project

## Project Overview
This project is a mobile test automation framework built using **Appium** for mobile application testing and **Cucumber** for Behavior-Driven Development (BDD). The framework supports both Android and iOS platforms, with tests written in Gherkin language for easy collaboration and understanding.

## Features
- **Cross-Platform Testing:** Supports both Android and iOS devices/emulators.
- **BDD with Cucumber:** Write test scenarios in Gherkin language for better readability and collaboration.
- **Parallel Execution:** Run tests on multiple devices or emulators concurrently.
- **Page Object Model:** Maintainable and scalable test automation with POM design.
- **Data-Driven Testing:** Manage test data using external files like JSON, Excel, or CSV.
- **Configuration Management:** Centralized configuration using properties files for flexibility.

## Project Structure
- **src/test/java:** Contains the step definitions, hooks, and test runners, the feature files written in Gherkin, and configuration properties files.
- **target:** Stores compiled test results, logs, and other artifacts generated during test execution.

Note : Update the config.properties file with necessary configurations, such as platform type, device name, app path, etc.
