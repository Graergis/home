package ru.grishin;

import java.io.File;

public class Dir extends BasicCommand{

    protected Dir() {
        super("dir");
    }

    @Override
    public void help() {
        System.out.println("Использование команды выводит в консоль список всех элементов директории,");
        System.out.println("в которой используется данная команда.");
        System.out.println("Пример ввода команды: dir");
    }

    @Override
    public void execute(String root,String[] args) {
        if (root.equals("")){
            root = Command.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        }
        File myFile = new File(root);
        File[] files = myFile.listFiles();
        if (files != null) {
            System.out.println("=================================================");
            for (int i = 0; i <files.length ; i++) {
                System.out.println(files[i]);
            }
            System.out.println("Элементов в папке: " + files.length);
            System.out.println("=================================================");
        }
    }
}