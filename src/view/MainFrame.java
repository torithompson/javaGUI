package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.DataModel;

/**
 * MainFrame class for COMP 305 GUI Demo
 */
public class MainFrame extends JFrame {
    private Container contentPane;
    private JTable table = new JTable();
    private JPanel titlePanel = new JPanel();
    private JPanel mainPanel = new JPanel();
    private JPanel controlPanel = new JPanel();
    private JLabel titleLabel = new JLabel("COMP 305");
    private JButton updateButton = new JButton("Update");
    private JScrollPane scrollPane;
    private JButton infoBtn = new JButton("Info");

    // constructor for MainFrame
    public MainFrame(String title) {
        setTitle(title);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initLayout();
    }

    // initialize the layout of the MainFrame
    private void initLayout() {
        contentPane = this.getContentPane();

        // TitleBar
        contentPane.add(titlePanel, "North");
        titlePanel.add(titleLabel);
        String fontName = titleLabel.getFont().getFontName();
        titleLabel.setFont(new Font(fontName, 0, 24));

        // MainPanel
        mainPanel.setBackground(new Color(0xAAFFFF));
        contentPane.add(mainPanel, "Center");
        // Headers and table data
        String[] headers = { "Column 1", "Column 2", "Column 3", "Column 4" };
        table = new JTable(new DefaultTableModel(DataModel.getData(), headers));
        scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane);
        // Update button
        updateButton.addActionListener(e -> {
            table.setModel(new DefaultTableModel(DataModel.getData(), headers));
        });
        infoBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, DataModel.getInfo());
        });

        // ControlPanel
        contentPane.add(controlPanel, "South");
        controlPanel.add(updateButton);
        controlPanel.add(infoBtn);
        // pack the frame to fit the content
        pack();
    }
}
