package ru.grishin;

import java.util.*;

public class CommandList {

    private Map<String, Command> commands = new HashMap<>();

    private void putCommand(Command command) {
        commands.put(command.getName(), command);
        commands.put(command.getShortName(), command);
    }

    public CommandList(){
        putCommand(new Dir());
        putCommand(new Chdir());
        putCommand(new Copy());
        putCommand(new Exit());
        putCommand(new Help());
        putCommand(new Mkdir());
        putCommand(new Rmdir());
    }

    public Command getCommandByName(String name){
        return commands.get(name);
    }

    public List<Command> getCommands() {
        return Collections.unmodifiableList(new ArrayList<>(commands.values()));
    }
}
