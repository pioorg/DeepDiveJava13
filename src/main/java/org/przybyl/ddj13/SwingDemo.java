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

import java.awt.*;

import javax.swing.*;

public class SwingDemo {

	// try running this in GNU/Linux with GTK+ 3.20 and above with and without
	// -Djdk.gtk.version=2.2

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
//		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//		UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		var progressBar = createProgressBar(42);
		var slider = createSlider(progressBar);
		var mainFrame = createMainFrame();

		addComponentsToMainFrame(mainFrame, progressBar, slider);
	}

	private static JSlider createSlider(JProgressBar progressBar) {
		var slider = new JSlider(JSlider.HORIZONTAL, progressBar.getMinimum(), progressBar.getMaximum(), progressBar.getMaximum() - progressBar.getValue());
		slider.addChangeListener(e -> progressBar.setValue(100 - slider.getValue()));
		return slider;
	}

	private static JProgressBar createProgressBar(int initialValue) {
		var progressBar = new JProgressBar(0, 100);
		progressBar.setStringPainted(true);
		progressBar.setValue(initialValue);
		return progressBar;
	}

	private static JFrame createMainFrame() {
		JFrame mainFrame = new JFrame("Swing Demo");
		mainFrame.setSize(800, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		return mainFrame;
	}

	private static void addComponentsToMainFrame(JFrame mainFrame, JProgressBar progressBar, JSlider slider) {
		mainFrame.getContentPane().add(BorderLayout.SOUTH, progressBar);
		mainFrame.getContentPane().add(BorderLayout.NORTH, slider);
		mainFrame.getContentPane().add(BorderLayout.CENTER, new JLabel("Having some fun experimenting with GTK L & F", JLabel.CENTER));
	}
}
