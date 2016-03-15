package ru.grishin;

import java.io.File;
import java.util.*;

public class Console {

    public static File WORK_DIRECTORY = new File(new File("").getAbsolutePath());
    public static List<String> LISTDIR = new ArrayList<>();

    public static void main(String[] args) {
        CommandList cl = new CommandList();
        boolean bool = false;
        while (true) {
            System.out.print(WORK_DIRECTORY.getAbsolutePath() + ">");
            Scanner scan = new Scanner(System.in);
            String line = scan.nextLine();
            String s2 = WORK_DIRECTORY.getAbsolutePath() + line;
            java.io.File t = new java.io.File(s2);
            if (t.exists()) {
                WORK_DIRECTORY = t;
            }
            String[] strings = line.split(" ");
            if (strings.length > 2) {
                if (strings[1].equals("dir")) {
                    LISTDIR.clear();
                    LISTDIR.add(strings[0]);
                    strings[0] = "";
                    Command command = cl.getCommandByName(strings[1]);
                    if (command != null) {
                        String[] s = Arrays.copyOfRange(strings, 2, 3);
                        command.execute(WORK_DIRECTORY, s);
                    }
                    LISTDIR.add(strings[strings.length - 1]);
                    bool = true;
                }
            }
            if (bool){
                String[] s1 = LISTDIR.toArray(new String[LISTDIR.size()]);
                Command command = cl.getCommandByName(s1[0]);
                if (command != null) {
                    String[] s = Arrays.copyOfRange(s1, 1, s1.length);
                    command.execute(WORK_DIRECTORY, s);
                }
                bool = false;
            }
            Command command = cl.getCommandByName(strings[0]);
            if (command != null) {
                String[] s = Arrays.copyOfRange(strings, 1, strings.length);
                command.execute(WORK_DIRECTORY, s);
            }
        }
    }
}