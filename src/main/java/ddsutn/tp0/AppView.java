package ddsutn.tp0;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
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
	}
	
	public static void main(String[] args) {
		new AppView().startApplication();
	}
}
