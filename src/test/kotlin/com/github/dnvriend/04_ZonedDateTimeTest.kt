package com.github.dnvriend

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.*

/**
 * Java 8 provides ZonedDateTime when we need to deal with time zone specific date and time. The ZoneId is an identifier
 * to represent different zones. There are about 40 different time zones and the ZoneId are used to represent them as follows.
 */

class `04_ZonedDateTimeTest` {

    @Test
    fun `create a zone identifier`() {
        val zoneId = ZoneId.of("Europe/Paris")
        assertThat(zoneId.toString()).isEqualTo("Europe/Paris")
    }

    @Test
    fun `get all timezones`() {
        val allZoneIds = ZoneId.getAvailableZoneIds()
        assertThat(allZoneIds).isNotEmpty
    }

    @Test
    fun `convert a LocalDateTime to a ZonedDateTime`() {
        val localDateTime = LocalDateTime.parse("2015-02-20T06:30:00")
        val zoneId = ZoneId.of("Europe/Paris")
        val zonedDateTime = ZonedDateTime.of(localDateTime, zoneId)
        assertThat(zonedDateTime.toString()).isEqualTo("2015-02-20T06:30+01:00[Europe/Paris]")
    }

    /**
     * Another way to work with time zone is by using OffsetDateTime. The OffsetDateTime is an immutable representation
     * of a date-time with an offset. This class stores all date and time fields, to a precision of nanoseconds,
     * as well as the offset from UTC/Greenwich.
     */

    @Test
    fun `convert a LocalDateTime to an OffsetDateTime`() {
        val localDateTime = LocalDateTime.parse("2015-02-20T06:30:00")
        val offset = ZoneOffset.of("+02:00")
        val offSetByTwo = OffsetDateTime.of(localDateTime, offset)
        assertThat(offSetByTwo.toString()).isEqualTo("2015-02-20T06:30+02:00")
    }
}