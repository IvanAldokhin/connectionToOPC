package org.example;

import com.hurence.opc.da.OpcDaConnectionProfile;
import com.hurence.opc.da.OpcDaOperations;
import com.hurence.opc.da.OpcDaTemplate;
import util.OpcDaConnectionProf;

public class Main {
    public static void main(String[] args) {
        OpcDaConnectionProfile connectionProfile = OpcDaConnectionProf.getProfile();
        OpcDaOperations opcDaOperations = new OpcDaTemplate();
        try (opcDaOperations) {
            opcDaOperations.connect(connectionProfile).ignoreElement().blockingAwait();
            opcDaOperations.browseTags().blockingForEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException("Can't read from OPC Server", e);
        }


    }
}