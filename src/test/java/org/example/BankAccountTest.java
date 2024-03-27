package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankAccountTest {
    BankAccount AccountFabih;
    BankAccount Account2;


    @BeforeEach
    void initMethod(){
//        menginisialisasi Account Bank
        AccountFabih = new BankAccount("089726262",20000);
        Account2 = new BankAccount("123456789",10000);
    }

    @Test
    void getAccountNumber() {
//        Test getter
        assertEquals("089726262",AccountFabih.getAccountNumber());
    }

    @Test
    void getBalance() {
//        test getter
        assertEquals(20000,AccountFabih.getBalance());
    }

    @Test
    void depositNegatif() {
//        jika angka deposit adalah negatif maka akan mengembalikan exception
        assertThrows(IllegalArgumentException.class,()-> AccountFabih.deposit(-90000));
    }

    @Test
    void depositZero(){
//        jika angka deposit 0 dengan angka balance tetap
        AccountFabih.deposit(0);
        assertEquals(20000,AccountFabih.getBalance());
    }

    @Test
    void depositPositif(){
//        jika angka deposit 10.000 dan angka balance 20.000 maka hasilnya adalah 30.000
        AccountFabih.deposit(10000);
        assertEquals(30000,AccountFabih.getBalance());
    }

    @Test
    void withdraw1() {
//        jika penarikan lebih dari saldo maka akan dikenai biaya overdraft yaitu 25 maka saldo adalah 19.975
        AccountFabih.withdraw(40000);
        assertEquals(19975,AccountFabih.getBalance());
    }

    @Test
    void withdraw2(){
//        jika penarikan 10.000 dan saldo adalah 20.000 maka sisanya adalah 10.000
        AccountFabih.withdraw(10000);
        assertEquals(10000,AccountFabih.getBalance());
    }

    @Test
    void withdraw3(){
//        jika penarikan 20.000 dan saldo 20.000 maka sisanya adalah 0
        AccountFabih.withdraw(20000);
        assertEquals(0,AccountFabih.getBalance());
    }

    @Test
    void withdraw4(){
//        jika penarikan minus seharusnya mengembalikan exception atau gagal (akan tetapi disini berhasil maka harus dipertanyakan)
        assertThrows(IllegalArgumentException.class,()->AccountFabih.withdraw(-90000));
    }

    @Test
    void transferFunds1() {
//        jika transfer yang dilakukan lebih dari saldo maka akan mengembalikan exception
        assertThrows(IllegalArgumentException.class,()-> AccountFabih.transferFunds(Account2,50000));
    }

    @Test
    void transferFunds2(){
//        jika nominal transfer dari akun Fabih ke akun 2 adalah 10.000 maka saldo yang ada di akun fabih sekarang harusnya 20.000 dan saldo akun 2 adalah 20.000
        AccountFabih.transferFunds(Account2,10000);
        assertEquals(10000,AccountFabih.getBalance());
        assertEquals(20000,Account2.getBalance());
    }
}