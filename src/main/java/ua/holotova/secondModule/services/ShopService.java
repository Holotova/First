//○	считывает данные из ранее созданного csv файла и случайным образом формирует заказ состоящий из 1-5 позиций.
//■	Если считывается некорректная строка нужно выбросить и правильно обработать исключение
//○	Сформированный заказ логируется в отдельный файл в формате
//■	[time] [user-data] [invoice-data]
//○	Также сформированные заказы сохраняются в хранилище (подходящая коллекция)
package ua.holotova.secondModule.services;

import ua.holotova.secondModule.model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

public class ShopService {
    public static final Map<String, Integer> technicsHeader = new HashMap<>();
    public static final List<Technics> technics = getTechnicsListFromCsv();

    public static List<Technics> getTechnicsListFromCsv() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream input = loader.getResourceAsStream("module2/module.csv");
        Scanner scanner;
        String line;
        ArrayList<Technics> technics = new ArrayList<>();
        try {
            scanner = new Scanner(input);
            if ((line = scanner.nextLine()) != null) {
                StringTokenizer str = new StringTokenizer(line, ",");
                int headerCount = str.countTokens();
                for (int i = 0; i < headerCount; i++) {
                    String headerKey = str.nextToken();
                    technicsHeader.put(headerKey, i);
                }
                while ((line = scanner.nextLine()) != null) {
                    String[] strings = line.split(",");
                    List<String> item = Arrays.stream(strings).toList();
                    checkForEmptyStrings(item);
                    technics.add(createTechnicUnit(item));
                }
            }
            scanner.close();
        } catch (DefectStringException e) {
            System.out.println(e.getMessage());
        } finally {
            return technics;
        }
    }

    private static void checkForEmptyStrings(List<String> items) throws DefectStringException {
        for (String item : items) {
            if (item.isEmpty()) {
                throw new DefectStringException("Incorrect string - missing element");
            }
        }
    }

    private static Technics createTechnicUnit(List<String> item) {
        if (Objects.equals(item.get(technicsHeader.get("type")), "Telephone")) {
            return new Telephone(item.get(technicsHeader.get("series")), item.get(technicsHeader.get("screen type")),
                    Integer.valueOf(item.get(technicsHeader.get("price"))), item.get(technicsHeader.get("model")));
        } else if (Objects.equals(item.get(technicsHeader.get("type")), "Television")) {
            return new Television(item.get(technicsHeader.get("series")), item.get(technicsHeader.get("screen type")),
                    Integer.valueOf(item.get(technicsHeader.get("price"))), Integer.valueOf(item.get(technicsHeader.get("diagonal"))),
                    item.get(technicsHeader.get("country")));
        }
        return null;
    }

    public static List<Technics> formOrder() {
        Random random = new Random();
        Technics[] orderArray = new Technics[random.nextInt(1, 6)];
        for (int i = 0; i < orderArray.length; i++) {
            orderArray[i] = technics.get(random.nextInt(0, 9));
        }
        List<Technics> orderList = Arrays.stream(orderArray).toList();
        return orderList;
    }

    public static Invoice formInvoice() {
        Date dateNow = new Date();
        SimpleDateFormat timeNow = new SimpleDateFormat("hh:mm:ss");
        String time = timeNow.format(dateNow);
        List<Technics> techno = formOrder();
        Customer customer = PersonService.generateCustomer();
        String type = Invoice.setType(techno);
        return new Invoice(time, customer, type, techno);

    }

    public static LinkedList<Invoice> generateFifteenOrders() {
        LinkedList<Invoice> fifteenOrdersList = new LinkedList<>();
        for (int i = 0; i < 15; i++) {
            fifteenOrdersList.add(formInvoice());
        }
        return fifteenOrdersList;
    }

    public static void writeFileWithInvoices() {
        LinkedList<Invoice> invoices = generateFifteenOrders();
        try (FileWriter fileWriter = new FileWriter("invoices.txt")) {
            for (Invoice invoice : invoices) {
                fileWriter.write(invoice.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

