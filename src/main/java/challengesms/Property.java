package challengesms;

import java.io.IOException;
import java.util.Properties;

public class Property {
	private Properties config;
	
	private Properties getConfig() {
		if (this.config == null) {
			config = new Properties();
			try {
				config.load(Property.class.getResourceAsStream("/config.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.config;
	}
	

	public Double getDouble(String key) {
		return Double.valueOf((String)getConfig().get(key));
	}

}
