package address.data;

import java.util.Objects;

/**
 * Representa una entrada de dirección en un libro de direcciones.
 */
public class AddressEntry {
    private String name, lastName, street, city, state;
    private int postalCode;
    private String email, telephone;

    // Constructor por defecto
    public AddressEntry() {

    }

    /**
     * Constructor que inicializa una entrada de dirección con los parámetros especificados.
     * @param name Nombre de la persona.
     * @param lastName Apellido de la persona.
     * @param street Calle de la dirección.
     * @param city Ciudad de la dirección.
     * @param state Estado de la dirección.
     * @param postalCode Código postal de la dirección.
     * @param email Correo electrónico de la persona.
     * @param telephone Número de teléfono de la persona.
     */
    public AddressEntry(String name, String lastName, String street, String city, String state, int postalCode, String email, String telephone) {
        this.name = name;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.email = email;
        this.telephone = telephone;
    }

    /**
     * Obtiene el nombre de la persona.
     * @return Nombre de la persona.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre de la persona.
     * @param name Nombre de la persona.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el apellido de la persona.
     * @return Apellido de la persona.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Establece el apellido de la persona.
     * @param lastName Apellido de la persona.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Obtiene la calle de la dirección.
     * @return Calle de la dirección.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Establece la calle de la dirección.
     * @param street Calle de la dirección.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Obtiene la ciudad de la dirección.
     * @return Ciudad de la dirección.
     */
    public String getCity() {
        return city;
    }

    /**
     * Establece la ciudad de la dirección.
     * @param city Ciudad de la dirección.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Obtiene el estado de la dirección.
     * @return Estado de la dirección.
     */
    public String getState() {
        return state;
    }

    /**
     * Establece el estado de la dirección.
     * @param state Estado de la dirección.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Obtiene el código postal de la dirección.
     * @return Código postal de la dirección.
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * Establece el código postal de la dirección.
     * @param postalCode Código postal de la dirección.
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     * @return Correo electrónico de la persona.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico de la persona.
     * @param email Correo electrónico de la persona.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el número de teléfono de la persona.
     * @return Número de teléfono de la persona.
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Establece el número de teléfono de la persona.
     * @param telephone Número de teléfono de la persona.
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    // Devolución en cadena
    @Override
    public String toString() {
        return "Nombre: " + name + " " + lastName + '\n' +
                "Dirección: " + street + " " + city + " " + state + '\n' +
                "Código postal: " + postalCode  +'\n' +
                "Email: " + email + '\n' +
                "Teléfono: " + telephone;
    }

    // Método para comparar dos objetos AddressEntry por igualdad
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntry that = (AddressEntry) o;
        return postalCode == that.postalCode &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(street, that.street) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(email, that.email) &&
                Objects.equals(telephone, that.telephone);
    }

    // Método para generar un valor hash único para un objeto AddressEntry
    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, street, city, state, postalCode, email, telephone);
    }
}