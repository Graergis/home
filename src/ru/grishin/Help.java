package ru.grishin;

import java.io.File;

public class Help extends Command {

    protected Help() {
        super("help");
    }

    @Override
    public void help() {
    }

    @Override
    public void execute(File root , String[] args) {
        CommandList cl = new CommandList();
        if (args.length == 0){
            System.out.println("Список поддерживаемых команд:");
            for (Command command : cl.getCommands()) {
                System.out.println(command.getName());
            }
            System.out.println("Вызов справки для определенной команды: help + \"команда\"");
        } else {
            Command command = cl.getCommandByName(args[0]);
            if (command != null) {
                command.help();
            }
        }
    }
}