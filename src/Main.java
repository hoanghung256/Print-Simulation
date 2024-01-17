
import java.util.Scanner;

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
            int choice = sc.nextInt();
            sc.nextLine();
            execute(choice);
        } while (true);
    }
    
    private static void showMenu() {
        System.out.println("PRINT SIMULATION");
        System.out.println("1. Add job");
        System.out.println("2. Execute next job");
        System.out.println("3. Show all remain jobs");
        System.out.println("4. Exit");        
    }
    
    private static void execute(int n) {
        switch (n) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                System.exit(0);
                break;    
        }
    }
}
