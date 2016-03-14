package ru.grishin;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Command {

    public static String COMM;

    public static void main(String[] args1){
        COMM = new File("").getAbsolutePath();
        CommandList cl = new CommandList();
        while (true) {
            System.out.print(COMM +">");
            Scanner scan = new Scanner(System.in);
            String line = scan.nextLine();
            if (line.endsWith("\\")){
                COMM += line;
                File file = new File(COMM);
                File[] files = file.listFiles();
                if (files == null) {
                    COMM = COMM.substring(0, COMM.length() - line.length());
                }
            }
            String[] args = line.split(" ");
            BasicCommand command = cl.getCommandByName(args[0]);
            if (command != null){
                String[] s = Arrays.copyOfRange(args, 1, args.length);
                command.execute(COMM ,s);
            }
        }
    }
}