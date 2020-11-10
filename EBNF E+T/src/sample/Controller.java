package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;


public class Controller implements Initializable {

  @FXML
  private Button btnDefinition,
    btnConcatenation,
    btnTermination,
    btnOptional,
    btnRepetition,
    btnGrouping,
    btnString1,
    btnString2,
    btnComment,
    btnSpecial,
    btnExclusion;

  @FXML
  private TextArea textEbnf,
    textSearch;

  private String searchString = "";
  private String ebnfString = "";

  private HashMap<String,String> ebnfChars = new HashMap<String,String>(){{put("(","(C)");put("[","[C]");put("{","{C}");put("="," = C");put("?"," ? C ? ");put(";",";\nC");}};

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    textEbnf.textProperty().addListener((observable, oldValue, newValue) -> {
      ebnfString = newValue;
      //matchEbnf(ebnfString, searchString);
    });
    textSearch.textProperty().addListener((observable, oldValue, newValue) -> {
      searchString = newValue;
      //matchEbnf(ebnfString, searchString);
    });
    textEbnf.setOnKeyTyped(event -> {
      String key = event.getCharacter();//event.getText() + "A" + (event.isAltDown()?"1":"0") + "C" + (event.isControlDown()?"1":"0") + "S" + (event.isShiftDown()?"1":"0");
      if (ebnfChars.containsKey(key)) {
        String replace = ebnfChars.get(key);
        int cursor = replace.indexOf('C') + textEbnf.getCaretPosition();
        textEbnf.insertText(textEbnf.getCaretPosition(), replace.replaceAll("C", ""));
        textEbnf.positionCaret(cursor);
        event.consume();
      }
    });
  }

  private void matchEbnf(String ebnfString, String searchString) {
    String regex = regexFromEbnf(ebnfString);
  }

  private String regexFromEbnf(String ebnfString) {
    String regex = "";

    String[] rules = ebnfString.split(";(\\s|\\n|\\r\\n)+");

    boolean first = true;
    for (String rule : rules) {
      String lhs = rule.split("=")[0];
      String rhs = rule.split("=")[1];
      rhs.replaceAll("[^'\"](\\w+)[^'\"]","<\\1>");
      rhs.replaceAll("['\"](\\w+)['\"]","\\1");
      rhs.replaceAll("\\{(.+?)\\}","(\\1)*");
      rhs.replaceAll("\\[(.+?)\\]","(\\1)?");
      rhs.replaceAll("(.+)\\.\\.(.+)", "[\\1..\\2]");

      if (first) {
        regex = rhs;
        first = false;
      } else {
        regex.replaceAll("<"+lhs+">",rhs);
      }
    }

    return regex;
  }

  @FXML
  private void handleButton(ActionEvent e) {
    String label = ((Button)e.getSource()).getText();
    String[] labelparts = label.split("\\.\\.");
    if (";".equals(labelparts[0])) matchEbnf(ebnfString,searchString);/*labelparts[0] = ";\n";
    if (!"".equals(textEbnf.getSelectedText()) && labelparts.length > 1)
    {
      int startsel = textEbnf.getSelection().getStart();
      int endsel = textEbnf.getSelection().getEnd();
      textEbnf.insertText(startsel,labelparts[0]);
      textEbnf.insertText(endsel+labelparts[0].length(),labelparts[1]);
    } else {
      int cursor = textEbnf.getCaretPosition();
      textEbnf.insertText(cursor,labelparts[0]);
      if (labelparts.length > 1) {
        textEbnf.insertText(cursor, labelparts[1]);
        textEbnf.positionCaret(cursor + labelparts[0].length());
      }
    }
    textEbnf.requestFocus();*/
  }
}
