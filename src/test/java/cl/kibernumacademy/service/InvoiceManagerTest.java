package cl.kibernumacademy.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceManagerTest {
  private InvoiceManager manager;

  @BeforeEach
  void setUp() {
    manager = new InvoiceManager();
  }

  @Test
  void deberiaCrearUnaFactura() {
    Invoice inv  = manager.createInvoice("TECHNOVA", 1500.0);
    assertThat(inv.getId()).isEqualTo(1);
    assertThat(manager.getAll()).hasSize(1);
  }

  @Test
  void deberiaActualizarEstado() {
    Invoice inv  = manager.createInvoice("TECHNOVA", 1500.0);
    boolean updated = manager.updateStatus(inv.getId(), "PAGADA");
    assertThat(updated).isTrue();
    assertThat(inv.getStatus()).isEqualTo("PAGADA");
  }

  @Test
  void deberiaEliminarFactura() {
    Invoice inv  = manager.createInvoice("TECHNOVA", 1500.0);
    boolean removed = manager.deleteInvoice(inv.getId());
    assertThat(removed).isTrue();
    assertThat(manager.getAll()).isEmpty();
  }

  


}
