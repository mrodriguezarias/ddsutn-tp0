package tp0.view;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import tp0.Settings;
import tp0.model.Assignment;
import tp0.vm.AssignmentViewModel;

@SuppressWarnings("serial")
public class AssignmentView extends SimpleWindow<AssignmentViewModel> {
	
	public AssignmentView(WindowOwner parent) {
		super(parent, new AssignmentViewModel());
	}

	@Override
	protected void createFormPanel(Panel formPanel) {
		setTitle("Lector de notas");
		
		if(!Settings.isSet("token")) {
			new TokenView(this).open();
		}
		
		getModelObject().updateAssignments();
		drawTable(formPanel);
	}
	
	private void drawTable(Panel panel) {
		Table<Assignment> table = new Table<>(panel, Assignment.class);
		table.setNumberVisibleRows(12);
		table.bindItemsToProperty("assignments");
		
		createColumn("ID", "id", 40, table);
		createColumn("Título", "title", 140, table);
		createColumn("Descripción", "description", 200, table);
		createColumn("Notas", "gradesString", 120, table);
		createColumn("Promedio", "average", 70, table);
		createColumn("Estado", "status", 80, table);
	}
	
	private void createColumn(String title, String property, int length, Table<Assignment> table) {
		Column<Assignment> column = new Column<>(table);
		column.setTitle(title);
		column.setFixedSize(length);
		column.bindContentsToProperty(property);
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel).setCaption("Actualizar asignaciones").onClick(() -> getModelObject().updateAssignments());
		new Button(actionsPanel).setCaption("Ver datos del alumno").onClick(() -> new StudentView(this).open());
	}
	
}
