# JavaShell
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Version](https://img.shields.io/badge/version-1.0.0-brightgreen.svg)]()
[![Build](https://img.shields.io/badge/build-passing-brightgreen.svg)]()
[![Coverage](https://img.shields.io/badge/coverage-90%25-green.svg)]()


JavaShell is a Java library for executing PowerShell scripts asynchronously on local machines. It provides features such as concurrent execution, output capture, and terminal integration, making it ideal for automation and systems administration-related tasks.

## Features
- Asynchronous execution of PowerShell scripts
- Concurrent execution using a thread pool
- Capturing and retrieval of output lines
- Integration with terminal applications

## Usage

JavaShell provides a convenient way to execute PowerShell scripts synchronously or asynchronously in Java.
### Maven
```
Current work in progress 8/25/2023
```

### Synchronous Programming
```
public static void main(String[] args) { 
	new Powershell().execute("ipconfig /all").forEach(System.out::println);
}
```
In the above example, the `execute` method is used to execute a PowerShell script synchronously. The output lines are retrieved into a list, and then each line is printed using `forEach(System.out::println)`.
### Asynchronous Programming
```
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

## License
JavaShell is licensed under the [MIT License](https://chat.openai.com/LICENSE).
