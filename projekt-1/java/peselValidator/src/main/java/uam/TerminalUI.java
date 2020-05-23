package uam;

import java.io.IOException;
import java.util.Scanner;

public class TerminalUI {

    private static final String EXIT = "exit";

    public void run() throws IOException {
        var fileName = FileUtil.generateName();

        var running = true;

        while (running) {
            var scanner = new Scanner(System.in);

            System.out.println("Podaj nazwe miasta: ");
            var town = scanner.nextLine();

            System.out.println("Podaj imie: ");
            var firstName = scanner.nextLine();

            System.out.println("Podaj nazwisko: ");
            var lastName = scanner.nextLine();

            System.out.println("Podaj PESEL: ");
            var pesel = scanner.nextLine();
            var isValidPesel = PeselValidatorClass.isValidPesel(pesel);
            if (!isValidPesel) {
                System.out.println("Pesel nieprawidłowy !");
            } else {
                var file = new FileUtil(fileName);
                file.readFile();
                file.update(town, firstName, lastName, pesel);
            }

            System.out.println("Jesli chcesz wyjsc wpisz \"exit\" w przeciwnym wypadku wpisz dowolny inny ciag znakow.");
            var exit = scanner.nextLine();

            if (EXIT.equals(exit)) {
                running = false;
            }

        }
    }
}
