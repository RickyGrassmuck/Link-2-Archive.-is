package com.link2archive

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ArchiveUrlTest {
    private val nyt = "https://www.nytimes.com/2026/11/17/upshot/school-phone-bans-study-scores.html"

    @Test fun buildsSubmitUrl() {
        assertEquals(
            "https://archive.is/submit/?url=https%3A%2F%2Fwww.nytimes.com%2F2026%2F11%2F17%2Fupshot%2Fschool-phone-bans-study-scores.html",
            ArchiveUrl.build(nyt),
        )
    }

    @Test fun extractsUrlFromSharedText() {
        assertEquals(nyt, ArchiveUrl.extractUrl("School Phone Bans Study - The New York Times $nyt"))
        assertEquals(nyt, ArchiveUrl.extractUrl(nyt))
    }

    @Test fun keepsQueryString() {
        val u = "https://example.com/a?b=1&c=2"
        assertEquals(u, ArchiveUrl.extractUrl("see $u."))
        assertEquals("https://archive.is/submit/?url=https%3A%2F%2Fexample.com%2Fa%3Fb%3D1%26c%3D2", ArchiveUrl.build(u))
    }

    @Test fun noUrl() {
        assertNull(ArchiveUrl.extractUrl("just some text"))
        assertNull(ArchiveUrl.extractUrl(null))
    }
}
