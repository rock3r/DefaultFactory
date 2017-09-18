package com.stylingandroid.mylibrary

import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle


class DateStringProvider internal constructor(private val formatter: Formatter = DefaultFormatter) {

    fun buildDateString(dateTime: DateTime) =
            formatter.format(dateTime)

    private object DefaultFormatter : Formatter {

        private val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)

        override fun format(instant: DateTime): String =
                dateTimeFormatter.format(instant.asLocalDateTime())
    }
}

interface Formatter {
    fun format(instant: DateTime): String
}

abstract class DateTime {
    abstract internal fun asLocalDateTime(): LocalDateTime
}

internal class ThreeTenDateTime(private val wrappedDateTime: LocalDateTime) : DateTime() {
    override fun asLocalDateTime(): LocalDateTime = wrappedDateTime
}
