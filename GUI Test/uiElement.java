import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;

public class uiElement extends JFrame implements ActionListener{

  public void uiElement()
  {
    JFrame frame=new JFrame("Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,500);

    JMenuBar menu = new JMenuBar();
    //File
    JMenu menuFile = new JMenu("File");
      JMenuItem fileNew   = new JMenuItem("New");//File>New
      JMenuItem fileOpen  = new JMenuItem("Open");//File>Open
      JMenuItem fileSave  = new JMenuItem("Save");//File>Save
      JMenuItem filePrint = new JMenuItem("Print");//File>Print
    //Edit
    JMenu menuEdit = new JMenu("Edit");
      JMenuItem editCut   = new JMenuItem("Cut");//Edit>Cut
      JMenuItem editCopy  = new JMenuItem("Copy");//Edit>Copy
      JMenuItem editPaste = new JMenuItem("Paste");//Edit>Paste
    //Close
    JMenuItem menuClose = new JMenuItem("Close");//Close
    //Run
    JMenuItem menuRun   = new JMenuItem("Run");//Run

    fileNew.addActionListener(this);
    fileOpen.addActionListener(this);
    fileSave.addActionListener(this);
    filePrint.addActionListener(this);

    editCut.addActionListener(this);
    editCopy.addActionListener(this);
    editPaste.addActionListener(this);

    menuClose.addActionListener(this);
    menuRun.addActionListener(this);

    menuFile.add(fileNew);
    menuFile.add(fileOpen);
    menuFile.add(fileSave);
    menuFile.add(filePrint);

    menuEdit.add(editCut);
    menuEdit.add(editCopy);
    menuEdit.add(editPaste);

    menu.add(menuFile);
    menu.add(menuEdit);
    menu.add(menuClose);
    menu.add(menuRun);


    JTextArea textEditor = new JTextArea();
    textEditor.setText("Hello");
    frame.add(textEditor);
		//JButton button = new JButton("Start");
    //frame.getContentPane().add(button);
    frame.setJMenuBar(menu);
    frame.show();

  }
}
