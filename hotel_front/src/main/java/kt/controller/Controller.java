package kt.controller;

import javax.servlet.http.HttpServletRequest;

import kt.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import kt.kafka.producer.Sender;
import kt.service.MyService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/front")
public class Controller {
    private static final Logger LOG = LoggerFactory.getLogger(Controller.class);

	@Autowired
    private MyService myService;
	@Autowired
	private Sender kafkaSender;

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String Hello(){
        return "hello AI " + myService.getName();
    }
	@RequestMapping(value ="/list", method = RequestMethod.GET)
    public String getList(@RequestBody String body,HttpServletRequest request){
    
        return "Hotel front list usage { room: xxx ,msg: xxx }" + myService.getName() +":::"+ body;
    }

	@RequestMapping(value ="/amenity", method = RequestMethod.POST)
    public String reqSvc(@RequestBody String body , HttpServletRequest request){
        LOG.info("'{}' sending message='{}' ", body ,request.getRequestURI());

		kafkaSender.send(body);
       return "Kafka send complete  " + request.getRequestURI();
    }
}
