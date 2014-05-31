/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propLlibreria.Interficie;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author towerthousand
 */
public class PropTableModel extends AbstractTableModel {
        private ArrayList<String> columnNames;
        private ArrayList<ArrayList<String> > dataRow;
        
        public PropTableModel() {
            columnNames = new ArrayList<String>();
            dataRow = new ArrayList<ArrayList<String> >();
        }
        
        @Override
        public int getRowCount() {
            return dataRow.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.size();
            //return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return dataRow.get(rowIndex).get(columnIndex);
        }
        @Override
        public String getColumnName(int col) {
                return columnNames.get(col);
                //return columnNames[col];
        }
        
        public void setColumnsValues(ArrayList<String> value) {
            columnNames = value;
        }
        public void setRowsValues(ArrayList<ArrayList<String> > value) {
                dataRow = value;
        }
    }