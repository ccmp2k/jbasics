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
package org.jbasics.net.http.browser;

import org.junit.Assert;
import org.junit.Test;

public class WebBrowserTypeTest {
	@Test
	public void testBrowsers() {
		Assert.assertSame(WebBrowserType.FIREFOX,
				WebBrowserType.detect("Mozilla/5.0 (Windows; U; Windows NT 5.1; de; rv:1.9.2) Gecko/20100115 Firefox/3.6 (.NET CLR 3.5.30729)"));
		Assert.assertNotSame(WebBrowserType.INTERNET_EXPLORER,
				WebBrowserType.detect("Mozilla/5.0 (Windows; U; Windows NT 5.1; de; rv:1.9.2) Gecko/20100115 Firefox/3.6 (.NET CLR 3.5.30729)"));
		Assert.assertSame(WebBrowserType.SAFARI, WebBrowserType.detect("Safari/5.0"));
		Assert.assertSame(WebBrowserType.OPERA, WebBrowserType.detect("Opera/8.5"));
		Assert.assertSame(WebBrowserType.KONQUEROR, WebBrowserType.detect("Konqueror/8.5;"));
		Assert.assertSame(WebBrowserType.OTHER, WebBrowserType.detect("Magic Browser"));
	}
}
