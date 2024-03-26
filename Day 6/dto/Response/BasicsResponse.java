package com.java.agrofund.dto.Response;

import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicsResponse<T> {

    private String message;
    @Builder.Default
    private List<T> dataList = Collections.emptyList();
    private T data;
    
}
