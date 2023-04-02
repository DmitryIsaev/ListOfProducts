import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Операции:\n1. Добавить;\n2. Показать;\n3. Удалить;\n4. Поиск.\nВыберите операцию:");
            String number = scanner.next();
            switch (number) {
                case "1":
                    System.out.println("\nКакую покупку хотите добавить?");
                    list.add(scanner.next());
                    System.out.println("Итого в списке покупок:" + list.size());
                    break;

                case "2":
                    System.out.println("\nСписок покупок:");
                    printList(list);
                    break;

                case "3":
                    System.out.println("\nСписок покупок:");
                    printList(list);
                    System.out.println("Какую хотите удалить? Введите номер или название");
                    String deletePurchase = scanner.next();
                    try {
                        int positionDelete = Integer.parseInt(deletePurchase) - 1;
                        deletePurchase = list.get(positionDelete);
                        list.remove(positionDelete);
                    } catch (Exception e) {
                        list.remove(deletePurchase);
                    }
                    System.out.println("\nПокупка \"" + deletePurchase + "\" удалена, список покупок:");
                    printList(list);
                    break;

                case "4":
                    System.out.println("\nВведите текст для поиска:");
                    String itemLower = scanner.next().toLowerCase();
                    int n = 0;
                    System.out.println("\nНайдено:");
                    for (int i = 0; i < list.size(); i++) {
                        String queryLower = list.get(i).toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            System.out.println((i + 1) + ". " + list.get(i));
                            n++;
                        }
                    }
                    if (n == 0) {
                        System.out.println("<Ничего>");
                    }
                    break;

                default:
                    System.out.println("Неправильная команда");
            }
        }
    }

    public static void printList(ArrayList<String> list) {
        if (list.size() == 0) {
            System.out.println("<Пусто>");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}