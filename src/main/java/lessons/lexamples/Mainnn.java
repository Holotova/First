package lessons.lexamples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

public class Mainnn {
    public static void main(String[] args) {
        getEMailRecepientList();
    }
    public static void getEMailRecepientList() {
        List<EmailRecepientData> emailList = null;// Blank list of POJO class
        Scanner scanner = null;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("module.csv"));
            Map<String, Integer> mailHeader = new HashMap<>();
            // read file line by line
            int index = 0;
            String line = reader.readLine();
            // Get header from 1st row of csv
            if (line != null) {
                StringTokenizer str = new StringTokenizer(line, ",");
                int headerCount = str.countTokens();
                for (int i = 0; i < headerCount; i++) {
                    String headerKey = str.nextToken();
                    mailHeader.put(headerKey.toUpperCase(), new Integer(i));

                }
            }
            emailList = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                // POJO class for getter and setters
                EmailRecepientData email = new EmailRecepientData();
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                //Use Specific key to get value what u want
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    if (index == mailHeader.get("EMAIL"))
                        email.setEmailId(data);
                    else if (index == mailHeader.get("FN"))
                        email.setFirstName(data);
                    else if (index == mailHeader.get("LN"))
                        email.setLastName(data);
                    else if (index == mailHeader.get("CC"))
                        email.setCouponCode(data);

                    index++;
                }
                index = 0;
                emailList.add(email);
            }
            reader.close();
            scanner.close();
        } catch (Exception e) {
            StringWriter stack = new StringWriter();
            e.printStackTrace(new PrintWriter(stack));

        } 

        System.out.println("list--" + emailList);

    }
}
