package ru.grishin;

import java.io.File;

public abstract class Command {

    private final String name;
    private final String shortName;

    protected Command(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    protected Command(String name) {
        this(name, name);
    }

    public abstract void help();
    public abstract void execute(File root , String[] args);

    public String getName() {
        return name;
    }
    public String getShortName() {
        return shortName;
    }
}
