package org.campus02;

import java.util.ArrayList;
import java.util.HashMap;

public class CovidManager {

    public static void main(String[] args) {

        Incidence stmk20211111 = new Incidence(
                "Steiermark", "2021-11-11", 1300
        );
        Incidence stmk20211110 = new Incidence(
                "Steiermark", "2021-11-10", 1200
        );
        Incidence stmk20211109 = new Incidence(
                "Steiermark", "2021-11-09", 1221
        );
        Incidence bgld20211111 = new Incidence(
                "Burgenland", "2021-11-11", 5
        );
        Incidence bgld20211110 = new Incidence(
                "Burgenland", "2021-11-10", 500
        );
        Incidence bgld20211109 = new Incidence(
                "Burgenland", "2021-11-09", 299
        );
        Incidence vlbg20211111 = new Incidence(
                "Vorarlberg", "2021-11-11", 5302
        );
        Incidence vlbg20211110 = new Incidence(
                "Vorarlberg", "2021-11-10", 2400
        );
        Incidence vlbg20211109 = new Incidence(
                "Vorarlberg", "2021-11-09", 1111
        );

        ArrayList<Incidence> recordedValues = new ArrayList<>();
        recordedValues.add(stmk20211109);
        recordedValues.add(stmk20211110);
        recordedValues.add(stmk20211111);
        recordedValues.add(bgld20211109);
        recordedValues.add(bgld20211110);
        recordedValues.add(bgld20211111);
        recordedValues.add(vlbg20211109);
        recordedValues.add(vlbg20211110);
        recordedValues.add(vlbg20211111);

        recordedValues.add(new Incidence(
                "Salzburg", "2021-11-11", 2999));

        System.out.println("Count of recorded Records: " + recordedValues.size());

        // Count der gesamten Fälle
        int countTotalIncidents = 0;

        for(int i = 0; i < recordedValues.size(); i++){
            Incidence oneValue = recordedValues.get(i);
            countTotalIncidents += oneValue.getNumber();
        }

        System.out.println("Bisher in Österreich: " + countTotalIncidents + " Fälle");

        countTotalIncidents = 0;
        for(Incidence incidence : recordedValues){
            countTotalIncidents += incidence.getNumber();
        }

        System.out.println("Bisher in Österreich: " + countTotalIncidents + " Fälle");

        // Anzahl der Fälle je Bundesland
        HashMap<String, Integer> totalIncidencesState = new HashMap<>();

        for (Incidence recordedValue : recordedValues) {
            /*
                1. Ist mein Key bereits in der Liste?
                    2. Wenn nein, dann muss ich den Key aufnehmen
                    3. Wenn ja, dann muss ich den Wert auslesen, summieren und neu ablegen
             */

            if (totalIncidencesState.containsKey(recordedValue.getState())){
                // ja, Fall 3.
                int currentValue = totalIncidencesState.get(recordedValue.getState());
                currentValue += recordedValue.getNumber();
                totalIncidencesState.put(recordedValue.getState(), currentValue);
            }
            else {
                // nein, Fall 2.
                totalIncidencesState.put(recordedValue.getState(), recordedValue.getNumber());
            }

        }

        System.out.println("totalIncidencesState = " + totalIncidencesState);
        
    }

}
