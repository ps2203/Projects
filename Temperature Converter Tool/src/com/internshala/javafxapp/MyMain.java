package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Optional;


public class MyMain extends Application {

	public static void main(String[] args) {
		System.out.println("main");
		launch(args);
	}

	@Override
	public void init() throws Exception {
		super.init();
		System.out.println("init"); //Initialize Application
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		System.out.println("Start");  //Starts an application by calling a method primaryStage.show()

		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0, menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show(); //Method allow the application visible to user

	}

	private MenuBar createMenu() {

		//File Menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(event -> {
			System.out.println("New Menu Item Clicked");
			//More Code...
		});

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> System.exit(0));

		fileMenu.getItems().addAll(newMenuItem , separatorMenuItem, quitMenuItem);

		//Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");

		aboutApp.setOnAction(event -> aboutApp());

		helpMenu.getItems().addAll(aboutApp);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu , helpMenu);
		return menuBar;
	}

	public static void aboutApp() {

		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop App");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("I am just a beginner but soon I will be pro and start developing applications");

		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

		Optional<ButtonType> clickedBtn;
		clickedBtn = alertDialog.showAndWait();

		if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
			System.out.println("Yes Button Clicked");
		}
		else {
			System.out.println("No Button Clicked");
		}
	}

	@Override
	public void stop() throws Exception {

		System.out.println("Stop"); //Called when application is stopped and is about to shut down
		super.stop();
	}
}


/* Parts of java lifecycle methods
1. init
2. start
3. stop

main method is not a part of java lifecycle
 */
