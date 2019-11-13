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
}