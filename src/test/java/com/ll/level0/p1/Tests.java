package com.ll.level0.p1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

 public class Tests {

    @Test
    @DisplayName("3 + 3  => 6")
    void t1() {
        assertThat(new Polynomial("3 + 3").calc()).isEqualTo(6);
    }

}
