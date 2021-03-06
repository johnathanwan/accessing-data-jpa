package com.example.accessingdatajpa

import org.hibernate.*
import javax.persistence.*

@Suppress("unused")
@Entity
data class Customer(
    var firstName: String,
    var lastName: String,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Customer

        return (id != null) && (id == other.id)
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , firstName = $firstName , lastName = $lastName )"
    }

}