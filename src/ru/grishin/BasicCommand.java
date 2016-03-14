package ru.grishin;

public abstract class BasicCommand {

    private final String name;
    private final String name2;

    protected BasicCommand(String name, String name2) {
        this.name = name;
        this.name2 = name2;
    }
    public abstract void help();
    public abstract void execute(String root ,String[] args);

    public String getName() {
        return name;
    }
    public String getName2() {
        return name2;
    }
}
