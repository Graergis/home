package ru.grishin;

import java.io.File;

public class Rmdir extends Command{

    protected Rmdir(){
        super("rmdir", "rd");
    }

    @Override
    public void help() {
        System.out.println("Использование команды удаляет выбранный объект в текущей директории");
        System.out.println("Пример ввода команды: rmdir / rd + \"имя удаляемого объекта\"");
    }

    @Override
    public void execute(File root,String[] args) {
        if(args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                File file = new File(root, args[i]);
                File file2 = new File(args[i]);
                if (file.delete() | file2.delete()) {
                    System.out.println("Объект успешно удален.");
                } else {
                }
            }
        }
    }
}