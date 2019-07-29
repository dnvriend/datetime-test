package com.github.dnvriend

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.*
import java.text.SimpleDateFormat

/**
 * Java 8 has added the toInstant() method which helps to convert existing Date and Calendar
 * instance to new Date Time API
 */

class `07_DateAndCalendarCompatTest` {
    @Test
    fun `java Date to LocalDateTime`() {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mmX")
        val date: java.util.Date = sdf.parse("2019-01-01T00:00Z")
        val localDateTime: LocalDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.UTC)
        assertThat(localDateTime.toString()).isEqualTo("2019-01-01T00:00")
    }

    @Test
    fun `LocalDateTime to java Date`() {
        val localDateTime = LocalDateTime.parse("2015-02-20T06:30:00")
        val date: java.util.Date = java.util.Date.from(localDateTime.toInstant(ZoneOffset.UTC))
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ")
        assertThat(sdf.format(date)).isEqualTo("2015-02-20T07:30+0100")
    }

    @Test
    fun `java Calendar to LocalDateTime`() {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mmX")
        val date: java.util.Date = sdf.parse("2019-01-01T00:00Z")
        val cal: java.util.Calendar = java.util.Calendar.getInstance()
        cal.setTime(date)
        val localDateTime: LocalDateTime = LocalDateTime.ofInstant(cal.toInstant(), ZoneOffset.UTC)
        assertThat(localDateTime.toString()).isEqualTo("2019-01-01T00:00")
    }
}