package ru.grishin;

import java.io.File;

public class Chdir extends BasicCommand{

    public static String CHDIR = "";
    public static boolean BOOLCHDIR = false;

    protected Chdir(){
        super("chdir");
    }

    @Override
    public void help() {
        System.out.println("Смена текущего нахождения, на новую директорию");
    }

    @Override
    public void execute(String root,String[] args) {
        if (args.length > 1){
            if (args[0].equals("..")){
                String[] url = Command.COMMLIST.toArray(new String[Command.COMMLIST.size()]);
                CHDIR = url[url.length - 2];
                BOOLCHDIR = true;
            } else {
                File myFile = new File(args[0]);
                File[] files = myFile.listFiles();
                if (files != null) {
                    CHDIR =  args[0];
                    BOOLCHDIR = true;
                }
            }
        } else {
            if (args.length == 1) {
                File myFile = new File(args[0]);
                File[] files = myFile.listFiles();
                if (files != null) {
                    CHDIR =  args[0];
                    BOOLCHDIR = true;
                    return;
                }
                String[] url2 = Command.COMMLIST.toArray(new String[Command.COMMLIST.size()]);
                CHDIR = url2[0];
                BOOLCHDIR = true;
            }
        }
    }
}
