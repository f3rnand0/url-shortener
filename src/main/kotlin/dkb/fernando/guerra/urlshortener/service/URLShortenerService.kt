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
        val urlRetrieved = urlShortenerRepository.findByUsernameAndHash(urlDto.username, hash)
        if (urlRetrieved != null)
            return URLDto(urlRetrieved.username, urlRetrieved.url, urlRetrieved.hash)
        else {
            val urlToSave = URL(null, urlDto.username, urlDto.url, hash)
            val urlSaved = urlShortenerRepository.save(urlToSave)
            return URLDto(urlSaved.username, urlSaved.url, urlSaved.hash)
        }
    }

    fun expandURL(username: String, hash: String): URLDto {
        val urlRetrieved = urlShortenerRepository.findByUsernameAndHash(username, hash)
        if (urlRetrieved == null)
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, "URL not found"
            )
        else
            return URLDto(urlRetrieved.username, urlRetrieved.url, urlRetrieved.hash)
    }

    fun encodeURL(url: String): String {
        return Base64.getUrlEncoder().encodeToString(url.toByteArray())
    }
}