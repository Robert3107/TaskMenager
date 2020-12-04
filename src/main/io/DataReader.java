package main.io;

import main.bin.TaskRequest;
import java.util.Scanner;

public class DataReader {

    private Scanner scr = new Scanner(System.in);

    public void close() {
        scr.close();
    }

    public int getInt() {
        int number = scr.nextInt();
        scr.nextLine();
        return number;
    }

    public TaskRequest readAndCreate() {

        System.out.println("Nazwa zadania: ");
        String taskName = scr.nextLine();

        System.out.println("Informacje o zadaniu: ");
        String taskInfo = scr.nextLine();

        System.out.println("Data wykonania zadania: rrrr-mm-dd ");
        String taskDate = scr.nextLine();

        System.out.println("Czy zadanie jest ważne? Wypisz TAK/NIE: ");
        String importantOrNot = scr.nextLine();

        return new TaskRequest(taskName, taskInfo, taskDate, importantOrNot);
    }
}
