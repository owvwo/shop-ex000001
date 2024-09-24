package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderPicked extends AbstractEvent {

    private Long id;
    private String status;

    public OrderPicked(Delivery aggregate) {
        super(aggregate);
    }

    public OrderPicked() {
        super();
    }
}
//>>> DDD / Domain Event
