import java.util.*;

public class OnboardingService {

    private final OnboardingParser parser;
    private final StudentValidator validator;
    private final StudentRepository repo;
    private final OnboardingPrinter printer;

    public OnboardingService(
        OnboardingParser parser,
        StudentValidator validator,
        StudentRepository repo,
        OnboardingPrinter printer
    ){
        this.parser = parser;
        this.validator = validator;
        this.repo = repo;
        this.printer = printer;
    }

    public void registerFromRawInput(String raw){

        printer.input(raw);

        Map<String,String> kv = parser.parse(raw);

        List<String> errors = validator.validate(kv);
        if(!errors.isEmpty()){
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(repo.count());

        StudentRecord rec = new StudentRecord(
            id,
            kv.get("name"),
            kv.get("email"),
            kv.get("phone"),
            kv.get("program")
        );

        repo.save(rec);

        printer.printSuccess(id, repo.count(), rec);
    }
}