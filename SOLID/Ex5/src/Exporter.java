public abstract class Exporter {

    public final ExportResult export(ExportRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("ExportRequest must not be null");
        }
        ExportResult result = doExport(req);
        if (result == null) {
            throw new IllegalStateException("Exporter must return a non-null ExportResult");
        }
        return result;
    }

    protected abstract ExportResult doExport(ExportRequest req);
}
