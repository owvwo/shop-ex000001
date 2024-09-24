package untitled.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.FrontApplication;
import untitled.domain.MenuSelected;
import untitled.domain.OrderPaymented;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        untitled.external.Order order = new untitled.external.Order();
        // mappings goes here
        FrontApplication.applicationContext
            .getBean(untitled.external.OrderService.class)
            .payment(order);

        MenuSelected menuSelected = new MenuSelected(this);
        menuSelected.publishAfterCommit();

        OrderPaymented orderPaymented = new OrderPaymented(this);
        orderPaymented.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void selectMenu() {
        //implement business logic here:

    }

    public void payment() {
        //implement business logic here:

    }
}
//>>> DDD / Aggregate Root
