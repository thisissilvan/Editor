package ch.zhaw.einhoerner.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static java.lang.System.lineSeparator;

public class TextOutput {

    private Paragraphs paragraphs;


    public TextOutput()
    {

    }

    public void printList(List<Paragraphs> allParagraphs)
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
     * Returns a single paragraph with the needed line breaks (\n) at the specific width nr
     * @param paragraph - the paragraph to be formatted
     * @param width     - the position at which a line break is added
     * @return singleParagraph  - the formatted paragraph
     */
    public String formatParagraphWidth (String paragraph, int width){
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
