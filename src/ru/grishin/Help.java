package ru.grishin;

public class Help extends BasicCommand {

    public Help() {
        super("help");
    }

    @Override
    public void help() {
    }

    @Override
    public void execute(String root ,String[] args) {
        CommandList cl = new CommandList();
        if (args.length == 0){
            System.out.println("Список поддерживаемых команд:");
            for (BasicCommand command : cl.getCommands()) {
                System.out.println(command.getName());
            }
            System.out.println("Вызов справки для определенной команды: help + \"команда\"");
        } else {
            BasicCommand command = cl.getCommandByName(args[0]);
            if (command != null) {
                command.help();
            }
        }
    }
}