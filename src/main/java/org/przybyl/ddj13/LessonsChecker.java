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

import java.util.*;
import java.util.stream.*;

enum DayOfWeek {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

	public static Optional<DayOfWeek> fromString(String day) {
		return Stream.of(DayOfWeek.values()).filter(dow -> dow.name().equalsIgnoreCase(day)).findFirst();
	}
}

public class LessonsChecker {
	public static void main(String[] args) {
		System.out.println("Hello Java 13!");

		if (args == null || args.length == 0) {
			System.out.println("I have no lessons!");
		} else {
			Stream.of(args)
				.map(DayOfWeek::fromString)
				.forEach(od -> od.ifPresent(d -> System.out.println(String.format("On %s I have %d lessons",
					d,
					howManyLessonsArrow(d)))));
		}

	}

	private static int howManyLessonsArrow(DayOfWeek day) {
		return switch (day) {
			case MONDAY, FRIDAY -> 6;
			case TUESDAY -> 7;
			case THURSDAY, WEDNESDAY -> 8;
			case SATURDAY, SUNDAY -> 0;
		};
	}

	private static int howManyLessonsArrowBlocks(DayOfWeek day) {
		return switch (day) {
			case MONDAY, FRIDAY -> 6;
			case TUESDAY -> 7;
			case THURSDAY, WEDNESDAY -> 8;
			case SATURDAY, SUNDAY -> {
				System.out.println("How dare you asking about the weekend?");
				yield 0;
			}
		};
	}

	private static int howManyLessonsInstruction(DayOfWeek day) {
		int lessons = 0;
		switch (day) {
			case MONDAY, FRIDAY:
				lessons = 6;
				break;
			case TUESDAY:
				lessons = 7;
				break;
			case THURSDAY, WEDNESDAY:
				lessons = 8;
				break;
			case SATURDAY, SUNDAY:
				lessons = 0;
				break;
		}
		return lessons;
	}

	private static int howManyLessonsExpressionWithBreak(DayOfWeek day) {
		var lessons = switch (day) {
			case MONDAY, FRIDAY:
				yield 6;
			case TUESDAY:
				yield 7;
			case THURSDAY, WEDNESDAY:
				yield 8;
			case SATURDAY, SUNDAY:
				yield 0;
		};
		return lessons;
	}

//	int switchStatementsNeedToBeExhaustive(int input) {
//		//generates compiler error
//		return switch (input) {
//			case 0, 1, 2 -> input + 1;
//			case 3, 4, 5 -> 2 * input;
////			default -> -1;
//		};
//	}

//	private int returnFromSwitchExpressionDoesNotWork(int input) {
//		int output = switch (input) {
//			case 0, 1, 2 -> input + 1;
//			case 3, 4, 5 -> {
//				return 2 * input;
//			}
//			default -> -1;
//		};
//		return output;
//	}

	private int returnFromSwitchStatementWorks(int input) {
		switch (input) {
			case 0, 1, 2 -> {
				return input + 1;
			}
			case 3, 4, 5 -> {
				return 2 * input;
			}
			default -> {
				return -1;
			}
		}
	}

//	private int switchStatementsNeedToBeExhaustive(int input) {
//		//generates compiler error
//		return switch (input) {
//			case 0, 1, 2 -> input + 1;
//			case 3, 4, 5 -> 2 * input;
//		};
//	}

	private void switchDoesNotNeedAssignedType() {
		// don't do randoms like this in production, demo only
		var input = new Random().nextInt(10);
		var stuff = switch (input) {
			case 0, 1, 2, 3, 4 -> "I'm very smol";
			default -> input;
		};
		System.out.println(String.format("The class of [%s] is [%s].",
			stuff, stuff.getClass().getCanonicalName()));
	}
}