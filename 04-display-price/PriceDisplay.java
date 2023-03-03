class PriceDisplay {
  public static void main(String[] args) {
    String item = "coffee machine";
    Double price = 15.99;

    System.out.printf("The price for the item %s ", item);
    System.out.printf("is £%.2f \n", price);
  }
}
