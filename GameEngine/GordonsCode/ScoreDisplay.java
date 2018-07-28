package GordonsCode;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ScoreDisplay extends JPanel {
    ScoreDisplay() {
        super();//super class
    }

    public ScoreDisplay(String dataFilePath) {
        JTable table;
        ScoreDisplayTable model;
        Font f;
        f = new Font("SanSerif", Font.PLAIN, 24);
        setFont(f);
        setLayout(new BorderLayout());
        model = new ScoreDisplayTable(dataFilePath);
        table = new JTable();
        table.setModel(model);
        table.createDefaultColumnsFromModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
        //sorter.setComparator(1, new IntComparator());

        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>(10);
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        JScrollPane scrollpane = new JScrollPane(table);
        add(scrollpane);
    }

    //Collections.sort(NL, new Comparator<String>() {
    //public int compare(String o1, String o2) {
    //return extractInt(o2) - extractInt(o1);
    // }
    //Considering Score (Digits)
    //int extractInt(String s) {
    //String num = s.replaceAll("\\D", "");
    //If no digits/score (empty or null), return value 0
    //return num.isEmpty() ? 0 : Integer.parseInt(num);
    //}
    //});
    //class IntComparator implements Comparator {
    //@Override
    //public int compare(Object o1, Object o2) {
    //Integer int1 = (Integer)o1;
    // Integer int2 = (Integer)o2;
    //return int1.compareTo(int2);
    // }
    // public boolean equals(String o2) {
    // return this.equals(o2);
    // }
//}
    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }

    class WindowCloser extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            Window win = e.getWindow();
            win.setVisible(false);
            System.exit(0);
        }
    }
}