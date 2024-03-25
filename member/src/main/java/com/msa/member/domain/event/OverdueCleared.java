package com.msa.member.domain.event;

import com.msa.member.domain.model.vo.IDName;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OverdueCleared implements Serializable {
    private IDName idName;
    private Long point;
}
