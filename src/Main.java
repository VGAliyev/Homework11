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
            System.out.printf("%d год является високосным.\n", year);
        } else {
            System.out.printf("%d год не является високосным.\n", year);
        }
    }

    public static void checkClientDevice(byte clientOS, short clientYear) {
        String deviceOSName = checkDeviceOS(clientOS);
        if (deviceOSName.isEmpty()) {
            System.out.println("Неизвестное устройство!");
            return;
        }
        if (checkDeviceYear(clientYear)) {
            System.out.printf("Установите облегчённую версию приложения для %s по ссылке. \n", deviceOSName);
        } else {
            System.out.printf("Установите приложение для %s по ссылке.\n", deviceOSName);
        }
    }

    /**
     * Проверка года устройства
     * @param clientYear - год выпуска устройства
     * @return булево значение (true - устройство старое; false - устройство новое)
     */
    private static boolean checkDeviceYear(short clientYear) {
        int currentYear = LocalDate.now().getYear();
        return clientYear < currentYear;
    }

    /**
     * Проверка ОС устройства
     * @param clientOS - цифровое обозначение ОС устройства
     * @return Строка с наименование ОС, либо пустая строка, если устройство неизвестно
     */
    private static String checkDeviceOS(byte clientOS) {
        return switch (clientOS) {
            case 0 -> "iOS";
            case 1 -> "Android";
            default -> "";
        };
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