package ru.grishin;

import java.io.File;

public class Chdir extends Command {

    protected Chdir(){
        super("chdir", "cd");
    }

    @Override
    public void help() {
        System.out.println("Смена текущего нахождения, на новую директорию");
        System.out.println("Пример ввода команды: chdir / cd + ..  \"возвращение в родительскую директорию\"");
        System.out.println("Пример ввода команды: chdir / cd + C:\\Program File\\  - переход по точному адресу");
    }

    @Override
    public void execute(File root, String[] args) {
        if (args[0].equals("..")) {
            Console.WORK_DIRECTORY = new File(root.getParent());
        } else {
            java.io.File file = new java.io.File(root, args[0]);
            if (file.exists()) {
                Console.WORK_DIRECTORY = file;
            } else {
                file = new java.io.File(args[0]);
                if (file.exists()) {
                    Console.WORK_DIRECTORY = file;
                } else {
                    System.out.println("File not exists");
                }
            }
        }
    }
}