package com.kalynx.serverlessreviewtool.plugin;

/**
 * Base interface for all Serverless Review Tool plugins.
 * All plugin interfaces extend this to ensure they are discoverable
 * by the PluginRegistry via ServiceLoader.
 */
public interface Plugin {

    /**
     * Called by the PluginRegistry immediately after the plugin is loaded.
     * Implementations should perform any setup required before the plugin is used.
     */
    void initialize();

    /**
     * Returns a {@link PluginPanel} describing the panel this plugin wishes to contribute
     * to the main application navigation menu, or {@code null} if the plugin provides no UI.
     *
     * <p>Returning {@code null} (the default) means the application will not add any menu
     * entry for this plugin. Override this method and return a {@link PluginPanel} instance
     * to add a named, prioritised entry to the slide-out menu.
     *
     * @return a {@link PluginPanel}, or {@code null} if this plugin has no UI contribution
     */
    default PluginPanel getUI() {
        return null;
    }
}

