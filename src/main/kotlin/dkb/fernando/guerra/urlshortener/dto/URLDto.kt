package dkb.fernando.guerra.urlshortener.dto

data class URLDto(
    val username: String,
    val url: String,
    val hash: String?
)