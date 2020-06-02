package com.example.domain;

import java.io.Serializable;


public class DataOut implements Serializable {

    private String text1;

    private String text2;

    public DataOut() {
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

	@Override
	public String toString() {
		return "DataOut [text1=" + text1 + ", text2=" + text2 + "]";
	}
    

}
