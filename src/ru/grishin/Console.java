package ru.grishin;

import java.io.File;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) {
        String command = "";
        System.out.println("Для получения справки введите help");
        while (1 > 0) {
            boolean bool = true;
            System.out.print(">" + command);
            Scanner scan = new Scanner(System.in);
            String console = scan.nextLine();
            if(console.toLowerCase().equals("help")){
                System.out.println("=================================================");
                System.out.println("Список поддерживаемых команд:");
                System.out.println("dir - выводит список файлов в текущей директории");
                System.out.println("rename - переименовать объект");
                System.out.println("recovery - сброс строки");
                System.out.println("delete - удаление объекта");
                System.out.println("exit - выход из программы");
                System.out.println("=================================================");
                console = "";
                bool = false;
            }
            if(console.toLowerCase().equals("recovery")){
                command = "";
                console = "";
                bool = false;
            }
            if (console.toLowerCase().equals("dir")){
                console = "";
                File myFile = new File(command);
                File[] files = myFile.listFiles();
                if (files == null) {
                    System.out.println("Несуществующая директория");
                }else {
                    System.out.println("=================================================");
                    for (int i = 0; i <files.length ; i++) {
                        System.out.println(files[i]);
                    }
                    System.out.println("=================================================");
                }
                bool = false;
            }
            if(console.toLowerCase().equals("rename")) {
                System.out.println("Введите имя объекта, который желаете переименовать");
                Scanner scan2 = new Scanner(System.in);
                String rename = scan2.nextLine();
                command += rename;
                java.io.File file2 = new java.io.File(command);
                if (file2.exists()) {
                    System.out.println("Введите новое имя объекту");
                    Scanner scan3 = new Scanner(System.in);
                    String rename2 = scan3.nextLine();
                    int r = rename.length();
                    command = command.substring(0, command.length() - r);
                    file2.renameTo(new java.io.File(command + rename2));
                    System.out.println("Объект переименован успешно");
                    bool = false;
                } else {
                    System.out.println("Объект не найден.");
                    bool = false;
                }
            }
            if(console.toLowerCase().equals("delete")){
                System.out.println("Введите имя объекта для удаления");
                Scanner scan4 = new Scanner(System.in);
                String delete = scan4.nextLine();
                command += delete;
                File file = new File(command);
                if (file.delete()){
                    System.out.println("Объект " + delete + " успешно удален");
                    int d = delete.length();
                    command = command.substring(0, command.length() - d);
                    bool = false;
                } else {
                    System.out.println("Объект " + delete + " не найден");
                    bool = false;
                }
            }
            if (console.toLowerCase().equals("exit")){
                return;
            }
            if (bool) {
                command += console;
                File file = new File(command);
                File[] fi = file.listFiles();
                if (fi == null) {
                    System.out.println(command + " не является директорией, либо командой.");
                    int j = console.length();
                    command = command.substring(0, command.length() - j);
                }
            }
        }
    }
}