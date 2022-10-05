package Algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import securityfx.MyClass;

public class jIOFile {

    public jIOFile() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            MyClass.showDialog("Exception message ", e.getMessage());
        }
    }

    public String getStringText() {
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.text", "txt", "js", "html", "php", "docx", "m", "css", "py");
        jFileChooser.addChoosableFileFilter(filter);
        int chooser = jFileChooser.showOpenDialog(null);
        if (chooser == JFileChooser.APPROVE_OPTION) {

            File file = jFileChooser.getSelectedFile();
            try {
                Scanner scan = new Scanner(file);
                String fileContent = "";
                while (scan.hasNextLine()) {
                    fileContent = fileContent.concat(scan.nextLine() + "\n");
                }
                return fileContent;
            } catch (FileNotFoundException ex) {
                MyClass.showDialog("Exception message ", ex.getMessage());
                return "";
            }
        } else {
            MyClass.showInformationDialog("Exception message ", "No file chooser...!");
            return "";
        }
    }
}
