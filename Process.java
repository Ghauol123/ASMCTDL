package asm;

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
        outputTextArea.setText(""); // Xóa nội dung cũ
        Stack<String> tempStack = new Stack<>(); // Ngăn xếp tạm
        long startTime = System.currentTimeMillis();

        // Duyệt qua các phần tử trong ngăn xếp gốc và đẩy vào ngăn xếp tạm
        while (!messageStack.isEmpty()) {
            tempStack.push(messageStack.pop());
        }

        // In ra các phần tử từ ngăn xếp tạm (theo thứ tự ban đầu)
        while (!tempStack.isEmpty()) {
            String message = tempStack.pop();
            outputTextArea.append(message + "\n");
            messageStack.push(message); // Đưa lại vào ngăn xếp gốc
            long endTime = System.currentTimeMillis(); // Ghi lại thời điểm kết thúc
            long elapsedTime = endTime - startTime; // Tính thời gian thực hiện

            System.out.println("Thời gian thực hiện showMessage: " + elapsedTime + "ms");
        }
    }
    public void deleteLastedmessage(){
        if (!messageStack.isEmpty()) {
            messageStack.pop();
        }
    }
    public void updateUI(JTextArea outputTextArea) {
        outputTextArea.setText(""); // Xóa nội dung cũ

        Stack<String> tempStack = new Stack<>(); // Ngăn xếp tạm để giữ nguyên thứ tự
        while (!messageStack.isEmpty()) {
            tempStack.push(messageStack.pop());
        }

        while (!tempStack.isEmpty()) {
            String message = tempStack.pop();
            outputTextArea.append(message + "\n");
            messageStack.push(message); // Đưa lại vào ngăn xếp gốc
        }
    }
    public void updateQueueUI(JTextArea outputTextArea) {
        outputTextArea.setText(""); // Xóa nội dung cũ
    }
}
