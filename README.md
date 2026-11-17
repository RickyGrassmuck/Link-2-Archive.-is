# Link 2 Archive.is

A minimal Android app that adds **"Open in archive.is"** to the system share sheet.
Sharing a link opens it in your default browser via archive.is:

```
https://www.nytimes.com/2026/11/17/upshot/school-phone-bans-study-scores.html
→ https://archive.is/submit/?url=https%3A%2F%2Fwww.nytimes.com%2F2026%2F11%2F17%2Fupshot%2Fschool-phone-bans-study-scores.html
```

There is no launcher icon or UI — the app only appears in the share sheet.
If the shared text contains other words (e.g. "Article title https://…"), the first `http(s)://` URL is used.

## Build

Requires JDK 17+ and the Android SDK (`ANDROID_HOME` or `local.properties`).

```sh
./gradlew testDebugUnitTest assembleDebug
adb install app/build/outputs/apk/debug/app-debug.apk
```
