package com.scfsoft.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpStudent implements Serializable {
    private Integer sId;

    private String sName;

    private String sPass;

    private String sSex;

    private String sIdcard;

    private String sAddress;

    private String sNation;

    private String sPolStat;

    private String sSchoolTime;

    private String sHousehold;

    private String sSchoolmethod;

    private String sClass;

    private String sPicPath;

    private Boolean delflag;

    private static final long serialVersionUID = 1L;
}