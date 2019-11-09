package ch.zhaw.einhoerner.editor;

/**
 * The class Processor.
 *
 * //todo
 */
public class Processor {

    public Processor()
    {
        //todo maybe do something here
    }

    /**
     * Prints out a welcome messeage to the console.
     */
    public void printWelcomeText()
    {
        System.out.println();
        System.out.println("Welcome to the Editor Application from the team Einhoerner");
        System.out.println("Type in " + EnumCommand.HELP + " at any time for a short manual.");
        System.out.println();
        System.out.println("Please use one of the following comands to proceed:");
        printHelpText();
    }

    /**
     * Prints out a help messeage to the console.
     */
    public void printHelpText()
    {
        System.out.println();
        System.out.println("You can choose from the following commands:");
        System.out.println("add (with or without paragraph number), print, quit, help, searchAndReplace (followed by the old and the new word");
        System.out.print("For a manual in detail, please use the Wiki in the Github repository.");
        System.out.println();
    }


}

