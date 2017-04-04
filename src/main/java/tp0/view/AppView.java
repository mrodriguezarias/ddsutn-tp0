package tp0.view;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import tp0.Settings;
import tp0.vm.AppViewModel;

@SuppressWarnings("serial")
public class AppView extends SimpleWindow<AppViewModel> {
	
	public AppView(WindowOwner parent) {
		super(parent, new AppViewModel());
	}

	@Override
	protected void createFormPanel(Panel formPanel) {
		setTitle("Lector de notas");
		
		if(Settings.get("token") == null) {
			new TokenView(this).open();
		} else {
			drawUI(formPanel);
		}
	}
	
	public void drawUI(Panel panel) {
		// TODO
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel).setCaption("Actualizar datos").onClick(() -> new StudentView(this).open());
		new Button(actionsPanel).setCaption("Cambiar alumno").onClick(() -> new TokenView(this).open());
	}
	
}
