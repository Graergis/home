package ru.grishin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Copy extends Command{

    protected Copy(){
        super("copy");
    }

    @Override
    public void help() {
        System.out.println("Использование команды позволяет копировать объект в другую директорию");
        System.out.println("Пример ввода команды: copy + \"имя объекта для копирования\" + \"новое имя\"");
    }

    @Override
    public void execute(File root,String[] args) {
        java.io.File one = new java.io.File(root, args[0]);
        if (!one.exists()) {
            one = new File(args[0]);
        }
        java.io.File two = new java.io.File(root, args[1]);
        if (!two.exists()) {
            two = new File(args[1]);
        }
        try {
            if (one.isFile()) {
                Files.copy(one.toPath(), two.toPath());
            } else {
                copyDirectory(one, two);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyDirectory(File one, File two) throws IOException {
        Files.copy(one.toPath(), two.toPath());
        if (one.isDirectory()){
            File[] files = one.listFiles();
            for(File file : files){
                copyDirectory(file, new File(two, file.getName()));
            }
        }
    }
}