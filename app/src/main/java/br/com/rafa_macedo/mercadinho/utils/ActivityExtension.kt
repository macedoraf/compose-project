package br.com.rafa_macedo.mercadinho.utils

import android.app.Activity
import android.content.Intent

fun Activity.redirect(activityName: Class<*>) {
    startActivity(Intent(this, activityName))
}