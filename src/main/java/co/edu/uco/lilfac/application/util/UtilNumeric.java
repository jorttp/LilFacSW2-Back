package co.edu.uco.lilfac.application.util;

public class UtilNumeric {
	
	private static final int DEFAULT_INT = 0;
    private static final double DEFAULT_DOUBLE = 0.0;

    private UtilNumeric() {
        super();
    }

    public static int getDefaultInt() {
        return DEFAULT_INT;
    }

    public static double getDefaultDouble() {
        return DEFAULT_DOUBLE;
    }

    public static boolean isNull(final Integer value) {
        return value == null;
    }

    public static boolean isNull(final Double value) {
        return value == null;
    }

    public static int applyDefault(final Integer value) {
        return isNull(value) ? getDefaultInt() : value;
    }

    public static double applyDefault(final Double value) {
        return isNull(value) ? getDefaultDouble() : value;
    }

    public static boolean isNegative(final int value) {
        return value < DEFAULT_INT;
    }

    public static boolean isNegative(final double value) {
        return value < DEFAULT_DOUBLE;
    }

    public static boolean isZero(final int value) {
        return value == DEFAULT_INT;
    }

    public static boolean isZero(final double value) {
        return value == DEFAULT_DOUBLE;
    }

    public static boolean isZeroOrNegative(final int value) {
        return isZero(value) || isNegative(value);
    }

    public static boolean isZeroOrNegative(final double value) {
        return isZero(value) || isNegative(value);
    }

}
