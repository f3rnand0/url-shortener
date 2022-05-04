package dkb.fernando.guerra.urlshortener.service

import dkb.fernando.guerra.urlshortener.dto.URLDto
import dkb.fernando.guerra.urlshortener.entity.URL
import dkb.fernando.guerra.urlshortener.repository.URLShortenerRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class URLShortenerServiceTest {

    private val urlShortenerRepository: URLShortenerRepository = mockk()
    private val urlShortenerService = URLShortenerService(urlShortenerRepository)

    private val sampleUrlDto = URLDto("https://example.com", "aHR0cHM6Ly9leGFtcGxlLmNvbQ==")

    @Test
    fun whenShortenURL_thenReturnHash() {
        val url = URL(1, sampleUrlDto.url, "aHR0cHM6Ly9leGFtcGxlLmNvbQ==")
        every { urlShortenerRepository.save(any()) } returns url
        val result = urlShortenerService.shortenURL(sampleUrlDto)
        verify(exactly = 1) { urlShortenerRepository.save(any()) }
        assertEquals("aHR0cHM6Ly9leGFtcGxlLmNvbQ==", result.hash)
    }

    @Test
    fun whenExpandURL_thenReturnExtendedURL() {
        val url = URL(1, sampleUrlDto.url, "aHR0cHM6Ly9leGFtcGxlLmNvbQ==")
        every { urlShortenerRepository.findByHash(sampleUrlDto.hash!!) } returns url
        val result = urlShortenerService.expandURL(sampleUrlDto.hash!!)
        verify(exactly = 1) { urlShortenerRepository.findByHash(sampleUrlDto.hash!!) }
        assertEquals(sampleUrlDto.url, result.url)
    }
}