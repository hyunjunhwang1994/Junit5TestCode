package com.example.junit5testcode;
import com.example.junit5testcode.util.LottoNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoTest {



    @Test
    @DisplayName("로또 번호 갯수 테스트")
    void lottoNumberSizeTest(){
        //given
        LottoNumberGenerator generator = new LottoNumberGenerator();
        int price = 1_000;
        //when
        List<Integer> list = generator.generate(price);
        //then
        Assertions.assertThat(list.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호 범위 테스트")
    void lottoNumberRangeTest(){
        //given
        LottoNumberGenerator generator = new LottoNumberGenerator();
        int price = 1_000;
        //when
        List<Integer> list = generator.generate(price);
        //then
        Assertions.assertThat(list.stream().allMatch(n -> n >= 1 && n <= 45)).isTrue();
    }

    @DisplayName("잘못된 로또 금액 테스트")
    @Test
    void lottoNumberInvalidMoneyTest(){
        //given
        LottoNumberGenerator generator = new LottoNumberGenerator();
        int price = 2_000;
        //when
        RuntimeException ex = assertThrows(RuntimeException.class, () -> generator.generate(price));
        //then
        Assertions.assertThat(ex.getMessage()).isEqualTo("올바른 금액이 아닙니다");
    }


}
