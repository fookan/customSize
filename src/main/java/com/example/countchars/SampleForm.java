package com.example.countchars;

import com.example.countchars.validator.CustomSize;

import lombok.Data;

@Data
public class SampleForm {
    @CustomSize(max = 20)
    private String text;    
}
