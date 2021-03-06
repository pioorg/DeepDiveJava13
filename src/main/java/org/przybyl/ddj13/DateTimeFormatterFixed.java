/*
 * BSD 2-Clause License
 *
 * Copyright (c) 2019, Piotr Przybył
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.przybyl.ddj13;

import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.util.*;

/**
 * This is demonstration of fix described in https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8223773
 */
public class DateTimeFormatterFixed {

	public static void main(String[] args) {
		DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder()
			.parseStrict()
			.appendValue(ChronoField.HOUR_OF_AMPM)
			.appendLiteral(':')
			.appendValue(ChronoField.MINUTE_OF_HOUR)
			.appendLiteral(' ')
			.appendText(ChronoField.AMPM_OF_DAY);
		DateTimeFormatter formatter = builder.toFormatter(Locale.US);
		TemporalAccessor accessor = formatter.parse("12:00 PM");
		LocalTime localDateTime = LocalTime.from(accessor);
		System.out.println(localDateTime.toString());
	}
}
