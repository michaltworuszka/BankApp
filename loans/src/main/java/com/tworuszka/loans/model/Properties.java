package com.tworuszka.loans.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * @author Michał Tworuszka
 * @project Bank App
 */
@Getter
@Setter
@AllArgsConstructor
public class Properties {

    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
    private List<String> activeBranches;


}
