package aeee.example.caches

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
class CachesApplication

fun main(args: Array<String>) {
    runApplication<CachesApplication>(*args)
}
