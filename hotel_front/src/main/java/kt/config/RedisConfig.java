package kt.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import kt.controller.Controller;

import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;

import redis.clients.jedis.JedisShardInfo;

@Configuration
@EnableCaching
@ComponentScan
public class RedisConfig {
    private static final Logger LOG = LoggerFactory.getLogger(RedisConfig.class);

	@Autowired
    Environment environment;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisConf = new RedisStandaloneConfiguration();
        redisConf.setHostName(environment.getProperty("spring.redis.host"));
        redisConf.setPort(Integer.parseInt(environment.getProperty("spring.redis.port")));
        redisConf.setPassword(RedisPassword.of(environment.getProperty("spring.redis.password")));

        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(redisConf);
        LOG.info("CALLED  RedisConnectionFactory---------------------");
        return connectionFactory;
    }

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate<>();

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        LOG.info("CALLED  RedisTemplate---------------------");
        return redisTemplate;
    }



/*    @Bean
    public RedisCacheManager redisCacheManager() {
        return new RedisCacheManager(redisTemplate(), 300);
    }*/
}
