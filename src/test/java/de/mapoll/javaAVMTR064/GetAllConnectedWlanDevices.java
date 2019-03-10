package de.mapoll.javaAVMTR064;
/***********************************************************************************************************************
*
* javaAVMTR064 - open source Java TR-064 API
*===========================================
*
* Copyright 2015 Marin Pollmann <pollmann.m@gmail.com>
* 
*
***********************************************************************************************************************
*
* Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
* an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
* specific language governing permissions and limitations under the License.
*
***********************************************************************************************************************/

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAllConnectedWlanDevices {

	private static final Logger logger = LoggerFactory.getLogger(DisplayInfo.class);

	static String ip = "192.168.168.1";
	static String user = "admin"; // admin is the default user
	static String password = "";

	public static void main(String[] args) {

		logger.info("starting....");

		// Create a new FritzConnection with username and password
		FritzConnection fc = new FritzConnection(ip, user, password);
		try {
			// The connection has to be initiated. This will load the tr64desc.xml
			// respectively igddesc.xml
			// and all the defined Services and Actions.
			fc.init();
		} catch (IOException | JAXBException ex) {
			logger.error("got JAXBException", ex);
			System.exit(1);
		}

		// get all "WLANConfiguration:" services
		Set<String> wlanServices = new HashSet<>();
		for (var name : fc.getServices().keySet()) {
			// logger.info("Service: " + name);

			if (name.startsWith("WLANConfiguration:")) {
				wlanServices.add(name);
			}
		}

		for (String name : wlanServices) {
			// Get the Service. In this case WLANConfiguration:X
			Service service = fc.getService(name);

			// Get the Action. in this case GetTotalAssociations
			Action action = service.getAction("GetTotalAssociations");

			Response response1 = null;
			try {
				// Execute the action without any In-Parameter.
				response1 = action.execute();
			} catch (UnsupportedOperationException | IOException e1) {
				logger.error("got Exception", e1);
			}

			int deviceCount = -1;
			try {
				// Get the value from the field NewTotalAssociations as an integer. Values can
				// have the Types: String, Integer, Boolean, DateTime and UUID
				deviceCount = response1.getValueAsInteger("NewTotalAssociations");
			} catch (ClassCastException | NoSuchFieldException e1) {
				logger.error("got Exception", e1);
			}

			logger.info("WLAN [{}] has [{}] devices", name, deviceCount);

			for (int j = 0; j < deviceCount; j++) {
				// Create a map for the arguments of an action. You have to do this, if the
				// action has IN-Parameters.
				HashMap<String, Object> arguments = new HashMap<String, Object>();
				// Set the argument NewAssociatedDeviceIndex to an integer value.
				arguments.put("NewAssociatedDeviceIndex", j);
				try {
					Response response2 = fc.getService(name).getAction("GetGenericAssociatedDeviceInfo")
							.execute(arguments);
					logger.info("    {}: {}", j, response2.getData());
				} catch (IOException e) {
					logger.error("got Exception", e);
				}

			}

		}

	}

}
