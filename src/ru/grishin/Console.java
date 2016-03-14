package ru.grishin;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Console {

    public static File WORK_DIRECTORY = new File(new File("").getAbsolutePath());

    public static void main(String[] args) {
        CommandList cl = new CommandList();
        while (true) {
            System.out.print(WORK_DIRECTORY.getAbsolutePath() + ">");
            Scanner scan = new Scanner(System.in);
            String line = scan.nextLine();
            String[] strings = line.split(" ");
            Command command = cl.getCommandByName(strings[0]);
            if (command != null) {
                String[] s = Arrays.copyOfRange(strings, 1, strings.length);
                command.execute(WORK_DIRECTORY, s);
            }
        }
    }
}