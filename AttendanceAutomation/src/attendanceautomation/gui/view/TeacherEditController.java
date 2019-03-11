/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author andreas
 */
public class TeacherEditController implements Initializable
{

    @FXML
    private TableView<?> tableTable;
    @FXML
    private TableColumn<?, ?> columnC1;
    @FXML
    private TableColumn<?, ?> columnC2;
    @FXML
    private RadioButton radioPresent;
    @FXML
    private RadioButton radioAbsent;
    @FXML
    private Label lblUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
}
