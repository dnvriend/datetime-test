package com.github.dnvriend

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.Month

class `03_LocalDateTimeTest` {

    @Test
    fun `create a LocalDateTime from system clock`() {
        val localDateTime = LocalDateTime.now();
        assertThat(localDateTime).isNotNull()
        println(localDateTime) // eg: 2019-07-28T18:16:04.817
    }

    @Test
    fun `create an instance`() {
        val localDateTime = LocalDateTime.of(2015, Month.FEBRUARY, 20, 6, 30)
        assertThat(localDateTime.toString()).isEqualTo("2015-02-20T06:30")
    }

    @Test
    fun `parse an instance`() {
        val localDateTime = LocalDateTime.parse("2015-02-20T06:30:00")
        assertThat(localDateTime).isEqualTo("2015-02-20T06:30:00")
    }

    @Test
    fun `add a day`() {
        val localDateTime = LocalDateTime.parse("2015-02-20T06:30:00").plusDays(1)
        assertThat(localDateTime).isEqualTo("2015-02-21T06:30:00")
    }

    @Test
    fun `subtract hours`() {
        val localDateTime = LocalDateTime.parse("2015-02-20T06:30:00").minusHours(2)
        assertThat(localDateTime).isEqualTo("2015-02-20T04:30:00")
    }

    @Test
    fun `get the month`() {
        val localDateTime = LocalDateTime.parse("2015-02-20T06:30:00").minusHours(2)
        val month: Month = localDateTime.getMonth();
        assertThat(month).isEqualTo(Month.FEBRUARY)

    }
}