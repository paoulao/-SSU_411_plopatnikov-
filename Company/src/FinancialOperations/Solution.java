package FinancialOperations;

import javenue.csv.Csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static Company createCompany() {
        Company company = new Company();
        return company;
    }

    public static Transaction transactionCreate() {
        Transaction transaction = new Transaction();
        return transaction;
    }

    public static void printTransaction(int q, ArrayList<Transaction> transactionList) {
        System.out.print("transaction" + q + " " + transactionList.get(q).sender_name + ";" +
                transactionList.get(q).sender_account + ";" + transactionList.get(q).recipient_name + ";" +
                transactionList.get(q).recipient_account + ";" + transactionList.get(q).price);
    }

    public static void printInfoAboutCompany(ArrayList<Company> listOfCompany) {
        System.out.println("INFO ABOUT COMPANY"); // выводим инфо о компаниях
        for (int q = 0; q < listOfCompany.size(); q++)
            System.out.println(listOfCompany.get(q).name + ";" + listOfCompany.get(q).account + ";" +
                    listOfCompany.get(q).budget);
        System.out.println();
    }

    public static ArrayList<Company> companyList() throws FileNotFoundException {
        File file = new File("info/info_about_company.csv");
        Scanner sc1 = new Scanner(file);
        String[] arr;
        int quantityCompany = 0; int q = 0;
        ArrayList<Company> companyList = new ArrayList();
        while (sc1.hasNext()) {
            arr = sc1.next().split(";");
            if (!arr[0].equals("Company")) {
                companyList.add(createCompany()); //с каждой новой строкой создаем новую компанию и заполняем данными
                companyList.get(quantityCompany).name = arr[0];
                companyList.get(quantityCompany).account = arr[1];
                companyList.get(quantityCompany).budget = new BigDecimal(arr[2]);
                quantityCompany++;
            }
        }
        sc1.close();
        return companyList;
    }

    public static ArrayList<Transaction> transactionList() throws FileNotFoundException {
        File F = new File("info");
        File[] fList = F.listFiles();
        String[] arr;
        int quantityTransaction = 0;
        ArrayList<Transaction> transactionList = new ArrayList();
        Scanner sc2 = null;
        for (int i = 0; i < fList.length; i++) {
            sc2 = new Scanner(fList[i]);
            while (sc2.hasNext()) {
                arr = sc2.next().split(";");
                if (!arr[0].equals("Company1")) {
                    if (arr.length == 5) {
                        transactionList.add(transactionCreate());
                        transactionList.get(quantityTransaction).sender_name = arr[0];
                        transactionList.get(quantityTransaction).sender_account = arr[1];
                        transactionList.get(quantityTransaction).recipient_name = arr[2];
                        transactionList.get(quantityTransaction).recipient_account = arr[3];
                        transactionList.get(quantityTransaction).price = new BigDecimal(arr[4]);
                        quantityTransaction++;
                    }
                }
            }
        }
        sc2.close();
        return transactionList;
    }

    public static ArrayList<Company> resultList(ArrayList<Transaction> transactionList, ArrayList<Company> resultList){
        System.out.println("INFO ABOUT TRANSACTION");
        for (int q = 0; q < transactionList.size(); q++) {
            printTransaction(q, transactionList); // инфо о транзакции
            BigDecimal sum = transactionList.get(q).price; // сумма транзакции

            for (int q1 = 0; q1 < resultList.size(); q1++) {
                if (resultList.get(q1).account.equals(transactionList.get(q).sender_account)){
                // если есть первая компания с таким счетом
                    if (resultList.get(q1).budget.compareTo(sum) >= 0) { // если ее бюджет позволяет
                        for (int q2 = 0; q2 < resultList.size(); q2++) {
                            if (resultList.get(q2).account.equals(transactionList.get(q).recipient_account)) {
                            // если есть вторая компания с таким счетом
                                resultList.get(q1).budget = resultList.get(q1).budget.add(sum.negate()); // снимаем мани
                                resultList.get(q2).budget = resultList.get(q2).budget.add(sum); // начисляем
                                System.out.println(" GOOD");
                            }
                        }
                    }
                    else System.out.println(" BAD BUGGET");
                }
            }
        }
        System.out.println();
        return resultList;
    }

    public static void createResult(ArrayList<Company> resultList){
        Csv.Writer writer_res = new Csv.Writer("info/result.csv").delimiter(';');
        writer_res.value("Company").value("ID").value("Budget").newLine();
        for (int qq = 0; qq < resultList.size(); qq++)
            writer_res.value(resultList.get(qq).name).value(resultList.get(qq).account).
                    value(resultList.get(qq).budget.toString()).newLine();
        writer_res.close();
    }

    public static void main(String[] args) throws IOException {
       // ArrayList<Company> listOfCompany = companyList(); // получаем лист с информацией о компаниях
        ArrayList<Transaction> listOfTransaction = transactionList(); // получаем лист с транзакциями
        ArrayList<Company> listOfResult = companyList(); // создаем результирующий лист

       // printInfoAboutCompany(listOfCompany); // выводим инфо о компаниях

        createResult(resultList(listOfTransaction, listOfResult)); // получаем результат и записываем в csv
    }
}
