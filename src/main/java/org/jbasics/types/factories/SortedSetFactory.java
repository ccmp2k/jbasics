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
package org.jbasics.types.factories;

import org.jbasics.pattern.factory.Factory;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetFactory<E> implements Factory<SortedSet<E>> {
	private final static SortedSetFactory<?> SHARED_INSTANCE = new SortedSetFactory<Object>();

	private final Comparator<E> comparator;

	public SortedSetFactory() {
		this(null);
	}

	public SortedSetFactory(final Comparator<E> comparator) {
		this.comparator = comparator;
	}

	public static <E> SortedSetFactory<E> create(final Comparator<E> comparator) {
		return new SortedSetFactory<E>(comparator);
	}

	@SuppressWarnings("unchecked")
	public static <E extends Comparable<E>> SortedSetFactory<E> sortedSetFactory() {
		return (SortedSetFactory<E>) SortedSetFactory.SHARED_INSTANCE;
	}

	@Override
	public SortedSet<E> newInstance() {
		if (this.comparator != null) {
			return new TreeSet<E>(this.comparator);
		} else {
			return new TreeSet<E>();
		}
	}
}
