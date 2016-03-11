package ru.grishin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) {
        String command = "";
        List <String> cons = new ArrayList<>();
        System.out.println("Для получения справки введите help");
        while (1 > 0) {
            String comm;
            boolean bool = true;
            System.out.print(command + ">");
            Scanner scan = new Scanner(System.in);
            String console = scan.nextLine();
            if(console.toLowerCase().equals("help")){
                System.out.println("=================================================");
                System.out.println("Список поддерживаемых команд:");
                System.out.println("    ");
                System.out.println("b - назад");
                System.out.println("dir - выводит список файлов в текущей директории");
                System.out.println("rename - переименовать объект");
                System.out.println("create - создать новую папку");
                System.out.println("delete - удаление объекта");
                System.out.println("recovery - сброс строки");
                System.out.println("exit - выход из программы");
                System.out.println("=================================================");
                console = "";
                bool = false;
            }
            if(console.toLowerCase().equals("recovery")){
                command = "";
                console = "";
                cons.clear();
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
                comm = command + rename;
                java.io.File file2 = new java.io.File(comm);
                if (file2.exists()) {
                    System.out.println("Введите новое имя объекту");
                    Scanner scan3 = new Scanner(System.in);
                    String rename2 = scan3.nextLine();
                    java.io.File file3 = new java.io.File(command + rename2);
                    if (file3.exists()){
                        System.out.println("Объект с таким именем уже существует");
                        bool = false;
                    } else {
                        file2.renameTo(new java.io.File(command + rename2));
                        System.out.println("Объект переименован успешно");
                        bool = false;
                    }
                } else {
                    System.out.println("Объект не найден.");
                    bool = false;
                }
            }
            if (console.toLowerCase().equals("create")){
                System.out.println("Введите имя новой папки");
                Scanner scan5 = new Scanner(System.in);
                String create = scan5.nextLine();
                java.io.File file2 = new java.io.File(command + create);
                if (file2.exists()) {
                    System.out.println("Папка с таким именем уже существует");
                    bool = false;
                } else {
                    File myCreate = new File(command + create);
                    myCreate.mkdir();
                    System.out.println("Папка успешно создана");
                    bool = false;
                }
            }
            if(console.toLowerCase().equals("delete")){
                System.out.println("Введите имя объекта для удаления");
                Scanner scan4 = new Scanner(System.in);
                String delete = scan4.nextLine();
                comm = command + delete;
                File file = new File(comm);
                if (file.delete()){
                    System.out.println("Объект " + delete + " успешно удален");
                    bool = false;
                } else {
                    System.out.println("Объект " + delete + " не найден");
                    bool = false;
                }
            }
            if (console.toLowerCase().equals("b")) {
                if (1 < cons.size()) {
                    int b1;
                    for (b1 = 0; b1 < cons.size(); b1++) {
                    }
                    cons.remove(b1 - 1);
                    String[] con;
                    con = cons.toArray(new String[cons.size()]);
                    command = "";
                    command += con[b1 - 2];
                    bool = false;
                } else {
                    cons.clear();
                    command = "";
                    bool = false;
                }
            }
            if (console.toLowerCase().equals("exit")){
                return;
            }
            if (bool) {
                if (console.endsWith("\\")){
                    command += console;
                    cons.add(command);
                    File file = new File(command);
                    File[] fi = file.listFiles();
                    if (fi == null) {
                        int b;
                        System.out.println(command + " не является директорией, либо командой.");
                        int j = console.length();
                        command = command.substring(0, command.length() - j);
                        for (b = 0; b < cons.size(); b++) {
                        }
                        cons.remove(b - 1);
                    }
                } else {
                    System.out.println(command + " не является директорией, либо командой.");
                }
            }
        }
    }
}