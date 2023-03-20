import javax.swing.*;
import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VirtualKeyboard implements ActionListener {

    public static ArrayList<String> note = new ArrayList<String>();
    public static ArrayList<String> extendedNote = new ArrayList<String>();
    JTextField octaveChoice;
    JTextField instrumentChoice;

    public static void main (String[] args) {
        VirtualKeyboard gui = new VirtualKeyboard();

        String[] preNote = {"C","D","E","F","G","A","B"};
        String[] preExtendedNote = {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};

        for (int i = 0; i < 7; i++) {
            note.add(preNote[i]);
        }

        for (int i = 0; i < 12; i++) {
            extendedNote.add(preExtendedNote[i]);
        }

        gui.setGUI();
    }

    public void setGUI() {
        JFrame frame = new JFrame("Rhysy's Virtual Keyboard!!!");
        JPanel keyPanel = new JPanel();
        JPanel controlPanel = new JPanel();

        JButton[] key = new JButton[7];

        for (int i = 0; i < 7; i++) {
            key[i] = new JButton(note.get(i));
            key[i].addActionListener(this);
            keyPanel.add(key[i]);
        }

        JLabel instrumentChoiceLabel = new JLabel("Instrument Choice: ");
        instrumentChoice = new JTextField(1);

        JLabel octaveChoiceLabel = new JLabel("Octave: ");
        octaveChoice = new JTextField(1);

        controlPanel.add(instrumentChoiceLabel);
        controlPanel.add(instrumentChoice);
        controlPanel.add(octaveChoiceLabel);
        controlPanel.add(octaveChoice);

        frame.getContentPane().add(BorderLayout.NORTH, keyPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, controlPanel);
        frame.setSize(500,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int finalNote = 0;
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton but = (JButton) source;
            System.out.print(but.getText());

            finalNote = (Integer.parseInt(octaveChoice.getText()) * 12) + extendedNote.indexOf(but.getText());

            System.out.print(" (" + finalNote + ")\n");

            playNote(finalNote, Integer.parseInt(instrumentChoice.getText()));
        }       
    }

    public void playNote(int finalNote, int finalInstrument) {
        try {

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            Sequence sequence = new Sequence(Sequence.PPQ,4);
            Track track = sequence.createTrack();

            MidiEvent event = null;

            ShortMessage first = new ShortMessage();
            first.setMessage(192,1,finalInstrument,0);
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,finalNote,100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,finalNote,100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            sequencer.setSequence(sequence);
            sequencer.start();
        } catch (Exception ex) { ex.printStackTrace(); }

    }
}
