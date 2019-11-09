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


    
}
