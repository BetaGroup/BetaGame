package Engine;

import javax.swing.table.*;
import java.io.*;
import java.util.*;

public class ScoreDisplayTable extends AbstractTableModel {
    protected Vector data;
    protected Vector columnNames;
    protected String datafile;
    public ScoreDisplayTable(String f) {
        datafile = f;
        initVectors();
    }
    public void initVectors() {
        String aLine;
        data = new Vector();
        columnNames = new Vector();
        try {
            FileInputStream fin = new FileInputStream(datafile);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(fin))) {
                //columnNames.addElement("Rank");
                columnNames.addElement("Name");
                columnNames.addElement("Score");
                // extract data
                while ((aLine = br.readLine()) != null) {
                    StringTokenizer st2
                            = new StringTokenizer(aLine, "\t");
                    while (st2.hasMoreTokens()) {
                        data.addElement(st2.nextToken());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        return data.size() / getColumnCount();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        String colName = "";

        if (columnIndex <= getColumnCount()) {
            colName = (String) columnNames.elementAt(columnIndex);
        }
        return colName;
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return (String) data.elementAt((rowIndex * getColumnCount()) + columnIndex);
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        return;
    }
}
