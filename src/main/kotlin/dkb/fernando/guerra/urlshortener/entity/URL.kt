package dkb.fernando.guerra.urlshortener.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class URL(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    val username: String,
    val url: String,
    val hash: String
)