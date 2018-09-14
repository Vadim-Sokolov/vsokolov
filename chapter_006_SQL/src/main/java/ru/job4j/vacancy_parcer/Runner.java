package ru.job4j.vacancy_parcer;

import org.jsoup.Jsoup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Runner {

    public static void main(String[] args) {

        Document document;
        try {
            document = Jsoup.connect("http://www.sql.ru/forum/job").get();

            BufferedWriter bw = new BufferedWriter( new FileWriter("d://bb.txt"));
            bw.write(document.toString());
            bw.close();

            Elements links =document.select("a[href]");
            for (Element link : links) {
                System.out.println(link.attr("href"));
                System.out.println(link.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        print("done");
    }

    public static void print(String string) {
        System.out.println(string);
    }
}
