package de.mapoll.javaAVMTR064;

/***********************************************************************************************************************
*
* javaAVMTR064 - open source Java TR-064 API
*===========================================
*
* Copyright 2019 a-brandt
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
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.mapoll.javaAVMTR064.beans.RootList;

public class GetAllHosts {

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

		// get "Hosts:" services
		Set<String> hostsServices = new HashSet<>();
		for (var name : fc.getServices().keySet()) {
			// logger.info("Service: " + name);

			if (name.startsWith("Hosts:")) {
				hostsServices.add(name);
			}
		}

		for (String name : hostsServices) {

			logger.info("Service: " + name);
			Service service = fc.getService(name);
			Action action = service.getAction("X_AVM-DE_GetHostListPath");

			Response response1 = null;
			try {
				// Execute the action without any In-Parameter.
				response1 = action.execute();
			} catch (UnsupportedOperationException | IOException e1) {
				logger.error("got Exception", e1);
			}

			// logger.info("response1: " + response1);
			// logger.info("data:");

			logger.info("response data (key -> value):");
			for (var x : response1.getData().entrySet()) {
				logger.info("{} -> {}", x.getKey(), x.getValue());
			}

			// key NewX_AVM-DE_HostListPath contains a link to a xml file
			try {
				InputStream is = fc.getXMLIS(response1.getData().get("NewX_AVM-DE_HostListPath"));

				JAXBContext jaxbContext = JAXBContext.newInstance(RootList.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				RootList root = (RootList) jaxbUnmarshaller.unmarshal(is);

				// String result = new BufferedReader(new
				// InputStreamReader(is)).lines().collect(Collectors.joining("\n"));

				if (root != null && root.getItems() != null) {
					for (var item : root.getItems()) {
						logger.info("{} {} {} {} {}", item.getIndex(), item.getMacAddress(), item.getIpAddress(),
								item.getHostName(), item.getInterfaceType());
					}
				}

				logger.info("result: {}", root);

			} catch (UnsupportedOperationException | IOException | JAXBException e1) {
				logger.error("got Exception", e1);
			}

		}

	}

}
