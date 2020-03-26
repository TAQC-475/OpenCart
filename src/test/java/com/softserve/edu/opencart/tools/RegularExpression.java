package com.softserve.edu.opencart.tools;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegularExpression {

    public RegularExpression() {
    }

    public int getNumberFromString(String str) {
        int stringNumber = 0;
        Pattern regularExpressionPattern = Pattern.compile("-?\\d+");
        Matcher matcher = regularExpressionPattern.matcher(str);
        while (matcher.find()) {
            stringNumber = Integer.parseInt(matcher.group());
            break;
        }
        return stringNumber;
    }

    /**
     * gets text from price field, using regex extracts number value from text, and converts it to BigDecimal
     * @param priceFieldText text from some price field at the page
     * @return BigDecimal value from the price field text
     */
    public BigDecimal getBigDecimalFromPriceField(String priceFieldText) {
        String stringValue = "";
        Pattern pattern = Pattern.compile("(\\d{1,3},)*\\d{1,3}\\.\\d{2}");
        Matcher matcher = pattern.matcher(priceFieldText);
        while (matcher.find()) {
            stringValue = priceFieldText.substring(matcher.start(), matcher.end());
            stringValue = stringValue.replace(",", "");
        }
        return new BigDecimal(stringValue);
    }

    /**
     * gets text from sub category names of the left menu, using regex extracts empty space and "-" symbol before the text, and saves it to String
     * @param strInput text from sub category name of the left menu
     * @return strResult text from the sub category name  text
     */
    public static String cutPrefixFromSubCategory(String strInput) {
        String strResult = "";
        Pattern p = Pattern.compile("[a-zA-Z].+[^ -]");
        Matcher m = p.matcher(strInput);
        while (m.find()) {
            strResult = String.valueOf(m.group());
        }
        return strResult;
    }

    /**
     * gets text from category names of the left menu, using regex extracts numbers in brackets after the text, and saves it to String
     * @param strInput text from category name of the left menu
     * @return strResult text from the category name text
     */
    public static String cutSuffixFromCategory(String strInput) {
        String strResult = "";
        Pattern p = Pattern.compile("[a-zA-Z].+[^ (0-9)]");
        Matcher m = p.matcher(strInput);
        while (m.find()) {
            strResult = String.valueOf(m.group());
        }
        return strResult;
    }
}
