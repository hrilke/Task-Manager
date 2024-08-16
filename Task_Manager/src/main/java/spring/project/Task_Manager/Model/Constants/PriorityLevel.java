package spring.project.Task_Manager.Model.Constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PriorityLevel {
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private final String value;

    PriorityLevel(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static PriorityLevel fromValue(String value) {
        for (PriorityLevel priority : values()) {
            if (priority.getValue().equalsIgnoreCase(value)) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
