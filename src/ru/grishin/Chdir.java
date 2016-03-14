package ru.grishin;

import java.io.File;

public class Chdir extends BasicCommand{

    protected Chdir(){
        super("chdir");
    }

    @Override
    public void help() {
        System.out.println("Смена текущего нахождения, на новую директорию");
    }

    @Override
    public void execute(String root,String[] args) {
        if (args[0].equals("..") & root.length() > 3){
            Command.COMM = new File(root).getParent();
        } else {
            if (!args[0].equals("..")) {
                java.io.File file = new java.io.File(args[0]);
                if (file.exists()) {
                    Command.COMM = args[0];
                }
            }
        }
    }
}