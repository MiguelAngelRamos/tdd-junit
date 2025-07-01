```java
package cl.kibernumacademy.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    
    for(Invoice inv: invoices) {
      if(inv.getId() == id) {
        inv.setStatus(newStatus);
        return true;
      }
  }

    return false;
  }
  

  public boolean deleteInvoice(int id) {
    return invoices.removeIf(inv -> inv.getId() == id);
  }

  public List<Invoice> getAll() {
    return Collections.unmodifiableList(invoices);
  }

}

```