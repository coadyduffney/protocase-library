package com.protocase.protocaselibrary.ui;

import com.protocase.protocaselibrary.fundamental.Library;
import com.protocase.protocaselibrary.fundamental.User;
import com.protocase.protocaselibrary.interactive.BookCopy;
import com.protocase.protocaselibrary.interactive.UserSession;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

/**
 * @author Coady Duffney
 */
public class ProfileViewController {
    public static final String FX_ALIGNMENT_CENTER = "-fx-alignment: CENTER;";
    @FXML
    private TableView<BookCopy> tableView;

    @FXML
    private Button checkInBooksButton;
    private ObservableList<BookCopy> selectedBooks = FXCollections.observableArrayList();

    public void init() {
        initializeTableView();
        refreshTableViewItems();
        checkInBooksButton.disableProperty().bind(Bindings.isEmpty(selectedBooks));
    }

    private void refreshTableViewItems() {
        selectedBooks.clear();

        User user = UserSession.getInstance().getUser();
        List<BookCopy> userBookHistory = Library.getInstance()
                .getBookLog().getHistoryForUser(user);

        tableView.setItems(FXCollections.observableArrayList(userBookHistory));
    }

    private void initializeTableView() {
        // Create columns
        TableColumn<BookCopy, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setPrefWidth(155);
        titleColumn.setStyle(FX_ALIGNMENT_CENTER);
        titleColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getOriginal().getTitle()));

        TableColumn<BookCopy, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setPrefWidth(120);
        authorColumn.setStyle(FX_ALIGNMENT_CENTER);
        authorColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getOriginal().getAuthor()));

        TableColumn<BookCopy, String> checkInDateColumn = new TableColumn<>("Check In Date");
        checkInDateColumn.setPrefWidth(100);
        checkInDateColumn.setStyle(FX_ALIGNMENT_CENTER);
        checkInDateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCheckInDate()));

        TableColumn<BookCopy, String> checkOutDateColumn = new TableColumn<>("Check Out Date");
        checkOutDateColumn.setPrefWidth(100);
        checkOutDateColumn.setStyle(FX_ALIGNMENT_CENTER);
        checkOutDateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCheckOutDate()));

        TableColumn<BookCopy, Boolean> overdueColumn = new TableColumn<>("Overdue");
        overdueColumn.setPrefWidth(100);
        overdueColumn.setStyle(FX_ALIGNMENT_CENTER);
        overdueColumn.setCellValueFactory(data -> new SimpleBooleanProperty(data.getValue().isOverdue()));

        TableColumn<BookCopy, Boolean> checkInColumn = new TableColumn<>("Check In");
        checkInColumn.setPrefWidth(100);
        checkInColumn.setStyle(FX_ALIGNMENT_CENTER);
        checkInColumn.setCellValueFactory(data -> new SimpleBooleanProperty(selectedBooks.contains(data)));
        checkInColumn.setCellFactory(column -> new TableCell<>() {
            private final CheckBox checkBox = new CheckBox();

            {
                checkBox.setOnAction(event -> {
                    BookCopy book = getTableView().getItems().get(getIndex());
                    if (checkBox.isSelected()) {
                        selectedBooks.add(book);
                    } else {
                        selectedBooks.remove(book);
                    }
                });
            }

            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    checkBox.setSelected(item);
                    setGraphic(checkBox);
                }
            }
        });

        // Add columns to TableView
        tableView.getColumns().addAll(
                titleColumn,
                authorColumn,
                checkInDateColumn,
                checkOutDateColumn,
                overdueColumn,
                checkInColumn);
    }

    @FXML
    void onCheckInBooks() {
        Library.getInstance().checkInBooks(selectedBooks);
        NotificationHelper.showCheckInNotification(selectedBooks.size());
        refreshTableViewItems();
    }

}
