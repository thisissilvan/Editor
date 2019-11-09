package ch.zhaw.einhoerner.editor;
/**
 * The main methode runs until the user decides
 * to quit the editor in a while loop.
 * For a manual in detail, please consult the wiki page in the Github repository.
 *
 * @author Silvan Luethy
 * @version 2019_11_09
 */
public class Editor {
    public static void main(String[] args) {
        {
            Processor processor = new Processor();
            processor.startEditor();
        }
    }
}
