package com.ggutzwiller.xebia.mowitnow.exception;

/**
 * @author Grégoire Gutzwiller
 * @since 29/12/2019
 */
public abstract class MowItNowException extends Exception {
    public MowItNowException(String errorMessage) {
        super(errorMessage);
    }
}
