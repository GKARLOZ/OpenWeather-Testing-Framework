package com.giancodes;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class SetUp{

        @BeforeSuite
        public void startDockerGrid() throws IOException, InterruptedException {

            Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");
            Thread.sleep(15000);
        }

        @AfterSuite
        public void stopDockerGrid() throws IOException, InterruptedException{
            Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
//        Thread.sleep(9000);

//        Runtime.getRuntime().exec("taskkill /f /im cmd.exe");//closes command prompt
        }


}
