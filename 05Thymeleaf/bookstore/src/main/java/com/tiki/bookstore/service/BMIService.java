package com.tiki.bookstore.service;

import com.tiki.bookstore.request.BMIrequest;
import com.tiki.bookstore.response.BMIresponse;

public class BMIService {
    public BMIresponse cal(BMIrequest request) {
        BMIresponse response = new BMIresponse();

        float BmiIndex = request.getWeight() / (request.getHeight() * request.getHeight());
        response.setBmiIndex(BmiIndex);
        if (BmiIndex < 18.5) {
            response.setCategory("Thiếu cân");
            response.setRecommendation("Ăn thêm cơm, tập thể dục điều độ");
        } else if (BmiIndex < 25) {
            response.setCategory("Cân đối");
            response.setRecommendation("Phát huy chế độ ăn uống và thể thao");
        } else {
            response.setCategory("Thừa cân");
            response.setRecommendation("Giảm chế độ ăn, tăng cường thể dục");
        }
        return response;
    }
}
