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
package org.jbasics.types.iteration;

import org.jbasics.checker.ContractCheck;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CombinedIteratorForIterables<T> implements Iterator<T> {
	private final Iterable<? extends T>[] iterables;
	private int nextIndex = 0;
	private Iterator<? extends T> currentIterator;

	public CombinedIteratorForIterables(final Iterable<? extends T>... iterables) {
		this.iterables = ContractCheck.mustNotBeNullOrEmpty(iterables, "iterables");
	}

	@Override
	public boolean hasNext() {
		if (this.currentIterator != null && this.currentIterator.hasNext()) {
			return true;
		} else if (this.nextIndex < this.iterables.length) {
			this.currentIterator = this.iterables[this.nextIndex++].iterator();
			return hasNext();
		} else {
			return false;
		}
	}

	@Override
	public T next() {
		if (hasNext()) {
			return this.currentIterator.next();
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public void remove() {
		if (this.currentIterator != null) {
			this.currentIterator.remove();
		}
	}
}
