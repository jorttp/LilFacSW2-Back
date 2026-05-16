package co.edu.uco.lilfac.application.util;

public class UtilText {
	
	public static final String EMPTY = "";
    public static final String SPACE = " ";

    private UtilText() {
        super();
    }

    public static String getDefault() {
        return EMPTY;
    }

    public static boolean isNull(final String value) {
        return value == null;
    }

    public static boolean isEmpty(final String value) {
        return getDefault().equals(value.trim());
    }

    public static boolean isNullOrEmpty(final String value) {
        return isNull(value) || isEmpty(value);
    }

    public static String applyDefault(final String value) {
        return isNull(value) ? getDefault() : value.trim();
    }

}
