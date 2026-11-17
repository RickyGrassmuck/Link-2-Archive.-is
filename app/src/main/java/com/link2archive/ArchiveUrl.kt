package com.link2archive

import java.net.URLEncoder

object ArchiveUrl {
    private const val SUBMIT = "https://archive.is/submit/?url="
    private val URL_REGEX = Regex("""https?://\S+""", RegexOption.IGNORE_CASE)

    /** Pulls the first http(s) URL out of shared text (apps often send "Title https://..."). */
    fun extractUrl(text: String?): String? =
        text?.let { URL_REGEX.find(it)?.value?.trimEnd('.', ',', ')', ']', '"', '\'') }

    fun build(url: String): String = SUBMIT + URLEncoder.encode(url, "UTF-8")
}
