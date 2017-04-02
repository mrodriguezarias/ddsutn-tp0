package ddsutn.tp0;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;

@SuppressWarnings("serial")
public class AppView extends MainWindow<AppViewModel> {
	
	public AppView() {
		super(new AppViewModel());
	}

	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Student Grades");
		mainPanel.setLayout(new VerticalLayout());
		new Label(mainPanel).setText(">>>>>>> Bonjour le monde ! <<<<<<<");
		
		new Label(mainPanel).setText("Ingresar token de alumno:");
		Control nombre = new TextBox(mainPanel).setWidth(200);
		
		new Button(mainPanel).setCaption("Buscar").onClick(this::searchStudent).setAsDefault();
	}
	
//	@Override
//	public void addActions(Panel mainPanel){
//	
//		new Label(mainPanel)
//		.setText("Ingresar token de alumno:");
//		
//		Control nombre = new TextBox(mainPanel);
//		nombre.setWidth(200);
//	}
	
	public static void main(String[] args) {
		new AppView().startApplication();
	}
	
	public void searchStudent(){
		
	}
	
}
