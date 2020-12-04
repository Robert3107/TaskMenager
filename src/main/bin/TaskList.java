package main.bin;

public class TaskList {

    private static final int maxTask = 100;
    private TaskRequest[] taskTab = new TaskRequest[maxTask];
    private int taskNumber;

    public void addTask(TaskRequest taskRequest) {
        if (taskNumber < maxTask) {
            taskTab[taskNumber] = taskRequest;
            taskNumber++;
        } else {
            System.err.println("Została zapisana maksymalna ilość zadań." +
                    " Sprawdź listę oraz usuń przeterminowane zadania.");
        }
    }

    public void printTask() {
        if (taskNumber == 0) {
            System.err.println("Brak zadań na liście. Dodaj zadanie do listy.");
        }
        for (int i = 0; i < taskNumber; i++) {
            taskTab[i].printInfo();
        }
    }
}
