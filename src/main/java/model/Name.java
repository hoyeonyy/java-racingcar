package model;

public class Name {
    private final String INVALID_RANGE_ERROR_MESSAGE = "이름의 길이는 1~5글자 사이만 가능합니다.";
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
