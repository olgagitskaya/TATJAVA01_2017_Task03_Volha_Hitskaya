package by.catalog.view;

import by.catalog.controller.Controller;

import java.util.Scanner;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public class Runner {
    public static void main(String[] args) {
        Controller controller = new Controller();
        try (Scanner sc = new Scanner(System.in))
        {
            while (true)
            {
                String command = sc.nextLine();
                String commandResult = controller.executeCommand(command);
                System.out.println(commandResult);
            }

        }
    }
}
