package com.tiki.bookstore.response;

public class BMIresponse {
    private float bmiIndex;
    private String category;
    private String recommendation;

    public BMIresponse(float bmiIndex, String category, String recommendation) {
        this.bmiIndex = bmiIndex;
        this.category = category;
        this.recommendation = recommendation;
    }

    public BMIresponse() {
    }

    public float getBmiIndex() {
        return bmiIndex;
    }

    public void setBmiIndex(float bmiIndex) {
        this.bmiIndex = bmiIndex;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
