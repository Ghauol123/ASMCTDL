package asm;
import implementations.*;

import java.util.Scanner;

public class Receive {
    private Queue<String> messageQueue;
    Scanner sc = new Scanner(System.in);

    public Receive(Queue<String> messageQueue) {
        this.messageQueue = messageQueue;
    }

    public void addMessageToQueue(String input) {
        messageQueue.offer(input);
    }
    public Queue<String> getMessageQueue() {
        return messageQueue;
    }
}
