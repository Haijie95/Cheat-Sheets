package ServersideFoundation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    // value redis host from appln.properties
    @Value("${spring.data.redis.host}")
    private String redisHost;

    // value redis port from appln.properties
    @Value("${spring.data.redis.port}")
    private Optional<Integer> redisPort;

    @Value("${spring.data.redis.username}")
    private String redisUsername;

    @Value("${spring.data.redis.password}")
    private String redisPassword;

    // define the return redis template bean as single Object
    // throughout the runtime.
    // Return the RedisTemplate
    @Bean
    @Scope("singleton")
    //for the <something,something> this depends on the tpye of key and value 
    public RedisTemplate<String, String> redisTemplate() {
        final RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();

        config.setHostName(redisHost);
        config.setPort(redisPort.get());

        if (!redisUsername.isEmpty() && !redisPassword.isEmpty()) {
            config.setUsername(redisUsername);
            config.setPassword(redisPassword);
        }
        config.setDatabase(0);

        final JedisClientConfiguration jedisClient = JedisClientConfiguration
                .builder()
                .build();
        final JedisConnectionFactory jedisFac = new JedisConnectionFactory(config, jedisClient);
        jedisFac.afterPropertiesSet();
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        // associate with the redis connection
        redisTemplate.setConnectionFactory(jedisFac);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // set the map key/value serialization type to String
        redisTemplate.setHashKeySerializer(redisTemplate.getKeySerializer());
        redisTemplate.setValueSerializer(redisTemplate.getKeySerializer());
        redisTemplate.setHashValueSerializer(redisTemplate.getKeySerializer());

        return redisTemplate;
    }
}
