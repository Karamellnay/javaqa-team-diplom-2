package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }
    @Test
    public void shouldAddToPositiveBalanceAmount() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }
    @Test
    public void ShouldAddToAmount() {
        CreditAccount account = new CreditAccount(
                -100,
                5_000,
                15
        );
        account.add(300);

        Assertions.assertEquals(200, account.getBalance());
    }


    @Test
    public void doNotShouldAddToNegativeAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        boolean actual = account.add(-1);
        Assertions.assertFalse(actual);

        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void doNotShouldAddToNegativeAmountWithBalance() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );
        boolean actual = account.add(-1);
        Assertions.assertFalse(actual);

        Assertions.assertEquals(100, account.getBalance());
    }

    @Test
    public void doNotShouldAddToAmount() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );
        boolean actual = account.add(0);
        Assertions.assertFalse(actual);

        Assertions.assertEquals(100, account.getBalance());
    }
    @Test
    public void doNotShouldAddToZeroAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        boolean actual = account.add(0);
        Assertions.assertFalse(actual);

        Assertions.assertEquals(0, account.getBalance());
    }






    @Test
    public void ShouldAddToAmountBalance() {
        CreditAccount account = new CreditAccount(
                10_000,
                5_000,
                15
        );
        account.pay(3_000);

        Assertions.assertEquals(7_000, account.getBalance());
    }
    @Test
    public void shouldAddToPositiveAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(2_000);

        Assertions.assertEquals(-2_000, account.getBalance());
    }
    @Test
    public void shouldAddToNegativeAmountZero() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );
        boolean actual = account.pay(0);
        Assertions.assertFalse(actual);

        Assertions.assertEquals(100, account.getBalance());
    }
    @Test
    public void doNotShouldAddToNegativeAmountZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        boolean actual = account.pay(-1);
        Assertions.assertFalse(actual);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void doNotShouldAddToAmountMoreLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        boolean actual = account.pay(5_001);
        Assertions.assertFalse(actual);
        Assertions.assertEquals(0, account.getBalance());
    }






    @Test
    public void doNotShouldAddChange() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );
        int actual = account.yearChange();
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddChangeZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        int actual = account.yearChange();
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddChangeNegative() {
        CreditAccount account = new CreditAccount(
                -100,
                5_000,
                15
        );
        int actual = account.yearChange();
        int expected = -15;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldAddChangeNegativeLimit() {
        CreditAccount account = new CreditAccount(
                -5_000,
                5_000,
                15
        );
        int actual = account.yearChange();
        int expected = -750;

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void expextionNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(0,-100, 15); }
                );
    }
    @Test
    public void expextionNegativeBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-100,5_000, 15); }
        );
    }
    @Test
    public void expextionNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(0,5_000, -15); }
        );
    }
}
