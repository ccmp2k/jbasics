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
package org.jbasics.math;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.jbasics.checker.ContractCheck;
import org.jbasics.pattern.builder.Builder;

public class BigDecimalMatrixBuilder implements Builder<BigDecimalMatrix> {
	private final List<List<BigDecimal>> storage;

	public BigDecimalMatrixBuilder() {
		this.storage = new ArrayList<List<BigDecimal>>();
	}

	public BigDecimalMatrixBuilder set(final int row, final int column, final BigDecimal value) {
		int x = ContractCheck.mustBeInRange(row, 1, Integer.MAX_VALUE, "row") - 1; //$NON-NLS-1$
		int y = ContractCheck.mustBeInRange(column, 1, Integer.MAX_VALUE, "row") - 1; //$NON-NLS-1$
		if (this.storage.size() < x) {
			// need to be extended by adding the missing rows
			for (int i = x - this.storage.size(); i >= 0; i--) {
				this.storage.add(new ArrayList<BigDecimal>());
			}
		}
		List<BigDecimal> temp = this.storage.get(x);
		if (temp.size() < y) {
			// need to be extended by adding the missing rows
			for (int i = y - temp.size(); i >= 0; i--) {
				temp.add(BigDecimal.ZERO);
			}
		}
		temp.set(y, value == null ? BigDecimal.ZERO : value);
		return this;
	}

	public void reset() {
		this.storage.clear();
	}

	public BigDecimalMatrix build() {
		return new BigDecimalMatrix(this.storage);
	}

}
