package com.example.talizorah.finalapp.Command;

/**
 * Created by talizorah on 16.10.4.
 */
// Creating the invoker class ->
public class CommandController {
    private EditingCommand deleteCommand, openCommand;
    private CreatingCommand creatingCommand;
    private CommandController(){
    }
    public static CommandController createCommandController(){
        return new CommandController();
    }
    public void setDeleteCommand(EditingCommand command){
        this.deleteCommand = command;
    }
    public void setOpenCommand(EditingCommand command){
        this.openCommand = command;
    }
    public void setCreatingCommand(CreatingCommand command){
        this.creatingCommand = command;
    }
    public void deleteTheNote(int pos){
        deleteCommand.setPosition(pos);
        deleteCommand.execute();
    }
    public void openTheNote(int pos){
        openCommand.setPosition(pos);
        openCommand.execute();
    }
    public void createNote(){
        creatingCommand.execute();
    }
}
