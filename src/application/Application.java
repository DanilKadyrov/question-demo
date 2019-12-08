package application;

import java.io.*;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = new FileWriter(new File("user"));
        DbService dbService = new DbService(fileWriter, scanner);
        UserService userService = new UserService(scanner, dbService);
        ApplicationRunner applicationRunner = new ApplicationRunner(scanner, userService);
        applicationRunner.run();
    }
}