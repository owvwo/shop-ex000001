package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CookingStarted extends AbstractEvent {

    private Long id;
    private Boolean isDelivery;
    private Boolean isCooked;

    public CookingStarted(Cook aggregate) {
        super(aggregate);
    }

    public CookingStarted() {
        super();
    }
}
//>>> DDD / Domain Event
