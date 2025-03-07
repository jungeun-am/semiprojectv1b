package com.example.zzyzzy.semiprojectv1.board;

import com.example.zzyzzy.semiprojectv1.domain.Board;
import com.example.zzyzzy.semiprojectv1.domain.BoardDTO;
import com.example.zzyzzy.semiprojectv1.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.TestConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@MybatisTest
@RequiredArgsConstructor //  final 필드변수로 생성자 생성
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL) // 생성자 주입시 필요
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // H2 데이터베이스 사용중지
public class BoardMapperTest {

    // autowired가 아닌 생성자를 이용한 의존성 주입 사용
    private final BoardRepository boardMapper;
    @Value("${board.page-size}") private int pageSize;

    @Test
    @DisplayName("BoardMapper select test")
    void selectTest() {
        // Given : 데스트에 사용할 데이터 제공
        int stnum = 0;  // 조회할 게시물 시작위치

        // When : 데이터로 테스트할 기능 호출
        List<BoardDTO> results = boardMapper.selectBoard(stnum, pageSize);

        // Then : 호출되고 난 후 결과값 확인
        log.info("results : {}", results);
        assertNotNull(results);

    }

    @Test
    @DisplayName("BoardMapper find test")
    void findTest() {
        // Given : 데스트에 사용할 데이터 제공
        Map<String, Object> params = new HashMap();
        params.put("stnum", 0);
        params.put("pageSize", 35);
        params.put("findtype", "title");
        params.put("findkey", "증강현실");

        // When : 데이터로 테스트할 기능 호출
        //List<BoardDTO> results = boardMapper.selectFindBoard(0,35,"title","증강현실");

        // When : 데이터로 테스트할 기능 호출
        //List<BoardDTO> results = boardMapper.selectFindBoard(0,35,"userid","abc");

        // When : 데이터로 테스트할 기능 호출
        //List<BoardDTO> results = boardMapper.selectFindBoard(0,35,"contents","아인슈타인");

        // HashMap 형태로 검색 관련 데이터 넘
        List<BoardDTO> results = boardMapper.selectFindBoard(params);

        // Then : 호출되고 난 후 결과값 확인
        log.info("results : {}", results);
        assertNotNull(results); // Null 여부 확인 - 리스트일 경우 의미없는 검사 !
        assertThat(results).isNotEmpty(); // 비어있는지 여부 확인
        assertThat(results.size()).isGreaterThan(0); // 결과 갯수 확인
    }

    @Test
    @DisplayName("BoardMapper countfind test")
    void countfind() {
        // Given : 데스트에 사용할 데이터 제공
        Map<String, Object> params = new HashMap();
        params.put("pageSize", 35);
        params.put("findtype", "title");
        params.put("findkey", "아인슈타인");

       int results = boardMapper.countFindBoard(params);

        // Then : 호출되고 난 후 결과값 확인
        log.info("results : {}", results);
        assertThat(results).isGreaterThan(0); // 결과 갯수 확인
    }

    @Test
    @DisplayName("BoardMapper selectOne test")
    void selectOneTest() {
        // Given : 데스트에 사용할 데이터 제공
      int bno = 3000;

      Board result = boardMapper.selectOneBoard(bno);

        // Then : 호출되고 난 후 결과값 확인
        log.info("results : {}", result);
        assertNotNull(result);
        assertThat(result.getUserid()).isNotNull();
    }

}
