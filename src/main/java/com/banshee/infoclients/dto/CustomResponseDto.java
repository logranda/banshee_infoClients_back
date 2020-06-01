package com.banshee.infoclients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomResponseDto<T> extends CustomResponseStateDto {

    private static final long serialVersionUID = -3222731372521775546L;
    private T response;
}
