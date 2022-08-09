import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Приветствуем! Добро пожаловать в магазин 'Рога/Копыта'!");

        while (true) {
            System.out.println("ВНИМАНИЕ! В нашем магазине действует акция 3 по цене 2!" +
                    "Введите промо-код 'Халява', чтобы перейти к акционным товарам!");
            System.out.println("Пожалуйста, введите промо-код или 'go', чтобы начать покупки (end - завершить покупки).");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            if ("1".equals(input)) {
                Shop.shopping();
                Shop.printBasket();
                Shop.summarizer();
                Shop.totalCount();
            }
            if ("Халява".equals(input)) {
                SaleThreeAsOne.shopping();
                SaleThreeAsOne.printBasket();
                SaleThreeAsOne.summarizer();
                SaleThreeAsOne.totalCount();
            }
        }
        System.out.println("Ваша корзина:");
        if (Shop.textBasket != null) {
            System.out.println(Shop.textBasket);
        } else {
            System.out.println();
        }
        if (SaleThreeAsOne.textBasket != null) {
            System.out.println(SaleThreeAsOne.textBasket);
        } else {
            System.out.println();
        }
        System.out.println("Итого: " + (Shop.sum + SaleThreeAsOne.sum) + " руб.");
    }
}