# Spring Boot Microservices Workspace
=====================================

This workspace contains a collection of Spring Boot microservices that demonstrate best practices for building scalable and maintainable applications.

## Table of Contents
-----------------

* [Introduction](#introduction)
* [Microservices](#microservices)
* [Getting Started](#getting-started)
* [Build and Run](#build-and-run)
* [API Documentation](#api-documentation)
* [Troubleshooting](#troubleshooting)
* [Contributing](#contributing)
* [License](#license)

## Introduction
------------

This workspace is designed to provide a starting point for building Spring Boot microservices. Each microservice is a separate module that can be built and deployed independently.

## Microservices
-------------

The following microservices are included in this workspace:

* **question-service**: provides question APIS
* **quiz-service**: provides quizes APIS

## Getting Started
---------------

To get started with this workspace, follow these steps:

1. Clone the repository: `git clone https://github.com/seen2/spring_boot_ms.git`
2. Install dependencies: `mvn clean install` (or `gradle build` if using Gradle)
3. Start each microservice individually: `mvn spring-boot:run` (or `gradle bootRun` if using Gradle)

## Build and Run
--------------

To build and run the microservices, follow these steps:

1. Build the project: `mvn clean package` (or `gradle build` if using Gradle)


## Troubleshooting
--------------

If you encounter any issues, please refer to the [troubleshooting guide](troubleshooting.md).

## Contributing
------------

Contributions are welcome! Please refer to the [contributing guide](contributing.md) for more information.

## License
-------

This project is licensed under the [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).