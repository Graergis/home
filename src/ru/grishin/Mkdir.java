package ru.grishin;

import java.io.File;

public class Mkdir extends Console{

    protected Mkdir() {
        int i;
        for (i = 0; i < S.length; i++) {
        }
        i -= 1;
        java.io.File file2 = new java.io.File(COMMAND + S[i]);
        if (file2.exists()) {
            System.out.println("Папка с таким именем уже существует.");
        } else {
            File myCreate = new File(COMMAND + S[i]);
            myCreate.mkdir();
        }
    }
}
