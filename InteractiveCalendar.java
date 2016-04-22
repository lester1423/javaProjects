// Assignment #: Assignment 6
//         Name: Jacob Lester
//	  StudentID: 100-23-7610
//	    Lecture: CSC 360
//      Section: 002
//  Description: creates interactive calendar with JavaFX

package assn6;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InteractiveCalendar extends Application {
	BorderPane borderPane = new BorderPane();
	Calendar calendar;
	@Override
	public void start(Stage stage) {
		// Set center of border pane (calendar)
		borderPane.setCenter(makeCalendar(2016, 2));


		// Set bottom of border pane (month controls)
		Button prevMonth = new Button("Prior");
		Button nextMonth = new Button("Next");
		prevMonth.setOnMouseClicked(e -> {
			borderPane.setCenter(makeCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) -2));
		});
		nextMonth.setOnMouseClicked(e -> {
			borderPane.setCenter(makeCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)));
		});
		HBox buttonBox = new HBox(15);
		buttonBox.getChildren().addAll(prevMonth, nextMonth);
		buttonBox.setPadding(new Insets(15, 15, 15, 15));
		buttonBox.setAlignment(Pos.CENTER);
		borderPane.setBottom(buttonBox);

		// Add border pane to scene, scene to stage, and show the stage
		Scene scene = new Scene(borderPane, 500, 350);
		stage.setScene(scene);
		stage.show();

	}
	public GridPane makeCalendar(int year, int month) {
		calendar = new GregorianCalendar(year, month, 1);

		// Set top of border pane (current moth)
		Text currentMonth = new Text(monthName(month) + ", " + year);
		borderPane.setTop(currentMonth);
		BorderPane.setAlignment(currentMonth, Pos.CENTER);
		BorderPane.setMargin(currentMonth, new Insets(15, 15, 15, 15));

		// Make calendar as a GridPane
		GridPane gridPane = new GridPane();
		gridPane.add(new Text("Sun"), 1, 0);
		gridPane.add(new Text("Mon"), 2, 0);
		gridPane.add(new Text("Tue"), 3, 0);
		gridPane.add(new Text("Wed"), 4, 0);
		gridPane.add(new Text("Thu"), 5, 0);
		gridPane.add(new Text("Fri"), 6, 0);
		gridPane.add(new Text("Sat"), 7, 0);
		for(int i=0; i<7; i++) {
			ColumnConstraints column = new ColumnConstraints();
		    column.setPercentWidth(10);
		    gridPane.getColumnConstraints().add(column);
		}
		if(calendar.get(Calendar.DAY_OF_WEEK) != 0) {
			for(int i=calendar.get(Calendar.DAY_OF_WEEK) - 1; i>0; i--) {
				Calendar prevMonth = new GregorianCalendar(year, month - 1, 1);
				Text prevMonthDays = new Text("" + (prevMonth.getActualMaximum(Calendar.DATE) - calendar.get(Calendar.DAY_OF_WEEK) + i + 1));
				prevMonthDays.setFill(Color.GRAY);
				gridPane.add(prevMonthDays, i, 1);
			}

		}
		/* for all weeks of month
				for current DAY_OF_WEEK -> 7
						grid.add(current date, column DAY_OF_WEEK, row WEEK_OF_MONTH);
						update calendar to next day

			*/
		for (int i=calendar.get(Calendar.WEEK_OF_MONTH); i<= calendar.getActualMaximum(Calendar.WEEK_OF_MONTH); i++) {
			for(int j=calendar.get(Calendar.DAY_OF_WEEK); j<=calendar.getActualMaximum(Calendar.DAY_OF_WEEK); j++)  {
				Text dayNum = new Text("" + calendar.get(Calendar.DATE));
				if (calendar.get(Calendar.MONTH) != month) {
					dayNum.setFill(Color.GRAY);
				}
				gridPane.add(dayNum, j, i);
				calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE) + 1);
			}
		}
		gridPane.setHgap(20);
		gridPane.setVgap(20);

		return gridPane;
	}

	public String monthName (int month) {
		switch(month) {
			case 0: return "January";
			case 1: return "February";
			case 2: return "March";
			case 3: return "April";
			case 4: return "May";
			case 5: return "June";
			case 6: return "July";
			case 7: return "August";
			case 8: return "September";
			case 9: return "October";
			case 10: return "November";
			case 11: return "December";
			default: return null;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
