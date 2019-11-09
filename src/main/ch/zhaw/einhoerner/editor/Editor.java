package ch.zhaw.einhoerner.editor;

public class Editor {

    /**
     * The main methode runs until the user decides
     * to quit the editor in a while loop.
     * For a manual in detail, please consult the wiki page in the Github repository.
     * @author Silvan Luethy
     * @version 2019_11_09
     *
     */
    public static void main(String[] args) {
        {
            Processor processor = new Processor();
            processor.printWelcomeText();

            boolean quit = false;
            while (!quit) {
               //todo do something and condition for finishing the loop
            }
            System.out.println("Thank you for using the Einhoerner Editor.");
        }
    }

}
