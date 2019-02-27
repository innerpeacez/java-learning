package com.zhw.java.study.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Apple {

    private String color;
    @NonNull
    private long weight;
}
