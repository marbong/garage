package kt.service;

import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MockService {
	
	public String orderService(Map<String,Object> map) {
		
		StringBuffer sb = new StringBuffer();
		Iterator<String> keys = map.keySet().iterator();
		while ( keys.hasNext() ) {
		    String key = keys.next();
		    sb.append("Key: " + key +" / value: " + map.get(key) + " | ");
		}   

		return sb.toString() + " Complete!!!!!";
	}
}
