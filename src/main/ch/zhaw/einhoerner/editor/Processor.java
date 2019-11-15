
package ch.zhaw.einhoerner.editor;

import java.util.*;

import static java.lang.System.lineSeparator;

/**
 * The class Processor.
 * <p>
 * <p>
 * This class contains all the logic from the Editor Application.
 */
public class Processor {

    private final static String QUIT_MESSAGE = "Thank you for using the Einhoerner Editor.";
    private Parser parser = new Parser();
    private static List<String> paragraphs;


    /**
     * Constructor of the class Processor.
     */
    public Processor() {

        paragraphs = new ArrayList<>();

    }

    /**
     * Public method used by the main method to start the editor.
     */
    public void startApplication() {
        printText(getWelcomeMessage());
        printText(getHelpMessage());

        String nextCommand = "";
        while (!Command.QUIT.getCommand().equals(nextCommand)) {
            // retrieve next user input
            System.out.print("> ");
            String userInput = getUserInput();

            // parse user input
            ParsedInput parsedInput = parser.parseInput(userInput);
            nextCommand = parsedInput.getCommand().getCommand();
            System.out.println("Detected command: " + nextCommand);

            // execute command
            executeCommand(parsedInput);
        }
    }


    void executeCommand(ParsedInput parsedInput) {
        switch (parsedInput.getCommand()) {
            case MAKE_WORD_INDEX:
                WordIndex wordIndex = new WordIndex(paragraphs);
                break;
            case ADD_EXAMPLETEXT:
                addExampleText();
                break;
            case ADD_INDEX:
                add(Integer.parseInt(parsedInput.getParameters().get(0)), parsedInput.getText());
                // TODO Exception occured
                System.out.println("Paragraph added at Index");
                break;
            case ADD:
                add(parsedInput.getText());
                System.out.println("Paragraph added at the end of the list");
                break;
            case DELETE:
                delete(Integer.parseInt(parsedInput.getParameters().get(0)));
                System.out.println("Paragraph " + Integer.parseInt(parsedInput.getParameters().get(0)) + " deleted");
                break;
            case PRINT:
                printUnformatted();
                break;
            case SEARCH_AND_REPLACE:
                searchAndReplace(Integer.parseInt(parsedInput.getParameters().get(0)), parsedInput.getParameters().get(1), parsedInput.getParameters().get(2));
                System.out.println("Word: " + parsedInput.getText() + " replaced in Paragraph " + Integer.parseInt(parsedInput.getParameters().get(0)));
                break;
            case PRINT_WIDTH:
                printFormatted(Integer.parseInt(parsedInput.getParameters().get(0)));
                break;
            case HELP:
                System.out.println(getHelpMessage());
                break;
            case QUIT:
                System.out.println(QUIT_MESSAGE);
                break;
            default:
                break;

        }
    }

    List<String> getParagraphs() {
        return paragraphs;
    }

    private String getUserInput() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    private void addExampleText() {
        List<String> text = detectNewParagraphs(ExampleText.EXAMPLE_TEXT);
        for (String line : text)
            add(line);
        System.out.println("Exampletext added");
    }

    /**
     * Prints out a text to the console.
     * <p>
     *
     * @param text A text as String value
     */
    public void printText(String text) {
        System.out.println(text);
    }


    private void printWholeParagraphs(List<String> toPrint) {
        for (int i = 0; i < toPrint.size(); i++) {
            System.out.println(i+1);
            System.out.println(toPrint.get(i));
            System.out.println();
        }
    }

    /**
     * Creates a welcome message which is used from the method startApplication.
     * <p>
     *
     * @return the welcome message which is getting printed out to the user.
     */
    public String getWelcomeMessage() {
        return "Welcome to the Editor Application from the team Einhoerner, please use one of the " +
                "following comands to proceed Type in " + Command.HELP + " at any time for a short manual.";
    }

    /**
     * Creates a help message to give the user some advice to use the application.
     * Further information and a manual on how to use the application is on the
     * Wiki-Page of the Github repository
     * <p>
     *
     * @return a short manual-text on how to use the editor
     */

    public String getHelpMessage() {
        return "You can choose from the following commands:" + lineSeparator() +
                "add (with or without paragraph number) <text>, add exampletext, print, " +
                "print width (with width in character count), delete, quit, help, search and replace" +
                "(followed by the old and the new word), make word index." + lineSeparator() + lineSeparator() +
                "For a manual in detail, please use the Wiki in the Github repository.";
    }

