package ru.grishin;

import java.io.File;

public class Rmdir extends Console{

    protected Rmdir(){
        int i;
        for (i = 0; i < S.length; i++) {
        }
        i -= 1;
        String comm;
        comm = COMMAND + S[i];
        File file = new File(comm);
        if (file.delete()){
            System.out.println("Объект " + S[i] + " успешно удален.");
        } else {
            System.out.println("Объект " + S[i] + " не найден.");
        }
    }
}
