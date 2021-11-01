package com.ironhack.convert.util;

public class EnumConverter {

  public static String toEnum(String inputEnum) {
    return inputEnum.trim().replace(" ", "_").toUpperCase();
  }

  public static String toStatus(String inputStatus) {
    return switch (inputStatus.trim().replace(" ", "_").toUpperCase()) {
      case "OPEN" -> "open";
      case "CLOSED_WON", "WON" -> "won";
      case "CLOSED_LOST", "LOST" -> "lost";
      default -> throw new IllegalArgumentException("Invalid status. Please use a valid status [OPEN, CLOSED_WON, CLOSED_LOST].");
    };
  }


  public static String toCountry(String inputCountry) {
    return inputCountry.trim().toUpperCase();
  }

}
