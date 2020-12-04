package main.app;

import main.bin.TaskList;
import main.bin.TaskRequest;
import main.files.ConsoleColors;
import main.io.DataReader;

public class TaskControl {

    private static final int exit = 0;
    private static final int addTask = 1;
    private static final int removeTask = 2;
    private static final int printTask = 3;

    private DataReader dataReader = new DataReader();
    private TaskList taskList = new TaskList();

    public void controlApp() {
        int option;

        do {
            printOption();
            option = dataReader.getInt();
            switch (option) {
                case addTask:
                    addTask();
                    break;
                case removeTask:
                    removeTask();
                    break;
                case printTask:
                    printTask();
                    break;
                case exit:
                    exit();
                    break;
                default:
                    System.err.println("Nie ma takiej opcji. Wybierz ponownie.");
            }
        } while (option != exit);
    }

    private void printOption() {
        System.out.println(ConsoleColors.YELLOW_BOLD);
        System.out.println("Wybierz jedną z opcji: " + "\n");
        System.out.println(addTask + " - Dodaj zadanie do listy");
        System.out.println(removeTask + " - Usuń zadanie z listy");
        System.out.println(printTask + " - Wyświetl zadania z listy");
        System.out.println(exit + " - Zapisz i wyjdź");
    }

    private void addTask() {
        TaskRequest taskRequest = dataReader.readAndCreate();
        taskList.addTask(taskRequest);
    }

    private void removeTask() {

    }

    private void printTask() {
        taskList.printTask();
    }

    private void exit() {
        System.out.println(ConsoleColors.BLUE_BOLD);
        System.out.println("Zamykanie programu");
        dataReader.close();
    }
}
