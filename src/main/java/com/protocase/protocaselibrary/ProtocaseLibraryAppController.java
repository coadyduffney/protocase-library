package com.protocase.protocaselibrary;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class ProtocaseLibraryAppController {
    @FXML
    private BorderPane parentContainer;

    @FXML
    private Tab profileTab;

    @FXML
    private Tab searchTab;

    @FXML
    private TabPane tabbedPane;

    public void init() {
        SearchBookView searchBookView = new SearchBookView();
        searchTab.setContent(searchBookView.getComponent());
    }
}