package com.jeff_media.spigotplugingeneratorplugin;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.module.ModuleType;
import com.intellij.ui.components.JBTabbedPane;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SpigotMavenPluginModuleBuilder extends ModuleBuilder {
    @Override
    public ModuleType<?> getModuleType() {
        return SpigotMavenPluginModuleType.getInstance();
    }

    @Override
    public @Nullable ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
        return new ModuleWizardStep() {
            @Override
            public JComponent getComponent() {
                JTabbedPane pane = new JBTabbedPane();
                pane.add("General", new GeneralPanel());
                pane.add("Dependencies", new DependencyPanel());
                return pane;
            }

            @Override
            public void updateDataModel() {

            }
        };
    }
}
