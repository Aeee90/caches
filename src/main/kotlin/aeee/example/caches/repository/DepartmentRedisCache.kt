package aeee.example.caches.repository

import aeee.example.caches.entity.Department
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Repository

@Repository
class DepartmentRedisCache(
    private val departmentRepository: DepartmentRepository
) : DepartmentCache {

    @Cacheable(key = "#departmentId", value = ["department"])
    override fun findById(departmentId: Long): Department? {
        return this.departmentRepository.findById(departmentId).orElse(null);
    }

    @Cacheable(key = "#code", value = ["department"])
    override fun findByCode(code: String): Department? {
        return this.departmentRepository.findByCode(code)
    }
}