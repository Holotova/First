/*Смоделировать сервис по починке телефонов
        Сервис должен принимать любой телефон (создать 3-4 реализации)
        Одна реализация телефона должна иметь поломку (любая реализация, просто чтобы ваш сервис мог найти эту поломку и обработать)
        Каждый класс телефона должен иметь один уникальный метод
        После нахождения поломки нужно протестировать все методы данного телефона (вызвать все метода класса)
        Выполнить двух-этапное сравнение (equals и hashCode) сломанного телефона с эталонным

        Написать программу на основе ООП принципов*/

package ua.holotova.hw11;

public class PhoneService {
    public static void main(String[] args) {
        Phone[] phones = new Phone[3];
        phones[0] = new Samsung();
        phones[1] = new IPhone();
        phones[2] = new Nokia();
        incomingCall(phones);
        checkCharge(phones);
        testAllFunctions(phones);
        comparePones(phones);
    }

    private static void incomingCall(Phone[] phones) {
        for (Phone phone : phones) {
            phone.incomingCall();
        }
    }

    private static void checkCharge(Phone[] phones) {
        for (Phone phone : phones) {
            phone.workAfterCharge();
        }
    }

    private static void testAllFunctions(Phone[] phones) {
        for (Phone phone : phones) {
            if (phone instanceof Nokia nokia) {
                nokia.workAfterRepair(9);
                nokia.outgoingCall(0507520502);
                nokia.displayMobileOperator("Life");
                nokia.displayNews();
            }
        }
    }
    private static void comparePones (Phone[] phones){
        if(phones[2].hashCode() == phones[1].hashCode()){
            if(phones[2].equals(phones[1])){
                System.out.println("Phone is the same");
            }
        }
        System.out.println("Different phones");
    }
}
