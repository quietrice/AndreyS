package program.models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Person {
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty street;
    private StringProperty city;
    private IntegerProperty postalCode;
    private ObjectProperty<LocalDate> birthDay;


    public Person(String firstName, String lastName){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        // Какие-то фиктивные значения
        this.street = new SimpleStringProperty("Какая-то улица");
        this.city = new SimpleStringProperty("Какой-то город");
        this.postalCode = new SimpleIntegerProperty(1234);
        this.birthDay = new SimpleObjectProperty<LocalDate>(LocalDate.of(1995,9,12));
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty getLastNameProperty() {
        return lastName;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty getFirstNameProperty() {
        return firstName;
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty getStreetProperty() {
        return street;
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public IntegerProperty getPostalCodeProperty() {
        return postalCode;
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty getCityProperty() {
        return city;
    }

    public LocalDate getBirthday() {
        return birthDay.get();
    }
    public ObjectProperty<LocalDate> getBirthdayProperty() {
        return birthDay;
    }

    public void setFirstName(String firstName){
        this.firstName.set(firstName);
    }

    public void setLastName(String lastName){
        this.lastName.set(lastName);
    }

    public void setCity(String city){
        this.city.set(city);
    }

    public void setStreet(String street){
        this.street.set(street);
    }
    public void setPostalCode(String postalCode){
        this.postalCode.set(Integer.parseInt(postalCode));
    }

    public void setBirthday(LocalDate birthday){
        this.birthDay.set(birthday);
    }
}
