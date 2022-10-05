package securityfx;

import Algorithm.AffineCipher;
import Algorithm.Atbash;
import Algorithm.CaesarCipher;
import Algorithm.Polyalphabetic;
import Algorithm.MultiplicativeCiphers;
import Algorithm.Vigenere;
import Algorithm.jIOFile;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import static securityfx.hill.choice;

public class fxmlFileController implements Initializable {

    @FXML
    private TextArea textArea1, textArea2;
    @FXML
    private Label labelShowMessage, AlgorithmLabel, keyTypeLabel, warningKeyLabel;
    @FXML
    private TextField textFieldKey1, textFieldKey2;
    @FXML
    private RadioButton rbEn, rbDe;
    @FXML
    private ComboBox<String> dbtypeCbx;

    @FXML
    private MenuItem menuAbout;

    @FXML
    private Button buttonStart1;
    private ObservableList<String> dbTypeList;
    @FXML
    private MenuItem menuItemOpenFile;
    @FXML
    private ToggleGroup rg1;

    //--------------------------------algorithm class 
    Atbash atbash = new Atbash();
    Polyalphabetic poly = new Polyalphabetic();
    Vigenere vigenere = new Vigenere();
    CaesarCipher caesarCipher = new CaesarCipher();
    AffineCipher affine = new AffineCipher();
    MultiplicativeCiphers mc = new MultiplicativeCiphers();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbTypeList = FXCollections.observableArrayList("Caesar cipher",
                "Vigenere cipher ",
                "Polyalphabetic cipher ",
                "Atbash cipher ",
                "Hill cipher ",
                "Affind cipher",
                "Multiplicative cipher");
        dbtypeCbx.setItems(dbTypeList);
        showComponent(false);

    }

    void showComponent(boolean b) {
        textFieldKey1.setVisible(b);
        textFieldKey2.setVisible(b);
        rbDe.setVisible(b);
        rbEn.setVisible(b);
    }
    // onclick function ------------------------------------------------

    @FXML
    private void onClickStartBtn(ActionEvent evt) {
        //on click start button 
        startClickedButton();
    }

    @FXML
    private void onClickComboBox1(ActionEvent evt) {
        // on clicked comboBox
        comboBoxClicked();
    }
    //-------------------------------------------------end onclick function

    // if comboBox clicked ................................................................................
    public void comboBoxClicked() {
        // this is for get index in jComboBox and check in switch statement
        SingleSelectionModel<String> x = dbtypeCbx.getSelectionModel();
        int selectedIndex = x.getSelectedIndex();
        if (selectedIndex >= 0) {
            showComponent(true);
            AlgorithmLabel.setText("");

            if (selectedIndex == 3) {
                textFieldKey1.setVisible(false);
            } else if (!(selectedIndex == 3)) {
                textFieldKey1.setVisible(true);
            }
            // this is for Affind cipher have two key
            if (selectedIndex != 5) {
                textFieldKey2.setVisible(false);
            }
        }
        switch (selectedIndex) {
            case 0:
                // index 0 : caesar cipher 
                keyTypeLabel.setText("Caesar cipher \nkey from 1 to 25");
                break;
            case 1:
                // index 1 : Veginer cipher
                keyTypeLabel.setText("Vigenere cipher \nkey is message");
                break;
            case 2:
                // index 2 : Mono cipher
                keyTypeLabel.setText("Mono cipher \nkey is alphabtics");
                break;
            case 3:
                // index 3 : Atbash cipher
                keyTypeLabel.setText("Atbash cipher \nkey is inverst");
                break;
            case 4:
                // index 4 : hill cipher
                keyTypeLabel.setText("Hill cipher \nkey is squr matrix");
                break;
            case 5:
                // index 5 : affind cipher
                keyTypeLabel.setText("Affind cipher \nHave tow number key");
                break;
            case 6:
                // index 5 : affind cipher
                keyTypeLabel.setText("Multiplicative cipher \n key in number ");
                break;
            default:
                keyTypeLabel.setText("");
                break;
        }
    }

    /*1*/ private void startClickedButton() {
        SingleSelectionModel<String> x = dbtypeCbx.getSelectionModel();
        int selectedIndex = x.getSelectedIndex();
        if (!(selectedIndex >= 0)) {
            AlgorithmLabel.setText("You must selecet algorithm");
        } else {
            switch (this.getSelectedRadioButton()) {
                case "encryption":
                    //----cell method en

                    switch (selectedIndex) {

                        // for algorithm have No key for example Atbash cipher-----------------------
                        case 3:
                            if (textArea1.getText().isEmpty()) {
                                labelShowMessage.setText("Plain text  is empty you must input plain text ...");
                            } else {
                                labelShowMessage.setText("");
                                this.encryptionSelected();
                            }
                            break;
                        //---------------------------------------------------------------------------------

                        // for algorithm have Two key for example Atbash cipher
                        case 5:
                            if (textFieldKey1.getText().isEmpty() || textFieldKey2.getText().isEmpty() || textArea1.getText().isEmpty()) {
                                labelShowMessage.setText("Plain text or key is empty you must input plain text and  both of key...");
                            } else {
                                labelShowMessage.setText("");
                                this.encryptionSelected();
                            }
                            break;
                        //--------------------------------------------------------
                        default:
                            // for algorithm have One key for example caesar cipher
                            if (textFieldKey1.getText().isEmpty() || textArea1.getText().isEmpty()) {
                                labelShowMessage.setText("Plain text or key is empty you must input plain text and key...");
                            } else {
                                labelShowMessage.setText("");
                                this.encryptionSelected();
                            }
                            break;
                    }
                    break;
                //------------------ End of encyption
                case "decryption":
                    // cell method de
                    switch (selectedIndex) {
                        case 3:
                            // for algorithm have No key for example Atbash cipher-----------------------
                            if (textArea2.getText().isEmpty()) {
                                labelShowMessage.setText("Cipher text  is empty you must input plain text ...");
                            } else {
                                labelShowMessage.setText("");
                                this.decryptionSelected();
                            }
                            break;
                        //----------------------------------------------------------------------------
                        case 5:
                            // for algorithm have Two key for example Atbash cipher
                            if (textFieldKey1.getText().isEmpty() || textFieldKey2.getText().isEmpty() || textArea2.getText().isEmpty()) {
                                labelShowMessage.setText("Cipher text or key is empty you must input Cipher text and key...");
                            } else {
                                labelShowMessage.setText("");
                                this.decryptionSelected();
                            }
                            break;
                        //-----------------------------------------------------------------------------
                        default:
                            // for algorithm have One key for example caesar cipher
                            if (textFieldKey1.getText().isEmpty() || textArea2.getText().isEmpty()) {
                                labelShowMessage.setText("Cipher text or key is empty you must input plain text and key...");
                            } else {
                                labelShowMessage.setText("");
                                this.decryptionSelected();
                            }
                            break;
                        //--------------------------------------------------
                    }
                // Default no one algorithm chosec
                default:
                    //keyTypeLabel.setText("Choose one Encryption or Decryption");
                    break;
            }
        }
    }

    /*2*/ private String getSelectedRadioButton() {
        if (rbEn.isSelected()) {
            return "encryption";
        }
        if (rbDe.isSelected()) {
            return "decryption";
        } else {
            return "nothing";
        }
    }

    /*3*/ public void encryptionSelected() {
        SingleSelectionModel<String> x = dbtypeCbx.getSelectionModel();
        int selectedIndex = x.getSelectedIndex();
        switch (selectedIndex) {
            case 0:
                if (!MyClass.isInteger(textFieldKey1.getText())) {
                    warningKeyLabel.setText("Key is message\nYou must input key\nNumber 1 to 25");
                } else {
                    this.textArea2.setText(caesarCipher.encryption(textArea1.getText(),
                            Integer.parseInt(textFieldKey1.getText())));
                    labelShowMessage.setText("Plain text successfully changed to ciphertext with key '" + textFieldKey1.getText() + "' ");
                }
                break;
            case 1:
                this.textArea2.setText(vigenere.encryption(this.textArea1.getText(),
                        this.textFieldKey1.getText()));
                labelShowMessage.setText("Plain text successfully changed to ciphertext with key'" + textFieldKey1.getText() + "' ");
                break;
            case 2:
                // polyalphabetic 
                this.textArea2.setText(poly.encryption(this.textArea1.getText(),
                        this.textFieldKey1.getText()));
                labelShowMessage.setText("Plain text successfully changed to cipher text");
                break;
            case 3:

                this.textArea2.setText(atbash.encryption(textArea1.getText()));
                labelShowMessage.setText("The plain text successfully revisit ...");
                break;
            case 4:
                // this is for hill cipher encryption >>>
                hill obj = new hill();
                hill.setChoice(1);
                hill.setLine(textArea1.getText());
                hill.setKey(textFieldKey1.getText());
                choice = hill.getChoice();
                String line = hill.getLine();
                String key = hill.getKey();
                double sq = Math.sqrt(key.length());
                if (sq != (long) sq) {
                    warningKeyLabel.setText("Cannot Form a square matrix");
                } else {
                    int size = (int) sq;
                    if (obj.check(key, size)) {
                        obj.cofact(obj.km, size);
                        obj.performDivision(line, size);
                    }
                }
                textArea2.setText(obj.getResult());
                labelShowMessage.setText("The plain text successfully change to cipher ...");
                break;
            case 5:
                //Affine
                textArea2.setText(affine.encryption(
                        textArea1.getText(), //plain text
                        Integer.parseInt(textFieldKey1.getText()),// key 1 
                        Integer.parseInt(textFieldKey2.getText())));// key 2 
                break;
            case 6:
                //Multiplicative Ciphers
                textArea2.setText(mc.encryption(textArea1.getText(),
                        Integer.parseInt(textFieldKey1.getText())));
                break;
            default:
                labelShowMessage.setText("Error......... warning");
                break;
        }
    }

    /*3*/ public void decryptionSelected() {
        SingleSelectionModel<String> x = dbtypeCbx.getSelectionModel();
        int selectedIndex = x.getSelectedIndex();
        switch (selectedIndex) {
            case 0:
                if (!MyClass.isInteger(textFieldKey1.getText())) {
                    warningKeyLabel.setText("Key is message\nYou must input key\nNumber 1 to 25");
                } else {
                    this.textArea1.setText(caesarCipher.decryption(this.textArea2.getText(),
                            Integer.parseInt(textFieldKey1.getText())));
                    labelShowMessage.setText("Cipher text successfully changed to plain text with key '"
                            + textFieldKey1.getText() + "' ");
                }
                break;
            case 1:
                this.textArea1.setText(vigenere.decryption(this.textArea2.getText(),
                        this.textFieldKey1.getText()));
                labelShowMessage.setText("Cipher text  successfully changed to Plaintext with key'"
                        + textFieldKey1.getText() + "' ");
                break;
            case 2:
                this.textArea1.setText(poly.decryption(this.textArea2.getText(),
                        this.textFieldKey1.getText()));
                this.labelShowMessage.setText("The cipher text successfully changed to plain text ...");
                break;
            case 3:
                this.textArea1.setText(atbash.decryption(this.textArea2.getText()));
                labelShowMessage.setText("The Cipher text successfully revisit ...");
                break;
            //
            case 4:
                hill obj = new hill();
                hill.setChoice(2);
                hill.setLine(this.textArea2.getText());
                hill.setKey(this.textFieldKey1.getText());
                choice = hill.getChoice();
                String line = hill.getLine();
                String key = hill.getKey();
                double sq = Math.sqrt(key.length());
                if (sq != (long) sq) {
                    warningKeyLabel.setText("Cannot Form a square matrix");
                } else {
                    int size = (int) sq;
                    if (obj.check(key, size)) {
                        obj.cofact(obj.km, size);
                        obj.performDivision(line, size);
                    }
                }
                textArea1.setText(obj.getResult());
                labelShowMessage.setText("The cipher text successfully change with key : '"
                        + textFieldKey1.getText() + "'");
                break;

            case 5:
                //Affine cipher
                textArea1.setText(affine.decryption(textArea2.getText(),
                        Integer.parseInt(textFieldKey1.getText()),
                        Integer.parseInt(textFieldKey2.getText())));
                labelShowMessage.setText("The cipher text successfully change with key one : '"
                        + textFieldKey1.getText());
                break;
            case 6:
                //Multiplicative Ciphers
                textArea1.setText(mc.decryption(textArea2.getText(),
                        Integer.parseInt(textFieldKey1.getText())));
                labelShowMessage.setText("The cipher text successfully change with key one : '"
                        + textFieldKey1.getText());
                break;
            default:
                labelShowMessage.setText("Error......... warning");
                break;
        }
    }

    @FXML
    void OpenFileAndSendTextToTextArea() {
        textArea1.setText(new jIOFile().getStringText());
    }

    @FXML
    void onMenuAboutClick(ActionEvent event) throws IOException {
        new MyClass().FXMLLoader("aboutFormFXML.fxml");
    }
}
