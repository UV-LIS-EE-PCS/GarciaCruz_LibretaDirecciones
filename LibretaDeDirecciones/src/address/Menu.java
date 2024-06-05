package address;

import address.data.AddressBook;
import address.data.AddressEntry;
import java.util.Scanner;

/**
 * Representa un menú para la gestión de una libreta de direcciones.
 */
public class Menu {

    public Scanner in = new Scanner(System.in);

    /**
     * Muestra el menú de opciones disponibles.
     */
    public void displayMenu() {
        System.out.println(
                "Elige una opción\n" +
                        "a) Cargar\n" +
                        "b) Agregar\n" +
                        "c) Eliminar\n" +
                        "d) Buscar\n" +
                        "e) Mostrar\n" +
                        "f) Salir\n");
    }

    /**
     * Solicita al usuario los datos para agregar una nueva entrada de dirección.
     */
    public void add() {
        try {
            AddressEntry newEntry = requestContactData();
            AddressBook addressBook = AddressBook.getInstance();
            addressBook.addAddressEntry(newEntry);
        } catch (Exception ex) {
            System.out.println("Error al agregar el contacto");
            add();
        }
    }

    /**
     * Solicita al usuario los datos para una nueva entrada de dirección.
     * @return La nueva entrada de dirección.
     * @throws Exception Si no se completan todos los campos.
     */
    public AddressEntry requestContactData() throws Exception {
        System.out.println("Nombre:");
        String name = in.nextLine();
        System.out.println("Apellido:");
        String lastName = in.nextLine();
        System.out.println("Calle:");
        String street = in.nextLine();
        System.out.println("Ciudad:");
        String city = in.nextLine();
        System.out.println("Estado:");
        String state = in.nextLine();
        System.out.println("CP:");
        int postalCode = in.nextInt();
        in.nextLine();
        System.out.println("Email:");
        String email = in.nextLine();
        System.out.println("Telefono:");
        String phone = in.nextLine();

        if (name.isEmpty() || lastName.isEmpty() || street.isEmpty() || city.isEmpty() || state.isEmpty()
                || email.isEmpty() || phone.isEmpty()) {
            throw new Exception("Todos los campos deben ser completados.");
        }

        return new AddressEntry(name, lastName, street, city, state, postalCode, email, phone);
    }
}