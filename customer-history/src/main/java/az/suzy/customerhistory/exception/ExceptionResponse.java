package az.suzy.customerhistory.exception;

import lombok.*;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionResponse {
    private LocalDate date;
    private String message;
    private String description;
}
