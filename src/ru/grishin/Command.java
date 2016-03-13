package ru.grishin;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Command {

    public static List <String> COMMLIST = new ArrayList<>();

    public static void main(String[] args1){
        String comm = "";
        CommandList cl = new CommandList();
        while (true) {
            if (Chdir.BOOLCHDIR){
                comm = Chdir.CHDIR;
                Chdir.BOOLCHDIR = false;
            }
            System.out.print(comm +">");
            Scanner scan = new Scanner(System.in);
            String line = scan.nextLine();
            if (line.endsWith("\\")){
                comm += line;
                File file = new File(comm);
                File[] files = file.listFiles();
                if (files == null) {
                    comm = comm.substring(0, comm.length() - line.length());
                } else {
                    COMMLIST.add(comm);
                }
            }
            String[] args = line.split(" ");
            BasicCommand command = cl.getCommandByName(args[0]);
            if (command != null){
                String[] s = Arrays.copyOfRange(args, 1, args.length);
                command.execute(comm ,s);
            }
        }
    }
}