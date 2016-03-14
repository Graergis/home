package ru.grishin;

import java.io.File;

public class Rmdir extends Command{

    protected Rmdir(){
        super("rmdir", "rd");
    }

    @Override
    public void help() {
        System.out.println("Использование команды удаляет выбранный объект в текущей директории");
        System.out.println("Пример ввода команды: rmdir + \"имя удаляемого объекта\"");
    }

    @Override
    public void execute(File root,String[] args) {
        if(args.length != 0) {
            File file = new File(root, args[0]);
            if (file.delete()) {
                System.out.println("Объект " + args[0] + " успешно удален.");
            } else {
                System.out.println("Объект не найден.");
            }
        }
    }
}