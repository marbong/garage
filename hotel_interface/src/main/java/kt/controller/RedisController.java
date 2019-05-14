package kt.controller;

import kt.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @RequestMapping(value="/info", method= RequestMethod.GET)
    public String redisInfo(){
        return redisService.redisInfo();
    }

    @RequestMapping(value="/cluster", method= RequestMethod.GET)
    public String redisClusterInfo(){
        return redisService.redisClusterInfo();
    }

    @RequestMapping(value="/value/set", method=RequestMethod.GET)
    public String redisSet(){
        return redisService.redisValueSet();
    }

    @RequestMapping(value="/value/get", method=RequestMethod.GET)
    public String redisGet(){
        return redisService.redisValueGet();
    }
}
