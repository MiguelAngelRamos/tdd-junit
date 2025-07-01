package cl.kibernumacademy.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import cl.kibernumacademy.model.Invoice;

public class InvoiceManager {

  private final List<Invoice> invoices = new ArrayList<>();

  private int nextId=1;

  public Invoice createInvoice(String client, double amount) {
    Invoice inv = new Invoice(nextId++, client, amount);
    invoices.add(inv);
    return inv;
  }

  public boolean updateStatus(int id, String newStatus) {
  return findById(id).map(inv -> {inv.setStatus(newStatus); return true;}).orElse(false);
  }

  private Optional<Invoice> findById(int id) {
    // que me permite identificar la factura por id
    return invoices.stream().filter(i -> i.getId() == id).findFirst();
  }

  public boolean deleteInvoice(int id) {
    return invoices.removeIf(inv -> inv.getId() == id);
  }

  public List<Invoice> getAll() {
    return Collections.unmodifiableList(invoices);
  }

}
