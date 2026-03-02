import java.util.*;

public class DeviceRegistry {
    private final List<Object> devices = new ArrayList<>();

    public void add(Object d) {
        devices.add(d);
    }

    public <T> T getFirstWithCapability(Class<T> capability) {
        for (Object d : devices) {
            if (capability.isInstance(d)) {
                return capability.cast(d);
            }
        }
        throw new IllegalStateException("No device found with capability: " + capability.getSimpleName());
    }

    public Object getFirstOfType(String simpleName) {
        for (Object d : devices) {
            if (d.getClass().getSimpleName().equals(simpleName))
                return d;
        }
        throw new IllegalStateException("Missing: " + simpleName);
    }
}
