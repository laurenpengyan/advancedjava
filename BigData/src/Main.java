import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;

// Question one: How much are the total awards per state?
// Question two: What are the total number of recipients per state?
public class Main {

    // Purposely omitting school city and institution type becuase the purpose only to count awards and recipients by state.
    private static final String OPE_ID_INDEX = "A";
    private static final String SCHOOL_NAME_INDEX = "B";
    private static final String STATE_INDEX = "D";
    private static final String AWARDS_INDEX = "F";
    private static final String RECIPIENTS_INDEX = "G";

    public static void main(String[] args) {

        // School list.
        List<School> schoolList = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {

            final String filePath = new File("src/data.json").getAbsolutePath();
            final JSONArray schools = (JSONArray) parser.parse(new FileReader(filePath));

            // Award and recipient HashMaps.
            HashMap<String, Long> awardsMap = new HashMap<>();
            HashMap<String, Long> recipientMap = new HashMap<>();

            // Parse through the JSON data and create the school objects/list.
            for (Object object : schools) {

                final JSONObject school = (JSONObject) object;

                final long opeID = (long) school.get(OPE_ID_INDEX);
                final String schoolName = (String) school.get(SCHOOL_NAME_INDEX);
                final String state = (String) school.get(STATE_INDEX);
                final long awards = (long) school.get(AWARDS_INDEX);
                final long recipients = (long) school.get(RECIPIENTS_INDEX);

                schoolList.add(new School(opeID, schoolName, state, awards, recipients));

            }

            // Tally up the number of awards and recipients per state by adding them to a HashMap.
            for (School school : schoolList) {

                if (awardsMap.containsKey(school.getState())) {
                    awardsMap.put(school.getState(), awardsMap.get(school.getState()) + school.getAwards());
                } else {
                    awardsMap.put(school.getState(), school.getAwards());
                }

                if (recipientMap.containsKey(school.getState())) {
                    recipientMap.put(school.getState(), awardsMap.get(school.getState()) + school.getRecipients());
                } else {
                    recipientMap.put(school.getState(), school.getRecipients());
                }

                // Test the implementation of the toString method.
                // System.out.println(school.toString());

            }

            // Sort the maps and print the results.
            Map<String, Long> sortedAwardsMap = new TreeMap<>(awardsMap);
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
            numberFormat.setMaximumFractionDigits(0);

            for (Map.Entry<String, Long> entry : sortedAwardsMap.entrySet()) {
                System.out.println(entry.getKey() + " = " + "Awards: " + numberFormat.format(entry.getValue()) + ", " +
                        " Recipients: " + NumberFormat.getNumberInstance(Locale.US).format(recipientMap.get(entry.getKey())));
            }

            // Test the implementation of the compareTo method.
            /* Collections.sort(schoolList);
            for (School school : schoolList)
                System.out.println(school.getId()); */


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
