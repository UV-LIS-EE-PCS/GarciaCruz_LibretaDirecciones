package test.AddressData;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import address.data.AddressEntry;

/**
 * Clase de pruebas unitarias para la clase AddressEntry.
 */
public class AddressEntryTest {

    private AddressEntry addressEntry;

    @BeforeEach
    public void setUp() {
        addressEntry = new AddressEntry("Carlos", "Garcia", "126 Ochoa", "Coatzacoalcos", "Veracruz", 96550, "Manu@example.com", "921-131-1341");
    }

    /**
     * Prueba para getName(), verifica si el nombre es correcto.
     */
    @Test
    public void testGetName() {
        assertEquals("Carlos", addressEntry.getName(), "El nombre debería ser 'Carlos'.");
    }

    /**
     * Prueba para setName(), verifica si el nombre se establece correctamente.
     */
    @Test
    public void testSetName() {
        addressEntry.setName("Manuel");
        assertEquals("Manuel", addressEntry.getName(), "El nombre debería ser 'Manuel'.");
    }

    /**
     * Prueba para getLastName(), verifica si el apellido es correcto.
     */
    @Test
    public void testGetLastName() {
        assertEquals("Garcia", addressEntry.getLastName(), "El apellido debería ser 'Garcia'.");
    }

    /**
     * Prueba para setLastName(), verifica si el apellido se establece correctamente.
     */
    @Test
    public void testSetLastName() {
        addressEntry.setLastName("Cruz");
        assertEquals("Cruz", addressEntry.getLastName(), "El apellido debería ser 'Cruz'.");
    }

    /**
     * Prueba para getStreet(), verifica si la calle es correcta.
     */
    @Test
    public void testGetStreet() {
        assertEquals("126 Ochoa", addressEntry.getStreet(), "La calle debería ser '126 Ochoa'.");
    }

    /**
     * Prueba para setStreet(), verifica si la calle se establece correctamente.
     */
    @Test
    public void testSetStreet() {
        addressEntry.setStreet("128 Ochoa");
        assertEquals("128 Ochoa", addressEntry.getStreet(), "La calle debería ser '128 Ochoa'.");
    }

    /**
     * Prueba para getCity(), verifica si la ciudad es correcta.
     */
    @Test
    public void testGetCity() {
        assertEquals("Coatzacoalcos", addressEntry.getCity(), "La ciudad debería ser 'Coatzacoalcos'.");
    }

    /**
     * Prueba para setCity(), verifica si la ciudad se establece correctamente.
     */
    @Test
    public void testSetCity() {
        addressEntry.setCity("Villahermosa");
        assertEquals("Villahermosa", addressEntry.getCity(), "La ciudad debería ser 'Villahermosa'.");
    }

    /**
     * Prueba para getState(), verifica si el estado es correcto.
     */
    @Test
    public void testGetState() {
        assertEquals("Veracruz", addressEntry.getState(), "El estado debería ser 'Veracruz'.");
    }

    /**
     * Prueba para setState(), verifica si el estado se establece correctamente.
     */
    @Test
    public void testSetState() {
        addressEntry.setState("Tabasco");
        assertEquals("Tabasco", addressEntry.getState(), "El estado debería ser 'Tabasco'.");
    }

    /**
     * Prueba para getPostalCode(), verifica si el código postal es correcto.
     */
    @Test
    public void testGetPostalCode() {
        assertEquals(96550, addressEntry.getPostalCode(), "El código postal debería ser 96550.");
    }

    /**
     * Prueba para setPostalCode(), verifica si el código postal se establece correctamente.
     */
    @Test
    public void testSetPostalCode() {
        addressEntry.setPostalCode(86244);
        assertEquals(86244, addressEntry.getPostalCode(), "El código postal debería ser 86244.");
    }

    /**
     * Prueba para getEmail(), verifica si el correo electrónico es correcto.
     */
    @Test
    public void testGetEmail() {
        assertEquals("Manu@example.com", addressEntry.getEmail(), "El correo electrónico debería ser 'Manu@example.com'.");
    }

    /**
     * Prueba para setEmail(), verifica si el correo electrónico se establece correctamente.
     */
    @Test
    public void testSetEmail() {
        addressEntry.setEmail("Carlos@example.com");
        assertEquals("Carlos@example.com", addressEntry.getEmail(), "El correo electrónico debería ser 'Carlos@example.com'.");
    }

    /**
     * Prueba para getTelephone(), verifica si el teléfono es correcto.
     */
    @Test
    public void testGetTelephone() {
        assertEquals("921-131-1341", addressEntry.getTelephone(), "El teléfono debería ser '921-131-1341'.");
    }

    /**
     * Prueba para setTelephone(), verifica si el teléfono se establece correctamente.
     */
    @Test
    public void testSetTelephone() {
        addressEntry.setTelephone("921-356-5678");
        assertEquals("921-356-5678", addressEntry.getTelephone(), "El teléfono debería ser '921-356-5678'.");
    }

    /**
     * Prueba para toString(), verifica si el método toString devuelve la cadena correcta.
     */
    @Test
    public void testToString() {
        String expected = "Nombre: Carlos Garcia\n" +
                "Dirección: 126 Ochoa Coatzacoalcos Veracruz\n" +
                "Código postal: 96550\n" +
                "Email: Manu@example.com\n" +
                "Teléfono: 921-131-1341";
        assertEquals(expected, addressEntry.toString(), "El método toString debería devolver la cadena correcta.");
    }
}