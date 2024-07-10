package com.example.canvastutorial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static final double EARTH_RADIUS = 6371;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Canvas tutorial");
        stage.setScene(scene);
        stage.show();
        double value = 23.4;
        int x = 7;
        System.out.println(value / x);
        double lat1 = 126.66648780; // Latitude of the first point in degrees
        double lon1 = 37.37680667; // Longitude of the first point in degrees
        double lat2 = 126.6673500; // Latitude of the second point in degrees
        double lon2 = 37.37547900;  // Longitude of the second point in degrees

        double distance = calculateHaversineDistance(lat1, lon1, lat2, lon2);

        System.out.println("Distance: " + distance + " km");
    }

    public static void main(String[] args) {
        launch();
    }


    public static double calculateHaversineDistance(double lat1, double lon1, double lat2, double lon2) {
        // Convert degrees to radians
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;

        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.asin(Math.sqrt(a));

        // Calculate the distance
        double distance = EARTH_RADIUS * c;

        return distance;
    }
}