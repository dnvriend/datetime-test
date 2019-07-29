package com.github.dnvriend

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.*

/**
 * The Duration class is used to deal with Time. The Period class is used to deal with dates.
 *
 * The Duration class represents a quantity of time in terms of seconds and nano seconds.
 */

class `06_DurationTest` {
    @Test
    fun `add Duration to LocalTime`() {
        val localTime: LocalTime = LocalTime.parse("06:30")
        val duration: Duration = Duration.ofSeconds(30)
        val finalTime = localTime.plus(duration)
        assertThat(finalTime.toString()).isEqualTo("06:30:30")
    }

    @Test
    fun `add Duration to LocalDateTime`() {
        val localDateTime: LocalDateTime = LocalDateTime.parse("2015-02-20T06:30")
        val duration: Duration = Duration.ofSeconds(30)
        val finalDateTime: LocalDateTime = localDateTime.plus(duration)
        assertThat(finalDateTime.toString()).isEqualTo("2015-02-20T06:30:30")
    }

    @Test
    fun `add Duration to ZonedDateTime`() {
        val zonedDateTime: ZonedDateTime = ZonedDateTime.parse("2015-02-20T10:00+02:00")
        val duration: Duration = Duration.ofSeconds(30)
        val finalZonedDateTime: ZonedDateTime = zonedDateTime.plus(duration)
        assertThat(finalZonedDateTime.toString()).isEqualTo("2015-02-20T10:00:30+02:00")
    }

    @Test
    fun `duration between two local times`() {
        val durationBetween: Duration = Duration.between(LocalTime.parse("06:30"), LocalTime.parse("06:30:30"))
        assertThat(durationBetween.toString()).isEqualTo("PT30S")
    }
}