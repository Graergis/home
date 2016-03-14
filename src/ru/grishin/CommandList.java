package ru.grishin;

import java.util.ArrayList;
import java.util.List;

public class CommandList {

    private List<BasicCommand> listCommand = new ArrayList<>();

    public BasicCommand getCommandByName(String name){
        for (int i = 0; i < listCommand.size(); i++) {
            BasicCommand command = listCommand.get(i);
            if (command.getName().equals(name) || command.getName2().equals(name)){
                return command;
            }
        }
        return null;
    }
    public CommandList(){
        listCommand.add(new Exit());
        listCommand.add(new Help());
        listCommand.add(new Dir());
        listCommand.add(new Copy());
        listCommand.add(new Mkdir());
        listCommand.add(new Rmdir());
        listCommand.add(new Chdir());
    }

    public List<BasicCommand> getCommands() {
        return listCommand;
    }
}
