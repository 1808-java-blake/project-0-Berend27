package com.Project0.bean;

import com.Project0.screens.Screen;
import com.Project0.screens.StartScreen;

public class ZeroLauncher {
	public static void main(String[] args) {
		Screen s = new StartScreen();
		while(s.on == true) {
			s = s.start();
		}
	}
}


