package aeee.example.caches.repository

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest
class DepartmentRedisCacheTest(
) {

    @Autowired
    private lateinit var departmentRedisCache: DepartmentRedisCache

    @Test
    @DisplayName("redis cache 테스트")
    fun testRedisCache() {
        this.departmentRedisCache.findById(1L)
    }
}