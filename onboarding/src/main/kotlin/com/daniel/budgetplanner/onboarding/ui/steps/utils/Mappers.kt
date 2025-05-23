package com.daniel.budgetplanner.onboarding.ui.steps.utils

import android.util.Log
import java.time.DateTimeException
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.TimeZone

fun convertMillisToDate(millis: Long):LocalDate {
    val localDate = LocalDateTime
        .ofInstant(
            Instant.ofEpochMilli(millis),
            TimeZone.getDefault().toZoneId())
    return localDate.plusDays(1L).toLocalDate()
}

fun LocalDate.toViewPattern(): String = format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))

fun String.changeDateFormat(): String {
    return try {
        val originalDate = LocalDate.parse(this, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        originalDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
    } catch (e: DateTimeException) {
        Log.d("Exception", e.message.toString())
        this
    }
}
