public class Main {
    public static void main(String[] args) {
        System.out.println("=== Transport Booking ===");

        IDistanceCalculator dist = new DistanceCalculator();
        IDriverAllocator alloc = new DriverAllocator();
        IPaymentGateway pay = new PaymentGateway();

        TransportBookingService service = new TransportBookingService(dist, alloc, pay);

        TripRequest req = new TripRequest("23BCS1010", new GeoPoint(12.97, 77.59), new GeoPoint(12.97, 77.62));
        service.book(req);
    }
}
