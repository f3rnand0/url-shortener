package dkb.fernando.guerra.urlshortener.service

import org.springframework.stereotype.Service

@Service
class URLShortenerService(val urlShortenerRepository: URLShortenerRepository) {

    fun shortenURL(url:String): String {
        return ""
    }

    fun expandURL(hash:String): String {
        return ""
    }
}