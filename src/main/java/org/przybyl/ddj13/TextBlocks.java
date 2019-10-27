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


public class TextBlocks {

	public static void main(String[] args) {
		System.out.println(getPoemFromText());
		System.out.println(getPoemFromTextBlock());
		System.out.println(getPoemDetails());
		System.out.println(getPoemDetailsFromBlock());
		indentationTests();
	}

	public static String getPoemFromText() {
		//piece of "Ode to Youth" by Adam Mickiewicz
		return "Dzieckiem w kolebce kto łeb urwał Hydrze,\n" +
			"Ten młody zdusi Centaury,\n" +
			"Piekłu ofiarę wydrze,\n" +
			"Do nieba pójdzie po laury.";
	}

	public static String getPoemFromTextBlock() {
		//piece of "Ode to Youth" by Adam Mickiewicz
		return """
			Tam sięgaj, gdzie wzrok nie sięga;
			Łam, czego rozum nie złamie:
			Młodości! orla twych lotów potęga,
			Jako piorun twoje ramię.
			""";
	}

	public static String getPoemDetails() {
		return "{\n" +
			"\t\"author\": \"Adam Mickiewicz\",\n" +
			"\t\"title\": \"Ode to Youth\",\n" +
			"\t\"written\": \"1820-12-26\"\n" +
			"}";
	}

	public static String getPoemDetailsFromBlock() {
		return """
		{
			"author": "Adam Mickiewicz",
			"title": "Ode to Youth",
			"written": "1820-12-26"
		}
		""";
	}

	private static void println(String toPrint) {
		System.out.println(toPrint);
	}

	static void indentationTests() {
//		println("""This doesn't compile, no new line after opening.""");
//		println("""
//		This doesn't compile, no matching closing.");

		println("""
			This has three ", you see? \"""
			""");

		println("""
		This is not indented.
		""");

		println("""
			This is not indented too.
			""");

		println("""
					This is not indented either.
					""");

		println("""
			This is indented.
		""");

		println("""
		This is indented.
	""");

		println("""
						This is veeery indented.
				""");

		println("""
			You don't have to close text block in the next line.""");

		println("""
			Or you can have many empty lines...

			in between...


			or at the end.


		    """);

		println("""
        spaces
			tabs
        more spaces
	 	 	 	""");

		println("""
			ene """ + """
			\t\tdue """);

		println("""
				What's your name? [%s]
				What's your number? [%d]
				""".formatted(
			ProcessHandle.current().info().user().orElse("FORBIDDEN"), ProcessHandle.current().pid()));
	}
}
