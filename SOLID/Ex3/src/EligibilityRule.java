import java.util.*;

public interface EligibilityRule {
    boolean check(StudentProfile s, List<String> reasons);
}