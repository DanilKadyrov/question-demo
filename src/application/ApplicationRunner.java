package application;

import java.io.BufferedInputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ApplicationRunner {

    private Scanner sc;
    private UserService userService;

    public ApplicationRunner(Scanner sc, UserService userService) {
        this.sc = sc;
        this.userService = userService;
    }

    public void run() throws Exception {
        String command;
        while (!(command = sc.nextLine()).equals("exit")) {
            if (command.equals("add login")) {
                userService.saveNewUser();
            } else if (command.equals("change")) {
                userService.changeUser();
            } else if (command.equals("user info")) {
                userService.getUserInfo();
            } else {
                System.out.println("Неверная команда. Введите запрос снова.");
            }
        }
    }


}
