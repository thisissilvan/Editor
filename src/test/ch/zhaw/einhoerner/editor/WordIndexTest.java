package ch.zhaw.einhoerner.editor;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


class WordIndexTest {    private List<String> paragraphs = new ArrayList<>();

    @Test
    public void emptyListTest() {
        WordIndex wordIndex = new WordIndex(paragraphs);
        assertEquals("", wordIndex.getAmount(""));
        assertEquals("", wordIndex.getAmount(""));
    }

    @Test
    public void occurrenceOfTwo() {
        paragraphs.add("die,die");
        WordIndex wordIndex = new WordIndex(paragraphs);
        assertNotEquals("2", wordIndex.getAmount("die"));
        assertNotEquals("0", wordIndex.getPlace("die"));
        assertEquals("", wordIndex.getAmount("die"));
        assertEquals("", wordIndex.getAmount("die"));
    }

    @Test
    public void occurrenceOfThreeSameParagraph() {
        paragraphs.add("die,die,die");
        WordIndex wordIndex = new WordIndex(paragraphs);
        assertEquals("3", wordIndex.getAmount("die"));
        assertEquals("0", wordIndex.getPlace("die"));
    }

}