package untitled.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookingStarted'"
    )
    public void wheneverCookingStarted_LoadDeliveryInfo(
        @Payload CookingStarted cookingStarted
    ) {
        CookingStarted event = cookingStarted;
        System.out.println(
            "\n\n##### listener LoadDeliveryInfo : " + cookingStarted + "\n\n"
        );

        // Sample Logic //
        Delivery.loadDeliveryInfo(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPaymented'"
    )
    public void wheneverOrderPaymented_LoadDeliveryInfo(
        @Payload OrderPaymented orderPaymented
    ) {
        OrderPaymented event = orderPaymented;
        System.out.println(
            "\n\n##### listener LoadDeliveryInfo : " + orderPaymented + "\n\n"
        );

        // Sample Logic //
        Delivery.loadDeliveryInfo(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
