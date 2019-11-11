package ch.zhaw.einhoerner.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.lineSeparator;

/**
 * The class Processor.
 * <p>
 * <p>
 * //todo Javadoc
 */
public class Processor {

    private Parser parser = new Parser();

    /**
     * Constructor of the class Processor.
     */
    public Processor() {
        //todo Empty yet
    }

    /**
     * Public method used by the main method to start the editor.
     */
    public void startApplication() {
        printText(makeWelcomeText());
        printText(makeHelpText());
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
                default:
                    break;
            }
        }


        System.out.println("Thank you for using the Einhoerner Editor.");
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
     * Print out an unformatted version of all the paragraphs
     * @param paragraphs a List of all Paragraphs stored at the time of ececution
     */
    public void printUnformatted(List<String> paragraphs)
    {
        // get list TODO

    }

    /**
     * Print out a formatted version of all the paragraphs
     * @param width - The maximum width of these paragraphs
     */

    public void printFormatted(int width) {
        // TODO List<String> paragraphs;
        // TODO Dekyi
    }

    /**
     * With the "lineSeparator()", a new line can be detected on every System
     * (e.g. in Windows it would be \r\n, in MacOS \n)
     *
     * This method returns a single paragraph with a line break (lineSeparator()) at the given width.
     *
     * @param paragraph paragraph to be formatted
     * @param width position at which a line break is added
     * @return singleParagraph formatted paragraph
     */
    private String formatParagraphWidth (String paragraph, int width){
        List<String> paragraphList = new ArrayList<String>();
        paragraphList.addAll(Arrays.asList(paragraph.split("")));

        String singleParagraph = "";
        width++;

        for (int i = 0; i < paragraphList.size(); i++) {
            if (i % width == 0) {
                paragraphList.add(i, lineSeparator());
            }
            singleParagraph += paragraphList.get(i);
        }

        return singleParagraph;
    }
}

