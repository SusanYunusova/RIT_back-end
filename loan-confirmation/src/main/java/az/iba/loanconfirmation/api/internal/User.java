package az.iba.loanconfirmation.api.internal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private int isAccept;
}
