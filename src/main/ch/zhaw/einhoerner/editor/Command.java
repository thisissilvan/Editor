package ch.zhaw.einhoerner.editor;

/**
 * The class Command is part of the Editor application.
 *
 * Objects in this class holding the information of the given commands which a user types in the console.
 * A valid command consists of two parts: A command and a String (for example: the command "add 4" consists
 * of the command "add" and the String "4")
 *
 * Commands are getting verified from the program. If an invalid command is given, the command is <null>.
 *
 * If the command only exists one word, the second word is <null>.
 *
 * @author  Ala Hadi, Silvan Luethy
 * @version 2019_11_09
 */

public class Command {
    private EnumCommand enumCommand;
    private String secondWord;

    /**
     * ...
     * ...
     * @param enumCommand
     * @param secondWord can be <null>
     */
    public Command(EnumCommand enumCommand, String secondWord)
    {
        this.enumCommand = enumCommand;
        this.secondWord = secondWord;
    }

    /**
     * ...
     * ...
     *
     * @return
     */
    public EnumCommand getCommand()
    {
        return enumCommand;
    }
    /**
     * ...
     * ...
     * ...
     * @return
     */
    public String getSecondWord()
    {
        return secondWord;
    }

   

}
