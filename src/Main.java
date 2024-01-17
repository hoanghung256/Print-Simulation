
import java.util.Scanner;

import model.Job;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author hoang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            showMenu();
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            execute(choice);
        } while (true);
    }

    private static void showMenu() {
        System.out.println("PRINT SIMULATION");
        System.out.println("1. Add print job");
        System.out.println("2. Execute next print job");
        System.out.println("3. Show all remain print jobs");
        System.out.println("4. Exit");
    }

    private static void execute(int n) {
        Scanner sc = new Scanner(System.in);
        JobManager jobManager = new JobManager();

        switch (n) {
            case 1:
                System.out.print("Enter job's name: ");
                String jobName = sc.nextLine();
                System.out.print("Enter job's priority: ");
                int priority = sc.nextInt();
                sc.nextLine();

                jobManager.addJob(new Job(jobName, priority));
                break;
            case 2:
                jobManager.executeNextJob();
                break;
            case 3:
                jobManager.showAllJob();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
}
