package com.example.actuator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="feature")
public class FeaturesEndpoint {
	
	final static Logger logger = LoggerFactory.getLogger(FeaturesEndpoint.class);
	
	private Map<String, Feature> features = new ConcurrentHashMap<>();
	 
    @ReadOperation
    public Map<String, Feature> features() {
    	logger.info("FeaturesEndpoint - features");
    	Feature feature1 = new Feature("primera");
    	Feature feature2 = new Feature("segunda");
    	features.put("una", feature1);
    	features.put("dos", feature2);
    	
        return features;
    }
 
    @ReadOperation
    public Feature feature(@Selector String name) {
    	logger.info("FeaturesEndpoint - feature");
        return features.get(name);
    }
 
    @WriteOperation
    public void configureFeature(@Selector String name, Feature feature) {
    	logger.info("FeaturesEndpoint - configureFeature");
        features.put(name, feature);
    }
    
    @DeleteOperation
    public void deleteFeature(@Selector String name) {
    	logger.info("FeaturesEndpoint - deleteFeature");
        features.remove(name);
    }
 
    

}
