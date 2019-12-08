package application;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserService {

    private String lastLogin;
    private Scanner sc;
    private DbService dbService;

    public UserService( Scanner sc, DbService dbService) {

        this.sc = sc;
        this.dbService = dbService;
    }

    public void saveNewUser() throws IOException {       //сохранение нового пользователя
        System.out.println("Введите логин: ");
        String login = this.askUserLogin();
        while (login.contains(" ")) {
            System.out.println("Логин не должен содержать пробелов. Введите логин заново: ");
            login = this.askUserLogin();
        }
        System.out.println("Придумайте пароль: ");
        String password = this.askUserPassword();
        while (password.contains(" ")) {
            System.out.println("Пароль не должен содержать пробелов. Введите пароль заново: ");
            password = this.askUserPassword();
        }
        dbService.addNewUser(login, password);
        System.out.println("Пользователь сохранён.");
    }

    public void getUserInfo() {
        System.out.println(lastLogin);
    }               //информация о пользователе

    public String askUserLogin() {               //логин
        String login = sc.nextLine();
        lastLogin = login;
        return login;
    }

    public String askUserPassword() {                //пароль
        String password = sc.nextLine();
        return password;
    }

    public void changeUser() throws IOException {                        //TODO довести до ума
        System.out.println("Введите логин: ");
        String login1 = this.askUserLogin();
        Scanner fileReader = new Scanner(new FileReader(new File("user")));
        String str = fileReader.nextLine();
        while ((fileReader.hasNextLine()) && !(((str.substring(str.indexOf(" ", 0) + 1, str.indexOf(" ", str.indexOf(" ", 0) + 1)))).equals(login1))) {
            if (((str.substring(str.indexOf(" ", 0) + 1, str.indexOf(" ", str.indexOf(" ", 0) + 1)))).equals(login1)) {
                break;
            }
            fileReader.nextLine();
            str = fileReader.nextLine();
        }
        if (!(str.substring(str.indexOf(" ", 0) + 1, str.indexOf(" ", str.indexOf(" ", 0) + 1))).equals(login1)) {
            System.out.println("Аккаунта с данным логином ещё не существует, если хотите, вы можете создать аккаунт с помощью команды add login.");
            return;
        }

        System.out.println("Введите пароль: ");
        String password = this.askUserPassword();
        System.out.println(str.substring((str.indexOf(" ", str.indexOf(" ", 0))) + 1, (str.indexOf(" ", str.indexOf(" ", str.indexOf(" ", 0) + 1)) + 1)));
        while ((!(str.substring((str.indexOf(" ", str.indexOf(" ", 0))) + 1, (str.indexOf(" ", str.indexOf(" ", str.indexOf(" ", 0))) + 1))).equals(password)) || (password.equals("back"))) {
            System.out.println("Неверный пароль, если вы передумали заходить напишите back");
            password = sc.nextLine();
            if (password.equals("back")) {
                return;
            }
        }
        lastLogin = str.substring(str.indexOf(" ", 0) + 1, str.indexOf(" ", str.indexOf(" ", 0) + 1));
    }
}
