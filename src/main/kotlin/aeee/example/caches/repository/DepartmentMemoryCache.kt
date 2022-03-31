package aeee.example.caches.repository

import aeee.example.caches.entity.Department
import org.springframework.stereotype.Repository
import javax.annotation.PostConstruct

@Repository
class DepartmentMemoryCache(
    private val departmentRepository: DepartmentRepository
): DepartmentCache {

    private val departmentMapWithId: HashMap<Long, Department> = HashMap();
    private val departmentMapWithCode: HashMap<String, Department> = HashMap();

    @PostConstruct
    fun init() {
        val departments: List<Department> = this.departmentRepository.findAll()
        for(department in departments) {
            this.departmentMapWithId[department.departmentId!!] = department
            this.departmentMapWithCode[department.code] = department
        }
    }

    override fun findById(departmentId: Long): Department? = this.departmentMapWithId[departmentId]

    override fun findByCode(code: String): Department? = this.departmentMapWithCode[code]
}