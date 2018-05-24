package com.company;

import com.company.UILayer.ConnectionClient;
import com.company.UILayer.ConsoleSock;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
       ConnectionClient client = new ConnectionClient("localhost",7000);
	   ProxyModel prModel = new ProxyModel(client);
       ConsoleSock console = new ConsoleSock(prModel);
       console.mainMenu();
    }
}
