package kt.controller;

import java.util.Base64;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import kt.service.MockService;

@RestController
@RequestMapping(value = "/api")
public class MockController {
	
	
	private static final Logger LOG = LoggerFactory.getLogger(Controller.class);
	
	@Autowired
	MockService mockService;

	@RequestMapping(value ="/mock/request", method = RequestMethod.POST)
    public String mockList(@RequestBody byte[] body , HttpServletRequest request){
		LOG.info("'{}' request message='{}' ", body ,request.getRequestURI());
		
		ObjectMapper mapper = null;
		Map<String,Object> map = null;
		
		String rtn = "";

		try {
			mapper = new ObjectMapper();
			map = mapper.readValue(body, Map.class);
			
			rtn = mockService.orderService(map);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "mock response : \n" + rtn;
    }
}
