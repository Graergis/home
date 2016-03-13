package ru.grishin;

import java.io.File;

public class Dir extends Console{

    protected Dir() {
        File myFile = new File(COMMAND);
        File[] files = myFile.listFiles();
        if (files == null) {
            System.out.println("Несуществующая директория.");
        }else {
            System.out.println("=================================================");
            int i;
            for (i = 0; i <files.length ; i++) {
                System.out.println(files[i]);
            }
            System.out.println("Элементов в папке: " + i);
            System.out.println("=================================================");
        }
    }
}
