package untitled.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.StoreApplication;
import untitled.domain.CookingFinished;
import untitled.domain.CookingStarted;
import untitled.domain.OrderAccepted;
import untitled.domain.OrderRejected;

@Entity
@Table(name = "Cook_table")
@Data
//<<< DDD / Aggregate Root
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean isDelivery;

    private Boolean isCooked;

    private Boolean isConfirmed;

    @PostPersist
    public void onPostPersist() {
        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();

        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();

        CookingStarted cookingStarted = new CookingStarted(this);
        cookingStarted.publishAfterCommit();

        CookingFinished cookingFinished = new CookingFinished(this);
        cookingFinished.publishAfterCommit();
    }

    public static CookRepository repository() {
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(
            CookRepository.class
        );
        return cookRepository;
    }

    public void pickFood() {
        //implement business logic here:

    }

    public void confirm() {
        //implement business logic here:

    }

    //<<< Clean Arch / Port Method
    public static void orderPayment(OrderPaymented orderPaymented) {
        //implement business logic here:

        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPaymented.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
