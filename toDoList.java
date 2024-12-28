/*
Filename: ToDoList.java
Author: J. Graham
Date: May 29, 2024
Purpose: A program that is a simple digital To Do list with a GUI using JavaFX.
*/

// Imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class toDoList extends Application {

   // TextArea to display the to-do list and ArrayList to store the list items
   private TextArea textArea;
   private ArrayList<String> items;

   public static void main(String[] args) {
      // Launch the JavaFX application
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) {
      // Set the title of the application window
      primaryStage.setTitle("Jacob's To Do List");

      // Initialize the TextArea and set the properties
      textArea = new TextArea();

      // Make it read-only
      textArea.setEditable(false);

      // Set preferred height
      textArea.setPrefHeight(400);
      // Initialize the ArrayList to store to-do list items
      items = new ArrayList<>();

      // Load existing to-do list from file
      loadToDoList();

      // Created buttons for adding and removing items
      Button addButton = new Button("Add");

      // Action to add items when clicked
      addButton.setOnAction(e -> addItem()); 

      Button removeButton = new Button("Remove");
      removeButton.setOnAction(e -> removeItem()); // Action to remove items when clicked

      // Layout for the buttons
      HBox buttonBox = new HBox(10); // Horizontal box with spacing
      buttonBox.getChildren().addAll(addButton, removeButton);

      // Main layout with vertical arrangement
      VBox layout = new VBox(10); // Vertical box with spacing
      layout.setPadding(new Insets(20)); // Set padding
      layout.getChildren().addAll(textArea, buttonBox);

      // Creates and sets the scene
      Scene scene = new Scene(layout, 400, 450);
      primaryStage.setScene(scene);
      primaryStage.show();

      // Styles for the application
      layout.setStyle("-fx-background-color: Teal;"); // Teal background

      // Hover effect for addButton

      // Green background with blue text on hover
      addButton.setOnMouseEntered(e -> addButton.setStyle("-fx-background-color: #00ff00; -fx-text-fill: #0000ff;")); 

      // Reset style on exit
      addButton.setOnMouseExited(e -> addButton.setStyle("-fx-background-color: LightGrey; -fx-text-fill: Black;")); 

      // Hover effect for removeButton

      // Red background with white text on hover
      removeButton.setOnMouseEntered(e -> removeButton.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff;")); 

      // Reset style on exit
      removeButton.setOnMouseExited(e -> removeButton.setStyle("-fx-background-color: LightGrey; -fx-text-fill: Black;")); 
   }

   // Load to-do list items from file
   private void loadToDoList() {
      // Clears the TextArea
      textArea.clear(); 
      
      // Clears the ArrayList
      items.clear(); 
      try {
         File toDoList = new File("toDoList.txt");
         Scanner myReader = new Scanner(toDoList);
         while (myReader.hasNextLine()) {
            String data = myReader.nextLine();

            // Add item to the ArrayList
            items.add(data); 

            // Display item in the TextArea
            textArea.appendText(data + "\n"); 
         }
         myReader.close();
      } catch (FileNotFoundException e) {
        // Message if file doesn't exist
         textArea.setText("No to-do list found."); 
      }
   }

   // Add a new item to the to-do list
   private void addItem() {
      // Dialog box to input new item
      TextInputDialog dialog = new TextInputDialog(); 
      dialog.setTitle("Add To Your To Do List");
      dialog.setHeaderText("Add a new item to your To Do list");
      dialog.setContentText("Enter what you would like to add to your To Do List:");

      dialog.showAndWait().ifPresent(
         item -> {
            // Add item to the ArrayList with formatting
            items.add("-" + item); 

            // Display item in the TextArea
            textArea.appendText("-" + item + "\n"); 

            // Save updated list to file
            saveToDoList(); 
         });
   }

   // Remove an item from the to-do list
   private void removeItem() {
    // Dialog box to input an item to remove
      TextInputDialog dialog = new TextInputDialog();
      dialog.setTitle("Remove Item From your To Do List");
      dialog.setHeaderText("Remove an item from your To Do List");
      dialog.setContentText("Enter what you wish to remove:");

      dialog.showAndWait().ifPresent(
         item -> {
            // Tries to remove the item
            boolean removed = items.remove("-" + item); 
            if (removed) {
               // Clear the TextArea
               textArea.clear(); 
               for (String listItem : items) {
                  // Updates the display
                  textArea.appendText(listItem + "\n"); 
               }
               // Saves the updated list to the toDoList file
               saveToDoList(); 
               // Shows a success message
               showAlert("Success", "Item removed successfully!"); 
            } else {
                // Shows an error message
               showAlert("Error", "Item not found!"); 
            }
         });
   }

   // Save the to-do list to a file
   private void saveToDoList() {
      try {
         FileWriter myWriter = new FileWriter("toDoList.txt");
         for (String item : items) {
            // Writes each item to the file
            myWriter.write(item + System.lineSeparator()); 
         }
         myWriter.close();
      } catch (IOException e) {
        // Shows an error message if the save fails
         showAlert("Error", "An error occurred while saving the to-do list."); 
         e.printStackTrace();
      }
   }

   private void showAlert(String title, String message) {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle(title); 
      alert.setHeaderText(null); 
      alert.setContentText(message);
      alert.showAndWait();
   }
}
