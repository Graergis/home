package ru.grishin;

public class Exit extends BasicCommand {

    protected Exit() {
        super("exit", "exit");
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
