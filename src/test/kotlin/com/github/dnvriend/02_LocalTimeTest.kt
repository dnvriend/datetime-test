package com.github.dnvriend

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalTime
import java.time.temporal.ChronoUnit

/**
 * Using LocalDate, LocalTime and LocalDateTime
 * The most commonly used classes are LocalDate, LocalTime and LocalDateTime. As their names indicate, they represent
 * the local Date/Time from the context of the observer.
 *
 * These classes are mainly used when *timezone are not required* to be explicitly specified in the context.
 */
class `02_LocalTimeTest` {
    @Test
    fun `create a LocalTime from system clock`() {
        val now = LocalTime.now()
        assertThat(now).isNotNull()
        println(now) // eg. 18:05:12.476
    }

    @Test
    fun `create a LocalTime of a time`() {
        val sixThirty = LocalTime.of(6, 30)
        assertThat(sixThirty.toString()).isEqualTo("06:30")
    }

    @Test
    fun `parse a LocalTime`() {
        val sixThirty = LocalTime.parse("06:30")
        assertThat(sixThirty.toString()).isEqualTo("06:30")
    }

    @Test
    fun `add an hour`() {
        val sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS)
        assertThat(sevenThirty.toString()).isEqualTo("07:30")
    }

    @Test
    fun `get the hour`() {
        val six = LocalTime.parse("06:30").hour
        assertThat(six).isEqualTo(6)
    }

    @Test
    fun `isBefore`() {
        val isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"))
        assertThat(isbefore).isTrue()
    }

    @Test
    fun `maxTime`() {
        val maxTime = LocalTime.MAX
        assertThat(maxTime.toString()).isEqualTo("23:59:59.999999999")
    }
}




