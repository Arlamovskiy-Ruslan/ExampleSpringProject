package com.example.examplespringproject.model.audit;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class LogData {

    Map<String, String> data;
}
