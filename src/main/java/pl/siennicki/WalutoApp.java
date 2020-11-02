package pl.siennicki;

import okhttp3.Response;

import java.io.IOException;
import java.util.Scanner;

public class WalutoApp {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        CurrencyApi currencyApi = new CurrencyApi(Client.getINSTANCE(),new JsonDataConverter());

        System.out.println("Podaj walute transakcji opcje");
        for (Currency currency : Currency.values()) {
            System.out.print(currency.name() + "; ");
        }

        System.out.println();
        Currency currency = Currency.getCurrency(scanner.nextLine());

        System.out.println("Ile chcesz waluty: ");
        double ilosc = scanner.nextDouble();

        CurrencyInfo currencyInfo = currencyApi.getInfoForCurrency(currency);
        System.out.println("sprzedaz >>> "
                + currencyInfo.getName() + " : " + (ilosc * currencyInfo.getSell()) + " zl");

        System.out.println("kupno >>> "
                + currencyInfo.getName() + " : " + (ilosc * currencyInfo.getBuy()) + " zl");

    }
}
