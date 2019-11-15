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
    public void addTextWithIndex() {
        processor.add("0");
        processor.add("1");
        processor.add(2, "hallo");
        assertEquals("hallo", processor.get(1));
        assertEquals("1", processor.get(2));
    }

    @Test
    public void addTextWrongIndex()
    {
        processor.add(2, "should not be possible");
        assertEquals("Invalid Index", processor.get(2));
    }

    @Test
    public void addTest(){
        processor.add("joking");
        assertEquals("joking", processor.get(0));
        processor.add("joking1");
        assertEquals("joking1", processor.get(1));
    }

    @Test
    public void addParagraphsNoLineSeparator()
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
    public void addParagraphs(){
        processor.add("hello" + lineSeparator()  + " next Line ");
        assertEquals("hello", processor.get(0));
        assertEquals(" next Line ", processor.get(1));

    }

    @Test
    public void tryingToAddNoArguments()
    {
        processor.add("");
        assertEquals("Empty text could not be added", processor.get(0));
    }

    @Test
    public void deleteTest(){
        processor.add("0");
        processor.add("1");
        processor.add("2");
        processor.delete(1);
        assertEquals("1", processor.get(0));
        assertEquals("Invalid Index.", processor.get(2));
    }

    @Test
    public void searchAndReplaceTest(){
        processor.add("a b a b a b a b");
        processor.add("no action");
        Processor.searchAndReplace(1, "a", "c");
        Processor.searchAndReplace(2, "x", "c");
        assertEquals("c b c b c b c b", processor.get(0));
        assertEquals("no action", processor.get(1));
        assertEquals( "Invalid Index", processor.get(2));
    }
    @Test
    void testExampleText() {
        Processor p = new Processor();
        String input = "add exampletext";

        ParsedInput parsedInput = new Parser().parseInput(input);
        assertThat("Processor should not have any paragraphs", 0, is(p.getParagraphs().size()));
        p.executeCommand(parsedInput);
        assertThat("Processor should have 5 paragraphs after adding the example text.", 5, is(p.getParagraphs().size()));
    }

    @Test
    public void formatParagraphWidthWithItem(){
        processor.add("a b c d e f g, h i");
        List<String> test = new ArrayList<>();
        test.add("a b c d e f g, "+System.lineSeparator()+ "h i ");
        assertLinesMatch(test,processor.formatParagraphWidth(15));
    }

    @Test
    public void formatParagraphWidthWithoutItem(){
        List<String> test = new ArrayList<>();
        assertLinesMatch(test,processor.formatParagraphWidth(15));
    }

    @Test
    public void formatParagraphWidthNegativeWidth(){
        processor.add("a b c d e f g, h i");
        List<String> test = new ArrayList<>();
        assertLinesMatch(test,processor.formatParagraphWidth(-15));
    }

    @Test
    public void formatParagraphWidthTooLongWidth(){
        processor.add("a b c d e f g, h i");
        List<String> test = new ArrayList<>();
        assertLinesMatch(test,processor.formatParagraphWidth(100));
    }


}