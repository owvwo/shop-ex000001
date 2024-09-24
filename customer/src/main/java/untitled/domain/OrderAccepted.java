package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class OrderAccepted extends AbstractEvent {

    private Long id;
    private Boolean isDelivery;
    private Boolean isCooked;
    private Boolean isConfirmed;
}
