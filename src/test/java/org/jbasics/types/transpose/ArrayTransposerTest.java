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

import junit.framework.Assert;
import org.jbasics.xml.XMLDateConverter;
import org.junit.Test;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.List;

public class ArrayTransposerTest {

	@Test
	public void testSimple() {
		Date[] input = new Date[]{new Date(), new Date(), new Date()};
		ArrayTransposer<XMLGregorianCalendar, Date> t = new ArrayTransposer<XMLGregorianCalendar, Date>(XMLDateConverter.TO_XML_DATE_FACTORY);
		List<XMLGregorianCalendar> output = t.transpose(input);
		Assert.assertEquals(input.length, output.size());
	}
}
