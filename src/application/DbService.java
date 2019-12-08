package application;

import application.User;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DbService {

    private FileWriter writer;
    private Scanner sc;

    public DbService(FileWriter writer, Scanner sc) {
        this.writer =writer;
        this.sc = sc;
    }

  public void addNewUser (String login, String password) throws IOException {
        Integer id = getCurrentId() + 1;
        User user = new User(id, login, password);
        writer.append("\n" + user.getId() + " " + user.getLogin() + " " + user.getPassword());
        writer.close();
    }

    public  Integer getCurrentId() throws IOException {
        Scanner fileReader = new Scanner(new FileReader(new File("user")));
        String line = "";
        while (fileReader.hasNextLine()) {
            line = fileReader.nextLine();
        }
        String idInString = line.substring(0, line.indexOf(" "));
        return Integer.parseInt(idInString);
    }
}
