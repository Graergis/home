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
        if (args[0].equals("..")){
            String[] url = Command.COMMLIST.toArray(new String[Command.COMMLIST.size()]);
            if (url.length > 1){
                Command.COMMLIST.remove(url.length -1);
                CHDIR = url[url.length - 2];
                BOOLCHDIR = true;
            } else {
                CHDIR = url[0];
                Command.COMMLIST.clear();
                Command.COMMLIST.add(url[0]);
                BOOLCHDIR = true;
            }
        } else {
            File myFile = new File(args[0]);
            File[] files = myFile.listFiles();
            if (files != null) {
                CHDIR = args[0];
                Command.COMMLIST.clear();
                Command.COMMLIST.add(args[0]);
                BOOLCHDIR = true;
            }
        }
    }
}