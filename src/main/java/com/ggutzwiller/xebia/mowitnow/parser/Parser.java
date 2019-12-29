package com.ggutzwiller.xebia.mowitnow.parser;

import com.ggutzwiller.xebia.mowitnow.exception.MowItNowException;

/**
 * @author Grégoire Gutzwiller
 * @since 28/12/2019
 */
interface Parser<T> {
    T parse(String stringRepresentation) throws MowItNowException;
}
