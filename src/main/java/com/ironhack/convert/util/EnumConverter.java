package com.ironhack.convert.util;

public class EnumConverter {

  public static String toEnum(String inputEnum) {
    return inputEnum.trim().replace(" ", "_").toUpperCase();
  }

  public static String toStatus(String inputStatus) {
    String formattedInputStatus = inputStatus.trim().replace(" ", "_").toUpperCase();
    switch (formattedInputStatus) {
      case "OPEN":
        return "open";
      case "CLOSED_WON":
      case "WON":
        return "won";
      case "CLOSED_LOST":
      case "LOST":
        return "lost";
      default:
        throw new IllegalArgumentException("Invalid status. Please use a valid status [OPEN, CLOSED_WON, WON, CLOSED_LOST, LOST].");
    }
  }

  public static String toCountry(String inputCountry) {
    return inputCountry.trim().toUpperCase();
  }

}
