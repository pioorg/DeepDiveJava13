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


import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class FileLister {

	public static void main(String[] args) {
		getDirNamesToList(args).map(File::new).filter(File::isDirectory).forEach(f -> {
			System.out.println("Listing subdirectories of " + f.getAbsolutePath());
			File[] t = f.listFiles(File::isDirectory);
			Arrays.stream(Objects.requireNonNull(t)).map(File::toPath).forEach(p -> {
				System.out.println(String.format("%s is %s and it's%s hidden", p.getFileName(), Files.isDirectory(p) ? "directory" : "file", hidden(p) ? "" : " NOT"));
			});
		});
	}

	/**
	 * In this simple demo no exceptions are thrown so "swallowing" exceptions work.
	 * However, this is not how we shall do that in production, because we should be using Try or Either.
	 */
	private static boolean hidden(Path path) {
		try {
			return Files.isHidden(path);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static Stream<String> getDirNamesToList(String[] args) {
		if (args != null && args.length != 0) {
			return Stream.of(args);
		} else {
			return Stream.of(".");
		}
	}
}
