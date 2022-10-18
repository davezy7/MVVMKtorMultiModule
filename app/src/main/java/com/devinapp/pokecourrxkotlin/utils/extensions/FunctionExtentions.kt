package com.devinapp.pokecourrxkotlin.utils.extensions

import java.text.NumberFormat
import java.util.*
import kotlin.math.floor

fun Double.toUSD(withSymbol: Boolean = true, fractionDigits: Int = 2): String {
    val localeUS = Locale("en", "US")
    val format = if (withSymbol) NumberFormat.getCurrencyInstance(localeUS)
    else NumberFormat.getInstance(localeUS)
    format.maximumFractionDigits = fractionDigits
    return format.format(this)
}

fun String.toUSD(withSymbol: Boolean = true, fractionDigits: Int = 2): String {
    val number = this.toDoubleOrNull() ?: return "-"
    val localeUS = Locale("en", "US")
    val format = if (withSymbol) NumberFormat.getCurrencyInstance(localeUS)
    else NumberFormat.getInstance(localeUS)
    format.maximumFractionDigits = fractionDigits
    return format.format(number)
}