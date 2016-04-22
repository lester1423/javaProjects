// Assignment #: Assignment 7
//         Name: Jacob Lester
//	  StudentID: 100-23-7610
//	    Lecture: CSC 360
//      Section: 002
//  Description: creates interactive Sierpinski triangle

package assn7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Sierpinski extends Application {

	@Override
	public void start(Stage stage) {

		// Create border pane
		BorderPane borderPane = new BorderPane();

		// Create center pane for triangle
		TrianglePane trianglePane = new TrianglePane();
		borderPane.setCenter(trianglePane);

		// Create order control buttons
		Button orderDown = new Button("-");
		Button orderUp = new Button("+");

		orderDown.setOnMouseClicked(e -> {
			trianglePane.setOrder(-1);
			orderDown.setDisable(trianglePane.getOrder() == 0);
		});

		orderUp.setOnMouseClicked(e -> {
			trianglePane.setOrder(1);
			orderDown.setDisable(trianglePane.getOrder() == 0);
		});

		HBox btnBox = new HBox(10, orderDown, orderUp);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.setPadding(new Insets(10));
		borderPane.setBottom(btnBox);

		// Create scene for border pane, add to stage
		Scene scene = new Scene(borderPane, 600, 410);
		stage.setScene(scene);
		stage.show();
	}

	// Class for creating triangles and get/set order
	public static class TrianglePane extends Pane {
		private int order = 0;

		public TrianglePane() {}

		public int getOrder() {
			return order;
		}

		public void setOrder(int order) {
			this.order += order;
			makePoints();
		}

		// Creates points to use for making triangles
		protected void makePoints() {
			Point2D p1 = new Point2D(getWidth() / 2, 10);
			Point2D p2 = new Point2D(10, getHeight() - 10);
			Point2D p3 = new Point2D(getWidth() -10, getHeight() - 10);

			this.getChildren().clear();

			makeTriangle(order, p1, p2, p3);
		}

		// Makes sub-triangles using midpoints of larger triangles
		private void makeTriangle(int order, Point2D p1, Point2D p2, Point2D p3) {
			if (order == 0) {
				Polygon triangle = new Polygon();
				triangle.getPoints().addAll(
					p1.getX(), p1.getY(),
					p2.getX(), p2.getY(),
					p3.getX(), p3.getY());

				triangle.setFill(Color.WHITE);
				triangle.setStroke(Color.BLACK);
				this.getChildren().add(triangle);
			} else {
				Point2D p1_2 = p1.midpoint(p2);
				Point2D p2_3 = p2.midpoint(p3);
				Point2D p1_3 = p3.midpoint(p1);

				makeTriangle(order - 1, p1, p1_2, p1_3);
				makeTriangle(order - 1, p1_2, p2, p2_3);
				makeTriangle(order - 1, p1_3, p2_3, p3);
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
