package com.example.cfttest.ui.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.sendMail(to: String, subject: String) {
    try {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "vnd.android.cursor.item/email" // or "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        // TODO: Handle case where no email app is available
    } catch (t: Throwable) {
        // TODO: Handle potential other type of exceptions
    }
}

fun Context.dial(phone: String) {
    try {
        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
        startActivity(intent)
    } catch (t: Throwable) {
        // TODO: Handle potential exceptions
    }
}

fun Context.map(longitude: String, latitude: String) {
    val mapUri = Uri.parse("geo:$latitude,$longitude?z=19")
    val intent = Intent(Intent.ACTION_VIEW, mapUri)
    startActivity(intent)
}