package test.AddressData;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import address.data.AddressBook;
import address.data.AddressEntry;

import java.util.ArrayList;

/**
 * Clase de pruebas unitarias para la clase AddressBook.
 */
public class AddressBookTest {

    private AddressBook addressBook;
    private AddressEntry entry1;
    private AddressEntry entry2;

    @BeforeEach
    public void setUp() {
        addressBook = AddressBook.getInstance();
        addressBook.deleteAddressEntry("Garcia"); // Limpiar las entradas existentes para garantizar el aislamiento entre pruebas

        entry1 = new AddressEntry("Carlos", "Garcia", "126 Ochoa", "Coatzacoalcos", "Veracruz", 96550, "Manu@example.com", "921-131-1341");
        entry2 = new AddressEntry("Manuel", "Cruz", "128 Ochoa", "Villahermosa", "Tabasco", 86244, "Carlos@example.com", "921-356-5678");

        addressBook.addAddressEntry(entry1);
        addressBook.addAddressEntry(entry2);
    }

    /**
     * Prueba para getInstance(), verifica si solo hay una instancia de AddressBook debido al patrón Singleton.
     */
    @Test
    public void testGetInstance() {
        AddressBook anotherInstance = AddressBook.getInstance();
        assertSame(addressBook, anotherInstance, "Ambas instancias deberían ser iguales debido al patrón Singleton.");
    }

    /**
     * Prueba para addAddressEntry(), comprueba la adición de una nueva entrada de dirección y su correcta recuperación.
     */
    @Test
    public void testAddAddressEntry() throws Exception {
        AddressEntry newEntry = new AddressEntry("Fatima", "Lopez", "26 Ballena", "Coatzacoalcos", "Veracruz", 96536, "Fatima@example.com", "921-123-1234");
        addressBook.addAddressEntry(newEntry);
        ArrayList<AddressEntry> foundEntries = addressBook.findAddressEntry("Lopez", true);
        assertEquals(1, foundEntries.size(), "Debería haber una entrada con el apellido 'Lopez'.");
        assertEquals(newEntry, foundEntries.get(0), "La entrada encontrada debería coincidir con la nueva entrada agregada.");
    }

    /**
     * Prueba para deleteAddressEntry(), verifica la eliminación de una entrada de dirección y que no pueda encontrarse después de eliminarse.
     */
    @Test
    public void testDeleteAddressEntry() throws Exception {
        addressBook.deleteAddressEntry("Garcia");
        ArrayList<AddressEntry> foundEntries = addressBook.findAddressEntry("Garcia", false);
        assertTrue(foundEntries.isEmpty(), "No debería haber entradas con el apellido 'Garcia' después de la eliminación.");
    }

    /**
     * Prueba para findAddressEntry(), verifica la búsqueda de una entrada de dirección con un apellido específico y su correcta recuperación.
     */
    @Test
    public void testFindAddressEntry() throws Exception {
        ArrayList<AddressEntry> foundEntries = addressBook.findAddressEntry("Garcia", true);
        assertEquals(1, foundEntries.size(), "Debería haber una entrada con el apellido 'Garcia'.");
        assertEquals(entry1, foundEntries.get(0), "La entrada encontrada debería coincidir con la entrada existente con el apellido 'Garcia'.");
    }

    /**
     * Prueba para findAddressEntry() con búsqueda no estricta, verifica la búsqueda de una entrada de dirección con un apellido parcial y su correcta recuperación.
     */
    @Test
    public void testFindAddressEntryNonStrict() throws Exception {
        ArrayList<AddressEntry> foundEntries = addressBook.findAddressEntry("Cruz", false);
        boolean found = false;
        for (AddressEntry entry : foundEntries) {
            if (entry.getLastName().equals("Cruz")) {
                assertEquals(entry2, entry, "La entrada encontrada debería coincidir con la entrada existente con el apellido 'Cruz'.");
                found = true;
                break;
            }
        }
        assertTrue(found, "Debería haber una entrada con el apellido que contenga 'Cruz'.");
    }

    /**
     * Prueba para findAddressEntry() cuando no se encuentra la entrada, verifica que se lance una excepción.
     */
    @Test
    public void testFindAddressEntryStrictNotFound() {
        Exception exception = assertThrows(Exception.class, () -> {
            addressBook.findAddressEntry("Nonexistent", true);
        });
        assertEquals("El apellido no existe en la lista de contactos", exception.getMessage(), "Debería lanzar una excepción con el mensaje 'El apellido no existe en la lista de contactos'.");
    }

    /**
     * Prueba para showContactsList(), verifica la visualización de la lista de contactos.
     * Esta prueba verifica la salida manualmente ya que no es posible verificar la salida de la consola con JUnit.
     */
    @Test
    public void testShowContactsList() {
        // Esta prueba verificará la salida manualmente.
        addressBook.showContactsList();
    }

    /**
     * Prueba para showContactsFound(), verifica la visualización de los contactos encontrados.
     * Esta prueba verificará la salida manualmente ya que no es posible verificar la salida de la consola con JUnit.
     */
    @Test
    public void testShowContactsFound() {
        ArrayList<AddressEntry> foundEntries = new ArrayList<>();
        foundEntries.add(entry1);
        addressBook.showContactsFound(foundEntries);
        // Esta prueba verificará la salida manualmente.
    }
}