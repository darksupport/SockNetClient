package com.company;

import com.company.ModelLayer.ISock;
import com.company.ModelLayer.ISockModel;
import com.company.ModelLayer.SockData;
import com.company.UILayer.ConnectionClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brainacad4 on 24.05.2018.
 */
public class ProxyModel implements ISockModel {

    ConnectionClient client;
    public ProxyModel(ConnectionClient client)
    {
        this.client = client;
    }
    @Override
    public List<ISock> getAllSocks() {
        List<ISock> result = new ArrayList<>();
        client.write("showAll");
        String data = client.read();
        String [] words = data.split("#");
        for (String str: words) {
            if (str.length()>2) {
                ISock sock = stringToSock(str);
                result.add(sock);
            }
        }
        return result;
    }

    @Override
    public void addSock(ISock sock) {
        client.write("addNewSock");
        client.write(sock.toString());
    }

    @Override
    public ISock updateSock(ISock sock) {
        return null;
    }

    @Override
    public boolean deleteSock(int id) {
        return false;
    }

    @Override
    public ISock getSockById(int id) {
        return null;
    }

    @Override
    public List<ISock> getSockByCondition(String fieldName, String condition, String value) {
        return null;
    }

    ISock stringToSock(String str)
    {

            String[] fields = str.split("\\|");
            int id = Integer.parseInt(fields[0]);
            String type = fields[1];
            String color = fields[2];
            int size = Integer.parseInt(fields[3]);
            return new SockData(type, color, size, id, null);
    }
}
