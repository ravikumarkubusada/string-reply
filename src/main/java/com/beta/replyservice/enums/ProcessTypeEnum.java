package com.beta.replyservice.enums;

public enum ProcessTypeEnum {
    REVERSE("1"),
    ENCODE("2");
    public final String label;

    private ProcessTypeEnum(String label) {
        this.label = label;
    }
}
