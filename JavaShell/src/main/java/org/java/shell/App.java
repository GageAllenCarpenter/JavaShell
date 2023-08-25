package org.java.shell;

public class App {
    public static void main(String[] args) {
        new Powershell().execute("ipconfig /all").forEach(System.out::println);
    }
}
