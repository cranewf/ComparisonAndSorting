import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    Ticket t1 = new Ticket("Домодедово", "Нижний Новгород", 5_000, 14, 21);
    Ticket t2 = new Ticket("Внуково", "Казань", 7_500, 11, 16);
    Ticket t3 = new Ticket("Казань", "Санкт-Петербург", 8_200,10, 16);
    Ticket t4 = new Ticket("Санкт-Петербург", "Внуково", 7_500, 15, 23);

    @Test
    public void addTickets(){
        AviaSouls add = new AviaSouls();

        add.add(t1);
        add.add(t2);
        add.add(t3);
        add.add(t4);

        Ticket[] expected = {t1, t2, t3, t4};
        Ticket[] actual = add.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchTickets(){
        AviaSouls search = new AviaSouls();

        search.add(t1);
        search.add(t2);
        search.add(t3);
        search.add(t4);

        Ticket[] actual1 = search.search("Домодедово", "Нижний Новгород");
        Ticket[] actual2 = search.search("Внуково", "Казань");
        Ticket[] actual3 = search.search("Санкт-Петербург", "Внуково");
        Ticket[] actual4 = search.search("Казань", "Санкт-Петербург");

        Ticket[] expected = {t1, t2, t4, t3};
        Ticket[][] actual = {actual1, actual2, actual3, actual4};

    }

    @Test
    public void searchNoneTickets(){
        AviaSouls searchNone = new AviaSouls();

        searchNone.add(t1);
        searchNone.add(t2);
        searchNone.add(t3);
        searchNone.add(t4);

        Ticket[] expected = {};
        Ticket[] actual = searchNone.search("Нижний Новгород", "Казань");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void sortByPrice(){
        AviaSouls sorts = new AviaSouls();

        sorts.add(t1);
        sorts.add(t2);
        sorts.add(t3);
        sorts.add(t4);

        Ticket[] tickets = {t1, t2, t3, t4};

        Ticket[] expected = {t1, t2, t4, t3};
        Arrays.sort(tickets);

        Assertions.assertArrayEquals(expected,tickets);
    }

    @Test
    public void searchWithComparator(){
        AviaSouls searchComparator = new AviaSouls();

        searchComparator.add(t1);
        searchComparator.add(t2);
        searchComparator.add(t3);
        searchComparator.add(t4);

        Ticket[] actual1 = searchComparator.searchAndSortBy("Внуково", "Казань");
        Ticket[] actual2 = searchComparator.searchAndSortBy("Казань", "Санкт-Петербург" );
        Ticket[] actual3 = searchComparator.searchAndSortBy("Домодедово", "Нижний Новгород");
        Ticket[] actual4 = searchComparator.searchAndSortBy("Санкт-Петербург", "Внуково");

        Ticket[] expected = {t2, t3, t1, t4};
        Ticket[][] actual = {actual1, actual2, actual3, actual4};

    }

}