package program.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import program.Main;
import program.models.Person;
import program.utils.DateUtil;

public class PersonAddController {
    private Main mainApp;
    @FXML
    private TextField firstNameField1;
    @FXML
    private TextField lastNameField1;
    @FXML
    private TextField streetField1;
    @FXML
    private TextField cityField1;
    @FXML
    private TextField postalCodeField1;
    @FXML
    private TextField birthdayField1;

    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    @FXML
    private void initialize(){

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPerson(){

        firstNameField1.setPromptText("First name");
        lastNameField1.setPromptText("Last Name");
        streetField1.setPromptText("Street");
        cityField1.setPromptText("City");
        postalCodeField1.setPromptText("Postal Code");
        birthdayField1.setPromptText("dd.mm.yyyy");

    }

    public boolean isOkClicked(){
        return okClicked;
    }

    @FXML
    private void handleCancel(){
        dialogStage.close();
    }

    @FXML
    private void handleOk(){
        if(isInputValid()){
            person = new Person(firstNameField1.getText(),lastNameField1.getText());
            person.setBirthday(DateUtil.parse(birthdayField1.getText()));
            person.setCity(cityField1.getText());
            person.setStreet(streetField1.getText());
            person.setPostalCode(postalCodeField1.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    private boolean isInputValid(){
        String errorMessage = "";
        if(firstNameField1.getText() == null || firstNameField1.getText().length() == 0){
            errorMessage += "Не валидно имя\n";
        }
        if(lastNameField1.getText() == null || lastNameField1.getText().length() == 0){
            errorMessage += "Не валидна фамилия\n";
        }
        if(streetField1.getText() == null || streetField1.getText().length() == 0){
            errorMessage += "Не валидна улица\n";
        }
        if(cityField1.getText() == null || cityField1.getText().length() == 0){
            errorMessage += "Не валиден город\n";
        }

        if(birthdayField1.getText() == null || birthdayField1.getText().length() == 0){
            errorMessage += "Не введена дата рождения\n";
        }else{
            if(!DateUtil.isValid(birthdayField1.getText())){
                errorMessage += "Введите дату в формате dd.MM.yyyy\n";
            }
        }
        if(postalCodeField1.getText() == null || postalCodeField1.getText().length() == 0){
            errorMessage += "Не введен почтовый индекс\n";
        }else{
            try{
                Integer.parseInt(postalCodeField1.getText());
            } catch (NumberFormatException e){
                errorMessage += "Почтовый индекс состоит из цифр";
            }
        }

        if(errorMessage.length() == 0){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("ОШИБКА");
            alert.setHeaderText(errorMessage);
            alert.setContentText("Введите заново");
            alert.showAndWait();
            return false;
        }
    }

    public void setMain(Main mainApp){
        this.mainApp = mainApp;
    }
}