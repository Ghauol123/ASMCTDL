package asm;

import implementations.*;


public class Process1 {

    private Queue<String> messageQueue;
    private Stack<String> messageStack;


    public Process1(Queue<String> queue, Stack<String> stack) {
        this.messageQueue = queue;
        this.messageStack = stack;
    }

    public void sendMessage() {
        while (!messageQueue.isEmpty()) {
            String message = messageQueue.poll();
            messageStack.push(message);
        }
    }

    public void showMessage() {
        Stack<String> tempStack = new Stack<>(); // Ngăn xếp tạm
        long startTime = System.currentTimeMillis();

        // Duyệt qua các phần tử trong ngăn xếp gốc và đẩy vào ngăn xếp tạm
        while (!messageStack.isEmpty()) {
            tempStack.push(messageStack.pop());
        }

        // In ra các phần tử từ ngăn xếp tạm (theo thứ tự ban đầu)
        while (!tempStack.isEmpty()) {
            String message = tempStack.pop();
            messageStack.push(message); // Đưa lại vào ngăn xếp gốc
            for(String s : messageStack){
                System.out.println(s);
            }
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
}
