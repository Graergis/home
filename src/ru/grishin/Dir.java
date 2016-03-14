package ru.grishin;

import java.io.File;

public class Dir extends Command {

    protected Dir() {
        super("dir", "dir");
    }

    @Override
    public void help() {
        System.out.println("Использование команды выводит в консоль список всех элементов директории,");
        System.out.println("в которой используется данная команда.");
        System.out.println("Пример ввода команды: dir");
    }

    @Override
    public void execute(File root, String[] args) {
        File[] files = root.listFiles();
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