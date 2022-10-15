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
public class SpSc implements Serializable {
    private String scClassid;

    private Integer scStuid;

    private static final long serialVersionUID = 1L;
}