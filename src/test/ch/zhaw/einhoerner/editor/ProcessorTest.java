package ch.zhaw.einhoerner.editor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.lineSeparator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;



class ProcessorTest {
    private Processor processor;
  
    @BeforeEach
    public void setUp()
    {
        processor = new Processor();
    }

    @Test
    public void addTextWithIndexPositive() {
        processor.add("0");
        processor.add("1");
        processor.add(2, "hallo");
        assertEquals("1", processor.get(2));
    }

    @Test
    public void addTextWithIndexNegative() {
        processor.add("0");
        processor.add("1");
        processor.add(2, "hallo");
        assertEquals("Invalid Index", processor.get(3));
    }

    @Test
    public void addTest(){
        processor.add("joking");
        assertEquals("joking", processor.get(0));
        processor.add("joking1");
        assertEquals("joking1", processor.get(1));
    }

    @Test
    public void addTextWithSeveralWords()
    {
        processor.add("line with no lineSeparator");
        assertEquals("line with no lineSeparator", processor.get(0));
    }

    @Test
    public void addFiveParagraphs()
    {
        processor.add("line one" + lineSeparator() + "line two" + lineSeparator() + "line three" + lineSeparator() + "line four" + lineSeparator() + "line five");
        assertEquals("line one", processor.get(0));
        assertEquals("line two", processor.get(1));
        assertEquals("line three", processor.get(2));
        assertEquals("line four", processor.get(3));
        assertEquals("line five", processor.get(4));
    }

    @Test
    public void tryingToAddNoArguments()
    {
        processor.add("");
        assertEquals("Invalid Index", processor.get(0));
    }

    @Test
    public void deleteTestPositive(){
        processor.add("0");
        processor.add("1");
        processor.add("2");
        processor.delete(1);
        assertEquals("1", processor.get(0));
    }

    @Test
    public void deleteTestNegative(){
        processor.add("0");
        processor.add("1");
        processor.add("2");
        processor.delete(1);
        assertEquals("Invalid Index", processor.get(2));
    }
  
    @Test
    public void searchAndReplaceTestPositive(){
        processor.add("a b a b a b a b");
        processor.add("no action");
        Processor.searchAndReplace(1, "a", "c");
        Processor.searchAndReplace(2, "x", "c");
        assertEquals("c b c b c b c b", processor.get(0));
        }
  
    @Test
    public void searchAndReplaceTestNegative(){
        processor.add("a b a b a b a b");
        processor.add("no action");
        Processor.searchAndReplace(1, "a", "c");
        Processor.searchAndReplace(2, "x", "c");
        assertEquals("no action", processor.get(1));
        assertEquals( "Invalid Index", processor.get(2));
    }
  
    @Test
    public void testExampleTextPositive() {
        String input = "add exampletexts";

        ParsedInput parsedInput = new Parser().parseInput(input);
        processor.executeCommand(parsedInput);
        //assertThat("Processor should have 5 paragraphs after adding the example text.", 5, is(processor.getParagraphs().size()));
        assertEquals(5, processor.getParagraphs().size());
    }

    @Test
    void testExampleTextNegative() {
        assertThat("Processor should not have any paragraphs", 0, is(processor.getParagraphs().size()));
    }

    @Test
    public void formatParagraphWidthWithItem(){
        processor.add("a b c d e f g, h i");
        List<String> test = new ArrayList<>();
        test.add("a b c d e f g, "+System.lineSeparator()+ "h i ");
        assertLinesMatch(test, processor.formatParagraphWidth(15));
    }

    @Test
    public void formatParagraphWidthWithoutItem(){
        List<String> test = new ArrayList<>();
        assertLinesMatch(test, processor.formatParagraphWidth(15));
    }

    @Test
    public void formatParagraphWidthNegativeWidth(){
        processor.add("a b c d e f g, h i");
        List<String> test = new ArrayList<>();
        assertLinesMatch(test, processor.formatParagraphWidth(-15));
    }

    @Test
    public void formatParagraphWidthTooLongWidth(){
        processor.add("a b c d e f g, h i");
        List<String> test = new ArrayList<>();
        assertLinesMatch(test, processor.formatParagraphWidth(100));
    }


}