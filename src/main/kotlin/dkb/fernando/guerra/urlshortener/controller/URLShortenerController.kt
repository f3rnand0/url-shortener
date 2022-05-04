package dkb.fernando.guerra.urlshortener.controller

import dkb.fernando.guerra.urlshortener.service.URLShortenerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class URLShortenerController(val urlShortenerService: URLShortenerService) {
    @GetMapping("/getHash")
    fun getHashFromURL(@PathVariable url: String): String {
        return urlShortenerService.shortenURL(url)
    }

    @GetMapping("/getURL")
    fun getURLFromHash(@PathVariable hash: String): String {
        return urlShortenerService.expandURL(hash)
    }

}