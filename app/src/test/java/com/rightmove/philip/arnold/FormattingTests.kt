package com.rightmove.philip.arnold

import com.rightmove.philip.arnold.utils.NumberFormatter.formatNumber
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.util.*

class FormattingTests {
    @Test
    fun `check million format US`() {
        val locale = Locale.US
        assertEquals("$1,000,000.00", formatNumber(locale, 1000000.00))
    }
    @Test
    fun `check million format UK`() {
        val locale = Locale.UK
        assertEquals("£1,000,000.00", formatNumber(locale, 1000000.00))
    }
    @Test
    fun `check million format DE`() {
        val locale = Locale.GERMANY
        assertEquals("1.000.000,00 €", formatNumber(locale, 1000000.00))
    }
}