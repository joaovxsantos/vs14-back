package task05.src.Service;

public enum Cores {

    ANSI_RESET("\u001B[0m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_RED("\u001B[31m"),
    RESET("\u001B[0m") ,
    GREEN_BG("\u001B[42m"),
    RED_BG("\u001B[41m"),
    BLACK_BG("\u001B[40m"),
    WHITE_TEXT("\u001B[37;1m"),
    NEGRITO_TEXT("\u001B[1m");

    private final String code;

    Cores(String code) {
        this.code = code;
    }

    public String getCodes() {
        return code;
    }
}
