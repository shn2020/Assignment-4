import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.event.*;

public class LogIn extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	public static boolean vA = false;
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Sign Up");
		GridPane gPane = new GridPane();
		gPane.setAlignment(Pos.TOP_LEFT);
		gPane.setHgap(10);
		gPane.setVgap(10);
		gPane.setPadding(new Insets(10,10,10,10));
		
		// Set Font
		Text sceneTitle = new Text("Sign Up");
		sceneTitle.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
		gPane.add(sceneTitle, 0, 0, 2, 1);
		
		// Set sign up button
		Button btSignUp = new Button ("Sign up");
		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(btSignUp);
		gPane.add(hBox,2,8);
		
		Label name = new Label("Name");
		Label lastname = new Label("Last name");
		Label email = new Label("Email");
		Label username = new Label("Username");
		Label password = new Label("Password");
		Label cpassword = new Label("Confirm Password");
		Label accounttype = new Label("Account Type");
		
		gPane.add(name, 0, 1);
		gPane.add(lastname, 0, 2);
		gPane.add(email, 0, 3);
		gPane.add(username, 0, 4);	
		gPane.add(password, 0, 5);
		gPane.add(cpassword, 0, 6);
		gPane.add(accounttype, 0, 7);
		
		TextField tfname = new TextField();
		TextField tflastname = new TextField();
		TextField tfemail = new TextField();
		TextField tfusername = new TextField();
		PasswordField pfpassword = new PasswordField();
		PasswordField pfcpassword = new PasswordField();
		ComboBox cbaccounttype = new ComboBox();
		String[] at = {"Administrator", "Faculty", "Student", "Staff", "Guest"};
		cbaccounttype.getItems().addAll(at);
		
		
		gPane.add(tfname, 1, 1);
		gPane.add(tflastname, 1, 2);
		gPane.add(tfemail, 1, 3);
		gPane.add(tfusername, 1, 4);
		gPane.add(pfpassword, 1, 5);
		gPane.add(pfcpassword, 1, 6);
		gPane.add(cbaccounttype, 1, 7);
		
		Text btxtname = new Text();
		Text btxtlastname = new Text();
		Text btxtemail = new Text();
		Text btxtusername = new Text();
		Text btxtpassword = new Text();
		Text btxtcpassword = new Text();
		Text txtpwlength = new Text();
		Text txtsamepassword = new Text();
		Text btxtaccounttype = new Text();
		
		gPane.add(btxtname, 2,1);
		gPane.add(btxtlastname, 2,2);
		gPane.add(btxtemail, 2,3);
		gPane.add(btxtusername, 2,4);
		gPane.add(btxtpassword, 2,5);
		gPane.add(btxtcpassword, 2,6);
		gPane.add(txtpwlength,2,5);
		gPane.add(txtsamepassword,2,6);
		gPane.add(btxtaccounttype,2,7);
		
		Scene scene = new Scene(gPane,500,500);
		primaryStage.setTitle("Sign up");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		/**
		 * Initialize action for Sign Up button
		 */
	
		btSignUp.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				vA = true;
				if (blankName()) {
					btxtname.setText("Name can not be blank");
					btxtname.setFill(Color.RED);
					vA = false;
				}
				else btxtname.setText("");
				
				if (blankLastName()) {
					btxtlastname.setText("Last name can not be blank");
					btxtlastname.setFill(Color.RED);
					vA = false;
				}	
				else btxtlastname.setText("");
				
				if (blankEmail()) {
					btxtemail.setText("Email can not be blank");
					btxtemail.setFill(Color.RED);
					vA = false;
				}	
				else btxtemail.setText("");
				
				if (blankUserName()) {
					btxtusername.setText("Username can not be blank");
					btxtusername.setFill(Color.RED);
					vA = false;
				}	
				else {
					btxtusername.setText("");
					if (casesensitiveUserName()) {
						btxtusername.setText("Username is case sensitive");
						btxtusername.setFill(Color.RED);
						vA= false;
					}
					else btxtusername.setText("");
				}
				
				if (blankPassword()) {
					btxtpassword.setText("Password can not be blank");
					btxtpassword.setFill(Color.RED);
					vA = false;
				}	
				else {
					btxtpassword.setText("");
					if (lengthPassword()) {
						btxtpassword.setText("Password must contain at least 8 characters");
						btxtpassword.setFill(Color.RED);
						vA = false;
					}
					else {
						btxtpassword.setText("");
						if (!strongPassword()) {
							btxtpassword.setText("Password is not strong enough");
							btxtpassword.setFill(Color.RED);
							vA = false;
						}
						else btxtpassword.setText("");
					}
					
				}
				
				if (blankConfirmPassword()) {
					btxtcpassword.setText("Confirm password can not be blank");
					btxtcpassword.setFill(Color.RED);
					vA = false;
				}	
				else btxtcpassword.setText("");
					
				if (!samePassword() && !blankPassword() && !blankConfirmPassword()) {
					txtsamepassword.setText("Wrong confirm password");
					txtsamepassword.setFill(Color.RED);
					vA = false;
				}	
				else txtsamepassword.setText("");
				
				if (!validEmail() && !blankEmail()) {
					btxtemail.setText("Email must be this format: xxxx@xxx.xxx");
					btxtemail.setFill(Color.RED);
					vA = false;
				}
				else btxtemail.setFill(Color.RED);
				
				if (blankAccountType()) {
					btxtaccounttype.setText("Choose account type");
					btxtaccounttype.setFill(Color.RED);
					vA = false;
				}
				else btxtaccounttype.setText("");
				
				if (vA) {
					String strat;
					if (cbaccounttype.getValue() == "Administrator") strat = "Administrator";
					else if (cbaccounttype.getValue() == "Faculty") strat = "Faculty";
					else if (cbaccounttype.getValue() == "Student") strat = "Student";
					else if (cbaccounttype.getValue() == "Staff") strat = "Staff";
					else strat = "Guest";
					
					User user = new User(tfusername.getText(),pfpassword.getText(),strat);
					System.out.println(user.toString());
				}
			}
			
			public boolean blankName() {
				return tfname.getText().trim().equals("");
			}
			
			public boolean blankLastName() {
				return tflastname.getText().trim().equals("");
			}
			
			public boolean blankEmail() {
				return tfemail.getText().trim().equals("");
			}
			
			public boolean validEmail() {
				String email = tfemail.getText().trim();
				return (email.indexOf('@') != -1 && email.indexOf('.') != -1 && email.indexOf('@') < email.indexOf('.')); 
			}
			
			public boolean blankUserName() {
				return tfusername.getText().trim().equals("");
			}
			public boolean casesensitiveUserName() {
				return tfusername.getText().matches(".*[A-Z].*");
			}
			
			public boolean blankPassword() {
				return pfpassword.getText().trim().equals("");
			}
			
			public boolean strongPassword() {
				String pw = pfpassword.getText();
				return pw.matches(".*[a-z].*") &&
					   pw.matches(".*[A-Z].*") &&
					   pw.matches(".*[0-9].*") &&
					   pw.matches(".*[~,!,@,#,$,%,^,&,*,_,-,+,=,`,|,(,),{,},[,],:,;,',<,>,.,?,/].*"); 
			}
			
			public boolean lengthPassword() {
				return pfpassword.getText().length() < 8;
			}
			
			public boolean blankConfirmPassword() {
				return pfcpassword.getText().trim().equals("");
			}
			
			public boolean samePassword() {
				return pfcpassword.getText().equals(pfpassword.getText());
			}
			
			public boolean blankAccountType() {
				return (cbaccounttype.getValue() == null);
			}
		
		});

		
	}

}