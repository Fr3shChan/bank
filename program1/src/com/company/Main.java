package com.company;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
public class Main {

    private static Bank bank;

    public static void main(String[] args) {
        bank = new Bank();
        logIn();
    }
        public static void logIn() {
            int option1;
            Scanner scanner1 = new Scanner(System.in);

            do{
                System.out.println("1. Konto użytkownika");
                System.out.println("2. Konto Admina");
                System.out.println("0. Wyjście");

                System.out.println("=================");
                System.out.println("Wybierz opcję: ");
                System.out.println("=================");
                option1 = scanner1.nextInt();
                scanner1.nextLine();

                switch (option1) {
                    case 1 -> {
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("Konto użytkownika");
                        System.out.println("Podaj id: ");
                        String userId = scanner2.nextLine();
                        System.out.println("Podaj hasło: ");
                        String userPass = scanner2.nextLine();
                        bank.LogIn(userId, userPass);
                        if (bank.isLoggedIn()) {
                            showMenu();
                        } else {
                            System.out.println("Błędne id lub hasło");
                            break;
                        }
                    }
                    case 2 -> {
                        Scanner scanner3 = new Scanner(System.in);
                        System.out.println("Witaj w panelu administratora");
                        System.out.print("W celu zalogowania się podaj hasło: ");
                        System.out.println();
                        String haslo1 = scanner3.nextLine();
                        bank.LogIn("Admin", haslo1);


                        if (bank.isLoggedIn()) {

                            showAdminMenu();
                        } else
                        {
                            System.out.println("Błędne hasło");
                            break;
                        }
                        break;
                    }
                    case 0 -> {
                        break;
                    }
                    default -> System.out.println("Wybrałeś opcję, której nie ma. Proszę spróbuj ponownie");
                }
            }while(option1 != 0);

        }




        public static void showAdminMenu() {
            int option5;
            Scanner scanner6 = new Scanner(System.in);


            System.out.println();
            System.out.println();
            System.out.println("1. Dodaj użytkownika");
            System.out.println("4. Wszystkie informacje");

            System.out.println("0. Wyjście");

            do {
                System.out.println("=================");
                System.out.println("Wybierz opcję: ");
                System.out.println("=================");
                option5 = scanner6.nextInt();
                scanner6.nextLine();

                switch (option5) {
                    case 1 -> {
                        System.out.println("==================");
                        System.out.println("Podaj imię i nazwisko = " );
                        String customerName = scanner6.nextLine();
                        System.out.println("==================");
                        System.out.println("Podaj id = " );
                        String customerId = scanner6.nextLine();
                        System.out.println("==================");
                        System.out.println("Podaj domyślne hasło = " );
                        String customerPassword = scanner6.nextLine();
                        System.out.println("==================");
                        System.out.println("\n");
                        bank.addAccount(customerName, customerId, customerPassword);

                    }
                    case 4 -> {
                        System.out.println("==================");
                        System.out.println("Wszystkie informacje");
                        System.out.println("\n");
                        bank.displayAllAccounts();
                    }
                    case 0 -> {
                        System.out.println("Wylogowano");
                        break;
                    }
                    default -> System.out.println("Wybrałeś opcję, której nie ma. Proszę spróbuj ponownie");
                }


                System.out.println("1. Dodaj użytkownika");
                System.out.println("4. Wszystkie informacje");
                System.out.println("0. Wyjście");
                System.out.println();
                System.out.println();
            } while(option5 != 0);



        }

        public static void showMenu() {
            int option;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Dzień dobry " + bank.getCustomerName());
            System.out.println("Twoje ID to: "+ bank.getCustomerId());
            System.out.println("\n");
            System.out.println("1. Sprawdź stan konta");
            System.out.println("2. Wpłata");
            System.out.println("3. Wypłata");
            System.out.println("4. Przelew");
            System.out.println("5. Poprzednia transakcja");
            System.out.println("6. Zaciągnięcie Kredytu");
            System.out.println("7. Spłata Kredytu");

            System.out.println("0. Wyjście");

            do {

                System.out.println("=================");
                System.out.println("Wybierz opcję: ");
                System.out.println("=================");
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1 -> {
                        System.out.println("==================");
                        System.out.println("Saldo = " + bank.getBalance());
                        System.out.println("Zadłużenie = " + bank.getLoan());
                        System.out.println("==================");

                    }
                    case 2 -> {
                        System.out.println("==================");
                        System.out.println("Wpisz sumę wpłaty: ");
                        System.out.println("==================");
                        int amount = scanner.nextInt();
                        bank.deposit(amount);


                    }
                    case 3 -> {
                        System.out.println("==================");
                        System.out.println("Wpisz sumę wypłaty: ");
                        System.out.println("==================");
                        int amount2 = scanner.nextInt();
                        bank.withdraw(amount2);


                    }
                    case 4 -> {
                        System.out.println("==================");
                        System.out.println("Wpisz kwotę przelewu: ");
                        System.out.println("==================");
                        int amount2 = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Wpisz id odbiorcy: ");
                        System.out.println("==================");
                        String destinationId = scanner.nextLine();
                        bank.wireTransfer(amount2,destinationId);
                        scanner.reset();

                    }
                    case 5 -> {
                        System.out.println("==================");
                        bank.getPreviousTransaction();
                        System.out.println("==================");

                    }
                    case 6 -> {
                        System.out.println("==================");
                        System.out.println("Wpisz kwotę kredytu do zaciągnięcia: ");
                        System.out.println("==================");
                        int amount2 = scanner.nextInt();
                        bank.takeLoan(amount2);
                    }
                    case 7 -> {
                        System.out.println("==================");
                        System.out.println("Wpisz kwotę kredytu do spłaty: ");
                        System.out.println("==================");
                        int amount2 = scanner.nextInt();
                        bank.payBackLoan(amount2);
                    }
                    case 0 -> {
                        System.out.println("Wylogowano");
                        break;
                    }
                    default -> System.out.println("Wybrałeś opcję, której nie ma. Proszę spróbuj ponownie");
                }
                System.out.println();
                System.out.println("1. Sprawdź stan konta");
                System.out.println("2. Wpłata");
                System.out.println("3. Wypłata");
                System.out.println("4. Przelew");
                System.out.println("5. Poprzednia transakcja");
                System.out.println("6. Zaciągnięcie Kredytu");
                System.out.println("7. Spłata Kredytu");

                System.out.println("0. Wyjście");
                System.out.println();
                System.out.println();
            } while(option !=0);

            System.out.println("Dziękujemy za skorzystanie z naszej aplikacji");
    }
}

