// Author: Lashmini A D
// CTS DN 5.0 - Week1 - Exercise01 - Singleton Pattern

public class Main {
    public static void main(String[] args){
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();

        log1.log("Application started...");
        log2.log("User logged in.");

        if(log1 == log2)
            System.out.println("Both are same instance. So Singleton is verified.");
    }
}