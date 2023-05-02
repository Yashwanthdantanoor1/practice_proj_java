package com.emp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
            private String symbol;
            private String name;
            private String symbol_native;
            private int decimal_digits;
            private int rounding;
            private String code;
            private String name_plural;
}
