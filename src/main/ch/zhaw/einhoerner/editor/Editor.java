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
    private String userInput;

    public static void main(String[] args) {
        Editor editor = new Editor();
        Scanner in = new Scanner(System.in);
        Processor processor = new Processor();

        processor.startEditor();
        System.out.print("> ");
        editor.userInput = in.nextLine();

        while (!editor.userInput.equals(Command.QUIT.name())) {
            editor.run(in);
        }
    }

    public void run(Scanner in) {

        // TODO if not empty input, fill input

        System.out.print("> ");
        userInput = in.nextLine();

    }
}
