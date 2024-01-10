package com.giancodes;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

//The Setup class sets up the Selenium Grid using the Docker Compose file.
//The methods below will run the command on the cmd and create containers with different browsers.
public class SetUp{

        @BeforeSuite(description = "The methods below will run the command on the cmd and create containers with different browsers.")
        public void startDockerGrid() throws IOException, InterruptedException {

            Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");
            Thread.sleep(15000);
        }

        @AfterSuite(description = " this method ends and closes all the containers. ")
        public void stopDockerGrid() throws IOException, InterruptedException{
            Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
//        Thread.sleep(9000);

//        Runtime.getRuntime().exec("taskkill /f /im cmd.exe");//closes command prompt
        }


}
