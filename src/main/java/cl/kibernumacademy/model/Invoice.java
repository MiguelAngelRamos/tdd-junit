package cl.kibernumacademy.model;

public class Invoice {
  
  private final int id;
  private final String client;
  private final double amount;
  private String status;

  public Invoice(int id, String client, double amount) {
    this.id = id;
    this.client = client;
    this.amount = amount;
    this.status = "PENDIENTE";
  }

  public int getId() {
    return id;
  }

  public String getClient() {
    return client;
  }

  public double getAmount() {
    return amount;
  }
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
