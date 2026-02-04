package com.ashish.java.learn.others;

public record OrderDetails(String orderId,

                           Card card,
                           double finalAmount) {
}
