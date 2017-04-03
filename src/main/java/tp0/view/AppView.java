package tp0.view;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import tp0.vm.AppViewModel;

@SuppressWarnings("serial")
public class AppView extends SimpleWindow<AppViewModel> {
	
	public AppView(WindowOwner parent) {
		super(parent, new AppViewModel());
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel).setCaption("Cambiar alumno").onClick(this::openTokenDialog);
	}

	@Override
	protected void createFormPanel(Panel formPanel) {
		setTitle("Lector de notas");
		
		if(!getModelObject().tokenIsSet()) {
			openTokenDialog();
		} else {
			drawUI(formPanel);
		}
	}
	
	public void drawUI(Panel panel) {
		new Button(panel).setCaption("Buscar").onClick(getModelObject()::searchStudent).setAsDefault();
		new Label(panel).bindValueToProperty("student");
	}
	
	private void openTokenDialog() {
		Dialog<?> dialog = new TokenView(this);
		dialog.open();
		dialog.onAccept(() -> {});
	}
	
}