package ch.zhaw.einhoerner.editor;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class WordIndexTest {    private List<String> paragraphs = new ArrayList<>();

    @Test
    public void emptyListTest() {
        WordIndex wordIndex = new WordIndex();
        wordIndex.makeWordIndex(paragraphs);
        assertEquals("", wordIndex.getAmount(""));
        assertEquals("", wordIndex.getAmount(""));
    }

    @Test
    public void occurrenceOfTwo() {
        paragraphs.add("die,die");
        WordIndex wordIndex = new WordIndex();
        wordIndex.makeWordIndex(paragraphs);
        assertNotEquals("2", wordIndex.getAmount("die"));
        assertNotEquals("0", wordIndex.getPlace("die"));
        assertEquals("", wordIndex.getAmount("die"));
        assertEquals("", wordIndex.getAmount("die"));
    }

    @Test
    public void occurrenceOfThreeSameParagraph() {
        paragraphs.add("die,die,die");
        WordIndex wordIndex = new WordIndex();
        wordIndex.makeWordIndex(paragraphs);
        assertEquals("3", wordIndex.getAmount("die"));
        assertEquals("0", wordIndex.getPlace("die"));
    }

    @Test
    public void occurrenceOfThreeDifferentParagraphs() {
        paragraphs.add("die");
        paragraphs.add("die");
        paragraphs.add("die");
        WordIndex wordIndex = new WordIndex();
        wordIndex.makeWordIndex(paragraphs);
        assertEquals("3", wordIndex.getAmount("die"));
        assertEquals("0, 1, 2", wordIndex.getPlace("die"));
    }

    @Test
    public void lowerUpperCaseSame() {
        paragraphs.add("Die");
        paragraphs.add("Die");
        paragraphs.add("die");
        WordIndex wordIndex = new WordIndex();
        wordIndex.makeWordIndex(paragraphs);
        assertEquals("3", wordIndex.getAmount("die"));
        assertEquals("0, 1, 2", wordIndex.getPlace("die"));
        assertEquals("3", wordIndex.getAmount("Die"));
        assertEquals("0, 1, 2", wordIndex.getPlace("Die"));
    }

    @Test
    public void deleteSpecialCharactersAlone() {
        paragraphs.add("die,die,die");
        paragraphs.add("+++");
        WordIndex wordIndex = new WordIndex();
        wordIndex.makeWordIndex(paragraphs);
        assertEquals("", wordIndex.getAmount("+"));
        assertEquals("", wordIndex.getPlace("+"));
    }

    @Test
    public void deleteSpecialCharactersInside() {
        paragraphs.add("die,die,die+");
        WordIndex wordIndex = new WordIndex();
        wordIndex.makeWordIndex(paragraphs);
        assertEquals("", wordIndex.getAmount("+"));
        assertEquals("3", wordIndex.getAmount("die"));
    }
}