package kt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kt.mock.MockApi;

@RestController
@RequestMapping(value = "/pms")
public class PmsController {
	@Autowired
    MockApi mockApi;
	
	
	@RequestMapping(value ="/call", method = RequestMethod.POST)
    public String getList(@RequestBody String body,HttpServletRequest request){
		
		System.out.println("Body===>>"+body );
		String rtnMsg = mockApi.getApiCall(body);
		System.out.println("rtnMsg===>>"+rtnMsg );
        return rtnMsg;
    }
}
