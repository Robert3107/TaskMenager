package main.app;

import main.files.ConsoleColors;

public class TaskApp {
    private static String appName = "Menadżer zadań";

    public static void main(String[] args) {

        System.out.println(ConsoleColors.BLUE_BOLD);
        System.out.println("---------- " + appName + " ----------");

        TaskControl taskControl = new TaskControl();
        taskControl.controlApp();
    }
}
