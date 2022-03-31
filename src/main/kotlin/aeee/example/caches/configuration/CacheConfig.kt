package aeee.example.caches.configuration

import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer
import java.time.Duration

@EnableCaching
@Configuration
class CacheConfig(
    private val redisConnectionFactory: RedisConnectionFactory
) {

    @Primary
    @Bean("cacheManager")
    fun cacheManagerRedis(): CacheManager = RedisCacheManager.RedisCacheManagerBuilder
        .fromConnectionFactory(this.redisConnectionFactory)
        .cacheDefaults(
            RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(GenericJackson2JsonRedisSerializer()))
                .entryTtl(Duration.ofSeconds(100))
        ).build()

    @Bean("cacheManager")
    fun cacheManagerMemory(): CacheManager = SimpleCacheManager().apply {
        setCaches(listOf(ConcurrentMapCache("example")))
    }
}