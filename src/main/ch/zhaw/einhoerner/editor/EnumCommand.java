package ch.zhaw.einhoerner.editor;

public enum EnumCommand
{
    ADD_EXAMPLETEXT("add exampletext"), ADD("add"), PRINT("print"),
    SEARCH_AND_REPLACE("search and replace"), PRINT_WIDTH("print width"), QUIT("quit");

    private String command;


    EnumCommand(String command)
    {
        this.command = command;
    }


    public String toString()
    {
        return command;
    }

}