package com.link2archive

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast

class ShareActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val url = if (intent?.action == Intent.ACTION_SEND) {
            ArchiveUrl.extractUrl(intent.getStringExtra(Intent.EXTRA_TEXT))
        } else null

        if (url == null) {
            Toast.makeText(this, R.string.no_url, Toast.LENGTH_SHORT).show()
        } else {
            val view = Intent(Intent.ACTION_VIEW, Uri.parse(ArchiveUrl.build(url)))
                .addCategory(Intent.CATEGORY_BROWSABLE)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            try {
                startActivity(view)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, R.string.no_browser, Toast.LENGTH_SHORT).show()
            }
        }
        finish()
    }
}
