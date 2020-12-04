package main.bin;

import main.files.ConsoleColors;

public class TaskRequest {

    String taskName;
    String taskInfo;
    String taskDate;
    String importantOrNot;

    public TaskRequest(String taskName, String taskInfo, String taskDate, String importantOrNot) {
        this.taskName = taskName;
        this.taskInfo = taskInfo;
        this.taskDate = taskDate;
        this.importantOrNot = importantOrNot;
    }

    public void printInfo() {

        String info = "Nazwa zadania: " + taskName + "\n"
                + "Dodatkowe informacje o zadaniu: " + taskInfo + "\n"
                + "Data zadania: " + taskDate + "\n"
                + "Czy zadanie jest ważne?: " + importantOrNot;
        System.out.println(ConsoleColors.PURPLE_BOLD);
        System.out.println(info);
    }
}
