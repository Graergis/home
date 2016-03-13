package ru.grishin;

public abstract class BasicCommand {

    private final String name;

    protected BasicCommand(String name) {
        this.name = name;
    }
    public abstract void help();
    public abstract void execute(String root ,String[] args);

    public String getName() {
        return name;
    }
}
