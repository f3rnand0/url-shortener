package dkb.fernando.guerra.urlshortener.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class URL(
    @Id @GeneratedValue var id: Long,
    val url: String,
    val hash: String)
