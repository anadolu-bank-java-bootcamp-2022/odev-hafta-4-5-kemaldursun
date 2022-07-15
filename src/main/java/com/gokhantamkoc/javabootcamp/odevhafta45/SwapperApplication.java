package com.gokhantamkoc.javabootcamp.odevhafta45;

import com.gokhantamkoc.javabootcamp.odevhafta45.util.consoleresponsehandler.ConsoleResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SwapperApplication implements CommandLineRunner {

    @Autowired
    ConsoleResponseHandler consoleResponseHandler;

    final Scanner keyboardInput = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(SwapperApplication.class, args);
    }

    @Override
    public void run(String... args) throws RuntimeException {
        while(true) {
            System.out.println("What do you want to do? \n (LP: List Products, LO: List Orders, SOD: Show Order Detail, E: Exit)");
            String response = readInputFromUser();
            boolean validResponse = consoleResponseHandler.handleConsoleResponse(response);
            if (!validResponse) {
                System.out.println("Response not valid!");
            }
        }
    }

    public String readInputFromUser() {
        return keyboardInput.nextLine();
    }
}
