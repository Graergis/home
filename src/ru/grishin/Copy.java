package ru.grishin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Copy extends Console {

    protected Copy(){
        int i;
        for (i = 0; i < S.length; i++) {
        }
        i -= 1;
        File one = new File(COMMAND + S[i]);
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
