package com.protocase.protocaselibrary;

import com.protocase.protocaselibrary.fundamental.Library;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class AppController {
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