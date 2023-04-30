//дополнительно. К калькулятору из предыдущего дз добавить логирование.

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task3 {
    private static String operations;
    private static int result;
    private static int numberOne;
    private static int numberTwo;
    private static Logger logger;
    private static boolean power;

    public static void main(String[] args) throws IOException {
        logger = Logger.getLogger(task3.class.getName());
        FileHandler fh = new FileHandler("src/main/java/txt/calcLogs.txt");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        power = true;
        while (power) {
            System.out.print("Введите первое число: ");
            numberOne = scanNumber();
            System.out.print("Введите второе число: ");
            numberTwo = scanNumber();
            System.out.println("Введите оператор: -, +, *, /      0 - Выход!");
            operations = scanOperations();
            result = getResult();
            if (power) {
                System.out.printf("Результат: %d %s %d = %d\n", numberOne, operations, numberTwo, result);
            }
        }
    }

    static int scanNumber() {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        return number;
    }

    static String scanOperations() {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        return str;
    }

    static int getResult() {
        String sol = numberOne + " " + operations + " " + numberTwo + " = ";
        switch (operations) {
            case "+":
                result = numberOne + numberTwo;
                logger.info(sol + result);
                break;
            case "-":
                result = numberOne - numberTwo;
                logger.info(sol + result);
                break;
            case "*":
                result = numberOne * numberTwo;
                logger.info(sol + result);
                break;
            case "/":
                result = numberOne / numberTwo;
                logger.info(sol + result);
                break;
            case "0":
                power = false;
                System.out.println("Завершение работы калькулятора!");
                break;
            default:
                System.out.println("!!!НЕ ПРАВИЛЬНЫЙ ОПЕРАТОР!!!");
                System.out.println("Введите оператор: -, +, *, /");
                operations = scanOperations();
                logger.warning(sol + result);
                getResult();
                break;
        }
        return result;
    }
}

