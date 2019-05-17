/*package kt.kafka.consmer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

    @KafkaListener(topics = "${app.topic.front}")
    public void listen(@Payload String message) {
        LOG.info("received message='{}'", message);
        System.out.println("GetMessage >> :" + message);
    }
}
*/