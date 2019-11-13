
package ch.zhaw.einhoerner.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.lineSeparator;

/**
 * The class Processor.
 * <p>
 * <p>
 * This class contains all the logic from the Editor Application.
 */
public class Processor {

    private Parser parser = new Parser();
    private List<String> paragraphs = new ArrayList<>();
    /**
     * Constructor of the class Processor.
     */
    public Processor() {}

    /**
     * Public method used by the main method to start the editor.
     */
    public void startApplication() {
        printText(makeWelcomeMesseage());
        printText(makeHelpMesseage());
        System.out.print("> ");

        String nextCommand = "";
        while (!Command.QUIT.getCommand().equals(nextCommand)) {

            // retrieve next user input
            String userInput = getUserInput();

            // parse user input
            ParsedInput parsedInput = parser.parseInput(userInput);
            nextCommand = parsedInput.getCommand().getCommand();
            System.out.println("Detected command: " + nextCommand);

            // execute command
            switch (parsedInput.getCommand()) {
                case ADD_EXAMPLETEXT:
                    String generated = addExampleText();
                    // TODO this text has to be saved somehow somewhere
                    break;
                case PRINT:
                    printUnformatted();
                    break;
                case PRINT_WIDTH:
                    printFormatted(Integer.parseInt(parsedInput.getParameters().get(0)));
                    break;
                default:
                    break;
            }
        }

        System.out.println(makeQuitMesseage());
    }

    private String addExampleText() {
        String text = ExampleText.EXAMPLE_TEXT;
        System.out.println(text);
        return text;
    }

    private String getUserInput() {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        return input;
    }

    /**
     * Prints out a text to the console.
     * <p>
     * @param text A text as String value
     */
    public void printText(String text)
    {
        System.out.println(text);
    }

    /**
     * Creates a welcome message which is used from the method startApplication.
     * <p>
     * @return the welcome messeage which is getting printed out to the user.
     */
    public String makeWelcomeMesseage() {
        return "Welcome to the Editor Application from the team Einhoerner, please use one of the " +
                "following comands to proceed:";
    }

    private void printWholeParagraphs() {
        for (int i = 0; i < paragraphs.size(); i++) {
            System.out.println(paragraphs.get(i));
            System.out.println();
        }
    }

    /**
     * Creates a help message to give the user some advice to use the application.
     * Further information and a manual on how to use the application is on the
     * Wiki-Page of the Github repository
     * <p>
     * @return a short manual-text on how to use the editor
     */
    public String makeHelpMesseage()
    {
        return "Type in " + Command.HELP + " at any time for a short manual. " +
                lineSeparator() + lineSeparator() + "You can choose from the following commands:" + lineSeparator() +
                "add (with or without paragraph number), print, quit, help, searchAndReplace" +
                "(followed by the old and the new word" + lineSeparator() + lineSeparator() +
                "For a manual in detail, please use the Wiki in the Github repository.";
    }

    /**
     * Creates a messeage which is getting printed out after exiting the Editor.
     * <p>
     * @return Quit messeage
     */
    public String makeQuitMesseage()
    {
        return "Thank you for using the Einhoerner Editor.";
    }
    public void add(int index, String text) {
        if(illegalIndex(index))
            throw new IllegalArgumentException ("No text to create a wordindex. Please add text.");
        else
            paragraphs.add(index, text);
        printUnformatted();
    }
    public void add(String text) {
        //add text in the end of paragraph list
        paragraphs.add(text);
        printUnformatted();
    }
    private void delete(int index) {
        //in list index deleten
        if(illegalIndex(index))
            throw new IllegalArgumentException ("No text to create a wordindex. Please add text.");
        else
            paragraphs.remove(index);
        printUnformatted();
    }
    private void searchAndReplace(int index, String wordToReplace, String replacement) {
        if(illegalIndex(index))
            throw new IllegalArgumentException ("No text to create a wordindex. Please add text.");
        else {
            String searchedParagraph = paragraphs.get(index);
            searchedParagraph = searchedParagraph.replace(wordToReplace, replacement);
            paragraphs.set(index, searchedParagraph);
        }
        printUnformatted();
    }

    private Boolean illegalIndex(int index){
        return (index < 0  || index >= paragraphs.size());
    }



    /**
     * Print out an unformatted version of all the paragraphs
     */
    private void printUnformatted() {
        printWholeParagraphs();
    }


    /**
     * Print out a formatted version of all the paragraphs
     * <p>
     * @param width - The maximum width of these paragraphs
     */
    private void printFormatted(int width) {
        formatParagraphWidth(width);
        printWholeParagraphs();
    }

    /**
     * In a given String, this method looks out for a line separator (new Paragraphs), this can be different
     * depending on the operating system. With the lineSeparator from the System-library, it can detect
     * new Paragraphs no matter which operating system is used.
     *<p>
     * @param text a given String to look out for new Paragraphs
     */
    public void detectNewParagraphs(String text)
    {
        String[] lines = text.split(System.getProperty("line.separator"));
        for(int i = 0; i < lines.length; i++)
        {
            System.out.println(i + ":" + lines[i]);
        }
    }

    /**
     * With the "lineSeparator()", a new line can be detected on every System
     * (e.g. in Windows it would be \r\n, in MacOS \n)
     * This method returns a single paragraph with a line break (lineSeparator()) at the given width.
     * <p>
     * @param width position at which a line break is added
     */
    private void formatParagraphWidth (int width)throws IllegalArgumentException{
        if (width <=0) {
            throw new IllegalArgumentException ("Please enter a positive number.");
        }else{
            for (int paragraphIndex = 0; paragraphIndex < paragraphs.size(); paragraphIndex++) {
                String text = paragraphs.get(paragraphIndex);
                if (width>=text.length()) {
                    throw new IllegalArgumentException ("Please enter a number lower than "+text.length()+".");}
                {
                    int anzahlZeilen = text.length() / width;
                    StringBuilder platzhalter = new StringBuilder();
                    int seperatorPlace = width;
                    int beginningPlace = 0;
                    for (int zeilenIndex = 0; zeilenIndex < anzahlZeilen; zeilenIndex++) {
                        if (Character.isWhitespace(text.charAt(seperatorPlace))) {
                            platzhalter.append(text.substring(beginningPlace, seperatorPlace)).append(System.lineSeparator());
                            seperatorPlace += width + 1;
                            beginningPlace += width + 1;
                        } else if (!Character.isWhitespace(text.charAt(seperatorPlace - 1))) {
                            platzhalter.append(text.substring(beginningPlace, seperatorPlace)).append("-").append(System.lineSeparator());
                            seperatorPlace += width;
                            beginningPlace += width;
                        } else {
                            platzhalter.append(text.substring(beginningPlace, seperatorPlace)).append(System.lineSeparator());
                            seperatorPlace += width;
                            beginningPlace += width;
                        }
                    }
                    if (!(text.length() % width == 0)) platzhalter.append(text.substring(beginningPlace));
                    paragraphs.set(paragraphIndex, platzhalter.toString());
                }
            }
        }
    }
}