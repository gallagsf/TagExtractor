import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WordCounterFrame extends JFrame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    JPanel outerPanel;

    JButton findFrequencyButton;
    JButton addStopFilterButton;
    JButton saveFrequenciesButton;

    JTextArea frequencyArea;
    JScrollPane frequencyScroller;

    WordCounter wordCounter = new WordCounter();

    public WordCounterFrame() throws HeadlessException {
        outerPanel = new JPanel();

        saveFrequenciesButton = new JButton("Save Frequencies");
        addStopFilterButton = new JButton("Add Stop Word Filter");
        findFrequencyButton = new JButton("Find Frequency");

        frequencyArea = new JTextArea(10, 50);
        frequencyArea.setEditable(false);

        frequencyScroller = new JScrollPane(frequencyArea);

        findFrequencyButton.addActionListener(new ClickListenerFindFrequency());
        addStopFilterButton.addActionListener(new ClickListenerAddFilter());
        saveFrequenciesButton.addActionListener(new ClickListenerSaveFrequencies());

        setSize(WIDTH, HEIGHT);
        setTitle("Word Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        outerPanel.setLayout(new BorderLayout());
        add(outerPanel);
        outerPanel.add(findFrequencyButton, BorderLayout.LINE_START);
        outerPanel.add(frequencyScroller, BorderLayout.CENTER);
        outerPanel.add(addStopFilterButton, BorderLayout.LINE_END);
        outerPanel.add(saveFrequenciesButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public class ClickListenerFindFrequency implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            int returnValue = jfc.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                try {
                    wordCounter.CountWordFrequency(selectedFile);
                    String frequency = wordCounter.wordCount.toString();
                    frequency = frequency.replaceAll(", ", "\n");
                    frequency = frequency.replaceAll("=", ": ");
                    frequency = frequency.replaceAll("}", "");
                    frequency = frequency.replaceAll("\\{", "#");
                    frequencyArea.setText("");
                    frequencyArea.setText(frequency);
                } catch (FileNotFoundException ex) {
                    ex.getMessage();
                }
            }
        }
    }

    public class ClickListenerAddFilter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            int returnValue = jfc.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                try {
                    wordCounter.AddStopWordsFile(selectedFile);
                } catch (FileNotFoundException ex) {
                    ex.getMessage();
                }
            }
        }
    }

    public class ClickListenerSaveFrequencies implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Random rand = new Random();
            try {
                wordCounter.SaveFrequencies("frequencies.txt");
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
    }
}