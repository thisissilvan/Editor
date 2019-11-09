package ch.zhaw.einhoerner.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public HashMap<String, Integer> getWords()
    {
        String[] wordsArray = text.split(" ");

        for(String word : wordsArray) {
            paragraphs.put(word, paragraphs.getOrDefault(word, 0) + 1);
        }
        return paragraphs;
    }

    // TODO just an example to use in other classes
    public List<String> getParagraphs() {
        ArrayList<String>example = new ArrayList<>();
        return example;
    }
}
