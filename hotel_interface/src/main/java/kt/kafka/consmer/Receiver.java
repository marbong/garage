package kt.kafka.consmer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import kt.kafka.producer.Sender;
import kt.mock.MockApi;


@Service
public class Receiver {

    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);
    
    @Autowired
    MockApi mockApi;
    
    @Autowired
	private Sender kafkaSender;

    @KafkaListener(topics = "${app.topic.front}")
    public void listen(@Payload String message) {
        LOG.info("received message='{}'", message);
        System.out.println("GetMessage >> :" + message);
        String rtnMsg = mockApi.getApiCall(message);
        System.out.println("return value===>>>"+rtnMsg);
        
        kafkaSender.send(rtnMsg);
    }
}