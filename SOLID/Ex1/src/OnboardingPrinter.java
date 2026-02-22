import java.util.*;
public class OnboardingPrinter {
    public void input(String raw){
        System.out.println("Input"+raw);
    }
    void printErrors(List<String> errors){
        System.out.println("Error: cannot register");
        for(String err:errors){
            System.out.println(err);
        }
    }
    void printSuccess(String id,int total,StudentRecord rec){
        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + total);
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
