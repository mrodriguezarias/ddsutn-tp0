package tp0;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import tp0.view.AssignmentView;

public class App extends Application {

	@Override
	protected Window<?> createMainWindow() {
		return new AssignmentView(this);
	}
	
	public static void main(String[] args) {
		new App().start();
	}
}
