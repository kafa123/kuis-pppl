package org.example;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DateUtilsTest {
    DateUtils date;

    @BeforeAll
    void init(){
        date = new DateUtils();
    }

    @Test
    void isLeapYear1() {
//        seharusnya tahun 400 adalah tahun kabisat
        assertTrue(date.isLeapYear(400));
    }

    @Test
    void isLeapYear2(){
        //        seharusnya tahun 404 adalah tahun kabisat
        assertTrue(date.isLeapYear(404));
    }

    @Test
    void isLeapYear3(){
        //        seharusnya tahun 120 adalah tahun kabisat
        assertTrue(date.isLeapYear(120));
    }

    @Test
    void isLeapYear4(){
        //        seharusnya tahun 100 adalah tahun kabisat
        assertFalse(date.isLeapYear(100));
    }

    @Test
    void isLeapYear5(){
        //        seharusnya tahun 44 adalah tahun kabisat
        assertTrue(date.isLeapYear(44));
    }
    @Test
    void isLeapYear6() {
        //        seharusnya tahun 402 bukan tahun kabisat
        assertFalse(date.isLeapYear(402));
    }
    @Test
    void isLeapYear7(){
        //        seharusnya tahun 102 bukan tahun kabisat
        assertFalse(date.isLeapYear(102));
    }
    @Test
    void getDaysInMonthJanuari() {
        //        Januari memiliki 31 hari
        assertEquals(31,date.getDaysInMonth(2000,1));
    }

    @Test
    void getDaysInMonthFebruariKabisat() {
        //        Februari Kabisat memiliki 29 hari
        assertEquals(29,date.getDaysInMonth(2000,2));
    }

    @Test
    void getDaysInMonthFebruariNonKabisat() {
        //        Februari non kabisat memiliki 28 hari
        assertEquals(28,date.getDaysInMonth(2001,2));
    }

    @Test
    void getDaysInMonthMaret() {
        //        Maret memiliki 31 hari
        assertEquals(31,date.getDaysInMonth(2000,3));
    }

    @Test
    void getDaysInMonthApril() {
        //        April memiliki 30 hari
        assertEquals(30,date.getDaysInMonth(2000,4));
    }

    @Test
    void getDaysInMonthMei() {
        //        Mei memiliki 31 hari
        assertEquals(31,date.getDaysInMonth(2000,5));
    }

    @Test
    void getDaysInMonthJuni() {
        //        Juni memiliki 30 hari
        assertEquals(30,date.getDaysInMonth(2000,6));
    }

    @Test
    void getDaysInMonthJuli() {
        //        Juli memiliki 31 hari
        assertEquals(31,date.getDaysInMonth(2000,7));
    }

    @Test
    void getDaysInMonthAgustus() {
        //        Agustus memiliki 31 hari
        assertEquals(31,date.getDaysInMonth(2000,8));
    }

    @Test
    void getDaysInMonthSeptember() {
        //        September memiliki 30 hari
        assertEquals(30,date.getDaysInMonth(2000,9));
    }

    @Test
    void getDaysInMonthOktober() {
        //        Oktober memiliki 31 hari
        assertEquals(31,date.getDaysInMonth(2000,10));
    }

    @Test
    void getDaysInMonthNovember() {
        //        November memiliki 30 hari
        assertEquals(30,date.getDaysInMonth(2000,11));
    }
    @Test
    void getDaysInMonthDesember() {
        //        Desember memiliki 31 hari
        assertEquals(31,date.getDaysInMonth(2000,12));
    }

    @Test
    void getDaysInMonthThrow(){
        assertThrows(IllegalArgumentException.class,()-> date.getDaysInMonth(1000,15));
    }

}