package com.jeff_media.spigotplugingeneratorplugin;

import com.jeff_media.spigotplugingeneratorplugin.dependency.Dependency;
import lombok.Getter;
import org.apache.tools.ant.taskdefs.optional.depend.Depend;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.hyperlink.AbstractHyperlinkAction;
import org.jdesktop.swingx.renderer.DefaultTableRenderer;
import org.jdesktop.swingx.renderer.HyperlinkProvider;

import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DependencyTable extends JXTable {

    @Getter
    private final List<Dependency> properties;

    public DependencyTable(List<Dependency> properties) {
        super(properties.stream().sorted().map(Dependency::asTableRow).toArray(Object[][]::new), new String[]{"Enabled", "Name", "Link", "Description", "Scope"});
        this.properties = properties.stream().sorted().collect(Collectors.toList());
        this.setTableHeader(new JTableHeader(this.columnModel));

        //this.addMouseListener(new DependencyTableLinkClickListener());
        AbstractHyperlinkAction<Object> hyperLinkAction = new AbstractHyperlinkAction<Object>(null) {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String url = DependencyTable.this.properties.get(getSelectedRow()).getUrl();
                if (url != null) {
                    try {
                        Desktop.getDesktop().browse(java.net.URI.create(url));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        };
        HyperlinkProvider hyperlinkProvider = new HyperlinkProvider(hyperLinkAction);
        TableCellRenderer renderer = new DefaultTableRenderer(hyperlinkProvider);
        getColumnExt(2).setEditable(false);
        getColumnExt(2).setCellRenderer(renderer);
    }

    @Override
    public Class<?> getColumnClass(int column) {
        if (column == 0) return Boolean.class;
        return String.class;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 0;
    }

    public List<Dependency> getSelectedDependencies() {
        List<Dependency> selectedDependencies = new ArrayList<>();
        for (int i = 0; i < properties.size(); i++) {
            boolean selected = (boolean) getModel().getValueAt(i, 0);
            if (selected) {
                selectedDependencies.add(properties.get(i));
            }
        }
        return selectedDependencies;
    }

//    public Map<RequiredProperty, WrappedComponent> getDependencies() {
//        Map<RequiredProperty, WrappedComponent> map = new HashMap<>();
//        for (RequiredProperty property : properties) {
//            map.put(property, new WrappedComponent((boolean) getModel().getValueAt(properties.indexOf(property), 0)));
//        }
//        return map;
//    }

    private class DependencyTableLinkClickListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            int column = getSelectedColumn();
            int row = getSelectedRow();
            System.out.println("Clicked on row " + row + ", column " + column);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }
}
