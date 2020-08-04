package az.suzy.simulation.api.internal;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {
    private long id;
    private int isAccept;
}
