package ch.zhaw.einhoerner.editor;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WordIndex {
    private Map<String, List<String>> woerterHaeufigkeit = new HashMap<>();
    private static final int AMOUNT = 0;
    private static final int PLACE = 1;
    public WordIndex(List<String> text) {
        for (int index = 0; index < text.size(); index++) {
            String platzhalter = text.get(index);
            String[] paragraph = platzhalter.toLowerCase().replaceAll("[ +.,?!\":; ]", " ").split(" +");

            for (String word : paragraph) {
                List<String> values = new ArrayList<>();
                if (!woerterHaeufigkeit.containsKey(word)) {
                    values.add(AMOUNT, "1");
                    values.add(PLACE, String.valueOf(index));
                    woerterHaeufigkeit.put(word, values);
                } else {
                    values = woerterHaeufigkeit.get(word);
                    int raiseCount = Integer.parseInt(values.get(AMOUNT));
                    raiseCount++;
                    values.set(AMOUNT, String.valueOf(raiseCount));
                    String newIndex = String.valueOf(index);
                    if (!values.get(PLACE).contains(newIndex)) {
                        String addPlace = values.get(PLACE);
                        addPlace = addPlace + ", " + newIndex;
                        values.set(PLACE, addPlace);
                    }
                    woerterHaeufigkeit.replace(word, values);
                }

            }
        }
    }
    public void printWordIndex() {
        for (Map.Entry<String, List<String>> wortHaeufigkeit : woerterHaeufigkeit.entrySet()) {
            System.out.println("Wort:         "+ wortHaeufigkeit.getKey());
            System.out.println("Paragraph/en: "+wortHaeufigkeit.getValue());
        }
    }
}
