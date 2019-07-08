package binbinlau.plane.xo.enums;

public enum EStatus {
    disable("0"),
    enable("1"),
    deleted("2"),
    init("10"),
    start("11"),
    wait("12"),
    end("13");

    private final String value;

    private EStatus(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }

    public static EStatus get(int value) {
        String str = String.valueOf(value);
        return get(str);
    }

    public static EStatus get(String str) {
        for (EStatus e : values()) {
            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
}
