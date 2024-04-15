package org.reservation.system.common.api;

public class MsgUtils {
    public static <T> ApiResponse<T> generateSuccessResponse(T data) {
        return ApiResponse.<T>builder()
                .message("success")
                .data(data)
                .build();
    }


}
