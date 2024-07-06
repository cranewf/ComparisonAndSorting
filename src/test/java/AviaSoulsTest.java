import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    Ticket t1 = new Ticket("Домодедово", "Нижний Новгород", 5_000, 14, 21);
    Ticket t2 = new Ticket("Внуково", "Казань", 7_500, 11, 16);
    Ticket t3 = new Ticket("Казань", "Санкт-Петербург", 8_200, 8, 16);
    Ticket t4 = new Ticket("Санкт-Петербург", "Внуково", 7_500, 15, 23);
    Ticket t5 = new Ticket("Санкт-Петербург", "Внуково", 8_500, 9, 17);
    Ticket t6 = new Ticket("Казань", "Санкт-Петербург", 7_200, 15, 21);
    Ticket t7 = new Ticket("Домодедово", "Нижний Новгород", 6_200, 8, 14);
    Ticket t8 = new Ticket("Внуково", "Казань", 9_000, 16, 22);

    @Test
    public void addTickets() {
        AviaSouls add = new AviaSouls();

        add.add(t1);
        add.add(t2);
        add.add(t3);
        add.add(t4);
        add.add(t5);
        add.add(t6);
        add.add(t7);
        add.add(t8);

        Ticket[] expected = {t1, t2, t3, t4, t5, t6, t7, t8};
        Ticket[] actual = add.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchTickets() {
        AviaSouls search = new AviaSouls();

        search.add(t1);
        search.add(t2);
        search.add(t3);
        search.add(t4);
        search.add(t5);
        search.add(t6);
        search.add(t7);
        search.add(t8);

        Ticket[] expected = {t1, t7};
        Ticket[] actual = search.search("Домодедово", "Нижний Новгород");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchNoneTickets() {
        AviaSouls searchNone = new AviaSouls();

        searchNone.add(t1);
        searchNone.add(t2);
        searchNone.add(t3);
        searchNone.add(t4);
        searchNone.add(t5);
        searchNone.add(t6);
        searchNone.add(t7);
        searchNone.add(t8);

        Ticket[] expected = {};
        Ticket[] actual = searchNone.search("Нижний Новгород", "Казань");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void sortByPrice() {
        AviaSouls sorts = new AviaSouls();

        sorts.add(t1);
        sorts.add(t2);
        sorts.add(t3);
        sorts.add(t4);
        sorts.add(t5);
        sorts.add(t6);
        sorts.add(t7);
        sorts.add(t8);

        Ticket[] tickets = {t1, t2, t3, t4, t5, t6, t7, t8};

        Ticket[] expected = {t1, t7, t6, t2, t4, t3, t5, t8};
        Arrays.sort(tickets);

        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void searchWithComparator() {
        AviaSouls searchComparator = new AviaSouls();

        searchComparator.add(t1);
        searchComparator.add(t2);
        searchComparator.add(t3);
        searchComparator.add(t4);
        searchComparator.add(t5);
        searchComparator.add(t6);
        searchComparator.add(t7);
        searchComparator.add(t8);

        Ticket[] expected = {t6, t3};
        Ticket[] actual = searchComparator.searchAndSortBy("Казань", "Санкт-Петербург");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortAllTicketWithComparator(){
        TicketTimeComparator sorts = new TicketTimeComparator();
        AviaSouls sortTicket = new AviaSouls();

        sortTicket.add(t1);
        sortTicket.add(t2);
        sortTicket.add(t3);
        sortTicket.add(t4);
        sortTicket.add(t5);
        sortTicket.add(t6);
        sortTicket.add(t7);
        sortTicket.add(t8);

        Ticket[] tickets = {t1, t2, t3, t4, t5, t6, t7, t8};

        Ticket[] expected = {t2, t6, t7, t8, t1, t3, t4, t5};
        Arrays.sort(tickets, sorts);

        Assertions.assertArrayEquals(expected, tickets);

    }

}