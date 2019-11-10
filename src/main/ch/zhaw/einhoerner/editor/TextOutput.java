package ch.zhaw.einhoerner.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static java.lang.System.lineSeparator;

/**
 * In the class TextOutput is all the text from the application stored and the output options are getting managed here.
 *
 * @author Silvan,
 * @version 2019_11_09
 */
public class TextOutput {


    private Paragraphs paragraphs;

    /**
     * Constructor of the class TextOutput.
     */
    public TextOutput()
    {

    }

    /**
     * Print out an unformatted version of all the paragraphs
     * @param allParagraphs a List of all Paragraphs stored at the time of ececution
     */
    public void printUnformatted(List<Paragraphs> allParagraphs)
    {
        for(int i = 0; i < allParagraphs.size(); i++) {
            System.out.println((i+1) + ": " + allParagraphs.get(i));
        }
    }

    /**
     * Print out a formatted version of all the paragraphs
     * @param width - The maximum width of these paragraphs
     */

    public void printFormatted(int width) {
        List<String> allParagraphs = paragraphs.getParagraphs();

        for (int i = 0; i < allParagraphs.size(); i++) {
            String singleParagraph = formatParagraphWidth(allParagraphs.get(i), width);
            System.out.println(singleParagraph);
        }
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

    /**
     * Split an Array of text into paragraphs as soon as a lineSeparator() is found.
     * @param text the text given to look for a 'new line'
     * @return splittedParagraph, an Array that stores the different paragraphs
     */
    public Paragraphs[] splitToParagraphs(String text){

        String[] foundParagraphs = {};

        if(text.length() > 0) {
            foundParagraphs = text.split(lineSeparator());
        }
        Paragraphs[] splittedParagraph = new Paragraphs[foundParagraphs.length];
        for (int i = 0; i < foundParagraphs.length; i++) {
            splittedParagraph[i] = new Paragraphs(foundParagraphs[i]);
        }
        return splittedParagraph;
    }

}
