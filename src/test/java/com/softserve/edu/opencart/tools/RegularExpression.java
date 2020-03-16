package com.softserve.edu.opencart.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegularExpression {

  public RegularExpression() {
  }

  public int getNumberFromWishList(String str){
    int listNumber = 0;
    Pattern regularExpressionPattern = Pattern.compile("-?\\d+");
    Matcher matcher = regularExpressionPattern.matcher(str);
    while (matcher.find()){
      listNumber = Integer.parseInt(matcher.group());
    break;}
    return listNumber;
  }
}
