package kt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public String redisInfo(){
        String result = redisTemplate.getConnectionFactory().getConnection().info().toString();
        return "Redis Test: " + result;
    }

    public String redisClusterInfo(){
        String result = redisTemplate.getConnectionFactory().getClusterConnection().info().toString();
        return "Redis Test: " + result;
    }

    public String redisClientInfo(){
        String result = redisTemplate.getClientList().toString();
        return "Redis Test: " + result;
    }

    public String redisValueSet(){
        ValueOperations<String, String>  valueOperations = redisTemplate.opsForValue();
        String key = "test";
        String value = "whcho";
        valueOperations.set(key, value);
        return "Result: Succeed";
    }

    public String redisValueGet(){
        ValueOperations<String, String>  valueOperations = redisTemplate.opsForValue();
        String key = "test";
        return "Result: " + valueOperations.get(key);
    }
}
