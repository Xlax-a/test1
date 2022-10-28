package com.xlax.test;

import com.xlax.Calc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalcTest {
    // 黑盒测试
    @Test
    void testBlack01() {
        Calc.calcPrice(null, null, null, null, "", "");
        String result = Calc.getPrice();
        assertEquals("输入错误或未输入。", result);
    }

    @Test
    void testBlack02() {
        Calc.calcPrice("a6", "b1", "c1", "d1", "999 999", "");
        String result = Calc.getPrice();
        assertEquals("输入错误或未输入。", result);
    }

    @Test
    void testBlack03() {
        Calc.calcPrice("a6", "b1", "c1", "d1", "100", "");
        String result = Calc.getPrice();
        assertEquals("输入错误或未输入。", result);
    }

    @Test
    void testBlack04() {
        Calc.calcPrice("a6", "b1", "c1", "d1", "!", "");
        String result = Calc.getPrice();
        assertEquals("输入错误或未输入。", result);
    }

    @Test
    void testBlack05() {
        Calc.calcPrice("a6", "b1", "c1", "d1", "", "999 999");
        String result = Calc.getPrice();
        assertEquals("输入错误或未输入。", result);
    }

    @Test
    void testBlack06() {
        Calc.calcPrice("a6", "b1", "c1", "d1", "", "1");
        String result = Calc.getPrice();
        assertEquals("输入错误或未输入。", result);
    }

    @Test
    void testBlack07() {
        Calc.calcPrice("a6", "b1", "c1", "d1", "", "!");
        String result = Calc.getPrice();
        assertEquals("输入错误或未输入。", result);
    }

    @Test
    void testBlack08() {
        Calc.calcPrice("a6", "b1", "c1", "d1", "", "");
        String result = Calc.getPrice();
        assertEquals("0.0元", result);
    }

    @Test
    void testBlack09() {
        Calc.calcPrice("a6", "b1", "c1", "d1", "100 30", "1 10");
        String result = Calc.getPrice();
        assertEquals("980.0元", result);
    }

    // 白盒测试
    @Test
    void testWhite01() {
        Calc.price = 0;
        Calc.right = true;
        boolean out = Calc.calcOverCPrice(1400, 2000, 3000, 1);
        assertTrue(out);
        assertEquals(1400, Calc.price);
        assertTrue(Calc.right);
    }

    @Test
    void testWhite02() {
        Calc.price = 0;
        Calc.right = true;
        boolean out = Calc.calcOverCPrice(1400, 2000, 3000, 2);
        assertTrue(out);
        assertEquals(2000, Calc.price);
        assertTrue(Calc.right);
    }

    @Test
    void testWhite03() {
        Calc.price = 0;
        Calc.right = true;
        boolean out = Calc.calcOverCPrice(1400, 2000, 3000, 3);
        assertTrue(out);
        assertEquals(3000, Calc.price);
        assertTrue(Calc.right);
    }

    @Test
    void testWhite04() {
        Calc.price = 0;
        Calc.right = true;
        boolean out = Calc.calcOverWSPrice(25, 100, 380, 980, 980, 1400);
        assertEquals(380, Calc.price);
        assertTrue(Calc.right);
        assertTrue(out);
    }

    @Test
    void testWhite05() {
        Calc.price = 0;
        Calc.right = true;
        boolean out = Calc.calcOverWSPrice(30, 100, 380, 980, 980, 1400);
        assertEquals(980, Calc.price);
        assertTrue(Calc.right);
        assertTrue(out);
    }

    @Test
    void testWhite06() {
        Calc.price = 0;
        Calc.right = true;
        boolean out = Calc.calcOverWSPrice(20, 200, 380, 980, 980, 1400);
        assertEquals(980, Calc.price);
        assertTrue(Calc.right);
        assertTrue(out);
    }

    @Test
    void testWhite07() {
        Calc.price = 0;
        Calc.right = true;
        boolean out = Calc.calcOverWSPrice(25, 200, 380, 980, 980, 1400);
        assertEquals(1400, Calc.price);
        assertTrue(Calc.right);
        assertTrue(out);
    }

    @Test
    void testWhite08() {
        Calc.price = 0;
        Calc.right = true;
        boolean out = Calc.calcSpecialPrice(20, 2, 23, 32, 45, 2600, 3900, 5200);
        assertEquals(2600, Calc.price);
        assertTrue(Calc.right);
        assertTrue(out);
    }

    @Test
    void testWhite09() {
        Calc.price = 0;
        Calc.right = true;
        boolean out = Calc.calcSpecialPrice(30, 2, 23, 32, 45, 2600, 3900, 5200);
        assertEquals(3900, Calc.price);
        assertTrue(Calc.right);
        assertTrue(out);
    }

    @Test
    void testWhite10() {
        Calc.price = 0;
        Calc.right = true;
        boolean out = Calc.calcSpecialPrice(40, 2, 23, 32, 45, 2600, 3900, 5200);
        assertEquals(5200, Calc.price);
        assertTrue(Calc.right);
        assertTrue(out);
    }
}