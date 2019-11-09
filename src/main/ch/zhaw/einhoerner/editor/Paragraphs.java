package ch.zhaw.einhoerner.editor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The class Paragraph stores the text which is given in by the user.
 * All the paragraphs are stored in a "HashMap<String, Integer> paragraphs"
 *
 * @author
 * @version 2019_11_09
 */
public class Paragraphs {
    private String text;
    private HashMap<String, Integer> paragraphs = new HashMap<>();
    private ArrayList<String> words = new ArrayList<>();

    public Paragraphs(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return text;
    }

    public void searchAndReplace(String wordToReplace, String newWord)
    {
        text.replaceAll(wordToReplace, newWord);
    }

   
}
