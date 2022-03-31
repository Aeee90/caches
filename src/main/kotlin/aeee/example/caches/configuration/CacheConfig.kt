package aeee.example.caches.configuration

import org.springframework.cache.CacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer
import java.time.Duration

@Configuration
class CacheConfig(
    private val redisConnectionFactory: RedisConnectionFactory
) {

    @Bean
    fun cacheManager(): CacheManager = RedisCacheManager.RedisCacheManagerBuilder
        .fromConnectionFactory(this.redisConnectionFactory)
        .cacheDefaults(
            RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(GenericJackson2JsonRedisSerializer()))
                .entryTtl(Duration.ofSeconds(100))
        ).build()

}