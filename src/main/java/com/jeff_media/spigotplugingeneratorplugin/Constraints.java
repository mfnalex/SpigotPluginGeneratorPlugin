package com.jeff_media.spigotplugingeneratorplugin;

import com.intellij.util.ui.JBUI;

import java.awt.*;

public class Constraints {
    private static final int MARGIN = 2;
    public static GridBagConstraints get(int x, int y, double weightx, double weighty, int width) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        constraints.insets = JBUI.insets(MARGIN);
        constraints.gridheight = 1;
        constraints.gridwidth = width;
        return constraints;
    }
}
