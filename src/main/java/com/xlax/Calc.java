package com.xlax;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Calc {
    static double price = 0;      // 行李总价
    static boolean right = false;   // 输入是否正确

    // 计算特殊行李价
    static boolean calcSpecialPrice(double w, double w1, double w2, double w3, double w4, double p1, double p2, double p3) {
        if (w >= w1 && w <= w2) {
            price += p1;
        }
        else if (w > w2 && w <= w3) {
            price += p2;
        }
        else if (w > w3 && w <= w4) {
            price += p3;
        }
        else {
            return false;
        }
        return true;
    }

    // 计算超重价或超尺寸价
    static boolean calcOverWSPrice(double w, double s, double p1, double p2, double p3, double p4) {
        if (s >= 60 && s <= 158 && w > 23 && w <= 28) {
            price += p1;
        }
        else if (s >= 60 && s <= 158 && w > 28 && w <= 32) {
            price += p2;
        }
        else if (s > 158 && s <= 203 && w >= 2 && w <= 23) {
            price += p3;
        }
        else if (s > 158 && s <= 203 && w > 23 && w <= 32) {
            price += p4;
        }
        else {
            return false;
        }
        return true;
    }

    // 计算超数量价
    static boolean calcOverCPrice(double p1, double p2, double p3, int c) {
        if (c == 1) {
            price += p1;
        }
        else if (c == 2) {
            price += p2;
        }
        else if (c >= 3) {
            price += p3;
        }
        else {
            return false;
        }
        return true;
    }

    // 计算总价
    public static void calcPrice(String a, String b, String c, String d, String normal, String special) {
        // 判断是否有输入
        if (a != null && b != null && c != null && d != null) {
            // 拆分字符串
            String[] n1 = normal.split("\\s+");
            String[] n2 = special.split("\\s+");
            // 判断字符串长度是否为偶数，接受空字符串
            boolean y1 = false;     // 是否有常规行李
            boolean y2 = false;     // 是否有特殊行李
            if (n1.length % 2 == 0) {
                y1 = true;
            }
            else {
                if (!Objects.equals(n1[0], "")) {
                    right = false;
                    return;
                }
            }
            if (n2.length % 2 == 0) {
                y2 = true;
            }
            else {
                if (!Objects.equals(n2[0], "")) {
                    right = false;
                    return;
                }
            }
            // 将字符串转化为数字，只接受正数
            double[] t1 = new double[n1.length];
            double[] t2 = new double[n2.length];
            if (y1) {
                for (int i = 0; i < n1.length; i++) {
                    if (StringUtils.isNumeric(n1[i])) {
                        t1[i] = Double.parseDouble(n1[i]);
                    } else {
                        right = false;
                        return;
                    }
                }
            }
            if (y2) {
                for (int i = 0; i < n2.length; i++) {
                    if (StringUtils.isNumeric(n2[i])) {
                        t2[i] = Double.parseDouble(n2[i]);
                    } else {
                        right = false;
                        return;
                    }
                }
            }
            // 数据无误，依据用户身份设立计算条件
            double freeW = 0;   // 行李非超重重量
            double freeC = 0;   // 行李免费数量
            switch (a) {
                case "a1":
                case "a2":
                case "a3":
                    freeW = 32;
                    freeC = 2;
                    break;
                case "a4":
                case "a5":
                    freeW = 23;
                    freeC = 2;
                    break;
                case "a6":
                    // 经济舱特殊对待
                    if (Objects.equals(d, "d1") || Objects.equals(d, "d2")) {
                        freeW = 23;
                        freeC = 2;
                    } else if (Objects.equals(d, "d3") || Objects.equals(d, "d4") || Objects.equals(d, "d5")) {
                        freeW = 23;
                        freeC = 1;
                    } else {
                        right = false;
                        return;
                    }
                    break;
                default:
                    right = false;
                    return;
            }
            // 计算行李总价
            price = 0;      // 行李总价
            int outcount = 0;   // 超出件数
            // 计算常规行李总价
            if (y1) {
                for (int i = 0; i < t1.length; i += 2) {
                    // 先计算额外行李收费
                    if (freeC <= 0) {
                        outcount++;
                        boolean error = false;
                        switch (d) {
                            case "d1":
                                error = !calcOverCPrice(1400, 2000, 3000, outcount);
                                break;
                            case "d2":
                                error = !calcOverCPrice(1100, 1100, 1590, outcount);
                                break;
                            case "d3":
                                error = !calcOverCPrice(1170, 1170, 1590, outcount);
                                break;
                            case "d4":
                                error = !calcOverCPrice(1380, 1380, 1590, outcount);
                                break;
                            case "d5":
                                error = !calcOverCPrice(830, 1100, 1590, outcount);
                                break;
                            default:
                                right = false;
                                return;
                        }
                        if (error) {
                            right = false;
                            return;
                        }
                    } else {
                        freeC--;
                    }
                    // 再计算超重收费
                    boolean over = false;
                    if (t1[i] > 158) {
                        over = true;
                    } else if (t1[i + 1] > freeW) {
                        over = true;
                    }
                    if (over) {
                        switch (d) {
                            case "d1":
                                over = !calcOverWSPrice(t1[i + 1], t1[i], 380, 980, 980, 1400);
                                break;
                            case "d2":
                                over = !calcOverWSPrice(t1[i + 1], t1[i], 280, 690, 690, 1100);
                                break;
                            case "d3":
                                over = !calcOverWSPrice(t1[i + 1], t1[i], 520, 520, 520, 520);
                                break;
                            case "d4":
                                over = !calcOverWSPrice(t1[i + 1], t1[i], 690, 1040, 1040, 2050);
                                break;
                            case "d5":
                                over = !calcOverWSPrice(t1[i + 1], t1[i], 210, 520, 520, 830);
                                break;
                            default:
                                right = false;
                                return;
                        }
                        if (over) {
                            right = false;
                            return;
                        }
                    }
                }
            }
            // 计算特殊行李总价
            if (y2) {
                for (int i = 0; i < t2.length; i += 2) {
                    boolean error = false;
                    switch ((int) t2[i]) {
                        case 1:
                            break;
                        case 2:
                            // 数量
                            if (freeC > 0) {
                                freeC--;
                            }
                            else {
                                outcount++;
                                switch (d) {
                                    case "d1":
                                        error = !calcOverCPrice(1400, 2000, 3000, outcount);
                                        break;
                                    case "d2":
                                        error = !calcOverCPrice(1100, 1100, 1590, outcount);
                                        break;
                                    case "d3":
                                        error = !calcOverCPrice(1170, 1170, 1590, outcount);
                                        break;
                                    case "d4":
                                        error = !calcOverCPrice(1380, 1380, 1590, outcount);
                                        break;
                                    case "d5":
                                        error = !calcOverCPrice(830, 1100, 1590, outcount);
                                        break;
                                    default:
                                        right = false;
                                        return;
                                }
                                if (error) {
                                    right = false;
                                    return;
                                }
                            }
                            // 重量
                            boolean over = false;
                            if (t2[i + 1] > freeW) {
                                over = true;
                            }
                            if (over) {
                                switch (d) {
                                    case "d1":
                                        over = !calcOverWSPrice(t2[i + 1], 100, 380, 980, 980, 1400);
                                        break;
                                    case "d2":
                                        over = !calcOverWSPrice(t2[i + 1], 100, 280, 690, 690, 1100);
                                        break;
                                    case "d3":
                                        over = !calcOverWSPrice(t2[i + 1], 100, 520, 520, 520, 520);
                                        break;
                                    case "d4":
                                        over = !calcOverWSPrice(t2[i + 1], 100, 690, 1040, 1040, 2050);
                                        break;
                                    case "d5":
                                        over = !calcOverWSPrice(t2[i + 1], 100, 210, 520, 520, 830);
                                        break;
                                    default:
                                        right = false;
                                        return;
                                }
                                if (over) {
                                    right = false;
                                    return;
                                }
                            }
                            break;
                        case 3:
                            error = !calcSpecialPrice(t2[i + 1], 2, 23, 32, 45, 2600, 3900, 5200);
                            break;
                        case 4:
                            error = !calcSpecialPrice(t2[i + 1], 2, 23, 32, 45, 1300, 2600, 3900);
                            break;
                        case 5:
                            error = !calcSpecialPrice(t2[i + 1], 2, 23, 32, 32, 490, 3900, 3900);
                            break;
                        case 6:
                            error = !calcSpecialPrice(t2[i + 1], 2, 23, 32, 32, 1300, 2600, 2600);
                            break;
                        case 7:
                            error = !calcSpecialPrice(t2[i + 1], 2, 5, 5, 5, 1300, 1300, 1300);
                            break;
                        case 8:
                            error = !calcSpecialPrice(t2[i + 1], 2, 8, 23, 32, 3900, 5200, 7800);
                            break;
                        default:
                            right = false;
                            return;
                    }
                    if (error) {
                        right = false;
                        return;
                    }
                }
            }
            right = true;
        }
        else {
            right = false;
        }
    }

    // 获取总价
    public static String getPrice() {
        if (right) {
            return price + "元";
        }
        else {
            return "输入错误或未输入。";
        }
    }
}
