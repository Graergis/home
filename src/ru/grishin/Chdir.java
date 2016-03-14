package ru.grishin;

import java.io.File;

public class Chdir extends BasicCommand{

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