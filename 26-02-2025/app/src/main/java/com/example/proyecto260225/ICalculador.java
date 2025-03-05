package com.example.proyecto260225;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface ICalculador {
    BigDecimal calcular(Operacion operacion, BigDecimal x, BigDecimal y);
}
