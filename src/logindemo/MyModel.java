/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindemo;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raymond
 */
public class MyModel extends AbstractTableModel {
    
    private String[] columns;
    private Object[][] rows;
    
    public MyModel() {
    }

    public MyModel(String[] columns, Object[][] rows) {
        this.columns = columns;
        this.rows = rows;
    }

    public Class getColumnClass(int col){
        if(col==6){
            return Icon.class;
        }else{
            return getValueAt(0,col).getClass();
        }
    }
    
    @Override
    public int getRowCount() {
        return this.rows.length;
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.rows[rowIndex][columnIndex];
    }
    
    public String getColumnName(int col){
        return this.columns[col];
    }
    
}
