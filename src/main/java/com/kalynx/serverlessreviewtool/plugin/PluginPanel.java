package com.kalynx.serverlessreviewtool.plugin;

import javax.swing.JPanel;

/**
 * Wrapper returned by {@link Plugin#getUI()} to contribute a named panel to the main application menu.
 *
 * <p>Plugins that wish to add a top-level navigation entry should return an instance of this
 * class from {@code getUI()}. The application will incorporate the panel into the slide-out menu
 * sorted by {@link #getMenuPriority()}.
 */
public class PluginPanel {

    private final String title;
    private final JPanel panel;
    private final int menuPriority;

    /**
     * Creates a PluginPanel.
     *
     * @param title        the menu label shown for this panel
     * @param panel        the panel to display when the menu item is selected
     * @param menuPriority ordering hint in the range 1–100; lower values appear nearer the top
     * @throws IllegalArgumentException if menuPriority is outside the range 1–100
     */
    public PluginPanel(String title, JPanel panel, int menuPriority) {
        if (menuPriority < 1 || menuPriority > 100) {
            throw new IllegalArgumentException("menuPriority must be between 1 and 100 inclusive");
        }
        this.title = title;
        this.panel = panel;
        this.menuPriority = menuPriority;
    }

    /**
     * Returns the menu label for this panel.
     *
     * @return the panel title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the Swing panel to display.
     *
     * @return the panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Returns the menu priority. Lower values appear nearer the top of the menu.
     *
     * @return priority in the range 1–100
     */
    public int getMenuPriority() {
        return menuPriority;
    }
}

