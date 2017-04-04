package tp0.view;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import tp0.vm.StudentViewModel;

@SuppressWarnings("serial")
public class StudentView extends Dialog<StudentViewModel> {
	
	private Panel mainPanel;
	private final int LABEL_WIDTH = 60;
	private final int TEXTBOX_WIDTH = 180;
	
	public StudentView(WindowOwner owner) {
		super(owner, new StudentViewModel());
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.mainPanel = mainPanel;
		setTitle("Datos del alumno");
		
		createFormElement("Legajo", "code");
		createFormElement("Nombre", "first_name");
		createFormElement("Apellido", "last_name");
		createFormElement("GitHub", "github_user");
	}
	
	private void createFormElement(String label, String property) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new HorizontalLayout());
		new Label(form).setText(label).setWidth(LABEL_WIDTH);
		new TextBox(form).setWidth(TEXTBOX_WIDTH).bindValueToProperty(property);
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel).setCaption("Cancelar").onClick(this::cancel);
		new Label(actionsPanel).setWidth(new Double(TEXTBOX_WIDTH / 2.5).intValue());
		new Button(actionsPanel).setCaption("Guardar").onClick(this::accept).setAsDefault();
	}
	
	@Override
	public void accept() {
		if(getModelObject().saveStudent()) {
			showInfo("Datos del alumno actualizados.");
			super.accept();
		} else {
			showError("Ocurrió un error al intentar actualizar los datos del alumno.");
		}
	}

}
