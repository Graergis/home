package ru.grishin;

public class Exit extends BasicCommand {

    public Exit() {
        super("exit");
    }

    @Override
    public void help() {
        System.out.println("Выход");
    }

    @Override
    public void execute(String root,String[] args) {
        System.exit(0);
    }
}
