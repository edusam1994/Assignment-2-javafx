package com.example.demo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private Text resultText;

    @FXML
    private void searchMovie() {
        String apiKey = " f218e9e7"; // Replace with your OMDb API key
        String movieTitle = searchField.getText().trim();

        if (!movieTitle.isEmpty()) {
            String apiUrl = "http://www.omdbapi.com/?apikey=" + apiKey + "&t=" + movieTitle;

            try {
                String jsonResponse = OMDbApiUtil.fetchDataFromAPI(apiUrl);
                String movieInfo = OMDbApiUtil.parseJson(jsonResponse);
                resultText.setText(movieInfo);
            } catch (Exception e) {
                e.printStackTrace();
                resultText.setText("Error fetching movie data");
            }
        }
    }
}
