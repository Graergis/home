package ru.grishin;

import java.io.File;

public class Exit extends Command {

    protected Exit() {
        super("exit");
    }

    @Override
    public void help() {
        System.out.println("Выход");
    }

    @Override
    public void execute(File root, String[] args) {
        System.exit(0);
    }
}
