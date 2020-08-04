package az.iba.loanconfirmation.api.internal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SimulationResult {
    private String fullName;
    private String result;
}
