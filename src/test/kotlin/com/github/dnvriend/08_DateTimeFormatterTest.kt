package com.github.dnvriend

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.UnsupportedTemporalTypeException

class `08_DateTimeFormatterTest` {
    @Test
    fun `format a date using BASIC_ISO_DATE '20111203'`() {
        val formatter: DateTimeFormatter = DateTimeFormatter.BASIC_ISO_DATE

        val localDate: LocalDate = LocalDate.parse("2015-02-20")
        assertThat(localDate.format(formatter)).isEqualTo("20150220")

        val localDateTime = LocalDateTime.parse("2015-02-20T06:30")
        assertThat(localDateTime.format(formatter)).isEqualTo("20150220")

        val zonedDateTime = ZonedDateTime.parse("2015-02-20T06:30+02:00")
        assertThat(zonedDateTime.format(formatter)).isEqualTo("20150220+0200")

        val localTime = LocalTime.parse("06:30")
        assertThatThrownBy({localTime.format(formatter)}).isInstanceOf(UnsupportedTemporalTypeException::class.java)
    }

    @Test
    fun `format a date using ISO_LOCAL_DATE '2011-12-03'`() {
        val formatter: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE

        val localDate: LocalDate = LocalDate.parse("2015-02-20")
        assertThat(localDate.format(formatter)).isEqualTo("2015-02-20")

        val localDateTime = LocalDateTime.parse("2015-02-20T06:30")
        assertThat(localDateTime.format(formatter)).isEqualTo("2015-02-20")

        val zonedDateTime = ZonedDateTime.parse("2015-02-20T06:30+02:00")
        assertThat(zonedDateTime.format(formatter)).isEqualTo("2015-02-20")

        // no date information available
        val localTime = LocalTime.parse("06:30")
        assertThatThrownBy {localTime.format(formatter)}.isInstanceOf(UnsupportedTemporalTypeException::class.java)
    }

    @Test
    fun `format a date using ISO_OFFSET_DATE`() {
        val formatter: DateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE

        // fails due to no offset information available
        val localDate: LocalDate = LocalDate.parse("2015-02-20")
        assertThatThrownBy {localDate.format(formatter)}.isInstanceOf(UnsupportedTemporalTypeException::class.java)

        // fails due to no offset information available
        val localDateTime = LocalDateTime.parse("2015-02-20T06:30")
        assertThatThrownBy {localDateTime.format(formatter)}.isInstanceOf(UnsupportedTemporalTypeException::class.java)

        val zonedDateTime = ZonedDateTime.parse("2015-02-20T06:30+02:00")
        assertThat(zonedDateTime.format(formatter)).isEqualTo("2015-02-20+02:00")

        // no date information available
        val localTime = LocalTime.parse("06:30")
        assertThatThrownBy {localTime.format(formatter)}.isInstanceOf(UnsupportedTemporalTypeException::class.java)
    }

}