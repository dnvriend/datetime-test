package com.github.dnvriend

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAdjusters

class `01_LocalDateTest` {
    /**
     * The LocalDate represents a date in ISO format (yyyy-MM-dd) without time.
     *
     * It can be used to store dates like birthdays and paydays.
     *
     * An instance of current date can be created from the system clock as below:
     */

    @Test
    fun `create a LocalDate from system clock`() {
        val localDate: LocalDate = LocalDate.now()
        Assertions.assertThat(localDate).isNotNull()
        println(localDate) // eg. 2019-07-28
    }

    /**
     * The LocalDate representing a specific day, month and year can be obtained using the “of” method or
     * by using the “parse” method. For example the below code snippets represents the LocalDate for 20 February 2015:
     */

    @Test
    fun `create a LocalDate of a date`() {
        val localDate: LocalDate = LocalDate.of(2015, 2, 20)
        Assertions.assertThat(localDate.toString()).isEqualTo("2015-02-20")
    }

    @Test
    fun `parse a LocalDate`() {
        val localDate: LocalDate = LocalDate.parse("2015-02-20")
        Assertions.assertThat(localDate.toString()).isEqualTo("2015-02-20")
    }

    /**
     * The LocalDate provides various utility methods to obtain a variety of information. Let’s have a quick peek at
     * some of these APIs methods. The following code snippet gets the current local date and adds one day:
     */

    @Test
    fun `add a day`() {
        val nextDay: LocalDate = LocalDate.parse("2015-02-20").plusDays(1)
        Assertions.assertThat(nextDay.toString()).isEqualTo("2015-02-21")
    }

    @Test
    fun `subtract a month`() {
        val previousMonthSameDay: LocalDate = LocalDate.parse("2015-02-20").minus(1, ChronoUnit.MONTHS)
        Assertions.assertThat(previousMonthSameDay.toString()).isEqualTo("2015-01-20")
    }

    /**
     * Parse the date “2016-06-12” and get the day of the week and the day of the month respectively.
     */

    @Test
    fun `get day of the week`() {
        val localDate: LocalDate = LocalDate.parse("2016-06-12")
        val dayOfWeek: DayOfWeek = localDate.dayOfWeek
        Assertions.assertThat(dayOfWeek).isEqualTo(DayOfWeek.SUNDAY)
    }

    @Test
    fun `get day of the month`() {
        val localDate: LocalDate = LocalDate.parse("2016-06-12")
        val dayOfMonth: Int = localDate.dayOfMonth
        Assertions.assertThat(dayOfMonth).isEqualTo(12)
    }

    /**
     * We can test if a date occurs in a leap year
     */

    @Test
    fun `test if a date occurs in a leap year`() {
        val localDate: LocalDate = LocalDate.parse("2016-06-12")
        val isLeapYear: Boolean = localDate.isLeapYear
        Assertions.assertThat(isLeapYear).isTrue()
    }

    /**
     * The relationship of a date to another can be determined to occur before or after another date
     */

    @Test
    fun `isBefore and isAfter`() {
        val notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"))
        Assertions.assertThat(notBefore).isFalse()
        val isAfter = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"))
        Assertions.assertThat(isAfter).isTrue()
    }

    /**
     * Date boundaries can be obtained from a given date. In the following examples we get the LocalDateTime that
     * represents the beginning of the day (2016-06-12T00:00) of the given date and the LocalDate that represents
     * the beginning of the month (2016-06-01) respectively:
     */

    @Test
    fun `beginning of the day and beginning of the month`() {
        val beginningOfDay: LocalDateTime = LocalDate.parse("2016-06-12").atStartOfDay()
        Assertions.assertThat(beginningOfDay.toString()).isEqualTo("2016-06-12T00:00")

        val firstDayOfMonth: LocalDate = LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth())
        Assertions.assertThat(firstDayOfMonth.toString()).isEqualTo("2016-06-01")
    }
}
