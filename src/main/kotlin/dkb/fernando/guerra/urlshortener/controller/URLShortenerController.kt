package dkb.fernando.guerra.urlshortener.controller

import dkb.fernando.guerra.urlshortener.dto.URLDto
import dkb.fernando.guerra.urlshortener.service.URLShortenerService
import org.springframework.web.bind.annotation.*

@RestController
class URLShortenerController(val urlShortenerService: URLShortenerService) {
    @PostMapping("/api/getHash")
    fun getHashFromURL(@RequestBody urlDto: URLDto): URLDto {
        return urlShortenerService.shortenURL(urlDto)
    }

    @GetMapping("/api/getURL")
    fun getURLFromHash(@RequestParam("hash") hash: String): URLDto {
        return urlShortenerService.expandURL(hash)
    }

}