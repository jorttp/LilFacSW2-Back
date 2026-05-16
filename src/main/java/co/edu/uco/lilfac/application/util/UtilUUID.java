package co.edu.uco.lilfac.application.util;

import java.util.UUID;

public class UtilUUID {
	
	private static final UUID DEFAULT = UUID.fromString("00000000-0000-0000-0000-000000000000");

    private UtilUUID() {
        super();
    }

    public static UUID getDefault() {
        return DEFAULT;
    }

    public static boolean isNull(final UUID value) {
        return value == null;
    }

    public static boolean isDefault(final UUID value) {
        return getDefault().equals(value);
    }

    public static boolean isNullOrDefault(final UUID value) {
        return isNull(value) || isDefault(value);
    }

    public static UUID applyDefault(final UUID value) {
        return isNull(value) ? getDefault() : value;
    }

    public static UUID generate() {
        return UUID.randomUUID();
    }

}
