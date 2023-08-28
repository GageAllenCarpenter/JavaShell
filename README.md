# JavaShell
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Version](https://img.shields.io/badge/version-1.0.0-brightgreen.svg)]()
[![Build](https://img.shields.io/badge/build-passing-brightgreen.svg)]()
[![Coverage](https://img.shields.io/badge/coverage-90%25-green.svg)]()

**JavaShell** is a comprehensive Java library designed to facilitate the effortless integration of PowerShell scripting capabilities into Java applications. This powerful utility empowers developers to seamlessly execute PowerShell scripts, whether synchronously or asynchronously, creating a seamless bridge between Java and PowerShell functionalities.

## Table of Contents
- [Introduction](#introduction)
- [Maven](#maven)
- [Features](#features)
- [Usage](#usage)
- [Overview](#overview)
- [Examples](#examples)
- [Contributions](#contributions)
- [License](#license)

## Introduction

The **JavaShell** library provides a streamlined and user-friendly interface for executing PowerShell scripts within a Java runtime environment. By abstracting the intricacies of script execution, output capture, and exception handling, this library simplifies the process of leveraging PowerShell's capabilities within Java applications.

Furthermore, **JavaShell** provides concurrency features that allow multiple instances of Powershell to run simultaneously. This is beneficial when running scripts such as Windows updates that take a considerable amount of time to complete. Generally, two or more PowerShell instances running at the same time would produce overlapping log files. However, another benefit of the concurrent execution of PowerShell scripts within this library is that the logs generated remain sorted and readable relative to their completion order.

## Maven
```xml
<dependency>
    <groupId>io.github.gageallencarpenter</groupId>
    <artifactId>JavaShell</artifactId>
    <version>1</version>
</dependency>
```

## Features
- Asynchronous execution of PowerShell scripts
- Concurrent execution using a thread pool
- Capturing and retrieval of output lines
- Integration with terminal applications

## Usage

1. Add the Powershell class or the Maven dependency from this repository to your project.
2. Utilize the available methods within Powershell.java to interact with your cache.

## Overview

| Method | Use Case |
| -- | -- |
| execute(String script) | Executes a PowerShell script synchronously |
| executeAsync(String script) | Executes a PowerShell script asynchronously |

## Examples

JavaShell provides a convenient way to execute PowerShell scripts synchronously or asynchronously in Java.

### Synchronous Programming
```java
public static void main(String[] args) { 
	new Powershell().execute("ipconfig /all").forEach(System.out::println);
}
```
In the above example, the `execute` method is used to execute a PowerShell script synchronously. The output lines are retrieved into a list, and then each line is printed using `forEach(System.out::println)`.
### Asynchronous Programming
```java
public static void main(String[] args) {
	Future<List<String>> result = new Powershell().executeAsync("ipconfig /all");
	try {
		result.get().forEach(System.out::println);
	} catch (InterruptedException | ExecutionException e) {
		e.printStackTrace();
	}
}
```
In the above example, the `executeAsync` method is used to execute a PowerShell script asynchronously. The result is obtained as a `Future` object, and then the output lines are retrieved into a list using `get()` method. Finally, each line is printed using `forEach(System.out::println)`. Futures allow for scripts to execute in parallel without overlapping output.

## Contributions

Contributions are welcome! If you'd like to contribute to JavaShell, please follow these steps:
1. Fork the repository and create a new branch for your feature or bug fix.
2. Make your changes and submit a pull request.
3. Provide a clear description of your changes and their purpose.

## License
JavaShell is licensed under the [MIT License](https://chat.openai.com/LICENSE).
