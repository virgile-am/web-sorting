# Advanced Web Sorting Algorithms

This project implements a web application showcasing various sorting algorithms within a Spring-based environment. It includes a RESTful API designed following HATEOAS principles, deployment on Apache Tomcat, and integration of sorting algorithms such as Heap Sort, Quick Sort, Merge Sort, Radix Sort, and Bucket Sort.

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
 

## Project Overview

This project demonstrates the capabilities of Java and Spring Framework in building a robust web application that integrates sorting algorithms. It encompasses the following key components:

- **API Design:** Implementation of RESTful API endpoints using Spring MVC.
- **Spring Framework:** Utilization of Spring modules for dependency injection, autowiring, and application context management.
- **Sorting Algorithms:** Implementation and integration of Heap Sort, Quick Sort, Merge Sort, Radix Sort, and Bucket Sort algorithms for data manipulation.

## Features

1. **HTTP Protocols & Apache Tomcat Web Server:**
    - Configuration and deployment on Apache Tomcat.
    - Handling HTTP requests and responses effectively.

2. **API Design:**
    - Designing a RESTful API adhering to HATEOAS principles.
    - Implementation of API endpoints for CRUD operations.

3. **Spring Framework:**
    - Utilizing Spring modules for building the application.
    - Implementing dependency injection, autowiring, and application context.
    - Developing a sample Spring application demonstrating these features.

4. **Sorting Algorithms:**
    - Implementing and integrating Heap Sort, Quick Sort, Merge Sort, Radix Sort, and Bucket Sort algorithms.
    - Providing a user interface to select and execute different sorting algorithms on sample datasets.

## Installation

To run this project locally, follow these steps:

1. **Prerequisites:**
    - JDK 21 (LTS)
    - Apache Tomcat server
    - Maven

2. **Clone the repository:**https://github.com/virgile-am/web-sorting.git
3. 5. **Deploy the WAR file to Tomcat:**
- Copy the generated WAR file from `target/` to Tomcat's `webapps/` directory.

## Usage

1. Start your Tomcat server.
2. Access the application at `http://localhost:8080/web-sorting`.
3. Use the provided UI to select sorting algorithms and input data for sorting.
4. Alternatively, use API endpoints directly for programmatic access.

## License

This project is licensed under the [MIT License](LICENSE).