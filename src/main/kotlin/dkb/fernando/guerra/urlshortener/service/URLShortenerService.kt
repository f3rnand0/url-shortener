package dkb.fernando.guerra.urlshortener.service

import dkb.fernando.guerra.urlshortener.dto.URLDto
import dkb.fernando.guerra.urlshortener.entity.URL
import dkb.fernando.guerra.urlshortener.repository.URLShortenerRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*


@Service
class URLShortenerService(val urlShortenerRepository: URLShortenerRepository) {

    fun shortenURL(urlDto: URLDto): URLDto {
        val hash = encodeURL(urlDto.url)
        val urlToSave = URL(null, urlDto.url, hash)
        val urlSaved = urlShortenerRepository.save(urlToSave)
        return URLDto(urlSaved.url, urlSaved.hash)
    }

    fun expandURL(hash: String): URLDto {
        val urlRetrieved = urlShortenerRepository.findByHash(hash)
        if (urlRetrieved != null)
            return URLDto(urlRetrieved.url, urlRetrieved.hash)
        else
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, "URL not found"
            )
    }

    fun encodeURL(url: String): String {
        return Base64.getUrlEncoder().encodeToString(url.toByteArray())
    }
}