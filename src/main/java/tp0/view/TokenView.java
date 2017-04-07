package tp0.view;

import org.uqbar.arena.widgets.Label;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import tp0.Settings;
import tp0.vm.TokenViewModel;

@SuppressWarnings("serial")
public class TokenView extends Dialog<TokenViewModel> {
	
	private final int TEXTBOX_WIDTH = 150;
	
	public TokenView(WindowOwner owner) {
		super(owner, new TokenViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		String cond = Settings.isSet("token") ? "Cambiar" : "Nuevo";
		setTitle(cond + " alumno");
		
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Ingresar token del alumno:");
		new TextBox(form).setWidth(TEXTBOX_WIDTH).bindValueToProperty("token");
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel).setCaption("Cancelar").onClick(this::cancel);
		new Label(actionsPanel).setWidth(TEXTBOX_WIDTH);
		new Button(actionsPanel).setCaption("Aceptar").onClick(this::accept).setAsDefault();
	}
	
	@Override
	public void accept() {
		if(getModelObject().saveToken()) {
			try {
				StudentView studentView = (StudentView) getOwner();
				studentView.getModelObject().updateStudent();
				AssignmentView assignmentView = (AssignmentView) studentView.getOwner();
				assignmentView.getModelObject().updateAssignments();
			} catch(ClassCastException e) {}
			super.accept();
		} else {
			showError("Error: token inválido.");
		}
	}
	
	@Override
	public void close() {
		if(!Settings.isSet("token")) {
			System.exit(0);
		}
		super.close();
	}
	
}
