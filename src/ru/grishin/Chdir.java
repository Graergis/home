package ru.grishin;

import java.util.Scanner;

public class Chdir extends Console{

    protected Chdir(){
        int i;
        for (i = 0; i < S.length; i++) {
        }
        i -= 1;
        java.io.File file2 = new java.io.File(COMMAND + S[i]);
        if (file2.exists()) {
            System.out.print("Введите новое имя объекту.>");
            Scanner scan3 = new Scanner(System.in);
            String rename2 = scan3.nextLine();
            java.io.File file3 = new java.io.File(COMMAND + rename2);
            if (file3.exists()){
                System.out.println("Объект с таким именем уже существует.");
            } else {
                file2.renameTo(new java.io.File(COMMAND + rename2));
                System.out.println("Объект переименован успешно.");
            }
        } else {
            System.out.println("Объект не найден.");
        }
    }
}
