package ru.grishin;

public class Help extends Console {

    protected Help() {
        boolean b = true;
        int i;
        for (i = 0; i < S.length; i++) {
        }
        i -= 1;
        if(S[i].toLowerCase().equals("dir")){
            System.out.println("=================================================");
            System.out.println("Использование команды выводит в консоль список всех элементов директории,");
            System.out.println("в которой используется данная команда.");
            System.out.println("Пример ввода команды: dir");
            System.out.println("=================================================");
            b = false;
        }
        if(S[i].toLowerCase().equals("mkdir")){
            System.out.println("=================================================");
            System.out.println("Использование команды позволяет создать новый объект в текущей директории.");
            System.out.println("Пример ввода команды: mkdir + \"имя нового объекта\"");
            System.out.println("=================================================");
            b = false;
        }
        if(S[i].toLowerCase().equals("chdir")){
            System.out.println("=================================================");
            System.out.println("Использование команды позволяет переименовать какой либо обект из текущей директории");
            System.out.println("Пример ввода команды: chdir + \"имя объекта, который желаете переименовать\"");
            System.out.println("=================================================");
            b = false;
        }
        if(S[i].toLowerCase().equals("rmdir")){
            System.out.println("=================================================");
            System.out.println("Использование команды удаляет выбранный объект в текущей директории");
            System.out.println("Пример ввода команды: rmdir + \"имя удаляемого объекта\"");
            System.out.println("=================================================");
            b = false;
        }
        if(S[i].toLowerCase().equals("copy")){
            System.out.println("=================================================");
            System.out.println("Использование команды позволяет копировать объект в другую директорию");
            System.out.println("Пример ввода команды: copy + \"имя объекта для копирования\"");
            System.out.println("После укажите полный путь для копирования с именем.");
            System.out.println("Пример полного пути: D:\\Program Files\\Test.txt");
            System.out.println("=================================================");
            b = false;
        }
        if (S[i].equals("")){
            System.out.println("Несуществующая команда для \"help\"");
            b = false;
        }

        if (b) {
            if (S[i].toLowerCase().equals("help")){
                System.out.println("=================================================");
                System.out.println("Пример ввода:  C:\\ -> Program Files\\ ....");
                System.out.println("    ");
                System.out.println("Список поддерживаемых команд:");
                System.out.println("    ");
                System.out.println("dir - показать список файлов и папок в текущей директории;");
                System.out.println("chdir - переименовать объект;");
                System.out.println("mkdir - создать новую папку;");
                System.out.println("rmdir - удалить объект;");
                System.out.println("copy - копировать объект.");
                System.out.println("exit - выход из программы.");
                System.out.println("     ");
                System.out.println("Вызов справки для определенной команды: help + \"команда\"");
                System.out.println("=================================================");
            }
        }
    }
}
