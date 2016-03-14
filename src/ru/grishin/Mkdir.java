package ru.grishin;

import java.io.File;

public class Mkdir extends Command{

    protected Mkdir() {
        super("mkdir", "md");
    }

    @Override
    public void help() {
        System.out.println("Использование команды позволяет создать новый объект в текущей директории.");
        System.out.println("Пример ввода команды: mkdir / md + \"имя нового объекта\"");
    }

    @Override
    public void execute(File root,String[] args) {
        if (args.length != 0){
            java.io.File file2 = new java.io.File(root,  args[0]);
            if (file2.exists()) {
                System.out.println("Папка с таким именем уже существует.");
            } else {
                File myCreate = new File(root, args[0]);
                myCreate.mkdir();
            }
        }
    }
}
