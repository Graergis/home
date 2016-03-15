package ru.grishin;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            if (args.length > 0) {
                Pattern p = Pattern.compile(args[0]);
                for (int i = 0; i < files.length; i++) {
                    Matcher matcher = p.matcher(files[i].getName());
                    if (matcher.find()) {
                        System.out.println(files[i]);
                        Console.LISTDIR.add("" + files[i]);
                    }
                }
            } else {
                for (int i = 0; i < files.length; i++) {
                    System.out.println(files[i]);
                }
            }
            System.out.println("=================================================");
        }
    }
}