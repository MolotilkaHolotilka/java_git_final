package org.example;
import java.util.*;
import java.util.random.RandomGenerator;
import java.io.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Integer readRecord(String filename) {
        try {
            File f = new File(filename);
            if (!f.exists()) return null;

            try (Scanner sc = new Scanner(f)) {
                if (!sc.hasNextInt()) return null;
                return sc.nextInt();
            }
        } catch (Exception e) {
            return null;
        }
    }

    private static void writeRecord(String filename, int value) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(value);
        } catch (Exception e) {
            System.out.println("Не удалось записать рекорд: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Boolean playAgain = true;
        while(playAgain == true){
        // Глобальные переменные
        Integer countOfAttempts = 0;
        // Загадывание числа
        Random random = new Random();
        Integer randInt = random.nextInt(100);
        // Цикл ввода числа. Условие остановки - inp == randInt
        // Чтение числа пользователя
        Scanner in = new Scanner(System.in);
        Integer inp = 101;
        while(inp != randInt){
            countOfAttempts++; // Сразу инициализируем попытку, как первая
            System.out.println("Введите число: ");
            inp = in.nextInt();
            if(inp < randInt){
                System.out.println("Больше");
            } else if (inp > randInt) {
                System.out.println("Меньше");
            }
        }
        System.out.println("Ура, число угадано!");
        System.out.println("Число попыток: " + countOfAttempts);
        String filename = "record.txt";
        Integer record = readRecord(filename);
        if(record == null || countOfAttempts < record){
            writeRecord(filename, countOfAttempts);
        }
        System.out.println("Сыграть ещё раз? (y/n) ");
        in.nextLine(); // очистка после nextInt
            Integer recordNew = readRecord(filename);
            System.out.println("Твой рекорд:" + recordNew);
        String choice = in.nextLine();
        playAgain = choice.trim().equalsIgnoreCase("y");

    }}
}