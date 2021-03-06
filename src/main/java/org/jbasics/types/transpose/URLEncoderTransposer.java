/*
 * Copyright (c) 2009 Stephan Schloepke and innoQ Deutschland GmbH
 *
 * Stephan Schloepke: http://www.schloepke.de/
 * innoQ Deutschland GmbH: http://www.innoq.com/
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jbasics.types.transpose;

import org.jbasics.checker.ContractCheck;
import org.jbasics.exception.DelegatedException;
import org.jbasics.pattern.transpose.Transposer;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by schls1 on 04.07.2014.
 */
public final class URLEncoderTransposer implements Transposer<String, String> {
	public static final URLEncoderTransposer SHARED_INSTANCE = new URLEncoderTransposer();
	private final String charset;

	public URLEncoderTransposer() {
		this("UTF-8");
	}

	public URLEncoderTransposer(String charset) {
		this.charset = ContractCheck.mustNotBeNullOrTrimmedEmpty(charset, "charset");
	}

	@Override
	public String transpose(String input) {
		try {
			return input == null ? null : URLEncoder.encode(input, this.charset);
		} catch(UnsupportedEncodingException e) {
			throw DelegatedException.delegate(e);
		}
	}
}
