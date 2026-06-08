package task4;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Login {

    static final String PASSWORD = "123456";
    static int error = 0;
    static LocalDateTime blocked = null;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            if (blocked != null && LocalDateTime.now().isBefore(blocked)) {
                System.out.println("bloklangan");
                System.out.println("Qayta urinish vaqti: " + blocked);
                continue;
            }

            System.out.print("Parolni kiriting: ");
            String password = scanner.nextLine();

            if (password.equals(PASSWORD)) {
                System.out.println("Tizimga muvaffaqiyatli kirildi.");
                break;
            } else {
                error++;
                System.out.println("Parol noto'g'ri! Urinishlar soni: " + error);

                if (error >= 3) {
                    blocked = LocalDateTime.now().plusHours(1);
                    error = 0;
                    System.out.println("3 marta xato kiritildi!");
                    System.out.println("Hisob 1 soatga bloklandi.");
                }
            }
        }

        scanner.close();
    }
}