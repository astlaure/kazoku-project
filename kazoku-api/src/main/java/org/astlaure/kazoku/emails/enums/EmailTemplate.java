package org.astlaure.kazoku.emails.enums;

public enum EmailTemplate {
    RESET_PASSWORD("reset-password");

    public final String value;

    EmailTemplate(String value) {
        this.value = value;
    }
}
