package com.flipkart.poseidon.sample.datasources;

import com.flipkart.poseidon.datasources.AbstractDataSource;
import com.flipkart.poseidon.model.annotations.Description;
import com.flipkart.poseidon.model.annotations.Name;
import com.flipkart.poseidon.model.annotations.Version;
import com.flipkart.poseidon.serviceclients.ServiceContext;
import com.flipkart.poseidon.serviceclients.sampleSC.v5.ABServiceClient;
import flipkart.lego.api.entities.DataType;
import flipkart.lego.api.entities.LegoSet;
import flipkart.lego.api.entities.Request;

@Name("ABExposureDS")
@Version(major = 1, minor = 0, patch = 0)
@Description("Fetches AB")
public class ABDataSource extends AbstractDataSource<ABDataSource.ABExposureData> {

    public ABDataSource(LegoSet legoset, Request request) {
        super(legoset, request);
    }

    public class ABExposureData implements DataType {
        private Object value;

        public ABExposureData(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }
    }

    @Override
    public ABExposureData call() throws Exception {
        String abTrackingId = request.getAttribute("abTrackingId");
        ABServiceClient serviceClient = (ABServiceClient) legoset.getServiceClient("aBSC_5.14.1");
        Object result = serviceClient.getExposureMeta(abTrackingId).get();
        System.out.println(ServiceContext.getCollectedHeaders("X-AB-IDS"));
        return new ABExposureData(result);
    }
}
