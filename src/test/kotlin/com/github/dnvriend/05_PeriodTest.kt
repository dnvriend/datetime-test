package com.github.dnvriend

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.*

/**
 * The Period class is widely used to modify values of given a date or to obtain the difference between two dates.
 *
 * The Period class represents a quantity of time in terms of years, months and days.
 */

class `05_PeriodTest` {
    @Test
    fun `manipulate LocalDate with Period`() {
        val period: Period = Period.ofDays(5)
        val localDate: LocalDate = LocalDate.parse("2015-02-20")
        val finalDate: LocalDate = localDate.plus(period)
        assertThat(finalDate.toString()).isEqualTo("2015-02-25")
    }

    @Test
    fun `parse a period`() {
        val period: Period = Period.parse("P5D")
        assertThat(period.days).isEqualTo(5)
    }

    @Test
    fun `calculate period between two localdates`() {
        val plus5Days: Period = Period.between(LocalDate.parse("2015-02-20"), LocalDate.parse("2015-02-25"))
        assertThat(plus5Days.toString()).isEqualTo("P5D")
        assertThat(plus5Days.days).isEqualTo(5)

        val minus5Days: Period = Period.between(LocalDate.parse("2015-02-25"), LocalDate.parse("2015-02-20"))
        assertThat(minus5Days.toString()).isEqualTo("P-5D")
        assertThat(minus5Days.days).isEqualTo(-5)
    }
}