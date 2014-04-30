package com.idetronic.eprint.transform;

/**
 * This exception is thrown when error occurs while transforming a document
 */
public class TransformationException extends RuntimeException {
    public TransformationException(String m) {
        super(m);
    }

    public TransformationException(String m, Throwable e) {
        super(m, e);
    }
}
