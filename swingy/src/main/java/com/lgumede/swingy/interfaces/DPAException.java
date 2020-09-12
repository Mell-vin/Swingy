package com.lgumede.swingy.interfaces;

public class DPAException extends Exception{
    private static final long serialVersionUID = 4L;
    
    public DPAException() {
        super("PlayArea error");
    }

    public DPAException (String msg) {
        super(msg);
    }
}
