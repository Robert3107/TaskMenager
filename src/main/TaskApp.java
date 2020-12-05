package main;

import org.apache.commons.lang3.ArrayUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class TaskApp {

    private static final String NAME_APP = "Menadżer zadań";
    private static final String EXIT = "0";
    private static final String ADD_TASK = "1";
    private static final String REMOVE_TASK = "2";
    private static final String LIST = "3";
    private static final String FILE_NAME = "tasks.csv";
    public static String[][] tasks;


    public static void printStart() {
        String info = "\n" + ConsoleColors.BLUE_BOLD + "----------" + NAME_APP + "----------";
        System.out.println(info);
    }

    public static void printInfo() {
        String option = ConsoleColors.YELLOW_BOLD + " \n" + ADD_TASK + " - Dodaj zadanie: " + "\n"
                + REMOVE_TASK + " - Usuń zadanie: " + "\n"
                + LIST + " - Wyświetl zadania " + "\n"
                + EXIT + " - Wyjdź z programu";
        System.out.println(option);
    }

    public static void main(String[] args) {

        tasks = loadData(FILE_NAME);
        printStart();
        printInfo();
        Scanner scr = new Scanner(System.in);
        while (scr.hasNext()) {
            String option = scr.nextLine();

            switch (option) {
                case ADD_TASK -> addTask();
                case REMOVE_TASK -> {
                    removeTask(tasks, checkNumber());
                    System.out.println("Zadanie zostało usunięte.");
                }
                case LIST -> printTasks(tasks);
                case EXIT -> {
                    exitAndSave(FILE_NAME, tasks);
                    System.out.println(ConsoleColors.BLUE_BOLD + "Koniec programu");
                    System.exit(0);
                }
                default -> System.err.println("Wybierz właściwą opcję.");
            }
            printInfo();
        }
    }

    public static void addTask() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nazwa zadania:");
        String nameTask = scanner.nextLine();
        System.out.println("Data wykonania zadania: ");
        String dateTask = scanner.nextLine();
        System.out.println("Czy zadanie jest ważne? Wpisz tak/nie: ");
        String importantOrNot = scanner.nextLine();
        tasks = Arrays.copyOf(tasks, tasks.length + 1);
        tasks[tasks.length - 1] = new String[3];
        tasks[tasks.length - 1][0] = nameTask;
        tasks[tasks.length - 1][1] = dateTask;
        tasks[tasks.length - 1][2] = importantOrNot;
    }

    public static void removeTask(String[][] tab, int number) {

        if (number < tab.length) {
            tasks = ArrayUtils.remove(tab, number);
        } else {
            System.err.println("Element nie istnieje w tablicy");
        }
    }

    public static int checkNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer zadania do usunięcia: ");
        String number = scanner.nextLine();

        while (Integer.parseInt(number) < 0) {
            System.err.println("Podana liczba jest mniejsza od zera");
        }
        return Integer.parseInt(number);
    }

    public static void printTasks(String[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(i + " - ");
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.print("\n");
        }
    }


    public static void exitAndSave(String file, String[][] tab) {
        Path fileDir = Paths.get(file);

        String[] line = new String[tasks.length];
        for (int i = 0; i < tab.length; i++) {
            line[i] = String.join(",", tab[i]);
            try {
                Files.write(fileDir, Arrays.asList(line));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String[][] loadData(String file) {
        Path dir = Paths.get(file);
        if (!Files.exists(dir)) {
            System.out.println("File not exist.");
            System.exit(0);
        }

        String[][] tab = null;

        try {
            List<String> strings = Files.readAllLines(dir);
            tab = new String[strings.size()][strings.get(0).split(",").length];

            for (int i = 0; i < strings.size(); i++) {
                String[] split = strings.get(i).split(",");
                System.arraycopy(split, 0, tab[i], 0, split.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tab;
    }
}

