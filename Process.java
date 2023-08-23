package asm.ASMCTDL;

import implementations.*;
import javax.swing.JTextArea;

public class Process {

    private Queue<String> messageQueue;
    private Stack<String> messageStack;


    public Process(Queue<String> queue, Stack<String> stack) {
        this.messageQueue = queue;
        this.messageStack = stack;
    }

    public void sendMessage() {
        while (!messageQueue.isEmpty()) {
            String message = messageQueue.poll();
            messageStack.push(message);
        }
    }

    public void showMessage(JTextArea outputTextArea) {
        long startTime = System.currentTimeMillis();
        outputTextArea.setText("");
        Stack<String> tempStack = new Stack<>();


        while (!messageStack.isEmpty()) {
            tempStack.push(messageStack.pop());
        }


        while (!tempStack.isEmpty()) {
            String message = tempStack.pop();
            outputTextArea.append(message + "\n");
            messageStack.push(message);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;

            System.out.println("\nThời gian thực hiện showMessage: " + elapsedTime + "ms\n");
        }
    }
    public void deleteLastedmessage(){
        if (!messageStack.isEmpty()) {
            messageStack.pop();
        }
    }
    public void updateUIQueue(JTextArea outputTextArea) {
        outputTextArea.setText("");

        Stack<String> tempStack = new Stack<>();
        while (!messageStack.isEmpty()) {
            tempStack.push(messageStack.pop());
        }

        while (!tempStack.isEmpty()) {
            String message = tempStack.pop();
            outputTextArea.append(message + "\n");
            messageStack.push(message);
        }
    }
    public void updateUIStack(JTextArea outputTextArea) {
        outputTextArea.setText("");

        Stack<String> tempStack = new Stack<>();
        while (!messageStack.isEmpty()) {
            tempStack.push(messageStack.pop());
        }

        while (!tempStack.isEmpty()) {
            String message = tempStack.pop();
            outputTextArea.append(message + "\n");
            messageStack.push(message);
        }
    }
    public void updateQueueUI(JTextArea outputTextArea) {
        outputTextArea.setText("");
    }
}
