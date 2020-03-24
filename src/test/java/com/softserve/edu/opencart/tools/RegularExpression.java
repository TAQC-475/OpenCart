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
    public BigDecimal getBigDecimalFromTheShoppingCartPriceField(String priceFieldText) {
        String stringValue = "";
        Pattern pattern = Pattern.compile("(\\d{1,3},)*\\d{1,3}\\.\\d{2}");
        Matcher matcher = pattern.matcher(priceFieldText);
        while (matcher.find()) {
            stringValue = priceFieldText.substring(matcher.start(), matcher.end());
            stringValue = stringValue.replace(",", "");
        }
        return new BigDecimal(stringValue);
    }

    private String getClearCategoryName(String strInput) {
        String strResult = "";
        Pattern p = Pattern.compile("[A-Z].+[^ (0-9)]");
        Matcher m = p.matcher(strInput);
        while (m.find()) {
            strResult = String.valueOf(m.group());
        }

        return strResult;
    }
}
