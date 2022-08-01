package oop.command.simple;

import java.util.ArrayList;
import java.util.List;

public class Invoker {

    private final List<ICommand> commandList = new ArrayList<>();

    public void addCommand(ICommand iCommand) {
        commandList.add(iCommand);
    }

    public void start() {
        for(ICommand cmd : commandList) {
            cmd.execute();
        }
    }

}
