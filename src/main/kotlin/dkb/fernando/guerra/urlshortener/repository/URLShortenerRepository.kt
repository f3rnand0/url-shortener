package dkb.fernando.guerra.urlshortener.repository

import dkb.fernando.guerra.urlshortener.entity.URL
import org.springframework.data.jpa.repository.JpaRepository

interface URLShortenerRepository : JpaRepository<URL, Long> {
    fun findByUsernameAndHash(username:String, hash: String): URL?

}