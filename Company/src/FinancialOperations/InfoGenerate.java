package FinancialOperations;

import javenue.csv.Csv;

public class InfoGenerate {
    public static void main(String[] args) {
        Csv.Writer writer_info = new Csv.Writer("info/info_about_company.csv").delimiter(';');
        writer_info.value("Company").value("ID").value("Budget").newLine();
        writer_info.value("Apple").value("1111").value("1000").newLine();
        writer_info.value("Microsoft").value("2222").value("1000").newLine();
        writer_info.value("Google").value("3333").value("2000").newLine().close();

        Csv.Writer writer_trans = new Csv.Writer("info/info_about_trans.csv").delimiter(';');
        writer_trans.value("Company1").value("ID1").value("Company2").value("ID2").value("Budget").newLine();
        writer_trans.value("Apple").value("1111").value("Google").value("3333").value("1100").newLine();
        writer_trans.value("Microsoft").value("2222").value("Apple").value("1111").value("200").newLine();
        writer_trans.value("Apple").value("1111").value("Google").value("3333").value("1100").close();
    }
}
