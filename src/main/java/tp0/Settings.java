package tp0;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public final class Settings {
	
	private static Properties properties;
	
	private static final String RESOURCES_DIR = Settings.class.getClassLoader().getResource("").getPath();
	private static final String CONFIG_FILENAME = "config.properties";
	
	private enum Mode { INPUT, OUTPUT };
	
	private static Object getConfigFile(Mode mode) {
		Object config = null;
		
		try {
			File file = new File(RESOURCES_DIR + CONFIG_FILENAME);
			
			if(!file.exists()) {
				file.createNewFile();
			}
			
			if(mode == Mode.INPUT) {
				config = new FileInputStream(file);
			} else {
				config = new FileOutputStream(file);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return config;
	}
	
	private static Properties getPropertiesObject() {
		if(properties == null) {
			properties = new Properties();
			
			try {
				properties.load((InputStream) getConfigFile(Mode.INPUT));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return properties;
	}
	
	public static void set(String key, String value) {
		getPropertiesObject().setProperty(key, value);
		
		try {
			getPropertiesObject().store((OutputStream) getConfigFile(Mode.OUTPUT), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String key) {
		return getPropertiesObject().getProperty(key);
	}
	
	public static boolean isSet(String key) {
		String value = get(key);
		return value != null && !value.isEmpty();
	}
}