    /**
     * Adds a String text to a chosen index location into the paragraphs list
     * <p>
     *
     * @param index An Integer as int value
     * @param text A text as String value
     */
    public void add(int index, String text) {
        int input = index - 1;
        if (illegalIndex(input))
            System.out.println("Invalid Index.");
        else
            paragraphs.addAll(input, detectNewParagraphs(text));
    }

    /**
     * Adds a String text at the end of the paragraphs list
     * <p>
     *
     * @param text A text as String value
     */
    public void add(String text) {
        //add text in the end of paragraph list
        paragraphs.addAll(detectNewParagraphs(text));
    }


    /**
     * Deletes an entry of the paragraphs list to a chosen index
     * <p>
     *
     * @param index An Integer as int value
     */
    public void delete(int index) {
        int input = index - 1;
        if (illegalIndex(input))
            System.out.println("Invalid Index.");
        else
            paragraphs.remove(input);
    }

    /**
     * Replaces a chosen word by a chosesn replacement in a chosen entry of the paragraphs list
     * <p>
     *
     * @param index An Integer as int value
     * @param wordToReplace A word that is to be replaced as String value
     * @param replacement A word that serves as replacement as String value
     */
    public static void searchAndReplace(int index, String wordToReplace, String replacement) {
        int input = index - 1;
        if (illegalIndex(input))
            System.out.println("Invalid Index.");
        else {
            String searchedParagraph = paragraphs.get(input);
            searchedParagraph = searchedParagraph.replace(wordToReplace, replacement);
            paragraphs.set(input, searchedParagraph);
        }
    }

    private static Boolean illegalIndex(int index) {
        return (index < 0 || index >= paragraphs.size());

    }

    /**
     * Gets a chosen entry of the praragraphs list
     * <p>
     *
     * @return entry of the paragraphs list
     */
    public String get(int index){
        if(illegalIndex(index))
            return "Invalid Index.";
        else
            return paragraphs.get(index);
    }

    /**
     * Print out an unformatted version of all the paragraphs
     */
    private void printUnformatted() {
        printWholeParagraphs(paragraphs);
    }

    /**
     * Print out a formatted version of all the paragraphs
     * <p>
     *
     * @param width - The maximum width of these paragraphs
     */
    private void printFormatted(int width) {
        printWholeParagraphs(formatParagraphWidth(width));
    }

    /**
     * In a given String, this method looks out for a line separator (new Paragraphs), this can be different
     * depending on the operating system. With the lineSeparator from the System-library, it can detect
     * new Paragraphs no matter which operating system is used.
     * <p>
     *
     * @param text a given String to look out for new Paragraphs
     * @return
     */
    public List<String> detectNewParagraphs(String text) {
        List<String> paragraph = new ArrayList<>();
        String[] lines = text.split(System.lineSeparator());
        for (String line : lines) {
            if (!line.isEmpty()) {
                paragraph.add(line);
            }

        }
        return paragraph;
    }


    /**
     * With the "lineSeparator()", a new line can be detected on every System
     * (e.g. in Windows it would be \r\n, in MacOS \n)
     * This method returns a single paragraph with a line break (lineSeparator()) at the given width.
     * <p>
     *
     * @param width position at which a line break is added
     * @return formatted list with the formatted paragraphs
     */
    public List<String> formatParagraphWidth(int width) {
        List <String> formatted= new ArrayList<>();
        if (width <= 0) {
            System.out.println("Please enter a positive number.");
            return formatted;
        }
        for(String line : paragraphs){
            if(line.length()<width) {
                System.out.println("Please enter a number lower than " + line.length() + ".");
                return formatted;
            }
            StringBuilder text= new StringBuilder();
            String [] worter = line.split(" ");
            int zeichenAnzahl=0;
            for (String wort : worter){
                zeichenAnzahl+=wort.length()+1;
                if (zeichenAnzahl<=width){
                    text.append(wort).append(" ");
                }else {
                    zeichenAnzahl=wort.length()+1;
                    text.append(System.lineSeparator()).append(wort).append(" ");
                }
            }
            formatted.add(text.toString());
        }
        return formatted;
    }
}