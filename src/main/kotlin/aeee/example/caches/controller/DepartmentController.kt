package aeee.example.caches.controller

import aeee.example.caches.entity.Department
import aeee.example.caches.repository.DepartmentRedisCache
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/departments")
class DepartmentController(
    private val departmentService: DepartmentRedisCache
) {

    @GetMapping("/{departmentId}")
    fun getDepartment(@PathVariable departmentId: Long): Department? {
        return this.departmentService.findById(departmentId)
    }
}