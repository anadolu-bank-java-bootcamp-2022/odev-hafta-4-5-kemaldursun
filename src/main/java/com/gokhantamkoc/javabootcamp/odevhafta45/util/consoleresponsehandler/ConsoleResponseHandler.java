package com.gokhantamkoc.javabootcamp.odevhafta45.util.consoleresponsehandler;

public abstract class ConsoleResponseHandler {
    protected ConsoleResponseHandler nextHandler;

    public ConsoleResponseHandler(ConsoleResponseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract boolean handleConsoleResponse(String response);
}
