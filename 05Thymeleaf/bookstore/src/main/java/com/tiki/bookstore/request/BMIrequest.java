package com.tiki.bookstore.request;

public class BMIrequest {

    private float height;
    private float weight;

    public BMIrequest( float height, float weight) {

        this.height = height;
        this.weight = weight;
    }
    public BMIrequest() {
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
