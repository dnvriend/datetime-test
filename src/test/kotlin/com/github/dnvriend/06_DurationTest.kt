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
    fun `add duration to time`() {
        val localTime = LocalTime.parse("06:30")
        val duration = Duration.ofSeconds(30)
        val finalTime = localTime.plus(duration)
        assertThat(finalTime.toString()).isEqualTo("06:30:30")
    }

    @Test
    fun `duration between two local times`() {
        val durationBetween: Duration = Duration.between(LocalTime.parse("06:30"), LocalTime.parse("06:30:30"))
        assertThat(durationBetween.toString()).isEqualTo("PT30S")
    }
}