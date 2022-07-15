package com.gokhantamkoc.javabootcamp.odevhafta45.util.consoleresponsehandler;

public class ExitConsoleResponseHandler extends ConsoleResponseHandler {

    public ExitConsoleResponseHandler(ConsoleResponseHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public boolean handleConsoleResponse(String response) {
        if (response.equalsIgnoreCase("E")) {
            System.out.println("Thanks for using Swapper! Bye bye");
            System.exit(0);
        } else if (nextHandler != null) {
            return this.nextHandler.handleConsoleResponse(response);
        }
        return false;
    }
}
