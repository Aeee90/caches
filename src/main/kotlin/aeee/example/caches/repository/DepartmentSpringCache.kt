package aeee.example.caches.repository

import aeee.example.caches.entity.Department
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Repository

@Repository
class DepartmentSpringCache(
    private val departmentRepository: DepartmentRepository
) : DepartmentCache {


    @Cacheable(cacheNames = ["example"], key = "#departmentId")
    override fun findById(departmentId: Long): Department? {
        return this.departmentRepository.findById(departmentId).orElse(null)
    }

    @Cacheable(cacheNames = ["example"], key = "#code")
    override fun findByCode(code: String): Department? {
        return this.departmentRepository.findByCode(code)
    }
}