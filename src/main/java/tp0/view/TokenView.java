package tp0.view;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import tp0.vm.TokenViewModel;

@SuppressWarnings("serial")
public class TokenView extends Dialog<TokenViewModel> {
	
	public TokenView(WindowOwner owner) {
		super(owner, new TokenViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		setTitle("Cambiar alumno");
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Ingresar token del alumno:");
		new TextBox(form).setWidth(150).bindValueToProperty("token");
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		Label errorLabel = new Label(actionsPanel);
		errorLabel.setWidth(actionsPanel.getWidth());
		errorLabel.bindValueToProperty("message");
		new Button(actionsPanel).setCaption("Aceptar").onClick(this::accept).setAsDefault();
	}
	
	@Override
	public void accept() {
		if(getModelObject().saveToken()) {
			super.accept();
		}
	}
	
}
