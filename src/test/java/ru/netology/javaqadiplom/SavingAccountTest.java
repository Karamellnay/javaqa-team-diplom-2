package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {
    /**
     * test add;
     * initialBalance + amount < MaxBalance;
     * Баланс после пополнения меньше максимального
     */
    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    /**
     * test add;
     * initialBalance + amount = MaxBalance;
     * Баланс после пополнения равен максимальному
     */
    @Test
    public void shouldAddEqualsMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        Assertions.assertEquals(2_000 + 8_000, account.getBalance());
    }

    /**
     * test add;
     * false if amount = 0;
     * Пополнение не может быть равным нулю
     */
    @Test
    public void shouldNotAddZeroToBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean actual = account.add(0);

        Assertions.assertFalse(actual);
        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(1_000, account.getMinBalance());
        Assertions.assertEquals(10_000, account.getMaxBalance());
    }

    /**
     * test add;
     * false if amount < 0;
     * Пополнение не может быть отрицательным
     */
    @Test
    public void shouldNotAddNegativeValueToBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean actual = account.add(-1000);

        Assertions.assertFalse(actual);
        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(1_000, account.getMinBalance());
        Assertions.assertEquals(10_000, account.getMaxBalance());
    }

    /**
     * test add;
     * false if initialBalance + amount > MaxBalance;
     * Баланс после пополнения не должен быть больше максимального
     */
    @Test
    public void shouldNotAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean actual = account.add(9000);

        Assertions.assertFalse(actual);
        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(1_000, account.getMinBalance());
        Assertions.assertEquals(10_000, account.getMaxBalance());
    }

    /**
     * test pay;
     * initialBalance - amount > MinBalance;
     * Баланс после оплаты больше минимального
     */
    @Test
    public void shouldPayLessThanMinBalance() {
        SavingAccount account = new SavingAccount(
                7_000,
                1_000,
                10_000,
                5
        );

        account.pay(3_000);

        Assertions.assertEquals(7_000 - 3_000, account.getBalance());
    }

    /**
     * test pay;
     * initialBalance - amount = MinBalance;
     * Баланс после оплаты равен минимальному
     */
    @Test
    public void shouldPayEqualsMinBalance() {
        SavingAccount account = new SavingAccount(
                7_000,
                1_000,
                10_000,
                5
        );

        account.pay(7_000);

        Assertions.assertEquals(7_000 - 7_000, account.getBalance());
    }

    /**
     * test pay;
     * false if amount = 0;
     * Оплата не может быть равной нулю
     */
    @Test
    public void shouldNotPayZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean actual = account.pay(0);

        Assertions.assertFalse(actual);
        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(1_000, account.getMinBalance());
        Assertions.assertEquals(10_000, account.getMaxBalance());
    }

    /**
     * test pay;
     * false if amount < 0;
     * Оплата не может быть отрицательной
     */
    @Test
    public void shouldNotPayNegativeAmount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean actual = account.pay(-1000);

        Assertions.assertFalse(actual);
        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(1_000, account.getMinBalance());
        Assertions.assertEquals(10_000, account.getMaxBalance());
    }

    /**
     * test pay;
     * false if initialBalance - amount < MinBalance;
     * Баланс после оплаты не может быть меньше минимального
     */
    @Test
    public void shouldNotPayMoreThanMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean actual = account.pay(3_000);

        Assertions.assertFalse(actual);
        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(1_000, account.getMinBalance());
        Assertions.assertEquals(10_000, account.getMaxBalance());
    }


    /**
     * test exception;
     * rate < 0;
     * отрицательная ставка
     */
    @Test
    public void testIllegalArgumentExceptionNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(5_000, 1_000, 10_000, -5));
    }

    /**
     * test exception;
     * minBalance < 0;
     * отрицательный минимальный баланс
     */
    @Test
    public void testIllegalArgumentExceptionNegativeMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(5_000, -1_000, 10_000, 5));
    }

    /**
     * test exception;
     * initialBalance < minBalance;
     * баланс меньше минимального
     */
    @Test
    public void testIllegalArgumentExceptionInitialBalanceLessThanMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(500, 1_000, 10_000, 5));
    }

    /**
     * test exception;
     * initialBalance > maxBalance;
     * баланс больше максимального
     */
    @Test
    public void testIllegalArgumentExceptionInitialBalanceMoreThanMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(11_000, 1_000, 10_000, 5));
    }

    /**
     * test exception;
     * minBalance > maxBalance;
     * минимальный баланс больше максимального
     */
    @Test
    public void testIllegalArgumentExceptionMinBalanceMoreThanMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(5_000, 11_000, 10_000, 5));
    }

    /**
     * test yearChange;
     * расчет суммы процентов;
     */
    @Test
    public void shouldCalcYearChange() {
        SavingAccount account = new SavingAccount(
                200,
                200,
                5_000,
                15
        );

        int actual = account.yearChange();
        int expected = 30;

        Assertions.assertEquals(expected, actual);
    }

    /**
     * test yearChange;
     * initialBalance = 0;
     * расчет суммы процентов при нулевом балансе;
     */
    @Test
    public void shouldCalcZeroYearChange() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                5_000,
                15
        );

        int actual = account.yearChange();
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetMinBalance() {
        SavingAccount savingAccount = new SavingAccount(
                200,
                200,
                5_000,
                15
        );

        int actual = savingAccount.getMinBalance();
        int expected = 200;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetMaxBalance() {
        SavingAccount savingAccount = new SavingAccount(
                200,
                200,
                5_000,
                15
        );

        int actual = savingAccount.getMaxBalance();
        int expected = 5_000;

        Assertions.assertEquals(expected, actual);
    }

}