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
package org.jbasics.math.impl;

import org.jbasics.math.AlgorithmStrategy;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalAlgorithmStrategyChain implements AlgorithmStrategy<BigDecimal> {
	private final AlgorithmStrategy<BigDecimal>[] strategies;

	public BigDecimalAlgorithmStrategyChain(final AlgorithmStrategy<BigDecimal>... strategies) {
		this.strategies = strategies;
	}

	@Override
	public BigDecimal calculate(final MathContext mc, final BigDecimal guess, final BigDecimal... xn) {
		final BigDecimal[] temp = new BigDecimal[xn.length];
		System.arraycopy(xn, 0, temp, 0, temp.length);
		for (final AlgorithmStrategy<BigDecimal> strategy : this.strategies) {
			temp[0] = strategy.calculate(mc, null, temp);
		}
		return temp[0];
	}
}
