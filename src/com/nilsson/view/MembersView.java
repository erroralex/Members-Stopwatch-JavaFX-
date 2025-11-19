package com.nilsson.view;

import com.nilsson.model.Member;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class MembersView extends BorderPane {

    public TextField firstNameField = new TextField();
    public TextField lastNameField = new TextField();
    public TextField phoneField = new TextField();
    public TextField addressField = new TextField();

    public Button saveButton = new Button("Save");
    public Button backButton = new Button("Back");

    public TableView<Member> table = new TableView<>();
    private List<Member> memberList = new ArrayList<>();

    public MembersView() {
        // Top Bar
        Label header = new Label("Add Member");
        header.getStyleClass().add("add-member-title");
        header.setMaxWidth(Double.MAX_VALUE);
        header.setAlignment(Pos.CENTER);

        GridPane formGrid = new GridPane();
        formGrid.setHgap(15);
        formGrid.setVgap(10);

        firstNameField.setPromptText("First Name");
        lastNameField.setPromptText("Last Name");
        phoneField.setPromptText("Phone");
        addressField.setPromptText("Address");

        formGrid.add(firstNameField, 0, 0);
        formGrid.add(lastNameField, 1, 0);
        formGrid.add(phoneField, 0, 1);
        formGrid.add(addressField, 1, 1);

        saveButton.setMaxWidth(Double.MAX_VALUE); // Make save button full width

        VBox formCard = new VBox(20, header, formGrid, saveButton);
        formCard.setAlignment(Pos.TOP_CENTER);
        formCard.getStyleClass().add("form-card"); // Apply new card styling

        VBox formWrapper = new VBox(formCard);
        formWrapper.setAlignment(Pos.TOP_CENTER);
        formWrapper.setPadding(new Insets(20, 0, 20, 0)); // Padding above and below the card area

        // Table
        TableColumn<Member, String> firstCol = new TableColumn<>("First Name");
        firstCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("firstName"));

        TableColumn<Member, String> lastCol = new TableColumn<>("Last Name");
        lastCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("lastName"));

        TableColumn<Member, String> phoneCol = new TableColumn<>("Phone");
        phoneCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("phone"));

        TableColumn<Member, String> addressCol = new TableColumn<>("Address");
        addressCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("address"));

        table.getColumns().addAll(firstCol, lastCol, phoneCol, addressCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getStyleClass().add("table-view");

        // Bottom Bar
        BorderPane bottom = new BorderPane();
        backButton.getStyleClass().add("red-button");
        bottom.setLeft(backButton); // Consistent back button placement (left)
        bottom.setPadding(new Insets(10, 20, 10, 20));

        this.setTop(formWrapper);
        this.setCenter(table);
        this.setBottom(bottom);

        BorderPane.setMargin(table, new Insets(0, 20, 0, 20)); // Add side margins to the table for visual separation
    }

    public void setMembers(List<Member> members) {
        this.memberList = members;
        table.setItems(FXCollections.observableArrayList(memberList));
    }

    public void addMember(Member member) {
        memberList.add(member);
        table.setItems(FXCollections.observableArrayList(memberList));
    }

    public void clearForm() {
        firstNameField.clear();
        lastNameField.clear();
        phoneField.clear();
        addressField.clear();
    }
}