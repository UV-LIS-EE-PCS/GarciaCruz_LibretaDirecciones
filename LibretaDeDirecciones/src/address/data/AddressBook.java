package address.data;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Clase que representa un libro de direcciones.
 */
public class AddressBook {
    private static AddressBook instance = null;
    private ArrayList<AddressEntry> entriesList;

    /**
     * Constructor privado para evitar la creación de instancias fuera de la clase.
     */
    private AddressBook() {
        this.entriesList = new ArrayList<>();
    }

    /**
     * Devuelve la única instancia de AddressBook.
     * @return La única instancia de AddressBook.
     */
    public static AddressBook getInstance() {
        if (instance == null) {
            instance = new AddressBook();
        }
        return instance;
    }

    /**
     * Muestra la lista de contactos en la consola ordenada por apellidos.
     */
    public void showContactsList() {
        if (entriesList.isEmpty()) System.out.println("La lista se encuentra vacia");
        else {
            // Definir el comparador
            Comparator<AddressEntry> byLastName = Comparator.comparing(AddressEntry::getLastName);

            // Ordenar la lista
            entriesList.sort(byLastName);
            for (AddressEntry entry : entriesList) {
                System.out.println((entriesList.indexOf(entry) + 1) + ". " + entry.toString() + "\n");
            }
        }
    }

    /**
     * Encuentra las entradas que coincidan con el apellido ingresado.
     * @param lastName Apellido a buscar.
     * @param strict Indica si la búsqueda debe ser estricta.
     * @return Lista de entradas de dirección que coinciden con el apellido.
     * @throws Exception Si la lista está vacía o si el apellido no existe en la lista de contactos.
     */
    public ArrayList<AddressEntry> findAddressEntry(String lastName, boolean strict) throws Exception {
        if (strict) lastNameExistInContactsList(lastName);
        ArrayList<AddressEntry> matchingContacts = new ArrayList<>();
        if (entriesList.isEmpty()) {
            throw new Exception("La lista se encuentra vacia");
        } else {
            for (AddressEntry entry : entriesList) {
                if (entry.getLastName().toLowerCase().contains(lastName.toLowerCase())) {
                    matchingContacts.add(entry);
                }
            }
        }
        return matchingContacts;
    }

    /**
     * Verifica si un apellido existe en la lista de contactos.
     * @param lastName Apellido a verificar.
     * @throws Exception Si el apellido no existe en la lista de contactos.
     */
    public void lastNameExistInContactsList(String lastName) throws Exception {
        if (entriesList.stream().noneMatch(entry -> entry.getLastName().equalsIgnoreCase(lastName))) {
            throw new Exception("El apellido no existe en la lista de contactos");
        }
    }

    /**
     * Añade una entrada de dirección a la lista.
     * @param addressEntry Entrada de dirección a añadir.
     */
    public void addAddressEntry(AddressEntry addressEntry) {
        entriesList.add(addressEntry);
    }

    /**
     * Elimina las entradas de dirección que coincidan con el apellido ingresado.
     * @param lastName Apellido de las entradas a eliminar.
     */
    public void deleteAddressEntry(String lastName) {
        entriesList.removeIf(entry -> entry.getLastName().equalsIgnoreCase(lastName));
    }

    /**
     * Lee entradas de dirección desde un archivo de texto y las añade a la lista.
     * @param filename Nombre del archivo desde el cual leer las entradas.
     */
    public void readFromATextFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] contactData = new String[8];
            int index = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\n");
                contactData[index] = parts[0];
                index++;
            }
            AddressEntry entry = new AddressEntry(contactData[0], contactData[1], contactData[2], contactData[3], contactData[4], Integer.parseInt(contactData[5]), contactData[6], contactData[7]);
            addAddressEntry(entry);
            System.out.println("Entries loaded from file.");
        } catch (IOException e) {
            System.err.println("Error loading from file: " + e.getMessage());
        }
    }

    /**
     * Muestra los contactos encontrados en la consola.
     * @param contacts Lista de contactos encontrados.
     */
    public void showContactsFound(ArrayList<AddressEntry> contacts) {
        if (contacts.size() == 1) {
            System.out.println("El siguiente contacto fue encontrado:");
            System.out.println(contacts.toString());
        } else {
            System.out.println("Los siguientes " + contacts.size() + " contactos fueron encontrados");
            for (AddressEntry entry: contacts) {
                System.out.println((entriesList.indexOf(entry) + 1) + ". " + entry.toString());
            }
        }
    }
}