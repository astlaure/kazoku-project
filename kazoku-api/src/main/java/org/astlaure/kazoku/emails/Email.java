package org.astlaure.kazoku.emails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.astlaure.kazoku.emails.enums.EmailTemplate;
import org.thymeleaf.context.Context;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    private String from;
    private String to;
    private String subject;
    private EmailTemplate template;
    private Context context;
}
