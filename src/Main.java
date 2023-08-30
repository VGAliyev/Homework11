import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Homework 11\n");

        System.out.println("Task 1");
        int year = 2023;
        checkYear(year);
        System.out.println();

        System.out.println("Task 2");
        byte clientOS = 1;
        short clientDeviceYear = 2022;
        checkClientDevice(clientOS, clientDeviceYear);
        System.out.println();

        System.out.println("Task 3");
        int distance = 95;
        int deliveryTime = determineDeliveryTime(distance);
        if (deliveryTime == -1) {
            System.out.println("Доставки на расстояние " + distance + " км нет!");
        } else {
            System.out.println("Время доставки на расстояние "
                    + distance + " км "
                    + deliveryTime + " дней.");
        }
    }

    public static void checkYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " год является високосным.\n");
        } else {
            System.out.println(year + " год не является високосным.\n");
        }
    }

    public static void checkClientDevice(byte clientOS, short clientYear) {
        int currentYear = LocalDate.now().getYear();
        if (clientOS == 0 && clientYear < currentYear) {
            System.out.println("Установите облегчённую версию приложения для iOS по ссылке.\n");
        } else if (clientOS == 0 && clientYear == currentYear) {
            System.out.println("Установите версию для iOS по ссылке.\n");
        } else if (clientOS == 1 && clientYear < currentYear) {
            System.out.println("Установите облегчённую версию приложения для Android по ссылке.\n");
        } else if (clientOS == 1 && clientYear == currentYear) {
            System.out.println("Установите версию для Android по ссылке.\n");
        } else {
            System.out.println("Неизвестная операционная система!");
        }
    }

    public static int determineDeliveryTime(int deliveryDistance) {
        if (deliveryDistance < 20) {
            return 1;
        } else if (deliveryDistance >= 20 && deliveryDistance < 60) {
            return 2;
        } else if (deliveryDistance >= 60 && deliveryDistance < 100) {
            return 3;
        } else {
            return -1;
        }
    }
}