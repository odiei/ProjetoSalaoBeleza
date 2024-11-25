package com.example.salao;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AppController {

    @FXML
    private TableView<Client> tableView;

    @FXML
    private TableColumn<Client, String> nomeColumn;

    @FXML
    private TableColumn<Client, String> telefoneColumn;

    @FXML
    private TableColumn<Client, String> gmailColumn;

    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;

    @FXML
    private GridPane clientsGridPane;

    @FXML
    private GridPane addClientGridPane;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

    private ObservableList<Client> clientData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        telefoneColumn.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        gmailColumn.setCellValueFactory(new PropertyValueFactory<>("gmail"));
        loadClientData();
    }

    private void loadClientData() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/example/salao/Clients.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 3) {
                    Client client = new Client(details[0], details[1], details[2]);
                    clientData.add(client);
                }
            }
            tableView.setItems(clientData);
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro de Leitura");
            alert.setHeaderText("Não foi possível carregar os dados dos clientes");
            alert.setContentText("Erro: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void handleSearch() {
        String searchText = searchField.getText().toLowerCase();
        ObservableList<Client> filteredData = FXCollections.observableArrayList();
        for (Client client : clientData) {
            if (client.getNome().toLowerCase().contains(searchText) ||
                    client.getTelefone().toLowerCase().contains(searchText) ||
                    client.getGmail().toLowerCase().contains(searchText)) {
                filteredData.add(client);
            }
        }
        tableView.setItems(filteredData);
    }

    @FXML
    private void handleClientesButtonClick() {
        clientsGridPane.setVisible(true);
    }

    @FXML
    private void handleSearchButtonClick() {
        // Método vazio por enquanto.
    }

    @FXML
    private void handleAddClientButtonClick() {
        addClientGridPane.setVisible(true);
    }

    @FXML
    private void handleAddClient() {
        String nome = nameField.getText();
        String telefone = phoneField.getText();
        String gmail = emailField.getText();

        if (nome.isEmpty() || telefone.isEmpty() || gmail.isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Campos Vazios");
            alert.setHeaderText("Todos os campos são obrigatórios");
            alert.setContentText("Por favor, preencha todos os campos");
            alert.showAndWait();
            return;
        }

        Client client = new Client(nome, telefone, gmail);
        clientData.add(client);
        tableView.setItems(clientData);

        try (FileWriter fw = new FileWriter("src/main/java/com/example/salao/Clients.txt", true)) {
            fw.write(nome + "," + telefone + "," + gmail + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro ao Adicionar Cliente");
            alert.setHeaderText("Não foi possível adicionar o cliente");
            alert.setContentText("Erro: " + e.getMessage());
            alert.showAndWait();
        }

        nameField.clear();
        phoneField.clear();
        emailField.clear();
        addClientGridPane.setVisible(false);
    }
}
