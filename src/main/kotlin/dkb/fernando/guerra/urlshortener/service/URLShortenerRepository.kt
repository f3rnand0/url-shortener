package dkb.fernando.guerra.urlshortener.service

import dkb.fernando.guerra.urlshortener.entity.URL
import org.springframework.data.repository.CrudRepository
import java.util.*

interface URLShortenerRepository : CrudRepository<URL, UUID> {
    fun findByURL(hash: String): URL?

}