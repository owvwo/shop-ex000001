package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class CookingStarted extends AbstractEvent {

    private Long id;
    private Boolean isDelivery;
    private Boolean isCooked;
}
