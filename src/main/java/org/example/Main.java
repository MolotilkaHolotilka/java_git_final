package org.example;
import java.util.*;
import java.util.random.RandomGenerator;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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
        System.out.println("Сыграть ещё раз? (y/n) ");
        in.nextLine(); // очистка после nextInt
        String choice = in.nextLine();

        playAgain = choice.trim().equalsIgnoreCase("y");

    }}
}