package com.example.batch.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.example.domain.DataIn;
import com.example.domain.DataOut;

public class MyProcessor  implements ItemProcessor<DataIn,DataOut> {

	

	 private static final Logger log = LoggerFactory.getLogger(MyProcessor.class);



   @Override

   public DataOut process(DataIn item) throws Exception {

   	log.info("[MyProcessor -process]item:"+item);

       DataOut dataOut = new DataOut();

       dataOut.setText1(item.getText1().toUpperCase());

       dataOut.setText2(item.getText2().toUpperCase());

       return dataOut;

   }



}