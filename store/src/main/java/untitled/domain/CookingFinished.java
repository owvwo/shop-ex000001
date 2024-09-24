package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CookingFinished extends AbstractEvent {

    private Long id;
    private Boolean isDelivery;
    private Boolean isCooked;

    public CookingFinished(Cook aggregate) {
        super(aggregate);
    }

    public CookingFinished() {
        super();
    }
}
//>>> DDD / Domain Event
