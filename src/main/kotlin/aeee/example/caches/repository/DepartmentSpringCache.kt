package aeee.example.caches.repository

import aeee.example.caches.entity.Department
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Repository

@Repository
class DepartmentSpringCache(
    private val departmentRepository: DepartmentRepository
) : DepartmentCache {

    override fun findById(departmentId: Long): Department? {
        TODO("Not yet implemented")
    }

    override fun findByCode(code: String): Department? {
        TODO("Not yet implemented")
    }
}