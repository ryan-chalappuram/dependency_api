package com.dependency.demo;

import lombok.Data;

import javax.persistence.Embeddable;
import java.util.Date;


@Data
public class Generator {
    public double schema_version;
    public double product_version;
    public String product_name;
    public Date timestamp;
}
