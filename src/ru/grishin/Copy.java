package ru.grishin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Copy extends Command{

    protected Copy(){
        super("copy");
    }

    @Override
    public void help() {
        System.out.println("Использование команды позволяет копировать объект в другую директорию");
        System.out.println("Пример ввода команды: copy + \"имя объекта для копирования\"");
        System.out.println("После укажите полный путь для копирования с именем.");
        System.out.println("Пример полного пути: D:\\Program Files\\Test.txt");
    }

    @Override
    public void execute(File root,String[] args) {
        File one = root;
        System.out.println("Укажите полный путь назначения и имя объекта");
        String coms = "";
        System.out.print(">");
        Scanner scan = new Scanner(System.in);
        String console = scan.nextLine();
        coms+= console;
        java.io.File file2 = new java.io.File(coms);
        if (file2.exists()) {
            System.out.println("Папка с таким именем уже существует.");
        }
        File two = new File(coms);
        try {
            Files.copy(one.toPath(), two.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}