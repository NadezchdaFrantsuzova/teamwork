import java.util.Scanner;

public class Shop {
    protected static Scanner scanner = new Scanner(System.in);
    protected static String[] products = {"Хлеб", "Яблоки", "Молоко", "Йогурт"};
    protected static int[] prices = {50, 80, 60, 10};
    protected static int[] basket = new int[products.length];
    protected static int[] summary = new int[products.length];
    protected static double sum = 0;
    public static String textBasket;

    public static void shopping() {
        while (true) {
            System.out.println("Список возможных товаров для покупки:");
            for (int i = 0; i < products.length; i++) {
                System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб./шт.");
            }
            System.out.println("Выберите товар и количество или введите 'end' для возврата в главное меню.");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] custChoice = input.split(" ");
            if (custChoice.length != 2) {
                throw new RuntimeException("Пожалуйста, введите только 2 числа: номер продукта по списку и количество!");
            }
            try {
                int productNumber = Integer.parseInt(custChoice[0]) - 1;
                if ((productNumber + 1) > products.length || (productNumber + 1) < 0) {
                    throw new RuntimeException("Введен некорректный номер товара! Пожалуйста, введите номер из списка.");
                }
                int productCount = Integer.parseInt(custChoice[1]);
                if (productCount == 0) {
                    basket[productNumber] = 0;
                } else {
                    basket[productNumber] += productCount;
                }
            } catch (NumberFormatException error) {
                System.out.println("Вы ввели название товара! Пожалуйста, введите его номер по списку.");
                continue;
            }
        }

    }

    public static void printBasket() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < products.length; i++) {
            if (basket[i] > 0) {
                s.append(products[i]);
                s.append(" ");
                s.append(basket[i]);
                s.append(" шт.");
                s.append(" ");
                s.append(prices[i]);
                s.append(" руб./шт.");
                s.append(" ");
                s.append((basket[i] * prices[i]));
                s.append(" руб. в сумме");
                s.append("\n");
            }
        }
        textBasket = s.toString();
    }

    public static void summarizer() {
        for (int i = 0; i < products.length; i++) {
            if (basket[i] > 0) {
                summary[i] = (basket[i] * prices[i]);
            }
        }
    }

    public static void totalCount() {
        for (int sum1 : summary) {
            sum += sum1;
        }
    }
}