package aeee.example.caches.entity

import javax.persistence.*

@Entity
class Department{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var departmentId: Long? = null

    @Column(length = 20, nullable = false)
    lateinit var code: String

    @Column(length = 100, nullable = false)
    lateinit var name: String

}