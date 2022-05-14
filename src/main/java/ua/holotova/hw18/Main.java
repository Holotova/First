package ua.holotova.hw18;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Box from xml File: \n %s \n", fillBoxFromXml(new Box()));
        System.out.println();
        System.out.printf("Box from json File: \n %s", fillBoxFromJson(new Box()));

    }

    private static String getStringFromFile(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        String result = "";
        if (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }

    private static String getTextFromXml() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream input = loader.getResourceAsStream("hw18/task1.xml");
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            list.add(scanner.nextLine());
        }
        scanner.close();
        String text = list.stream()
                .collect(Collectors.joining());
        return text;
    }

    private static String getTextFromJson() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream input = loader.getResourceAsStream("hw18/task1.json");
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            list.add(scanner.nextLine());
        }
        scanner.close();
        String text = list.stream()
                .collect(Collectors.joining());
        return text;
    }

    private static Box fillBoxFromXml(Box box) {
        MaxLiftingCapacity maxLiftingCapacity = new MaxLiftingCapacity();
        maxLiftingCapacity.setUnit(getStringFromFile(getTextFromXml(), "unit=.(\\w+)"));
        maxLiftingCapacity.setValue(Integer.parseInt(getStringFromFile(getTextFromXml(), "kg..(\\w+)")));

        Cargo cargo = new Cargo();
        cargo.setName(getStringFromFile(getTextFromXml(), "name.(\\w+)"));
        cargo.setClasss(getStringFromFile(getTextFromXml(), "class.(\\w+.\\d)"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse((getStringFromFile(getTextFromXml(), "date.(\\d+.\\d+.\\d+.\\d+.\\d+.\\d+)")), formatter);

        box.setFrom(getStringFromFile(getTextFromXml(), "from=.(\\w+)"));
        box.setMaterial(getStringFromFile(getTextFromXml(), "material=.(\\w+)"));
        box.setColor(getStringFromFile(getTextFromXml(), "color.(\\w+)"));
        box.setMaxLiftingCapacity(maxLiftingCapacity);
        box.setCargo(cargo);
        box.setDate(date);
        return box;
    }

    private static Box fillBoxFromJson(Box box) {
        MaxLiftingCapacity maxLiftingCapacity = new MaxLiftingCapacity();
        maxLiftingCapacity.setUnit(getStringFromFile(getTextFromJson(), "unit....(\\w+)"));
        maxLiftingCapacity.setValue(Integer.parseInt(getStringFromFile(getTextFromJson(), "value...(\\w+)")));

        Cargo cargo = new Cargo();
        cargo.setName(getStringFromFile(getTextFromJson(), "name....(\\w+)"));
        cargo.setClasss(getStringFromFile(getTextFromJson(), "class..\\s.(\\w+.\\d)"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse((getStringFromFile(getTextFromJson(), "date..\\s.(\\d+.\\d+.\\d+.\\d+.\\d+.\\d+)")), formatter);

        box.setFrom(getStringFromFile(getTextFromJson(), "from....(\\w+)"));
        box.setMaterial(getStringFromFile(getTextFromJson(), "material....(\\w+)"));
        box.setColor(getStringFromFile(getTextFromJson(), "color....(\\w+)"));
        box.setMaxLiftingCapacity(maxLiftingCapacity);
        box.setCargo(cargo);
        box.setDate(date);
        return box;
    }


}

    
