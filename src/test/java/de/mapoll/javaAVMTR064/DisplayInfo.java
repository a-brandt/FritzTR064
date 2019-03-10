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

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisplayInfo {

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

		fc.printInfo();
	}
}
