package org.mba.api.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.NONE)
@Data
@NoArgsConstructor
@Getter
@Setter
public class ResponseResult {

    @XmlElement(name = "Valute")
    private List<ResponseCurrency> currencies;

}
