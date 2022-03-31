package aeee.example.caches.repository

import aeee.example.caches.entity.Department

interface DepartmentCache {
    fun findById(departmentId: Long): Department?
    fun findByCode(code: String): Department?
}