package aeee.example.caches.repository

import aeee.example.caches.entity.Department
import org.springframework.data.jpa.repository.JpaRepository

interface DepartmentRepository: JpaRepository<Department, Long> {

    fun findByCode(code: String): Department
}