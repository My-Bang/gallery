import axios from "axios";

export const addOrder = (orderData) => {
    return axios.post("/v1/api/orders", orderData);
};


// 주문 삽입

// 주문 목록 조회

// 주문 상세 조회
