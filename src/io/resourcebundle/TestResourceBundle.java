package io.resourcebundle;

import java.util.ResourceBundle;

public class TestResourceBundle {

	
	public static void main(String[] args) {
		String str = "common";
		ResourceBundle rb = ResourceBundle.getBundle(str);
		System.out.println(rb.keySet());
		System.out.println(rb.getString("IndexAt1Starts"));
	}
}
