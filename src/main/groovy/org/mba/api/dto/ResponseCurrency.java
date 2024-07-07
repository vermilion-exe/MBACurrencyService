package org.mba.api.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.*;

import jakarta.xml.bind.annotation.XmlElement;
import org.mba.api.config.DoubleAdapter;

@XmlRootElement(name = "Valute")
@XmlAccessorType(XmlAccessType.NONE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseCurrency {

    @XmlElement(name = "NumCode")
    private String numCode;
    @XmlElement(name = "CharCode")
    private String charCode;
    @XmlElement(name = "Nominal")
    private Integer nominal;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "Value")
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    private Double value;
    @XmlElement(name = "VunitRate")
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    private Double vUnitRate;

}
