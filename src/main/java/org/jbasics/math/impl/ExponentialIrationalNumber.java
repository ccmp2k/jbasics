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
import org.jbasics.math.IrationalNumber;
import org.jbasics.math.strategies.ExponentialTaylerAlgorithmStrategy;

import java.math.BigDecimal;

public class ExponentialIrationalNumber extends BigDecimalIrationalNumber {
	public static final IrationalNumber<BigDecimal> E;
	private static final AlgorithmStrategy<BigDecimal> STRATEGY;

	static {
		STRATEGY = new ExponentialTaylerAlgorithmStrategy();
		E = new ExponentialIrationalNumber(BigDecimal.ONE);
	}

	private ExponentialIrationalNumber(BigDecimal x) {
		super(STRATEGY, x);
	}

	public static IrationalNumber<BigDecimal> valueOf(BigDecimal x) {
		if (BigDecimal.ONE.compareTo(x) == 0) {
			return E;
		}
		return new ExponentialIrationalNumber(x);
	}
}
