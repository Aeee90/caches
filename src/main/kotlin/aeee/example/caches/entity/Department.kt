package aeee.example.caches.entity

import javax.persistence.*

@Entity
class Department(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var departmentId: Long,
    @Column(length = 20, nullable = false)
    var code: String,
    @Column(length = 100, nullable = false)
    var name: String,
) {

}