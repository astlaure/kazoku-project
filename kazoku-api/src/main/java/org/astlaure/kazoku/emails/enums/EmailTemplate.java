package org.astlaure.kazoku.emails.enums;

public enum EmailTemplate {
    RESET_PASSWORD("reset-password.ftlh");

    public final String value;

    EmailTemplate(String value) {
        this.value = value;
    }
}
