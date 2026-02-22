interface InvoiceStore {
    void save(String id, String text);
    int countLines(String id);
}
