package application;

import java.io.*;
import java.util.Scanner;

public class Application {

    private static Scanner scanner;

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        run();
    }

    public static void run() throws IOException {
        String command;
        while (!(command = scanner.nextLine()).equals("exit")) {
            if (command.equals("add login")) {
                saveNewUser();
            } else if (command.equals("change")) {
                changeUser();
            } else if (command.equals("user info")) {
                getUserInfo();
            } else {
                System.out.println("Неверная команда. Введите запрос снова.");
            }
        }
    }

    public static void changeUser() throws IOException {                        //смена пользователя
        System.out.println("Введите логин: ");
        String login1 = askUserLogin();
        Scanner fileReader = new Scanner(new FileReader(new File("user")));
        String str = fileReader.nextLine();
        while ((fileReader.hasNextLine()) && ((str.substring(str.indexOf(" ", 0) + 1, str.indexOf(" ", str.indexOf(" ", 0) + 1)))).equals(login1)) {
            fileReader.nextLine();
        }
        System.out.println("Введите пароль: ");
        String password = askUserPassword();
        while ((str.substring((str.indexOf(" ", str.indexOf(" ", 0))) + 1, (str.indexOf(" ", str.indexOf(" ", str.indexOf(" ", 0))) + 1))).equals(password) || (password.equals("back"))) {
            System.out.println("Неверный пароль, если вы передумали заходить напищите back");
            password = scanner.nextLine();
        }
    }

    public static void getUserInfo() {
        System.out.println(askUserLogin());
    }               //информация о пользователе

    public static String askUserLogin() {               //логин
        String login = scanner.nextLine();
        return login;
    }

    public static String askUserPassword() {                //пароль
        String password = scanner.nextLine();
        return password;
    }

    public static void saveNewUser() throws IOException {       //сохранение нового пользователя
        System.out.println("Введите логин: ");
        String login = askUserLogin();
        String password = askUserPassword();
        while (login.contains(" ")) {
            System.out.println("Логин не должен содержать пробелов. Введите логин заново: ");
            login = askUserLogin();
        }
        while (password.contains(" ")) {
            System.out.println("Пароль не должен содержать пробелов. Введите пароль заново: ");
            password = askUserPassword();
        }
        Integer id = getCurrentId() + 1;
        User user = new User(id, login, password);
        FileWriter writer = new FileWriter("user", true);
        writer.append("\n" + user.getId() + " " + user.getLogin() + " " + user.getPassword());
        writer.close();
        System.out.println("Пользователь сохранён.");
    }

    public static Integer getCurrentId() throws IOException {                       //делает id для польвателя
        Scanner fileReader = new Scanner(new FileReader(new File("user")));
        String line = "";
        while (fileReader.hasNextLine()) {
            line = fileReader.nextLine();
        }
        String idInString = line.substring(0, line.indexOf(" "));
        return Integer.parseInt(idInString);
    }

}
