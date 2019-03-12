package interviews.progress;

public class DigitToWords {

    public static void main(String[] args) {
        // System.out.println(DIGIT.UNITDIGIT.getWord('1'));

        DigitToWords ex3 = new DigitToWords();
        String s = "74544112400044";
        System.out.println(ex3.getTrillionthWord(s));

    }

    private String getTrillionthWord(String s) {
        if (s != null) {
            if (s.length() < 13) {
                return getBillionthWord(s);
            } else {
                return getTrillionthWord(s.substring(0, s.length() - 12))
                        + DIGIT.TRILLIONTHDIGIT.getWord()
                        + getBillionthWord(s.substring(s.length() - 12));
            }
        } else {
            return "";
        }
    }

    private String getBillionthWord(String s) {
        if (s != null) {
            if (s.length() < 10) {
                return getMillionthWord(s);
            } else {
                return getHundredthWord(s.substring(0, s.length() - 9)
                        .toCharArray())
                        + DIGIT.BILLIONTHDIGIT.getWord()
                        + getMillionthWord(s.substring(s.length() - 9));
            }
        } else {
            return "";
        }
    }

    private String getMillionthWord(String s) {
        if (s != null) {
            if (s.length() < 7) {
                return getLacthWord(s.toCharArray());
            } else {
                return getHundredthWord(s.substring(0, s.length() - 6)
                        .toCharArray())
                        + DIGIT.MILLIONTHDIGIT.getWord()
                        + getLacthWord(s.substring(s.length() - 6)
                        .toCharArray());
            }
        } else {
            return "";
        }
    }

    private String getLacthWord(char[] c) {
        if (c != null) {
            if (c.length < 6) {
                return getThousandthWord(c);
            } else {
                if (c[c.length - 6] != '0') {
                    return getUnitWord(c[c.length - 6])
                            + DIGIT.LACDIGIT.getWord() + getThousandthWord(c);
                } else {
                    return getUnitWord(c[c.length - 6]) + getThousandthWord(c);
                }
            }
        } else {
            return "";
        }

    }

    private String getThousandthWord(char[] c) {
        if (c != null) {
            if (c.length < 4) {
                return getHundredthWord(c);
            } else if (c.length == 4) {
                if (c[c.length - 4] != '0') {
                    return getUnitWord(c[c.length - 4])
                            + DIGIT.THOUSANDTHDIGIT.getWord()
                            + getHundredthWord(c);
                } else {
                    return getUnitWord(c[c.length - 4]) + getHundredthWord(c);
                }
            } else {
                if (c[c.length - 5] == '0' && c[c.length - 4] == '0') {
                    return getTenthWord(new char[]{c[c.length - 5],
                            c[c.length - 4]})
                            + getHundredthWord(c);
                } else {
                    return getTenthWord(new char[]{c[c.length - 5],
                            c[c.length - 4]})
                            + DIGIT.THOUSANDTHDIGIT.getWord()
                            + getHundredthWord(c);
                }
            }
        } else {
            return "";
        }

    }

    private String getHundredthWord(char[] c) {
        if (c != null) {
            if (c.length < 3) {
                return getTenthWord(c);
            } else {
                if (c[c.length - 3] != '0') {
                    return getUnitWord(c[c.length - 3])
                            + DIGIT.HUNDREDTHDIGIT.getWord() + getTenthWord(c);
                } else {
                    return getUnitWord(c[c.length - 3]) + getTenthWord(c);
                }
            }
        } else {
            return "";
        }
    }

    private String getTenthWord(char[] c) {
        if (c != null) {
            if (c.length < 2 || c[c.length - 2] == '0') {
                return getUnitWord(c[c.length - 1]);
            } else {
                if (c[c.length - 2] == '1') {
                    return DIGIT.UNITDIGITWITHTENTHDIGITONE
                            .getWord(c[c.length - 1]);
                } else {
                    return DIGIT.TENTHDIGIT.getWord(c[c.length - 2])
                            + getUnitWord(c[c.length - 1]);
                }

            }
        } else {
            return "";
        }
    }

    private String getUnitWord(char c) {
        if (c == '\u0000') {
            return "";
        } else {
            return DIGIT.UNITDIGIT.getWord(c);
        }
    }

    /**
     * @author anurag
     * <p>
     * Instead of using lacs, use thousand only. Use the American number
     * system. Not the Indian number system. e.g. if the number is
     * 2434562, then the number would be `Two million four hundred
     * thirty four thousand five hundred sixty two`.
     */

    public static enum DIGIT {
        UNITDIGIT {
            public String getWord(char digit) {
                switch (digit) {
                    case '1':
                        return "one ";
                    case '2':
                        return "two ";
                    case '3':
                        return "three ";
                    case '4':
                        return "four ";
                    case '5':
                        return "five ";
                    case '6':
                        return "six ";
                    case '7':
                        return "seven ";
                    case '8':
                        return "eight ";
                    case '9':
                        return "nine ";
                    default:
                        return "";
                }
            }
        },
        UNITDIGITWITHTENTHDIGITONE {
            public String getWord(char digit) {
                switch (digit) {
                    case '0':
                        return "ten ";
                    case '1':
                        return "eleven ";
                    case '2':
                        return "twelve ";
                    case '3':
                        return "thirteen ";
                    case '4':
                        return "fourteen ";
                    case '5':
                        return "fifteen ";
                    case '6':
                        return "sixteen ";
                    case '7':
                        return "seventeen ";
                    case '8':
                        return "eighteen ";
                    case '9':
                        return "nineteen ";
                    default:
                        return "";
                }
            }
        },
        TENTHDIGIT {
            public String getWord(char digit) {
                switch (digit) {
                    case '2':
                        return "twenty ";
                    case '3':
                        return "thirty ";
                    case '4':
                        return "forty ";
                    case '5':
                        return "fifty ";
                    case '6':
                        return "sixty ";
                    case '7':
                        return "seventy ";
                    case '8':
                        return "eighty ";
                    case '9':
                        return "ninety ";
                    default:
                        return "";
                }
            }
        },
        HUNDREDTHDIGIT {
            public String getWord() {
                return "hundred ";
            }
        },
        THOUSANDTHDIGIT {
            public String getWord() {
                return "thousand ";
            }
        },
        LACDIGIT {
            public String getWord() {
                return "lacs ";
            }

        },
        MILLIONTHDIGIT {
            public String getWord() {
                return "million ";
            }

        },
        BILLIONTHDIGIT {
            public String getWord() {
                return "billion ";
            }
        },
        TRILLIONTHDIGIT {
            public String getWord() {
                return "trillion ";
            }
        };

        public String getWord(char i) {
            return "";
        }

        public String getWord() {
            return "";
        }

    }
}
