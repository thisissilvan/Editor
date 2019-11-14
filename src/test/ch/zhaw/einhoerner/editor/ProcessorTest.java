package ch.zhaw.einhoerner.editor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void addTest(){
        processor.add("joking");
        assertEquals("joking", processor.get(0));
        processor.add("joking1");
        assertEquals("joking1", processor.get(1));
    }
    @Test
    public void addParagraphs(){
        processor.add("hello" + lineSeparator()  + " next Line ");
        assertEquals("hello", processor.get(0));
        assertEquals(" next Line ", processor.get(1));

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
        processor.searchAndReplace(1, "a", "c");
        processor.searchAndReplace(2, "x", "c");
        assertEquals("c b c b c b c b", processor.get(0));
        assertEquals("no action", processor.get(1));
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




}