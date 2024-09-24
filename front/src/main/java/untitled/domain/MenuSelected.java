package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class MenuSelected extends AbstractEvent {

    private Long id;

    public MenuSelected(Order aggregate) {
        super(aggregate);
    }

    public MenuSelected() {
        super();
    }
}
//>>> DDD / Domain Event
