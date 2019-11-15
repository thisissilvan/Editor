package ch.zhaw.einhoerner.editor;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;




/**
 * The WordIndex class is responsible for making and printing a wordindex for the currently saved paragraphs.
 *
 * @author Gruppe_Einhoerner
 * @version 2019-11-15
 */


public class WordIndex {

    private Map<String, List<String>> wordCount = new HashMap<>();
    private static final int AMOUNT = 0;
    private static final int PLACE = 1;

    /**
     * When calling this method, it is required to hand over a list of Strings.
     *
     * @param text a list of paragraphs to be processed
     */

    /**
     * When calling this method, it is required to hand over a list of Strings.
     *
     * @param text a list of paragraphs to be processed
     */

    public void makeWordIndex(List<String> text) {
        //Ensure that if the passed on list is empty, no wordindex can be created
        if (text.size() <= 0) {
            System.out.println("No text to create a wordindex. Please add text.");
            wordCount.put("", Arrays.asList("", ""));
        }
        for (int index = 0; index < text.size(); index++) {
            String platzhalter = text.get(index);
            String[] paragraph = platzhalter.toLowerCase().replaceAll("[ +.,?!\":;]", " ").split(" +");
            for (String word : paragraph) {
                List<String> values = new ArrayList<>();

                //If the wordindex doesn't contain the word yet, it gets added
                if (!wordCount.containsKey(word)) {
                    values.add(AMOUNT, "1");
                    values.add(PLACE, String.valueOf(index));
                    wordCount.put(word, values);
                } else

                //If the word already exists, then raise the amount and save the location
                {
                    values = wordCount.get(word);
                    int raiseCount = Integer.parseInt(values.get(AMOUNT));
                    raiseCount++;
                    values.set(AMOUNT, String.valueOf(raiseCount));
                    String newIndex = String.valueOf(index);

                    //Control whether the location is already saved or not
                    if (!values.get(PLACE).contains(newIndex)) {
                        String addPlace = values.get(PLACE);
                        addPlace = addPlace + ", " + newIndex;
                        values.set(PLACE, addPlace);
                    }
                    wordCount.replace(word, values);
                }

            }
        }
        entrysToDelete(controlMinimumAmount());
        printWordIndex();
    }

    /**
     * This method saves the words that aren't mentioned often enough.
     *
     * @return toDelete a list of words that are mentioned less than thrice
     */
    private List<String> controlMinimumAmount() {
        List<String> values;
        List<String> toDelete = new ArrayList<>();
        for (Map.Entry<String, List<String>> wortHaeufigkeit : wordCount.entrySet()) {
            values = wortHaeufigkeit.getValue();
            int wordCount = Integer.parseInt(values.get(AMOUNT));
            if (wordCount < 3)
                toDelete.add(wortHaeufigkeit.getKey());
        }
        return toDelete;
    }

    /**
     * All the words that aren't mentioned often enough are deleted from the wordindex.
     *
     * @param toDelete a list of words to be deleted
     */
    private void entrysToDelete(List<String> toDelete) {
        for (String keyToDelete : toDelete)
            wordCount.remove(keyToDelete);

        if (wordCount.isEmpty())
            wordCount.put("", Arrays.asList("", ""));


    }

    private void printWordIndex() {
        for (Map.Entry<String, List<String>> wortHaeufigkeit : wordCount.entrySet()) {
            String toPrint = wortHaeufigkeit.getValue().get(AMOUNT) + ": " + wortHaeufigkeit.getKey() + " in: " + wortHaeufigkeit.getValue().get(PLACE);
            System.out.println(toPrint);
            System.out.println();
        }
    }

    /**
     * This method returns the amount a word is mentioned.
     *
     * @param key the word in question
     * @return amount a String which saves the occurrence of the word
     */

    public String getAmount(String key) {
        String amount;
        if (!wordCount.containsKey(key.toLowerCase()))
            amount = "";
        else
            amount = wordCount.get(key.toLowerCase()).get(AMOUNT);
        return amount;
    }

    /**
     * This method returns the location/s where a word is mentioned.
     *
     * @param key the word in question
     * @return place a String which saves where the word occurs
     */

    public String getPlace(String key) {
        String place;
        if (!wordCount.containsKey(key.toLowerCase()))
            place = "";
        else
            place = wordCount.get(key.toLowerCase()).get(PLACE);
        return place;
    }

}