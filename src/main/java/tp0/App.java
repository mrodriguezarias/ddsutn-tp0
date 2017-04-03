package tp0;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import tp0.view.AppView;

public class App extends Application {

	@Override
	protected Window<?> createMainWindow() {
		return new AppView(this);
	}
	
	public static void main(String[] args) {
		new App().start();
	}
}
