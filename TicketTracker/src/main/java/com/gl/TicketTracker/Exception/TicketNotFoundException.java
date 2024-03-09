package com.gl.TicketTracker.Exception;


    public class TicketNotFoundException extends RuntimeException {
        public TicketNotFoundException(String message) {
            super(message);
        }
    }

