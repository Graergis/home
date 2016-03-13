package ru.grishin;

import java.io.File;
import java.util.Scanner;

public class Command extends Console {

    protected Command() {
        System.out.println("Для получения справки введите help.");
        while (true) {
            boolean bool = true;
            System.out.print(COMMAND + ">");
            Scanner scan = new Scanner(System.in);
            String console = scan.nextLine();
            S = console.split(" ");
            if(S[0].toLowerCase().equals("help")){
                Help help = new Help();
                bool = false;
            }
            if (console.toLowerCase().equals("dir")){
                Dir dir = new Dir();
                bool = false;
            }
            if(S[0].toLowerCase().equals("chdir")) {
                Chdir chdir = new Chdir();
                bool = false;
            }
            if (S[0].toLowerCase().equals("mkdir")){
                Mkdir mkdir = new Mkdir();
                bool = false;
            }
            if(S[0].toLowerCase().equals("rmdir")){
                Rmdir rmdir = new Rmdir();
                bool = false;
            }
            if(S[0].toLowerCase().equals("copy")){
                Copy copy = new Copy();
                bool = false;
            }
            if (console.toLowerCase().equals("exit")){
                return;
            }
            if (bool) {
                if (console.endsWith("\\")){
                    COMMAND+= console;
                    File file = new File(COMMAND);
                    File[] fi = file.listFiles();
                    if (fi == null) {
                        System.out.println(COMMAND + " не является директорией, либо командой.");
                        int j = console.length();
                        COMMAND = COMMAND.substring(0, COMMAND.length() - j);
                    }
                } else {
                    System.out.println(COMMAND + " не является директорией, либо командой.");
                }
            }
        }
    }
}
