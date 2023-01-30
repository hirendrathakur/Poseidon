package com.flipkart.poseidon.sample;

import com.flipkart.poseidon.Poseidon;

public class ServiceClientRunner {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//        SampleLegoSet sampleLegoSet = new SampleLegoSet();
//        SampleConfiguration sampleConfiguration = new SampleConfiguration();
//        APIManager apiManager = new APIManager(sampleLegoSet, sampleConfiguration);
//        SampleApplication sampleApplication = new SampleApplication(apiManager, sampleLegoSet);
        Poseidon.main(new String[]{"/Users/hirendra.thakur/workspace/Poseidon/sample/src/main/resources/external/bootstrap.xml"});
        System.out.println("Started");
    }
}