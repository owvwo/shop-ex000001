package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderDone extends AbstractEvent {

    private Long id;
    private String status;

    public OrderDone(Delivery aggregate) {
        super(aggregate);
    }

    public OrderDone() {
        super();
    }
}
//>>> DDD / Domain Event
