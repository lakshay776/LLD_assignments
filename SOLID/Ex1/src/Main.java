public class Main {
    public static void main(String[] args) {

        System.out.println("=== Student Onboarding ===");

      
        FakeDb db = new FakeDb();
        
        OnboardingParser parser = new OnboardingParser();
        StudentValidator validator = new StudentValidator();
        StudentRepository repo = new FakeDbRepository(db);
        OnboardingPrinter printer = new OnboardingPrinter();

       
        OnboardingService svc =
            new OnboardingService(parser, validator, repo, printer);

        String raw =
            "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";

        svc.registerFromRawInput(raw);

        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(db));
    }
}