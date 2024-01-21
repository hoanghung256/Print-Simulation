
import java.util.Scanner;

import model.Job;

/**
 *
 * @author hoang
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JobManager2 jobManager = new JobManager2();

        do {
            showMenu();
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            execute(choice, jobManager);
        } while (true);
    }

    private static void showMenu() {
        System.out.println("PRINT SIMULATION WITH ARRAYQUEUE");
        System.out.println("1. Add print job");
        System.out.println("2. Execute next print job");
        System.out.println("3. Show all remain print jobs");
        System.out.println("4. Exit");
    }

    private static void execute(int n, JobManager2 jobManager) {
        Scanner sc = new Scanner(System.in);

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
