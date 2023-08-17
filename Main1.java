package asm;
import implementations.*;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Queue<String> messageQueue = new Queue<>(); // Create an instance of Queue
        Stack<String> messageStack = new Stack<>(); // Create an instance of Stack

        Receive input = new Receive(messageQueue);
        Process1 send = new Process1(messageQueue,messageStack);
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("Chọn một tùy chọn:");
            System.out.println("1. Nhập thông điệp vào Queue");
            System.out.println("2. In ra thông điệp trong Queue");
            System.out.println("3. Nhập thông tin vào Stack");
            System.out.println("4. Hiển thị thông tin trong Stack");
            System.out.println("5. Thoát");

            int choose = scn.nextInt();
            scn.nextLine();

            switch (choose) {
                case 1:
                    String message = scn.nextLine();
                    input.addMessageToQueue(message);
                    break;
                case 2:
                    System.out.println("Các thông điệp trong Queue:");
                    for (String message1 : messageQueue) {
                        System.out.println(message1);
                    }
                    break;
                case 3:
                    send.sendMessage();
                    break;
                case 4:
                    System.out.println("Các thông điệp trong Stack:");
                    send.showMessage();
                    break;
                case 5:
                    System.out.println("Thoát chương trình...");
                    System.exit(0);
                case 6:
                    System.out.println("xóa message mới nhất");
                    send.deleteLastedmessage();
                    for (String message2 : messageStack) {
                        System.out.println(message2);
                    }
                    break;
                case 7:
                    int size = messageStack.size();
                    String getsize = Integer.toString(size);
                    System.out.println(getsize);
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }
}