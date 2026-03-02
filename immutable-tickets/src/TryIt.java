import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

/**
 * Demo proving that IncidentTicket is now immutable.
 */
public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        // 1. Create a ticket
        IncidentTicket t1 = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Initial: " + t1);

        // 2. Service "updates" return new instances; original remains unchanged
        IncidentTicket t2 = service.assign(t1, "agent@example.com");
        IncidentTicket t3 = service.escalateToCritical(t2);

        System.out.println("\nOriginal after service calls (unchanged): " + t1);
        System.out.println("After assignment (new instance): " + t2);
        System.out.println("After escalation (new instance): " + t3);

        // 3. Prove that external mutation of tags has no effect
        try {
            List<String> tags = t3.getTags();
            tags.add("HACKED_FROM_OUTSIDE");
        } catch (UnsupportedOperationException e) {
            System.out.println("\nSuccessfully blocked external tag mutation (UnmodifiableList)");
        }

        System.out.println("\nFinal state of t3: " + t3);
        
        // Note: Direct mutation like t1.setPriority("HIGH") will no longer compile.
    }
}
